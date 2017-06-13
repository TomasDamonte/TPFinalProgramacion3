package ar.edu.ub.proyectoalgoritmogenetico.controlador;

import java.sql.SQLException;

import ar.edu.ub.proyectoalgoritmogenetico.util.Contexto;
import ar.edu.ub.proyectoalgoritmogenetico.util.Validaciones;
import ar.edu.ub.proyectoalgoritmogenetico.util.Utilidades;
import ar.edu.ub.proyectoalgoritmogenetico.vista.*;
import ar.edu.ub.proyectoalgoritmogenetico.modelo.*;

public class AlgoritmoGeneticoControlador {

	public static void simular(String tamañoPoblacion, String tamañoCromosoma, String cantidadGenesMutar, String clave){
		try {			
			AlgoritmoGenetico algoritmoGenetico = new AlgoritmoGenetico(Integer.parseInt(tamañoPoblacion),Integer.parseInt(tamañoCromosoma),Integer.parseInt(cantidadGenesMutar));
			if(clave.equals(""))
				algoritmoGenetico.setClave(new Cromosoma());				
			else 
				algoritmoGenetico.setClave(new Cromosoma(clave));
			algoritmoGenetico.buscar();
			Vista vista = new Vista();		
			vista.getClave().setText(algoritmoGenetico.getClave().getHexadecimalString());			
			vista.getLblNumeroIteraciones().setText(algoritmoGenetico.getCantidadGeneraciones().toString());
			vista.getListaPoblacion().setText(algoritmoGenetico.getPoblacion().getPoblacionString());
			algoritmoGenetico.guardarEnDB();
		} catch (SQLException e1) {			
			System.out.println("Error al guardar base de datos: No se encontro la base de datos.");
		}				
	}

	public static void validarConfiguracion(String tamañoPoblacion, String tamañoCromosoma, String cantidadGenesMutar, String clave, Boolean rdbtnManualIsSelected) {			
		Contexto.put(Validaciones.VALIDACION_ENTERO_TAMAÑO_POBLACION, Utilidades.esEntero(tamañoPoblacion) ? Boolean.TRUE: Boolean.FALSE);
		Contexto.put(Validaciones.VALIDACION_ENTERO_TAMAÑO_CROMOSOMA, Utilidades.esEntero(tamañoCromosoma) ? Boolean.TRUE: Boolean.FALSE);
		Contexto.put(Validaciones.VALIDACION_ENTERO_GENES_A_MUTAR, Utilidades.esEntero(cantidadGenesMutar) ? Boolean.TRUE: Boolean.FALSE);
		if (rdbtnManualIsSelected)
			Contexto.put(Validaciones.VALIDACION_HEXADECIMAL_CLAVE, Utilidades.esHexadecimal(clave) ? Boolean.TRUE: Boolean.FALSE);
		else
			Contexto.put(Validaciones.VALIDACION_HEXADECIMAL_CLAVE, Boolean.TRUE);		
	}	

}