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

public class Preco {
	public Preco() {
	}
	
	private int id;
	
	private main.TipoRefeicao tipoRefeicao;
	
	private main.TipoConsumidor tipoConsumidor;
	
	private float valor;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setValor(float value) {
		this.valor = value;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setTipoConsumidor(main.TipoConsumidor value) {
		this.tipoConsumidor = value;
	}
	
	public main.TipoConsumidor getTipoConsumidor() {
		return tipoConsumidor;
	}
	
	public void setTipoRefeicao(main.TipoRefeicao value) {
		this.tipoRefeicao = value;
	}
	
	public main.TipoRefeicao getTipoRefeicao() {
		return tipoRefeicao;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
