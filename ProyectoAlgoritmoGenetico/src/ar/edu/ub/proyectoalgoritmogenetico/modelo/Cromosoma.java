package ar.edu.ub.proyectoalgoritmogenetico.modelo;

import java.util.concurrent.ThreadLocalRandom;

public class Cromosoma {
	
	private String[] hexadecimal = new String[tama�oCromosoma];
	private String[] binario = new String[tama�oCromosoma];
	private Integer Fitness;
	private static Integer tama�oCromosoma;
	
	public Cromosoma () {
		Integer random;
		for(Integer i=0;i<tama�oCromosoma;i++) {
			random = ThreadLocalRandom.current().nextInt(0, 15 + 1);
			this.setPosicionHexadecimal(Integer.toHexString(random).toUpperCase(),i);
			this.setPosicionBinario(String.format("%4s",Integer.toBinaryString(random)).replace(' ','0'),i);
		}		
	}
	
	public Cromosoma(String clave) {
		String [] array = clave.split("");
		this.setHexadecimal(array);
		for(Integer i=0;i<tama�oCromosoma;i++) {
			this.setPosicionBinario(String.format("%4s",Integer.toBinaryString(Integer.parseInt(array[i], 16))).replace(' ','0'),i);
		}
	}

	public static Integer getTama�oCromosoma() {
		return tama�oCromosoma;
	}

	public static void setTama�oCromosoma(Integer tama�oCromosoma) {
		Cromosoma.tama�oCromosoma = tama�oCromosoma;
	}

	public String[] getHexadecimal() {
		return this.hexadecimal;
	}

	public void setPosicionHexadecimal(String hexadecimal,Integer posicion) {
		this.hexadecimal[posicion] = hexadecimal;
	}

	public String[] getBinario() {
		return this.binario;
	}
	
	public String getBinarioString() {
		String str = "";
		for(String aux : binario)
			str = str + aux;
		return str;
	}
	
	public String getHexadecimalString() {
		String str = "";
		for(String aux : hexadecimal)
			str = str + aux;
		return str;
	}

	public void setPosicionBinario(String binario,Integer posicion) {
		this.binario[posicion] = binario;
	}
	
	public String getPosicionBinario(Integer posicion) {
		return this.getBinario()[posicion];
	}

	public void setHexadecimal(String[] hexadecimal) {
		this.hexadecimal = hexadecimal;
	}
	
	public String getPosicionHexadecimal(Integer posicion) {
		return this.getHexadecimal()[posicion];
	}
	
	public Integer getFitness() {
		return this.Fitness;
	}

	public void setFitness(Integer fitness) {
		this.Fitness = fitness;
	}	
	
	public String toString() {
		String str = "";
		for(Integer i=0;i<tama�oCromosoma;i++)
			str = str + this.getPosicionHexadecimal(i) + " ";
		str = str + "\n";
		for(Integer i=0;i<tama�oCromosoma;i++)
			str = str +  this.getPosicionBinario(i) + " ";
		return str;
	}
}