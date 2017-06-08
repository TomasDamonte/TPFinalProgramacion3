package ar.edu.ub.proyectoalgoritmogenetico.controlador;

import java.sql.SQLException;

import ar.edu.ub.proyectoalgoritmogenetico.vista.*;
import ar.edu.ub.proyectoalgoritmogenetico.modelo.*;

public class AlgoritmoGeneticoControlador {
	
	public static void simular(){
		try {
			Integer tama�oPoblacion = 6;
			Integer tama�oCromosoma = 1;
			Integer cantidadGenesMutar = 50;
			String clave = "";			
			AlgoritmoGenetico algoritmoGenetico = new AlgoritmoGenetico(tama�oPoblacion,tama�oCromosoma,cantidadGenesMutar);
			if((clave == "") || (clave == null))
				algoritmoGenetico.setClave(new Cromosoma());				
			else 
				algoritmoGenetico.setClave(new Cromosoma(clave));
			algoritmoGenetico.buscar();
			Vista vista = new Vista();		
			vista.getClave().setText(algoritmoGenetico.getClave().getHexadecimalString());			
			vista.getLblNumeroIteraciones().setText(algoritmoGenetico.getCantidadGeneraciones().toString());
			vista.getListaPoblacion().setText(algoritmoGenetico.getPoblacion().getPoblacionString());
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
}