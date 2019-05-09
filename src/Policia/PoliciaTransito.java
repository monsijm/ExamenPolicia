package Policia;

import Constantes.RangosPolicias;
import Errores.ComisariaException;
import Interfaces.IPoliciaTransito;

public class PoliciaTransito extends Policia implements IPoliciaTransito {

	protected PoliciaTransito(String nombre) throws ComisariaException {
		super(RangosPolicias.T, nombre);

	}

	@Override
	public boolean actualizarSueldo() throws ComisariaException {
		// TODO Auto-generated method stub
		return false;
	}

}