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

public class CantinaVisivel {
	public CantinaVisivel() {
	}
	
	private int id;
	
	private main.Consumidor consumidor;
	
	private main.Cantina cantina;
	
	private boolean visivel;
	
	private int posicao;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setVisivel(boolean value) {
		this.visivel = value;
	}
	
	public boolean getVisivel() {
		return visivel;
	}
	
	public void setPosicao(int value) {
		this.posicao = value;
	}
	
	public int getPosicao() {
		return posicao;
	}
	
	public void setCantina(main.Cantina value) {
		this.cantina = value;
	}
	
	public main.Cantina getCantina() {
		return cantina;
	}
	
	public void setConsumidor(main.Consumidor value) {
		this.consumidor = value;
	}
	
	public main.Consumidor getConsumidor() {
		return consumidor;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
