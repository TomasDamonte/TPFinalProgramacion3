package ar.edu.ub.proyectoalgoritmogenetico.vista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.table.TableColumn;
import javax.swing.JTable;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel lblCantidadDeIteraciones;
	private JLabel lblNumeroIteraciones;
	private JLabel lblCromosomaABuscar;
	private JLabel lblPoblacion;
	private JTextArea clave;
	private JTable table;

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

		this.setClave(new JTextArea());
		this.getClave().setBackground(UIManager.getColor("Viewport.background"));
		this.getClave().setEditable(false);
		this.getClave().setBounds(183, 32, 196, 36);
		this.getFrame().getContentPane().add(this.getClave());

		this.getFrame().setVisible(true);
	}

	public JTable getTable() {
		return this.table;
	}

	public void setTable(JTable table) {
		this.table = table;
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

	public void generarTabla(String[][] registros) {
		String[] columnas = {"Representación binaria","Representacion hexadecimal"};
		this.setTable (new JTable(registros,columnas));
		this.getTable().setPreferredScrollableViewportSize(new Dimension(50, 50));	
		registros[0][0] = "Binario";
		registros[0][1] = "Hexadecimal";
		this.getTable().setBounds(10, 144, 109, 51);
		this.getTable().setFillsViewportHeight(true);		
		this.getFrame().getContentPane().add(new JScrollPane(this.getTable()));		
	}

}