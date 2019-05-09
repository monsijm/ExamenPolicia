package Multa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Constantes.Shared;
import Errores.ComisariaException;
import Interfaces.IMulta;

public class Multa implements IMulta {

	private static Map<String, List<Multa>> multas = null;

	public Multa(Map<String, List<Multa>> tempMultas) throws ComisariaException {
		if (!tempMultas.isEmpty() && tempMultas != null) {
			multas = new HashMap<>(tempMultas);
		} else if (tempMultas.isEmpty()) {
			throw new ComisariaException(Shared.DEFAULT_ERR_EMPTY, "Coleccion de Multas vacia");
		} else {
			throw new ComisariaException(Shared.DEFAULT_ERR_NULL, "Coleccion de Multas null");
		}
	}

	public Multa() {
		multas = new HashMap<>();
	}

	@Override
	public int numeroMultas() throws ComisariaException {
		int contMultas = 0;
		Iterator<String> ite = null;
		
		if (multas.isEmpty()) {
			throw new ComisariaException(Shared.DEFAULT_ERR_MULTAS_EMPTY);
		}else {
			ite = multas.keySet().iterator();
			
			while (ite.hasNext()) {
				contMultas += multas.get(ite.next()).size();
			}
			
		}
		
		return contMultas;
	}

	@Override
	public List<Multa> multasPolicia(String cod_policia) throws ComisariaException {
		List<Multa> temp = null;

		if (cod_policia.charAt(1) != 'T') {
			throw new ComisariaException(Shared.DEFAULT_ERR_MULTAS_PERM_DENIED, "Este Policia no es de Transito");
		}

		if (multas.containsKey(cod_policia)) {
			temp = new ArrayList<>(multas.get(cod_policia));
		} else {
			throw new ComisariaException(Shared.DEFAULT_ERR_MULTAS_EMPTY);
		}

		return temp;
	}

	@Override
	public Set<String> policiasConMultas() throws ComisariaException {
		Set<String> temp = null;

		if (multas.isEmpty()) {
			throw new ComisariaException(Shared.DEFAULT_ERR_MULTAS_EMPTY);
		}else {
			temp = multas.keySet();
		}

		return temp;
	}

}
