package Constantes;

public class Shared {

	// region Policia
	public final static int SUELDO_BASE = 1500; // Sueldo base de todos los Policias
	public static int cont_policias = 0; // Contador de los policias que hay en la comisaria
	// endregion

	// region Multa
	public static int cont_multas = 99; // Contador de las multas existentes
	public static boolean listadoMultasCargados = false; // boolean para controlar que el listado de multas se carge y
															// cambie una unica vez
	// endregion

	// region ComisariaException
	public final static int DEFAULT_ERR = 418; // Codigo de error por defecto
	public final static int DEFAULT_ERR_NULL = 101; // Codigo de error de String null
	public final static int DEFAULT_ERR_EMPTY = 102; // Codigo de error de String Vacio
	public final static int DEFAULT_ERR_FORMAT = 103; // Codigo de error de Formato Erroneo
	public final static int DEFUALT_ERR_RANGEPOLICE = 104; // Codigo de error de Rango Policia
	public final static int DEFAULT_ERR_MULTAS_PERM_DENIED = 105; // Codigo de error si el policia no tiene autoridad
																	// para poner multas
	public final static String DEFAULT_ERR_MESSAGE = "NO DATA"; // Mensaje de error por defecto
	// endregion

}
