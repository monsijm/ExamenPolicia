package Interfaces;

import Errores.ComisariaException;

public interface IComisaria {

	/**
	 * Metodo que muestra la informacion de todos los Policias y Multas, ordenador
	 * por Codigo.
	 * 
	 * @return String
	 * @throws ComisariaException
	 */
	public String mostrarTodosPoliciasYMultasOrdenadoPorCodigo() throws ComisariaException;

	/**
	 * Metodo que muestra la informacion de todos los Policias, ordenador por
	 * nombre.
	 * 
	 * @return String
	 * @throws ComisariaException
	 */
	public String mostrarTodosPoliciasOrdenadorPorNombre() throws ComisariaException;

	/**
	 * Metodo que muestra todos los Policias que ponen Multas
	 * 
	 * @return String
	 * @throws ComisariaException
	 */
	public String mostrarPoliciaPonenMulta() throws ComisariaException;

}
