package Interfaces;

import Errores.ComisariaException;

public interface IPoliciaTransito {

	/**
	 * Metodo que actualiza el sueldo del Policia de Tansito, siendo dicho sueldo el
	 * Sueldo base, mas un 10% del total de todas las multas puestas por el.
	 * 
	 * @return boolean
	 * @throws ComisariaException
	 */
	public boolean actualizarSueldo() throws ComisariaException;

}
