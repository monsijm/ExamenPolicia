package Comisaria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import Constantes.Shared;
import Errores.ComisariaException;
import Interfaces.IComisaria;
import Policia.Policia;
import Policia.PoliciaTransito;
import Multa.Multa;

public class ComisariaPolicia implements IComisaria {

	private List<Policia> comisaria = null;

	public ComisariaPolicia() {
		comisaria = new ArrayList<>();
	}

	public boolean addPolicia(Policia p) throws ComisariaException {
		boolean insertado = false;

		if (comisaria == null) {
			throw new ComisariaException(Shared.DEFAULT_ERR_NULL, "Comisaria no inicializada");
		}

		if (!comisaria.contains(p)) {
			comisaria.add(p);
			insertado = true;
		}

		return insertado;
	}

	public boolean removePolicia(Policia p) throws ComisariaException {
		boolean eliminado = false;

		lanzarExceptions();

		if (comisaria.contains(p)) {
			comisaria.remove(p);
			eliminado = true;
		}

		return eliminado;
	}

	@Override
	public String mostrarTodosPoliciasYMultasOrdenadoPorCodigo() throws ComisariaException {
		StringBuffer sb = new StringBuffer();
		Iterator<Policia> ite = comisaria.iterator();

		lanzarExceptions();

		while (ite.hasNext()) {
			Policia policia = (Policia) ite.next();
			sb.append(policia + "\n");
			if (policia instanceof PoliciaTransito) {
				sb.append("--Multas--\n");
				Iterator<Multa> listadoMultas = Multa.listadoMultas(policia.getCodigo()).iterator();
				while (listadoMultas.hasNext()) {
					sb.append(listadoMultas.next() + "\n");
				}
			}
		}

		return sb.toString();
	}

	@Override
	public String mostrarTodosPoliciasOrdenadorPorNombre() throws ComisariaException {
		List<Policia> temp = null;

		lanzarExceptions();

		temp = new ArrayList<>(comisaria);

		Collections.sort(comisaria, (p1, p2) -> (((Policia) p1).getNombre().compareTo(((Policia) p2).getNombre())));

		return temp.toString();
	}

	@Override
	public String mostrarPoliciaPonenMulta() throws ComisariaException {
		StringBuffer sb = new StringBuffer();
		Iterator<Policia> ite = null;
		lanzarExceptions();

		ite = comisaria.iterator();

		while (ite.hasNext()) {
			Policia policia = (Policia) ite.next();
			if (policia.getCodigo().charAt(0) == 'T') {
				sb.append(policia.toString() + "\n");
			}
		}

		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Iterator<Policia> ite = comisaria.iterator();

		while (ite.hasNext()) {
			sb.append(ite.next().toString() + "\n");
		}

		return sb.toString();
	}

	private void lanzarExceptions() throws ComisariaException {
		if (comisaria == null) {
			throw new ComisariaException(Shared.DEFAULT_ERR_NULL, "Comisaria no inicializada");
		} else if (comisaria.isEmpty()) {
			throw new ComisariaException(Shared.DEFAULT_ERR_EMPTY, "Comisaria vacia");
		}
	}

}
