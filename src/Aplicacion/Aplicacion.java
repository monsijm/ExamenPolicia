package Aplicacion;

import Comisaria.ComisariaPolicia;
import EntradaTeclado.LeerTeclado;
import Errores.ComisariaException;
import Interfaces.IComisaria;
import Policia.PoliciaTransito;

public class Aplicacion {

	public static void main(String[] args) {
		IComisaria comisaria = null;

		boolean darNombre = false;
		int opc = 0;

		do {

			try {

				if (!darNombre) {
					darNombre = true;
					comisaria = HelperAplicacion
							.cargarComisaria(LeerTeclado.leerString("Escriba un nombre para la Comisaria"));
				}
				
				System.out.println(HelperAplicacion.menu());
				opc = LeerTeclado.leerEntero("Escribe la opcion");

				switch (opc) {
				case 1:
					HelperAplicacion.insertarPolicia();
					break;
				case 2:
					
					break;
				case 3:
					System.out.println(((ComisariaPolicia)comisaria).toString());
					break;
				case 4:
					System.out.println(comisaria.mostrarTodosPoliciasYMultasOrdenadoPorCodigo());
					break;
				case 5:
					System.out.println(comisaria.mostrarTodosPoliciasOrdenadorPorNombre());
					break;
				case 6:
					System.out.println(comisaria.mostrarPoliciaPonenMulta());
					break;
				case 7:
					
					break;
				case 8:
					
					break;
				case 9:
					break;
				case 10:
					
					break;
				case 11:
					
					break;
				case 12:
					
					break;
				default:
					System.out.println("La opcion introducida es Erronea");
					break;
				}

			} catch (ComisariaException e) {
				System.out.println(e.toString());
			}
			
		} while (opc != 12);
	}

}
