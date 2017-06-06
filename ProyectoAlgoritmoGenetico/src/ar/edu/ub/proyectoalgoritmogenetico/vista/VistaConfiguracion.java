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
	private JLabel lblTama�oDePoblacion;
	private JSlider sliderTama�oPoblacion;
	private JLabel lblTama�oDeCromosoma;
	private JSlider sliderTama�oCromosoma;
	private JLabel lblCantidadDeGenes;
	private JSlider sliderCantidadGenes;
	private JLabel lblClave;
	private JRadioButton rdbtnManual;
	private JRadioButton rdbtnAutomatica;
	private JButton btnBuscar;
	
	public VistaConfiguracion() {
		getContentPane().setLayout(null);
		
		this.setSize(500, 500);
		
		lblTama�oDePoblacion = new JLabel("Tama\u00F1o de poblacion:");
		lblTama�oDePoblacion.setBounds(10, 11, 121, 23);
		getContentPane().add(lblTama�oDePoblacion);
		
		sliderTama�oPoblacion = new JSlider();
		sliderTama�oPoblacion.setValue(250);
		sliderTama�oPoblacion.setMinorTickSpacing(1);
		sliderTama�oPoblacion.setMinimum(10);
		sliderTama�oPoblacion.setMaximum(500);
		sliderTama�oPoblacion.setBounds(172, 11, 200, 37);
		getContentPane().add(sliderTama�oPoblacion);
		
		lblTama�oDeCromosoma = new JLabel("Tama\u00F1o de cromosoma:");
		lblTama�oDeCromosoma.setBounds(10, 45, 132, 14);
		getContentPane().add(lblTama�oDeCromosoma);
		
		sliderTama�oCromosoma = new JSlider();
		sliderTama�oCromosoma.setValue(25);
		sliderTama�oCromosoma.setMinorTickSpacing(1);
		sliderTama�oCromosoma.setMinimum(1);
		sliderTama�oCromosoma.setMaximum(50);
		sliderTama�oCromosoma.setBounds(148, 45, 200, 30);
		sliderTama�oCromosoma.setPaintLabels(true);
		sliderTama�oCromosoma.setPaintTicks(true);
		sliderTama�oCromosoma.setPaintTrack(true);
		
		getContentPane().add(sliderTama�oCromosoma);
		
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

	public JLabel getLblTama�oDePoblacion() {
		return lblTama�oDePoblacion;
	}

	public void setLblTama�oDePoblacion(JLabel lblTama�oDePoblacion) {
		this.lblTama�oDePoblacion = lblTama�oDePoblacion;
	}

	public JSlider getSliderTama�oPoblacion() {
		return sliderTama�oPoblacion;
	}

	public void setSliderTama�oPoblacion(JSlider sliderTama�oPoblacion) {
		this.sliderTama�oPoblacion = sliderTama�oPoblacion;
	}

	public JLabel getLblTama�oDeCromosoma() {
		return lblTama�oDeCromosoma;
	}

	public void setLblTama�oDeCromosoma(JLabel lblTama�oDeCromosoma) {
		this.lblTama�oDeCromosoma = lblTama�oDeCromosoma;
	}

	public JSlider getSliderTama�oCromosoma() {
		return sliderTama�oCromosoma;
	}

	public void setSliderTama�oCromosoma(JSlider sliderTama�oCromosoma) {
		this.sliderTama�oCromosoma = sliderTama�oCromosoma;
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
