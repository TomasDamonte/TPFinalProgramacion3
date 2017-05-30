package ar.edu.ub.proyectoalgoritmogenetico.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import ar.edu.ub.proyectoalgorimogenetico.vista.Vista;
import ar.edu.ub.proyectoalgoritmogenetico.modelo.AlgoritmoGenetico;

public class AlgoritmoGeneticoControlador implements ActionListener {
	private Vista vista;
	AlgoritmoGenetico algen = new AlgoritmoGenetico();
	
	public AlgoritmoGeneticoControlador() {
		this.vista = new Vista(this);
		vista.getClave().setText(algen.getClave().getHexadecimalString() + "\n" + algen.getClave().getBinarioString());
		vista.mostrar();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vista.getBtnBuscar()) {
			try {
				algen.buscar(algen.getClave());
				vista.getLblNumeroIteraciones().setText(algen.getCantidadGeneraciones().toString());
				vista.getListaPoblacion().setText(algen.getPoblacion().getPoblacionString());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}		
	}
	
}