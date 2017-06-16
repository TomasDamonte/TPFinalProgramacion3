package ar.edu.ub.proyectoalgoritmogenetico.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.SwingConstants;

public class VistaConfiguracion extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;	
	private JLabel lblTama�oDePoblacion;
	private JLabel lblTama�oDeCromosoma;
	private JLabel lblCantidadDeGenes;
	private JLabel lblClave;
	private JRadioButton rdbtnManual;
	private JRadioButton rdbtnAutomatica;
	private JButton btnBuscar;
	private JTextField textFieldTama�oPoblacion;
	private JTextField textFieldTama�oCromosoma;
	private JTextField textFieldCantidadGenesMutar;
	private JTextField textFieldClave;
	private JLabel lblErrorPoblacion;
	private JLabel lblErrorCromosoma;
	private JLabel lblErrorGenes;
	private JTextArea textAreaErrorClave;

	public VistaConfiguracion() {
		getContentPane().setBackground(UIManager.getColor("Button.background"));
		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 500);
		this.setTitle("Configuraci�n");		

		this.setLblTama�oDePoblacion(new JLabel("Cantidad de individuos:"));
		this.getLblTama�oDePoblacion().setBounds(10, 11, 150, 23);
		this.getContentPane().add(this.getLblTama�oDePoblacion());

		this.setLblTama�oDeCromosoma(new JLabel("Cantidad de genes:"));
		this.getLblTama�oDeCromosoma().setBounds(10, 62, 150, 14);
		this.getContentPane().add(this.getLblTama�oDeCromosoma());

		this.setLblCantidadDeGenes(new JLabel("Cantidad de genes a mutar:"));
		this.getLblCantidadDeGenes().setBounds(10, 98, 158, 14);
		this.getContentPane().add(this.getLblCantidadDeGenes());

		this.setLblClave(new JLabel("Clave:"));
		this.getLblClave().setBounds(10, 148, 59, 14);
		this.getContentPane().add(this.getLblClave());

		ButtonGroup botonGrupo = new ButtonGroup();

		this.setRdbtnManual(new JRadioButton("Manual"));
		this.getRdbtnManual().setBounds(32, 169, 80, 37);
		this.getRdbtnManual().addActionListener(this);
		botonGrupo.add(this.getRdbtnManual());
		this.getContentPane().add(this.getRdbtnManual());

		this.setRdbtnAutomatica(new JRadioButton("Autom\u00E1tica"));
		this.getRdbtnAutomatica().setBounds(32, 202, 93, 30);
		this.getRdbtnAutomatica().setSelected(true);
		this.getRdbtnAutomatica().addActionListener(this);
		botonGrupo.add(this.getRdbtnAutomatica());
		this.getContentPane().add(this.getRdbtnAutomatica());

		this.setTextFieldClave(new JTextField());
		this.getTextFieldClave().setEditable(false);
		this.getTextFieldClave().setBounds(113, 173, 200, 29);
		this.getContentPane().add(this.getTextFieldClave());
		this.getTextFieldClave().setColumns(10);
		this.getTextFieldClave().addKeyListener(this);

		this.setBtnBuscar(new JButton("Simular"));
		this.getBtnBuscar().setBounds(178, 270, 108, 23);
		this.getBtnBuscar().addActionListener(this);		
		this.getContentPane().add(this.getBtnBuscar());

		this.setTextFieldTama�oPoblacion(new JTextField());
		this.getTextFieldTama�oPoblacion().setBounds(178, 12, 86, 22);
		this.getContentPane().add(this.getTextFieldTama�oPoblacion());
		this.getTextFieldTama�oPoblacion().setColumns(10);
		this.getTextFieldTama�oPoblacion().addKeyListener(this);

		this.setTextFieldTama�oCromosoma(new JTextField());
		this.getTextFieldTama�oCromosoma().setBounds(178, 58, 86, 23);
		this.getContentPane().add(this.getTextFieldTama�oCromosoma());
		this.getTextFieldTama�oCromosoma().setColumns(10);
		this.getTextFieldTama�oCromosoma().addKeyListener(this);

		this.setTextFieldCantidadGenesMutar(new JTextField());
		this.getTextFieldCantidadGenesMutar().setBounds(178, 95, 86, 23);
		this.getContentPane().add(this.getTextFieldCantidadGenesMutar());
		this.getTextFieldCantidadGenesMutar().setColumns(10);
		this.getTextFieldCantidadGenesMutar().addKeyListener(this);

		this.setLblErrorPoblacion(new JLabel("Este campo solo acepta enteros"));
		this.getLblErrorPoblacion().setBounds(310, 15, 192, 19);
		this.getLblErrorPoblacion().setVisible(false);
		this.getLblErrorPoblacion().setForeground(Color.RED);
		this.getContentPane().add(this.getLblErrorPoblacion());

		this.setLblErrorCromosoma(new JLabel("Este campo solo acepta enteros"));
		this.getLblErrorCromosoma().setBounds(310, 62, 192, 14);
		this.getLblErrorCromosoma().setVisible(false);
		this.getLblErrorCromosoma().setForeground(Color.RED);
		this.getContentPane().add(this.getLblErrorCromosoma());

		this.setLblErrorGenes(new JLabel("Este campo solo acepta enteros"));
		this.getLblErrorGenes().setBounds(310, 98, 192, 23);
		this.getLblErrorGenes().setVisible(false);
		this.getLblErrorGenes().setForeground(Color.RED);
		this.getContentPane().add(this.getLblErrorGenes());

		this.setTextAreaErrorClave(new JTextArea());
		this.getTextAreaErrorClave().setBackground(UIManager.getColor("ComboBox.disabledBackground"));
		this.getTextAreaErrorClave().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		this.getTextAreaErrorClave().setText("Este campo solo acepta\r\nvalores hexadecimales");
		this.getTextAreaErrorClave().setEditable(false);
		this.getTextAreaErrorClave().setBounds(323, 169, 151, 37);
		this.getTextAreaErrorClave().setForeground(Color.RED);
		this.getTextAreaErrorClave().setVisible(false);
		this.getContentPane().add(this.getTextAreaErrorClave());

		this.setVisible(true);
	}

	public JLabel getLblErrorPoblacion() {
		return this.lblErrorPoblacion;
	}

	public void setLblErrorPoblacion(JLabel lblErrorPoblacion) {
		this.lblErrorPoblacion = lblErrorPoblacion;
		lblErrorPoblacion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
	}

	public JLabel getLblErrorCromosoma() {
		return this.lblErrorCromosoma;
	}

	public void setLblErrorCromosoma(JLabel lblErrorCromosoma) {
		this.lblErrorCromosoma = lblErrorCromosoma;
		lblErrorCromosoma.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
	}

	public JLabel getLblErrorGenes() {
		return this.lblErrorGenes;
	}

	public void setLblErrorGenes(JLabel lblErrorGenes) {
		this.lblErrorGenes = lblErrorGenes;
		lblErrorGenes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
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
		textFieldClave.setHorizontalAlignment(SwingConstants.RIGHT);
	}

	public JLabel getLblTama�oDePoblacion() {
		return this.lblTama�oDePoblacion;
	}

	public void setLblTama�oDePoblacion(JLabel lblTama�oDePoblacion) {
		this.lblTama�oDePoblacion = lblTama�oDePoblacion;
		lblTama�oDePoblacion.setToolTipText("Cantidad de cromosomas de la poblaci\u00F3n");
	}

	public JLabel getLblTama�oDeCromosoma() {
		return this.lblTama�oDeCromosoma;
	}

	public void setLblTama�oDeCromosoma(JLabel lblTama�oDeCromosoma) {
		this.lblTama�oDeCromosoma = lblTama�oDeCromosoma;
		lblTama�oDeCromosoma.setToolTipText("Cantidad de caracteres hexadecimales de cada cromosoma");
	}

	public JLabel getLblCantidadDeGenes() {
		return this.lblCantidadDeGenes;
	}

	public void setLblCantidadDeGenes(JLabel lblCantidadDeGenes) {
		this.lblCantidadDeGenes = lblCantidadDeGenes;
		lblCantidadDeGenes.setToolTipText("Cantidad de cromosomas y genes a mutar en cada generaci\u00F3n");
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
		rdbtnAutomatica.setToolTipText("Clave generada al alzar por el programa");
	}

	public JButton getBtnBuscar() {
		return this.btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
	}

	public JTextField getTextFieldTama�oPoblacion() {
		return this.textFieldTama�oPoblacion;
	}

	public void setTextFieldTama�oPoblacion(JTextField textFieldTama�oPoblacion) {
		this.textFieldTama�oPoblacion = textFieldTama�oPoblacion;
		textFieldTama�oPoblacion.setHorizontalAlignment(SwingConstants.RIGHT);
	}

	public JTextField getTextFieldTama�oCromosoma() {
		return this.textFieldTama�oCromosoma;
	}

	public void setTextFieldTama�oCromosoma(JTextField textFieldTama�oCromosoma) {
		this.textFieldTama�oCromosoma = textFieldTama�oCromosoma;
		textFieldTama�oCromosoma.setHorizontalAlignment(SwingConstants.RIGHT);
	}

	public JTextField getTextFieldCantidadGenesMutar() {
		return this.textFieldCantidadGenesMutar;
	}

	public void setTextFieldCantidadGenesMutar(JTextField textFieldCantidadGenesMutar) {
		this.textFieldCantidadGenesMutar = textFieldCantidadGenesMutar;
		textFieldCantidadGenesMutar.setHorizontalAlignment(SwingConstants.RIGHT);
	}

	private void resetearMensajesError() {
		this.getLblErrorPoblacion().setVisible(false);
		this.getLblErrorCromosoma().setVisible(false);
		this.getLblErrorGenes().setVisible(false);
		this.getTextAreaErrorClave().setVisible(false);		
	}

	public void actionPerformed(ActionEvent e) {			
		if(e.getSource() == this.getBtnBuscar()) {
			this.resetearMensajesError();
			AlgoritmoGeneticoControlador.validarConfiguracion(this.getTextFieldTama�oPoblacion().getText(),
					this.getTextFieldTama�oCromosoma().getText(),this.getTextFieldCantidadGenesMutar().getText(),
					this.getTextFieldClave().getText(),this.getRdbtnManual().isSelected());
			if (!(Boolean) Contexto.get(Validaciones.VALIDACION_ENTERO_TAMA�O_POBLACION))
				this.getLblErrorPoblacion().setVisible(Boolean.TRUE);
			if (!(Boolean) Contexto.get(Validaciones.VALIDACION_ENTERO_TAMA�O_CROMOSOMA))
				this.getLblErrorCromosoma().setVisible(Boolean.TRUE);
			if (!(Boolean) Contexto.get(Validaciones.VALIDACION_ENTERO_GENES_A_MUTAR))
				this.getLblErrorGenes().setVisible(Boolean.TRUE);
			if (!(Boolean) Contexto.get(Validaciones.VALIDACION_HEXADECIMAL_CLAVE))
				this.getTextAreaErrorClave().setVisible(Boolean.TRUE);
			if ((Boolean) Contexto.get(Validaciones.VALIDACION_ENTERO_TAMA�O_POBLACION) && (Boolean) Contexto.get(Validaciones.VALIDACION_ENTERO_TAMA�O_CROMOSOMA) && (Boolean) Contexto.get(Validaciones.VALIDACION_ENTERO_GENES_A_MUTAR) && (Boolean) Contexto.get(Validaciones.VALIDACION_HEXADECIMAL_CLAVE))
				AlgoritmoGeneticoControlador.simular(this.getTextFieldTama�oPoblacion().getText(),this.getTextFieldTama�oCromosoma().getText(),this.getTextFieldCantidadGenesMutar().getText(),this.getTextFieldClave().getText());
		}
		if(e.getSource() == this.getRdbtnManual()) 
			textFieldClave.setEditable(true);
		if(e.getSource() == this.getRdbtnAutomatica()) 
			textFieldClave.setEditable(false);	
	}

	public void keyPressed(KeyEvent e) {


	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (this.getTextFieldCantidadGenesMutar().getText().length()>= 2  && (c != KeyEvent.VK_BACK_SPACE)) {
			e.consume();  // ignore event
		
		}
		else if (this.getTextFieldTama�oCromosoma().getText().length()>= 2  && (c != KeyEvent.VK_BACK_SPACE)) {
			e.consume();  // ignore event
		}
		else if (this.getTextFieldTama�oPoblacion().getText().length()>= 2  && (c != KeyEvent.VK_BACK_SPACE)) {
			e.consume();  // ignore event
		}
		else if (this.getTextFieldClave().getText().length()>= 6  && (c != KeyEvent.VK_BACK_SPACE)) {
			e.consume();  // ignore event
		}

	}
}