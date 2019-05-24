package Policia;

import java.util.Iterator;

import Constantes.RangosPolicias;
import Constantes.Shared;
import Errores.ComisariaException;
import Interfaces.IPoliciaTransito;
import Multa.Multa;

public class PoliciaTransito extends Policia implements IPoliciaTransito {

	public PoliciaTransito(String nombre) throws ComisariaException {
		super(RangosPolicias.T, nombre);

	}

	@Override
	public boolean actualizarSueldo() throws ComisariaException {
		boolean actualizado = false;
		int auxSueldo = 0;
		Iterator<Multa> listadoMultas = Multa.listadoMultas(getCodigo()).iterator();		
		
		while (listadoMultas.hasNext()) {
			auxSueldo += listadoMultas.next().getImporte();
		}
		
		setSueldo(Shared.SUELDO_BASE + auxSueldo);

		return actualizado;
	}

	public boolean insertarMulta(Multa m) throws ComisariaException {
		return Multa.insertarMulta(getCodigo(), m);
	}

}