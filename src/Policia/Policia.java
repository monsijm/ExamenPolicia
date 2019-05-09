package Policia;

import Constantes.RangosPolicias;
import Constantes.Shared;
import Errores.ComisariaException;

public abstract class Policia {

	protected String codigo = "";
	protected String nombre = "";
	protected double sueldo = Shared.SUELDO_BASE;

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

		switch (cod) {
		case J:
			temp.append("J - " + (++Shared.cont_policias));
			break;
		case A:
			temp.append("A - " + (++Shared.cont_policias));
			break;
		case T:
			temp.append("T - " + (++Shared.cont_policias));
			break;
		default:
			throw new ComisariaException(Shared.DEFUALT_ERR_RANGEPOLICE,"Rango no Valido");
		}

		return temp.toString();
	}

}
