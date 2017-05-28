package algoritmo.genetico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Controlador implements ActionListener{
	private View view;
	AlgoritmoGenetico algen = new AlgoritmoGenetico();
	
	public Controlador(){
		this.view = new View(this);
		view.getClave().setText(algen.getClave().getHexadecimalString() + "\n" + algen.getClave().getBinarioString());
		view.mostrar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getBtnBuscar()){
			try {
				algen.buscar(algen.getClave());
				view.getLblNumeroIteraciones().setText(algen.getCantidadGeneraciones().toString());
				view.getListaPoblacion().setText(algen.getPoblacion().getPoblacionString());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
