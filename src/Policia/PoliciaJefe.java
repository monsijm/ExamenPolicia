package Policia;

import Constantes.RangosPolicias;
import Constantes.Shared;
import Errores.ComisariaException;

public class PoliciaJefe extends Policia{

	public PoliciaJefe(String nombre) throws ComisariaException {
		super(RangosPolicias.J, nombre);
		setSueldo(Shared.SUELDO_BASE + 1000);
	}

}
