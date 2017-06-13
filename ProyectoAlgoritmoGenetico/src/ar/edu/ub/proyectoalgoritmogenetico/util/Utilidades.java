package ar.edu.ub.proyectoalgoritmogenetico.util;

public class Utilidades {
	
	private Utilidades() {
		
	}
	
	public static Boolean esEntero(String string) {
		try {
			Integer.parseInt(string);			
		} catch(Exception e) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public static Boolean esHexadecimal(String string) {
		try {
			Long.parseLong(string,16);
		} catch(Exception e) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}