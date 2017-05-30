package ar.edu.ub.proyectoalgoritmogenetico.modelo;

import java.sql.SQLException;

public class AlgoritmoGenetico {
	
	private Cromosoma clave; 
	private Integer cantidadGeneraciones;
	private Poblacion poblacion;

	public AlgoritmoGenetico(){
		this.setClave( new Cromosoma());
		this.setPoblacion(new Poblacion(5));
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
	
	public void buscar(Cromosoma clave) throws SQLException {
		ManejadorDB db = new ManejadorDB();		
		this.setCantidadGeneraciones(0);
		Integer finessMaximo = (Cromosoma.tama�oCromosoma + 1)
				* Cromosoma.tama�oCromosoma * 4 * Cromosoma.tama�oCromosoma * 4;
		this.getPoblacion().evaluarPoblacion(this.getClave());
		while (this.getPoblacion().mayorFitness() < finessMaximo) {
			this.getPoblacion().seleccionarParejas();
			this.getPoblacion().cruzarParejas();
			this.getPoblacion().mutar();
			this.getPoblacion().evaluarPoblacion(this.getClave());
			this.setCantidadGeneraciones(this.getCantidadGeneraciones() + 1);
			System.out.println(this.getPoblacion().getPoblacionString());
		}
		System.out.println("Clave encontrada despues de "
				+ this.getCantidadGeneraciones() + " generaciones.");
		db.borrarCromosomasBD();
		db.insertarCromosomasBD(this.getPoblacion());
	}

}