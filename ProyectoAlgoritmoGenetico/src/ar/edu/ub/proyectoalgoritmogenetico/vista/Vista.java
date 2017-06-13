package ar.edu.ub.proyectoalgoritmogenetico.vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Vista extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel lblCantidadDeIteraciones;
	private JLabel lblNumeroIteraciones;
	private JLabel lblCromosomaABuscar;
	private JLabel lblPoblacion;
	private JTextArea ListaPoblacion;
	private JTextArea clave;
	
	public Vista() {		
		this.setFrame(new JFrame());
		this.getFrame().setBounds(500, 500, 500, 400);
		this.getFrame().setLocation(150, 200);
		this.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getFrame().getContentPane().setLayout(null);
		this.getFrame().setSize(500, 500);
		this.getFrame().setTitle("Resultado");
		
		this.setLblCantidadDeIteraciones(new JLabel("Cromosoma encontrado en generacion:"));
		this.getLblCantidadDeIteraciones().setBounds(10, 73, 276, 36);
		this.getFrame().getContentPane().add(this.getLblCantidadDeIteraciones());

		this.setLblNumeroIteraciones(new JLabel(""));
		this.getLblNumeroIteraciones().setBounds(296, 84, 71, 14);
		this.getFrame().getContentPane().add(this.getLblNumeroIteraciones());

		this.setLblCromosomaABuscar(new JLabel("Cromosoma a buscar:"));
		this.getLblCromosomaABuscar().setBounds(10, 26, 145, 36);
		this.getFrame().getContentPane().add(this.getLblCromosomaABuscar());
		
		this.setLblPoblacion(new JLabel("Ultima poblacion:"));
		this.getLblPoblacion().setBounds(10, 144, 109, 51);
		this.getFrame().getContentPane().add(this.getLblPoblacion());
		
		this.setListaPoblacion(new JTextArea());
		this.getListaPoblacion().setBackground(UIManager.getColor("Viewport.background"));
		this.getListaPoblacion().setForeground(Color.BLACK);
		this.getListaPoblacion().setEditable(false);
		this.getListaPoblacion().setBounds(148, 157, 353, 204);
		this.getFrame().getContentPane().add(this.getListaPoblacion());
		
		this.setClave(new JTextArea());
		this.getClave().setBackground(UIManager.getColor("Viewport.background"));
		this.getClave().setEditable(false);
		this.getClave().setBounds(183, 32, 196, 36);
		this.getFrame().getContentPane().add(this.getClave());
		
		this.getFrame().setVisible(true);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
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
		this.ListaPoblacion = listaPoblacion;
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
		
}