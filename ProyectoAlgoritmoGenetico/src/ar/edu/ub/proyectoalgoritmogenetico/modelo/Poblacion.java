package ar.edu.ub.proyectoalgoritmogenetico.modelo;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Poblacion {

	private LinkedList<Cromosoma> poblacion;
	private Integer tama�o;
	private Integer cantidadGenesMutar;

	public Poblacion(Integer tama�o,Integer cantidadGenesMutar) {
		this.setCantidadGenesMutar(cantidadGenesMutar);
		this.setTama�o(tama�o);
		this.setPoblacion(new LinkedList<Cromosoma>());
		for(Integer i=0;i<this.getTama�o();i++){
			this.agregarCromosoma();
		}
	}

	public Integer getCantidadGenesMutar() {
		return cantidadGenesMutar;
	}

	public void setCantidadGenesMutar(Integer cantidadGenesMutar) {
		this.cantidadGenesMutar = cantidadGenesMutar;
	}

	public Integer getTama�o() {
		return this.tama�o;
	}

	public void setTama�o(Integer tama�o) {
		this.tama�o = tama�o;
	}

	public LinkedList<Cromosoma> getPoblacion() {
		return this.poblacion;
	}

	public void setPoblacion(LinkedList<Cromosoma> poblacion) {
		this.poblacion = poblacion;
	}

	public void agregarCromosoma() {
		this.getPoblacion().add(new Cromosoma());
	}	

	public void seleccionarParejas() {
		Cromosoma c1 = new Cromosoma();
		Cromosoma c2 = new Cromosoma();
		LinkedList<Cromosoma> aux = new LinkedList<Cromosoma>();
		for(Integer i=0;i<this.getTama�o();i++) {
			c1 = this.getPoblacion().get(ThreadLocalRandom.current().nextInt(0,this.getTama�o()-1+1));
			c2 = this.getPoblacion().get(ThreadLocalRandom.current().nextInt(0,this.getTama�o()-1+1));
			if(c1.getFitness() > c2.getFitness())				
				aux.add(c1);			
			else
				aux.add(c2);			
		}
		this.setPoblacion(aux);
	}

	public void cruzarParejas() {
		Cromosoma c1 = new Cromosoma();
		Cromosoma c2 = new Cromosoma();
		Cromosoma c3 = new Cromosoma();
		Integer punto;
		for(Integer i=0;i<this.getTama�o()-1;i++) {
			c1 = this.getPoblacion().get(ThreadLocalRandom.current().nextInt(0,this.getTama�o()-1+1));
			c2 = this.getPoblacion().get(ThreadLocalRandom.current().nextInt(0,this.getTama�o()-1+1));
			punto = ThreadLocalRandom.current().nextInt(0,Cromosoma.getTama�oCromosoma()-1+1);
			for(Integer j=0;j<punto;j++){
				c3.setPosicionHexadecimal(c1.getPosicionHexadecimal(j), j);
				c3.setPosicionBinario(c1.getPosicionBinario(j), j);
				c1.setPosicionHexadecimal(c2.getPosicionHexadecimal(j), j);
				c1.setPosicionBinario(c2.getPosicionBinario(j), j);
				c2.setPosicionHexadecimal(c3.getPosicionHexadecimal(j), j);
				c2.setPosicionBinario(c3.getPosicionBinario(j), j);				
			}
			this.getPoblacion().set(i, c1);
			this.getPoblacion().set(i+1,c2);
		}	
	}

	public void mutar() {
		Cromosoma c = new Cromosoma();
		Integer posC,posBit,pos;
		for(Integer i=0;i<this.getCantidadGenesMutar();i++){
			posC = ThreadLocalRandom.current().nextInt(0,this.getTama�o()-1+1);
			c = this.getPoblacion().get(posC);
			for(Integer j=0;j<this.getCantidadGenesMutar();j++){
				posBit = ThreadLocalRandom.current().nextInt(0,Cromosoma.getTama�oCromosoma()-1+1);
				pos = ThreadLocalRandom.current().nextInt(0,3+1);
				c.setPosicionBinario(cambiarBit(c.getPosicionBinario(posBit),pos),posBit);
			}
			for(Integer j=0;j<Cromosoma.getTama�oCromosoma();j++){
				c.setPosicionHexadecimal(Integer.toString(Integer.parseInt(c.getPosicionBinario(j),2),16).toUpperCase(), j);
			}
			this.getPoblacion().set(posC,c);
		}
	}

	private String cambiarBit(String str,Integer posicion) {
		char[] charArray = str.toCharArray();
		if(str.charAt(posicion) == '0')
			charArray[posicion]='1';
		else
			charArray[posicion]='0';
		return new String(charArray);
	}


	public Integer mayorFitness() {
		Integer mayor=0;
		for(Integer i=0;i<this.getTama�o();i++){
			if(this.getPoblacion().get(i).getFitness() > mayor)
				mayor = this.getPoblacion().get(i).getFitness();
		}
		return mayor;
	}

	public void evaluarPoblacion(Cromosoma clave) {
		Integer h,b;
		for(Integer j=0;j<this.getTama�o();j++){
			h=0;
			b=0;
			for(Integer i=0;i<Cromosoma.getTama�oCromosoma();i++){			
				if(clave.getPosicionHexadecimal(i).equals(this.getPoblacion().get(j).getPosicionHexadecimal(i))){
					h++;
				}
				for(Integer k=0;k<4;k++){
					if(clave.getPosicionBinario(i).charAt(k) == this.getPoblacion().get(j).getPosicionBinario(i).charAt(k)){
						b++;
					}
				}				
			}
			this.getPoblacion().get(j).setFitness((h+1)*b*b);
		}
	}
	
	public String getPoblacionString(){
		String str = "";
		for(Integer i=0;i<this.getTama�o();i++){
			for(Integer j=0;j<Cromosoma.getTama�oCromosoma();j++)
				str = str + this.getPoblacion().get(i).getPosicionHexadecimal(j) + " ";
			str = str + "\n";
			for(Integer j=0;j<Cromosoma.getTama�oCromosoma();j++)
				str = str +  this.getPoblacion().get(i).getPosicionBinario(j) + " ";
			str = str + "\n";
		}
		return str;
	}
	
	public String toString() {
		String str = "";
		for(Integer i=0;i<this.getTama�o();i++){
			for(Integer j=0;j<Cromosoma.getTama�oCromosoma();j++)
				str = str + this.getPoblacion().get(i).getPosicionHexadecimal(j) + " ";
			str = str + "\n";
			for(Integer j=0;j<Cromosoma.getTama�oCromosoma();j++)
				str = str +  this.getPoblacion().get(i).getPosicionBinario(j) + " ";
			str = str + "\n";
		}
		return str;
	}
}