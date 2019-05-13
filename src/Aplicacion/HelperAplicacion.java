package Aplicacion;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import Comisaria.ComisariaPolicia;
import Constantes.Shared;
import EntradaTeclado.LeerTeclado;
import Errores.ComisariaException;
import Policia.Policia;
import Policia.PoliciaAdministrativo;
import Policia.PoliciaJefe;
import Policia.PoliciaTransito;
import Multa.Multa;

public class HelperAplicacion {

	public static String menu() {
		StringBuffer sb = new StringBuffer();

		sb.append("1- Insertar un Policia");
		sb.append("\n2- Poner una Multa");
		sb.append("\n3- Mostrar todos los Policias");
		sb.append("\n4- Mostrar todos los Policias y Multas Ordenador por Codigo");
		sb.append("\n5- Mostrar todos los Policias Ordenados por nombre");
		sb.append("\n6- Actualizar sueldo del Policia");
		sb.append("\n7- Mostrar Policias ponen Multas");
		sb.append("\n8- Mostrar el numero de Multas que hay en total");
		sb.append("\n9- Mostrar las Multas que tiene un Policia");
		sb.append("\n10- Mostrar todos los Policias que han puesto una Multa");
		sb.append("\n11- Actualizar sueldo del Policia");
		sb.append("\n12- Guardar y Salir del Programa");

		return sb.toString();
	}

	public static Policia insertarPolicia() throws ComisariaException {
		Policia temp = null;

		char opcion = LeerTeclado
				.leerChar("Que Rango de Policia deseas insertar? (Jefe - J, Administrativo - A, Transito - T)");
		String nombre = LeerTeclado.leerString("Escribe el nombre de dicho Policia");

		if (opcion != 'J' || opcion != 'T' || opcion != 'A') {
			throw new ComisariaException(Shared.DEFAULT_ERR_FORMAT, "Opcion Erronea");
		}

		switch (opcion) {
		case 'J':
			temp = new PoliciaJefe(nombre);
			break;
		case 'A':
			temp = new PoliciaAdministrativo(nombre);
			break;
		case 'T':
			temp = new PoliciaTransito(nombre);
			break;
		default:
			temp = insertarPolicia();
		}

		return temp;
	}

	@SuppressWarnings("unchecked")
	public static ComisariaPolicia cargarComisaria(String nombre) throws ComisariaException {
		ComisariaPolicia temp = null;
		Path path = Paths.get(nombre + ".txt");

		if (Files.exists(path) && path.toFile().isFile()) {

			try {
				ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream(path.toFile()));

				Shared.cont_multas = flujoEntrada.readInt();
				Shared.cont_policias = flujoEntrada.readInt();

				Multa.setMultas((Map<String, List<Multa>>) flujoEntrada.readObject());
				temp = (ComisariaPolicia) flujoEntrada.readObject();

				flujoEntrada.close();
			} catch (Exception e) {

			}

		} else {
			temp = new ComisariaPolicia();
			Shared.listadoMultasCargados = true;
			throw new ComisariaException(Shared.DEFAULT_ERR, "La Comisaria no existia");
		}

		return temp;
	}

	public static boolean guardarComisaria(ComisariaPolicia comisaria, String nombre) throws ComisariaException {
		boolean guardado = false;
		Path path = Paths.get(nombre + ".txt");

		try {

			if (!Files.exists(path)) {
				BufferedWriter bw = new BufferedWriter(new PrintWriter(path.toString()));
				bw.close();
			}

			ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream(path.toFile()));

			flujoSalida.writeInt(Shared.cont_multas);
			flujoSalida.writeInt(Shared.cont_policias);
			flujoSalida.writeObject(Multa.getMulta());
			flujoSalida.writeObject(comisaria);

			flujoSalida.close();

		} catch (Exception e) {
			throw new ComisariaException(Shared.DEFAULT_ERR, "Error al Guardar");
		}

		return guardado;
	}

}
