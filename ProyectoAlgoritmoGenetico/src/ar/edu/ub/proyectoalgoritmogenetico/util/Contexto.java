package ar.edu.ub.proyectoalgoritmogenetico.util;

import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.proyectoalgoritmogenetico.vista.Vista;

public class Contexto {
	
	private static Map<Object, Object> mapa = new HashMap<Object, Object>();
	private static Vista vista;
	
	private Contexto() {
		
	}
	
	public static Vista getVista() {
		return vista;
	}

	public static void setVista(Vista vista) {
		Contexto.vista = vista;
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
	
	public static void generateVista(){
		Contexto.setVista(new Vista());
	}
	

}