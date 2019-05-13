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

	private int codMulta = 0;
	private double importe = 0;
	
	public Multa(Map<String, List<Multa>> tempMultas) throws ComisariaException {
		lanzarErrores(tempMultas);
		multas = new HashMap<>(tempMultas);
	}
	
	public Multa(String codPolicia, double importe) throws ComisariaException {
		this.codMulta = ++Shared.cont_multas;
		this.importe = importe;
		
		insertarMulta(codPolicia, this);
		
	}

	public Multa() {
		multas = new HashMap<>();
	}

	public static boolean insertarMulta(String codPolicia, Multa m) throws ComisariaException{
		boolean insertado = false;
		
		lanzarErrores(multas);
		
		if (multas.containsKey(codPolicia)) {
			multas.get(codPolicia).add(m);
			insertado = true;
		}
		
		return insertado;
	}
	
	public static List<Multa> listadoMultas(String codPolicia) throws ComisariaException{
		List<Multa> temp = null;
		
		lanzarErrores(multas);
		
		if (multas.containsKey(codPolicia)) {
			temp = new ArrayList<>(multas.get(codPolicia));
		}
		
		return temp;
	}
	
	@Override
	public int numeroMultas() throws ComisariaException {
		int contMultas = 0;
		Iterator<String> ite = null;

		lanzarErrores(multas);
		
		ite = multas.keySet().iterator();

		while (ite.hasNext()) {
			contMultas += multas.get(ite.next()).size();
		}

		return contMultas;
	}

	@Override
	public List<Multa> multasPolicia(String cod_policia) throws ComisariaException {
		List<Multa> temp = null;
		
		lanzarErrores(multas);
		
		if (cod_policia.charAt(1) != 'T') {
			throw new ComisariaException(Shared.DEFAULT_ERR_MULTAS_PERM_DENIED, "Este Policia no es de Transito");
		}

		if (multas.containsKey(cod_policia)) {
			temp = new ArrayList<>(multas.get(cod_policia));
		}

		return temp;
	}

	@Override
	public Set<String> policiasConMultas() throws ComisariaException {
		Set<String> temp = null;
		
		lanzarErrores(multas);

		temp = multas.keySet();

		return temp;
	}

	public int getCodMulta() {
		return codMulta;
	}

	public double getImporte() {
		return importe;
	}

	// region metodos privados
	private static void lanzarErrores(Map<String, List<Multa>> tempMultas) throws ComisariaException {
		if (tempMultas == null) {
			throw new ComisariaException(Shared.DEFAULT_ERR_NULL, "Coleccion de Multas null");
		} else if (tempMultas.isEmpty()) {
			throw new ComisariaException(Shared.DEFAULT_ERR_EMPTY, "Coleccion de Multas vacia");
		}
	}
	// endregion

}
