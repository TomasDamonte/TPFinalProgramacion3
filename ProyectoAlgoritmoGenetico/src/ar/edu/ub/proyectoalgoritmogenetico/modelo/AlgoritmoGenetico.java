package ar.edu.ub.proyectoalgoritmogenetico.modelo;

import java.sql.SQLException;

public class AlgoritmoGenetico {
	
	private Cromosoma clave; 
	private Integer cantidadGeneraciones;
	private Poblacion poblacion;

	public AlgoritmoGenetico(Integer tama�oPoblacion, Integer tama�oCromosoma, Integer cantidadGenesMutar) {
		Cromosoma.setTama�oCromosoma(tama�oCromosoma);
		this.setPoblacion(new Poblacion(tama�oPoblacion,cantidadGenesMutar));
	}

	public Poblacion getPoblacion() {
		return this.poblacion;
	}

	public void setPoblacion(Poblacion poblacion) {
		this.poblacion = poblacion;
	}

	public Cromosoma getClave() {
		return this.clave;
	}

	public void setClave(Cromosoma clave) {
		this.clave = clave;
	}

	public Integer getCantidadGeneraciones() {
		return this.cantidadGeneraciones;
	}

	public void setCantidadGeneraciones(Integer cantidadGeneraciones) {
		this.cantidadGeneraciones = cantidadGeneraciones;
	}
	
	public void buscar() {		
		this.setCantidadGeneraciones(0);
		Integer finessMaximo = (Cromosoma.getTama�oCromosoma()+ 1)
				* Cromosoma.getTama�oCromosoma() * 4 * Cromosoma.getTama�oCromosoma() * 4;
		this.getPoblacion().evaluarPoblacion(this.getClave());
		System.out.println(this.getPoblacion());
		while (this.getPoblacion().mayorFitness() < finessMaximo) {
			this.getPoblacion().seleccionarParejas();
			this.getPoblacion().cruzarParejas();
			this.getPoblacion().mutar();
			this.getPoblacion().evaluarPoblacion(this.getClave());
			this.setCantidadGeneraciones(this.getCantidadGeneraciones() + 1);
			System.out.println(this.getPoblacion());
		}
		System.out.println("Clave encontrada despues de "
				+ this.getCantidadGeneraciones() + " generaciones.");		
	}
	
	public void guardarEnDB() throws SQLException {
		ManejadorDB db = new ManejadorDB();		
		db.borrarCromosomasBD();
		db.insertarCromosomasBD(this.getPoblacion());
	}
	
}