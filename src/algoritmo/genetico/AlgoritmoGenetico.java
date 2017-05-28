package algoritmo.genetico;

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
		//ManejadorDB db = new ManejadorDB();		
		this.setCantidadGeneraciones(0);
		Integer finessMaximo = (Cromosoma.tamañoCromosoma + 1)
				* Cromosoma.tamañoCromosoma * 4 * Cromosoma.tamañoCromosoma * 4;
		poblacion.evaluarPoblacion(clave);
		while (poblacion.mayorFitness() < finessMaximo) {
			poblacion.seleccionarParejas();
			poblacion.cruzarParejas();
			poblacion.mutar();
			poblacion.evaluarPoblacion(clave);
			this.setCantidadGeneraciones(this.getCantidadGeneraciones() + 1);
			System.out.println(poblacion.getPoblacionString());
		}
		System.out.println("Clave encontrada despues de "
				+ this.getCantidadGeneraciones() + " generaciones.");
		//db.borrarCromosomasBD();
		//db.insertarCromosomasBD(poblacion);
	}

}