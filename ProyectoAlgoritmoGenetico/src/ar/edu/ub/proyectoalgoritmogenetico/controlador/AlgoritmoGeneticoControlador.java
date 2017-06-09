package ar.edu.ub.proyectoalgoritmogenetico.controlador;

import java.sql.SQLException;

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
		} catch (SQLException e1) {
			e1.printStackTrace();
		}				
	}

	public static void validarConfiguracion(VistaConfiguracion vistaConfiguracion, String tamañoPoblacion, String tamañoCromosoma, String cantidadGenesMutar, String clave) {
		vistaConfiguracion.getLblErrorPoblacion().setVisible(false);
		vistaConfiguracion.getLblErrorCromosoma().setVisible(false);
		vistaConfiguracion.getLblErrorGenes().setVisible(false);
		vistaConfiguracion.getTextAreaErrorClave().setVisible(false);
		vistaConfiguracion.getBtnBuscar().setVisible(false);
		vistaConfiguracion.getBtnBuscar().setEnabled(false);		
		if(!esEntero(tamañoPoblacion))
			vistaConfiguracion.getLblErrorPoblacion().setVisible(true);
		if(!esEntero(tamañoCromosoma))
			vistaConfiguracion.getLblErrorCromosoma().setVisible(true);
		if(!esEntero(cantidadGenesMutar))
			vistaConfiguracion.getLblErrorGenes().setVisible(true);
		if(vistaConfiguracion.getRdbtnManual().isSelected() && !esHexadecimal(clave))			
			vistaConfiguracion.getTextAreaErrorClave().setVisible(true);
		if(vistaConfiguracion.getRdbtnManual().isSelected()) {
			if(esEntero(tamañoPoblacion) && esEntero(tamañoCromosoma) && esEntero(cantidadGenesMutar) && esHexadecimal(clave)){
				vistaConfiguracion.getBtnBuscar().setVisible(true);
				vistaConfiguracion.getBtnBuscar().setEnabled(true);
			}
		}
		else {
			if(esEntero(tamañoPoblacion) && esEntero(tamañoCromosoma) && esEntero(cantidadGenesMutar)) {
				vistaConfiguracion.getBtnBuscar().setVisible(true);
				vistaConfiguracion.getBtnBuscar().setEnabled(true);	
			}
		}		
	}

	private static Boolean esEntero(String string) {
		try {
			Integer.parseInt(string);			
		} catch(Exception e) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	private static Boolean esHexadecimal(String string) {
		try {
			Long.parseLong(string,16);
		} catch(Exception e) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}