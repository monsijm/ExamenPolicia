package Policia;

import Constantes.RangosPolicias;
import Constantes.Shared;
import Errores.ComisariaException;

public abstract class Policia {

	private String codigo = "";
	private String nombre = "";
	private double sueldo = Shared.SUELDO_BASE;

	protected Policia(RangosPolicias codigo, String nombre) throws ComisariaException {
		this.codigo = convertirCodigo(codigo);

		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		} else {
			throw new ComisariaException(Shared.DEFAULT_ERR_FORMAT, "Nombre no Valido");
		}

	}

	@Override
	public String toString() {
		return "Codigo Policia =" + codigo + ", nombre=" + nombre + ", sueldo=" + sueldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	protected void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getCodigo() {
		return codigo;
	}

	private String convertirCodigo(RangosPolicias cod) throws ComisariaException {
		StringBuffer temp = new StringBuffer();
		if (cod != null) {
			temp.append(cod.name() + " - " + (++Shared.cont_policias));
		} else {
			throw new ComisariaException(Shared.DEFUALT_ERR_RANGEPOLICE, "Rango no Valido");
		}

		return temp.toString();
	}

}
