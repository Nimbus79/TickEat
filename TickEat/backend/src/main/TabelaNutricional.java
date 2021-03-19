/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Ana Rodrigues(Universidade do Minho)
 * License Type: Academic
 */
package main;

public class TabelaNutricional {
	public TabelaNutricional() {
	}
	
	private int id;
	
	private int energia;
	
	private float lipidos;
	
	private float saturados;
	
	private float hidratos;
	
	private float acucar;
	
	private float fibra;
	
	private float proteinas;
	
	private float sal;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setEnergia(int value) {
		this.energia = value;
	}
	
	public int getEnergia() {
		return energia;
	}
	
	public void setLipidos(float value) {
		this.lipidos = value;
	}
	
	public float getLipidos() {
		return lipidos;
	}
	
	public void setSaturados(float value) {
		this.saturados = value;
	}
	
	public float getSaturados() {
		return saturados;
	}
	
	public void setHidratos(float value) {
		this.hidratos = value;
	}
	
	public float getHidratos() {
		return hidratos;
	}
	
	public void setAcucar(float value) {
		this.acucar = value;
	}
	
	public float getAcucar() {
		return acucar;
	}
	
	public void setFibra(float value) {
		this.fibra = value;
	}
	
	public float getFibra() {
		return fibra;
	}
	
	public void setProteinas(float value) {
		this.proteinas = value;
	}
	
	public float getProteinas() {
		return proteinas;
	}
	
	public void setSal(float value) {
		this.sal = value;
	}
	
	public float getSal() {
		return sal;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
