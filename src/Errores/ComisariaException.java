package Errores;

import Constantes.Shared;

@SuppressWarnings("serial")
public class ComisariaException extends Exception{

	public ComisariaException(int errCod, String message) {
		super(Integer.toString(errCod) + " -> " + message);
	}
	
	public ComisariaException(int errCod) {
		this(errCod, Shared.DEFAULT_ERR_MESSAGE);
	}
	
	public ComisariaException() {
		this(Shared.DEFAULT_ERR);
	}
	
}
