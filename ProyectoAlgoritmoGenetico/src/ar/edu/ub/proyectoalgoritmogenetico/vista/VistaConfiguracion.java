package ar.edu.ub.proyectoalgoritmogenetico.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

import ar.edu.ub.proyectoalgoritmogenetico.controlador.AlgoritmoGeneticoControlador;

public class VistaConfiguracion extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtFieldManual;
	private JLabel lblTamañoDePoblacion;
	private JSlider sliderTamañoPoblacion;
	private JLabel lblTamañoDeCromosoma;
	private JSlider sliderTamañoCromosoma;
	private JLabel lblCantidadDeGenes;
	private JSlider sliderCantidadGenes;
	private JLabel lblClave;
	private JRadioButton rdbtnManual;
	private JRadioButton rdbtnAutomatica;
	private JButton btnBuscar;
	
	public VistaConfiguracion() {
		getContentPane().setLayout(null);
		
		this.setSize(500, 500);
		
		lblTamañoDePoblacion = new JLabel("Tama\u00F1o de poblacion:");
		lblTamañoDePoblacion.setBounds(10, 11, 121, 23);
		getContentPane().add(lblTamañoDePoblacion);
		
		sliderTamañoPoblacion = new JSlider();
		sliderTamañoPoblacion.setValue(250);
		sliderTamañoPoblacion.setMinorTickSpacing(1);
		sliderTamañoPoblacion.setMinimum(10);
		sliderTamañoPoblacion.setMaximum(500);
		sliderTamañoPoblacion.setBounds(172, 11, 200, 37);
		getContentPane().add(sliderTamañoPoblacion);
		
		lblTamañoDeCromosoma = new JLabel("Tama\u00F1o de cromosoma:");
		lblTamañoDeCromosoma.setBounds(10, 45, 132, 14);
		getContentPane().add(lblTamañoDeCromosoma);
		
		sliderTamañoCromosoma = new JSlider();
		sliderTamañoCromosoma.setValue(25);
		sliderTamañoCromosoma.setMinorTickSpacing(1);
		sliderTamañoCromosoma.setMinimum(1);
		sliderTamañoCromosoma.setMaximum(50);
		sliderTamañoCromosoma.setBounds(148, 45, 200, 30);
		sliderTamañoCromosoma.setPaintLabels(true);
		sliderTamañoCromosoma.setPaintTicks(true);
		sliderTamañoCromosoma.setPaintTrack(true);
		
		getContentPane().add(sliderTamañoCromosoma);
		
		lblCantidadDeGenes = new JLabel("Cantidad de genes a mutar:");
		lblCantidadDeGenes.setBounds(10, 98, 150, 14);
		getContentPane().add(lblCantidadDeGenes);
		
		sliderCantidadGenes = new JSlider();
		sliderCantidadGenes.setValue(2);
		sliderCantidadGenes.setMinimum(1);
		sliderCantidadGenes.setMaximum(4);
		sliderCantidadGenes.setBounds(158, 95, 200, 30);
		getContentPane().add(sliderCantidadGenes);
		
		lblClave = new JLabel("Clave:");
		lblClave.setBounds(10, 148, 59, 14);
		getContentPane().add(lblClave);
		
		ButtonGroup botonGrupo = new ButtonGroup();
		
		rdbtnManual = new JRadioButton("Manual");
		rdbtnManual.setBounds(32, 169, 80, 37);
		rdbtnManual.addActionListener(this);
		botonGrupo.add(rdbtnManual);
		getContentPane().add(rdbtnManual);
		
		rdbtnAutomatica = new JRadioButton("Automatica");
		rdbtnAutomatica.setBounds(32, 202, 93, 30);
		rdbtnAutomatica.addActionListener(this);
		botonGrupo.add(rdbtnAutomatica);
		getContentPane().add(rdbtnAutomatica);
		
		txtFieldManual = new JTextField();
		txtFieldManual.setEditable(false);
		txtFieldManual.setBounds(131, 173, 200, 29);
		getContentPane().add(txtFieldManual);
		txtFieldManual.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(178, 228, 108, 23);
		btnBuscar.addActionListener(this);
		getContentPane().add(btnBuscar);
		
		this.setVisible(true);
	}
	
	public JTextField getTxtFieldManual() {
		return txtFieldManual;
	}

	public void setTxtFieldManual(JTextField txtFieldManual) {
		this.txtFieldManual = txtFieldManual;
	}

	public JLabel getLblTamañoDePoblacion() {
		return lblTamañoDePoblacion;
	}

	public void setLblTamañoDePoblacion(JLabel lblTamañoDePoblacion) {
		this.lblTamañoDePoblacion = lblTamañoDePoblacion;
	}

	public JSlider getSliderTamañoPoblacion() {
		return sliderTamañoPoblacion;
	}

	public void setSliderTamañoPoblacion(JSlider sliderTamañoPoblacion) {
		this.sliderTamañoPoblacion = sliderTamañoPoblacion;
	}

	public JLabel getLblTamañoDeCromosoma() {
		return lblTamañoDeCromosoma;
	}

	public void setLblTamañoDeCromosoma(JLabel lblTamañoDeCromosoma) {
		this.lblTamañoDeCromosoma = lblTamañoDeCromosoma;
	}

	public JSlider getSliderTamañoCromosoma() {
		return sliderTamañoCromosoma;
	}

	public void setSliderTamañoCromosoma(JSlider sliderTamañoCromosoma) {
		this.sliderTamañoCromosoma = sliderTamañoCromosoma;
	}

	public JLabel getLblCantidadDeGenes() {
		return lblCantidadDeGenes;
	}

	public void setLblCantidadDeGenes(JLabel lblCantidadDeGenes) {
		this.lblCantidadDeGenes = lblCantidadDeGenes;
	}

	public JSlider getSliderCantidadGenes() {
		return sliderCantidadGenes;
	}

	public void setSliderCantidadGenes(JSlider sliderCantidadGenes) {
		this.sliderCantidadGenes = sliderCantidadGenes;
	}

	public JLabel getLblClave() {
		return lblClave;
	}

	public void setLblClave(JLabel lblClave) {
		this.lblClave = lblClave;
	}

	public JRadioButton getRdbtnManual() {
		return rdbtnManual;
	}

	public void setRdbtnManual(JRadioButton rdbtnManual) {
		this.rdbtnManual = rdbtnManual;
	}

	public JRadioButton getRdbtnAutomatica() {
		return rdbtnAutomatica;
	}

	public void setRdbtnAutomatica(JRadioButton rdbtnAutomatica) {
		this.rdbtnAutomatica = rdbtnAutomatica;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.getBtnBuscar()) {
			AlgoritmoGeneticoControlador.buscar();
		}	
		if(e.getSource() == this.getRdbtnManual()) {
			txtFieldManual.setEditable(true);
		}
		if(e.getSource() == this.getRdbtnAutomatica()) {
			txtFieldManual.setEditable(false);
		}
	}
	
}
