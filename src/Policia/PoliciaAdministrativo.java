package Policia;

import Constantes.RangosPolicias;
import Constantes.Shared;
import Errores.ComisariaException;

public class PoliciaAdministrativo extends Policia {

	protected PoliciaAdministrativo(String nombre) throws ComisariaException {
		super(RangosPolicias.A, nombre);
		setSueldo(Shared.SUELDO_BASE + 100);
	}

}
