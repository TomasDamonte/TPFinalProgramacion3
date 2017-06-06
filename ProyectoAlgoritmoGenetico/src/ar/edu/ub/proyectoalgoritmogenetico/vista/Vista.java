package ar.edu.ub.proyectoalgoritmogenetico.vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Vista extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel lblCantidadDeIteraciones;
	private JLabel lblNumeroIteraciones;
	private JLabel lblCromosomaABuscar;
	private JLabel lblPoblacion;
	private JTextArea ListaPoblacion;
	private JTextArea clave;
	
	public Vista() {
		frame = new JFrame();
		frame.setBounds(500, 500, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

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
	
	public JTextArea getClave() {
		return this.clave;
	}

	public void setClave(JTextArea clave) {
		this.clave = clave;
	}

	public JTextArea getListaPoblacion() {
		return this.ListaPoblacion;
	}

	public void setListaPoblacion(JTextArea listaPoblacion) {
		ListaPoblacion = listaPoblacion;
	}

	public JLabel getLblPoblacion() {
		return this.lblPoblacion;
	}

	public void setLblPoblacion(JLabel lblPoblacion) {
		this.lblPoblacion = lblPoblacion;
	}

	public JLabel getLblCantidadDeIteraciones() {
		return this.lblCantidadDeIteraciones;
	}

	public void setLblCantidadDeIteraciones(JLabel lblCantidadDeIteraciones) {
		this.lblCantidadDeIteraciones = lblCantidadDeIteraciones;
	}

	public JLabel getLblNumeroIteraciones() {
		return this.lblNumeroIteraciones;
	}

	public void setLblNumeroIteraciones(JLabel lblNumeroIteraciones) {
		this.lblNumeroIteraciones = lblNumeroIteraciones;
	}

	public JLabel getLblCromosomaABuscar() {
		return this.lblCromosomaABuscar;
	}

	public void setLblCromosomaABuscar(JLabel lblCromosomaABuscar) {
		this.lblCromosomaABuscar = lblCromosomaABuscar;
	}
	
	public void mostrar(){
		this.setVisible(true);
	}
		
}