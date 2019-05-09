package Interfaces;

import java.util.List;
import java.util.Set;

import Errores.ComisariaException;
import Multa.Multa;

public interface IMulta {

	/**
	 * Metodo que devuelve el numero de multas que hay en total.
	 * 
	 * @return int
	 * @throws ComisariaException
	 */
	public int numeroMultas() throws ComisariaException;

	/**
	 * Metodo que devuelve una lista con todas las multas que ha puesto un Policia,
	 * pasandole el codigo de dicho Policia.
	 * 
	 * @param cod_policia
	 * @return List<Multa>
	 * @throws ComisariaException
	 */
	public List<Multa> multasPolicia(String cod_policia) throws ComisariaException;

	/**
	 * Metodo que devuelve un conjunto con todos los codigos de Policias que han
	 * puesto alguna multa.
	 * 
	 * @return
	 * @throws ComisariaException
	 */
	public Set<String> policiasConMultas() throws ComisariaException;

}
