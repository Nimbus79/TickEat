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

public class Ferramenta {
	public Ferramenta() {
	}
	
	private int id;
	
	private main.Cantina cantina;
	
	private boolean ativo;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setAtivo(boolean value) {
		this.ativo = value;
	}
	
	public boolean getAtivo() {
		return ativo;
	}
	
	public void setCantina(main.Cantina value) {
		this.cantina = value;
	}
	
	public main.Cantina getCantina() {
		return cantina;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
