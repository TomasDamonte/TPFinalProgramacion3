package ar.edu.ub.proyectoalgoritmogenetico.controlador;

import java.sql.SQLException;

import ar.edu.ub.proyectoalgoritmogenetico.vista.*;
import ar.edu.ub.proyectoalgoritmogenetico.modelo.*;

public class AlgoritmoGeneticoControlador {

	private static Vista vista;
	
	public AlgoritmoGeneticoControlador() {
	/*	vista = new Vista();		
		vista.getClave().setText(clave.toString());
		vista.mostrar();*/
	}
	
	public static void simular(){
		try {
			AlgoritmoGenetico algoritmoGenetico = new AlgoritmoGenetico();			
			Cromosoma clave = new Cromosoma();
			algoritmoGenetico.setClave(clave);
			algoritmoGenetico.buscar(algoritmoGenetico.getClave());
//			vista.getLblNumeroIteraciones().setText(algoritmoGenetico.getCantidadGeneraciones().toString());
//			vista.getListaPoblacion().setText(algoritmoGenetico.getPoblacion().getPoblacionString());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
}