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
		} catch (SQLException e1) {
			e1.printStackTrace();
		}				
	}

	public static void validarConfiguracion(VistaConfiguracion vistaConfiguracion, String tamañoPoblacion, String tamañoCromosoma, String cantidadGenesMutar, String clave) {
		resetearMensajesError(vistaConfiguracion);				
		Contexto.put(Validaciones.VALIDACION_ENTERO_TAMAÑO_POBLACION, Utilidades.esEntero(tamañoPoblacion) ? Boolean.TRUE: Boolean.FALSE);
		if(!Utilidades.esEntero(tamañoCromosoma))
			vistaConfiguracion.getLblErrorCromosoma().setVisible(true);
		if(!Utilidades.esEntero(cantidadGenesMutar))
			vistaConfiguracion.getLblErrorGenes().setVisible(true);
		if(vistaConfiguracion.getRdbtnManual().isSelected() && !Utilidades.esHexadecimal(clave))			
			vistaConfiguracion.getTextAreaErrorClave().setVisible(true);
		if(vistaConfiguracion.getRdbtnManual().isSelected()) {
			if(Utilidades.esEntero(tamañoPoblacion) && Utilidades.esEntero(tamañoCromosoma) && Utilidades.esEntero(cantidadGenesMutar) && Utilidades.esHexadecimal(clave)){
				vistaConfiguracion.getBtnBuscar().setVisible(true);
				vistaConfiguracion.getBtnBuscar().setEnabled(true);
			}
		}
		else {
			if(Utilidades.esEntero(tamañoPoblacion) && Utilidades.esEntero(tamañoCromosoma) && Utilidades.esEntero(cantidadGenesMutar)) {
				vistaConfiguracion.getBtnBuscar().setVisible(true);
				vistaConfiguracion.getBtnBuscar().setEnabled(true);	
			}
		}		
	}
	
	private static void resetearMensajesError(VistaConfiguracion vistaConfiguracion) {		
		vistaConfiguracion.getLblErrorPoblacion().setVisible(false);
		vistaConfiguracion.getLblErrorCromosoma().setVisible(false);
		vistaConfiguracion.getLblErrorGenes().setVisible(false);
		vistaConfiguracion.getTextAreaErrorClave().setVisible(false);
		vistaConfiguracion.getBtnBuscar().setVisible(false);
		vistaConfiguracion.getBtnBuscar().setEnabled(false);		
	}

}