package ar.edu.ub.proyectoalgoritmogenetico.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ar.edu.ub.proyectoalgoritmogenetico.controlador.AlgoritmoGeneticoControlador;
import ar.edu.ub.proyectoalgoritmogenetico.util.Contexto;
import ar.edu.ub.proyectoalgoritmogenetico.util.Validaciones;

import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;

public class VistaConfiguracion extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;	
	private JLabel lblTama�oDePoblacion;
	private JLabel lblTama�oDeCromosoma;
	private JLabel lblCantidadDeGenes;
	private JLabel lblClave;
	private JRadioButton rdbtnManual;
	private JRadioButton rdbtnAutomatica;
	private JButton btnBuscar;
	private JButton btnValidarConfiguracion;
	private JTextField textFieldTama�oPoblacion;
	private JTextField textFieldTama�oCromosoma;
	private JTextField textFieldCantidadGenesMutar;
	private JTextField textFieldClave;
	private JLabel lblErrorPoblacion;
	private JLabel lblErrorCromosoma;
	private JLabel lblErrorGenes;
	private JTextArea textAreaErrorClave;
	
	public VistaConfiguracion() {
		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 500);
		this.setTitle("Configuraci�n");		
		
		lblTama�oDePoblacion = new JLabel("Tama\u00F1o de poblacion:");
		lblTama�oDePoblacion.setBounds(10, 11, 150, 23);
		getContentPane().add(lblTama�oDePoblacion);
		
		lblTama�oDeCromosoma = new JLabel("Tama\u00F1o de cromosoma:");
		lblTama�oDeCromosoma.setBounds(10, 62, 150, 14);
		getContentPane().add(lblTama�oDeCromosoma);
		
		lblCantidadDeGenes = new JLabel("Cantidad de genes a mutar:");
		lblCantidadDeGenes.setBounds(10, 98, 158, 14);
		getContentPane().add(lblCantidadDeGenes);
		
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
		rdbtnAutomatica.setSelected(true);
		rdbtnAutomatica.addActionListener(this);
		botonGrupo.add(rdbtnAutomatica);
		getContentPane().add(rdbtnAutomatica);
		
		textFieldClave = new JTextField();
		textFieldClave.setEditable(false);
		textFieldClave.setBounds(113, 173, 200, 29);
		getContentPane().add(textFieldClave);
		textFieldClave.setColumns(10);
		
		btnBuscar = new JButton("Simular");
		btnBuscar.setBounds(178, 270, 108, 23);
		btnBuscar.addActionListener(this);
		btnBuscar.setVisible(false);
		btnBuscar.setEnabled(false);
		getContentPane().add(btnBuscar);
		
		textFieldTama�oPoblacion = new JTextField();
		textFieldTama�oPoblacion.setBounds(178, 12, 86, 22);
		getContentPane().add(textFieldTama�oPoblacion);
		textFieldTama�oPoblacion.setColumns(10);
		
		textFieldTama�oCromosoma = new JTextField();
		textFieldTama�oCromosoma.setBounds(178, 58, 86, 23);
		getContentPane().add(textFieldTama�oCromosoma);
		textFieldTama�oCromosoma.setColumns(10);
		
		textFieldCantidadGenesMutar = new JTextField();
		textFieldCantidadGenesMutar.setBounds(178, 95, 86, 23);
		getContentPane().add(textFieldCantidadGenesMutar);
		textFieldCantidadGenesMutar.setColumns(10);
		
		lblErrorPoblacion = new JLabel("Este campo solo acepta enteros");
		lblErrorPoblacion.setBounds(310, 15, 192, 19);
		lblErrorPoblacion.setVisible(false);
		lblErrorPoblacion.setForeground(Color.RED);
		getContentPane().add(lblErrorPoblacion);
		
		lblErrorCromosoma = new JLabel("Este campo solo acepta enteros");
		lblErrorCromosoma.setBounds(310, 62, 192, 14);
		lblErrorCromosoma.setVisible(false);
		lblErrorCromosoma.setForeground(Color.RED);
		getContentPane().add(lblErrorCromosoma);
		
		lblErrorGenes = new JLabel("Este campo solo acepta enteros");
		lblErrorGenes.setBounds(310, 98, 192, 23);
		lblErrorGenes.setVisible(false);
		lblErrorGenes.setForeground(Color.RED);
		getContentPane().add(lblErrorGenes);
		
		this.setTextAreaErrorClave(new JTextArea());
		this.getTextAreaErrorClave().setBackground(UIManager.getColor("ComboBox.disabledBackground"));
		textAreaErrorClave.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textAreaErrorClave.setText("Este campo solo acepta\r\nvalores hexadecimales");
		textAreaErrorClave.setEditable(false);
		textAreaErrorClave.setBounds(323, 169, 151, 37);
		textAreaErrorClave.setForeground(Color.RED);
		textAreaErrorClave.setVisible(false);
		getContentPane().add(textAreaErrorClave);
		
		btnValidarConfiguracion = new JButton("Validar configuraci\u00F3n");
		btnValidarConfiguracion.setBounds(163, 231, 200, 23);
		btnValidarConfiguracion.addActionListener(this);
		getContentPane().add(btnValidarConfiguracion);
		
		this.setVisible(true);
	}
	
	public JLabel getLblErrorPoblacion() {
		return this.lblErrorPoblacion;
	}

	public void setLblErrorPoblacion(JLabel lblErrorPoblacion) {
		this.lblErrorPoblacion = lblErrorPoblacion;
	}

	public JLabel getLblErrorCromosoma() {
		return this.lblErrorCromosoma;
	}

	public void setLblErrorCromosoma(JLabel lblErrorCromosoma) {
		this.lblErrorCromosoma = lblErrorCromosoma;
	}

	public JLabel getLblErrorGenes() {
		return this.lblErrorGenes;
	}

	public void setLblErrorGenes(JLabel lblErrorGenes) {
		this.lblErrorGenes = lblErrorGenes;
	}

	public JTextArea getTextAreaErrorClave() {
		return this.textAreaErrorClave;
	}

	public void setTextAreaErrorClave(JTextArea textAreaErrorClave) {
		this.textAreaErrorClave = textAreaErrorClave;
	}

	public JTextField getTextFieldClave() {
		return this.textFieldClave;
	}

	public void setTextFieldClave(JTextField txtFieldManual) {
		this.textFieldClave = txtFieldManual;
	}

	public JLabel getLblTama�oDePoblacion() {
		return this.lblTama�oDePoblacion;
	}

	public void setLblTama�oDePoblacion(JLabel lblTama�oDePoblacion) {
		this.lblTama�oDePoblacion = lblTama�oDePoblacion;
	}

	public JLabel getLblTama�oDeCromosoma() {
		return this.lblTama�oDeCromosoma;
	}

	public void setLblTama�oDeCromosoma(JLabel lblTama�oDeCromosoma) {
		this.lblTama�oDeCromosoma = lblTama�oDeCromosoma;
	}

	public JLabel getLblCantidadDeGenes() {
		return this.lblCantidadDeGenes;
	}

	public void setLblCantidadDeGenes(JLabel lblCantidadDeGenes) {
		this.lblCantidadDeGenes = lblCantidadDeGenes;
	}

	public JLabel getLblClave() {
		return this.lblClave;
	}

	public void setLblClave(JLabel lblClave) {
		this.lblClave = lblClave;
	}

	public JRadioButton getRdbtnManual() {
		return this.rdbtnManual;
	}

	public void setRdbtnManual(JRadioButton rdbtnManual) {
		this.rdbtnManual = rdbtnManual;
	}

	public JRadioButton getRdbtnAutomatica() {
		return this.rdbtnAutomatica;
	}

	public void setRdbtnAutomatica(JRadioButton rdbtnAutomatica) {
		this.rdbtnAutomatica = rdbtnAutomatica;
	}

	public JButton getBtnBuscar() {
		return this.btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JTextField getTextFieldTama�oPoblacion() {
		return this.textFieldTama�oPoblacion;
	}

	public void setTextFieldTama�oPoblacion(JTextField textFieldTama�oPoblacion) {
		this.textFieldTama�oPoblacion = textFieldTama�oPoblacion;
	}

	public JTextField getTextFieldTama�oCromosoma() {
		return this.textFieldTama�oCromosoma;
	}

	public void setTextFieldTama�oCromosoma(JTextField textFieldTama�oCromosoma) {
		this.textFieldTama�oCromosoma = textFieldTama�oCromosoma;
	}

	public JTextField getTextFieldCantidadGenesMutar() {
		return this.textFieldCantidadGenesMutar;
	}

	public void setTextFieldCantidadGenesMutar(JTextField textFieldCantidadGenesMutar) {
		this.textFieldCantidadGenesMutar = textFieldCantidadGenesMutar;
	}

	public JButton getBtnValidarConfiguracion() {
		return this.btnValidarConfiguracion;
	}

	public void setBtnValidarConfiguracion(JButton btnValidarConfiguracion) {
		this.btnValidarConfiguracion = btnValidarConfiguracion;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.getBtnValidarConfiguracion()) {
			AlgoritmoGeneticoControlador.validarConfiguracion(this,this.getTextFieldTama�oPoblacion().getText(),this.getTextFieldTama�oCromosoma().getText(),this.getTextFieldCantidadGenesMutar().getText(),this.getTextFieldClave().getText());
			if (!(Boolean) Contexto.get(Validaciones.VALIDACION_ENTERO_TAMA�O_POBLACION))
				this.getLblErrorPoblacion().setVisible(Boolean.TRUE);
		}		
		if(e.getSource() == this.getBtnBuscar()) 
			AlgoritmoGeneticoControlador.simular(this.getTextFieldTama�oPoblacion().getText(),this.getTextFieldTama�oCromosoma().getText(),this.getTextFieldCantidadGenesMutar().getText(),this.getTextFieldClave().getText());
		if(e.getSource() == this.getRdbtnManual()) 
			textFieldClave.setEditable(true);
		if(e.getSource() == this.getRdbtnAutomatica()) 
			textFieldClave.setEditable(false);		
	}
	
}