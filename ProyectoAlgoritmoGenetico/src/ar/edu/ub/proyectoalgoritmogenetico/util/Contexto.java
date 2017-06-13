package ar.edu.ub.proyectoalgoritmogenetico.util;

import java.util.HashMap;
import java.util.Map;

public class Contexto {
	
	private static Map<Object, Object> mapa = new HashMap<Object, Object>();
	
	private Contexto() {
		
	}
	
	public static Map<Object, Object> getInstance() {
		return Contexto.mapa;
	}
	
	public static void put(Object clave, Object valor) {
		Contexto.getInstance().put(clave, valor);
	}
	
	public static Object get(Object clave) {
		return Contexto.getInstance().get(clave);
	}

}