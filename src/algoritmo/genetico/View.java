package algoritmo.genetico;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;

public class View {
	private JFrame frame;
	private JButton btnBuscar;
	private JLabel lblCantidadDeIteraciones;
	private JLabel lblNumeroIteraciones;
	private JLabel lblCromosomaABuscar;
	private JLabel lblPoblacion;
	private JTextArea ListaPoblacion;
	private JTextArea clave;

	public View(Controlador controlador) {
		frame = new JFrame();
		frame.setBounds(100, 100, 544, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnBuscar = new JButton("buscar");
		btnBuscar.setBounds(239, 393, 89, 23);
		frame.getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(controlador);

		lblCantidadDeIteraciones = new JLabel(
				"Cromosoma encontrado en generacion:");
		lblCantidadDeIteraciones.setBounds(10, 73, 276, 36);
		frame.getContentPane().add(lblCantidadDeIteraciones);

		lblNumeroIteraciones = new JLabel("");
		lblNumeroIteraciones.setBounds(296, 84, 71, 14);
		frame.getContentPane().add(lblNumeroIteraciones);

		lblCromosomaABuscar = new JLabel("Cromosoma a buscar:");
		lblCromosomaABuscar.setBounds(10, 26, 145, 36);
		frame.getContentPane().add(lblCromosomaABuscar);
		
		lblPoblacion = new JLabel("Ultima poblacion:");
		lblPoblacion.setBounds(10, 144, 109, 51);
		frame.getContentPane().add(lblPoblacion);
		
		ListaPoblacion = new JTextArea();
		ListaPoblacion.setBackground(UIManager.getColor("Viewport.background"));
		ListaPoblacion.setForeground(Color.BLACK);
		ListaPoblacion.setEditable(false);
		ListaPoblacion.setBounds(148, 157, 353, 204);
		frame.getContentPane().add(ListaPoblacion);
		
		clave = new JTextArea();
		clave.setBackground(UIManager.getColor("Viewport.background"));
		clave.setEditable(false);
		clave.setBounds(183, 32, 196, 36);
		frame.getContentPane().add(clave);

	}
	
	public void mostrar(){
		frame.setVisible(true);
	}
	
	public JTextArea getClave() {
		return clave;
	}

	public void setClave(JTextArea clave) {
		this.clave = clave;
	}

	public JTextArea getListaPoblacion() {
		return ListaPoblacion;
	}

	public void setListaPoblacion(JTextArea listaPoblacion) {
		ListaPoblacion = listaPoblacion;
	}

	public JLabel getLblPoblacion() {
		return lblPoblacion;
	}

	public void setLblPoblacion(JLabel lblPoblacion) {
		this.lblPoblacion = lblPoblacion;
	}


	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JLabel getLblCantidadDeIteraciones() {
		return lblCantidadDeIteraciones;
	}

	public void setLblCantidadDeIteraciones(JLabel lblCantidadDeIteraciones) {
		this.lblCantidadDeIteraciones = lblCantidadDeIteraciones;
	}

	public JLabel getLblNumeroIteraciones() {
		return lblNumeroIteraciones;
	}

	public void setLblNumeroIteraciones(JLabel lblNumeroIteraciones) {
		this.lblNumeroIteraciones = lblNumeroIteraciones;
	}

	public JLabel getLblCromosomaABuscar() {
		return lblCromosomaABuscar;
	}

	public void setLblCromosomaABuscar(JLabel lblCromosomaABuscar) {
		this.lblCromosomaABuscar = lblCromosomaABuscar;
	}
}
