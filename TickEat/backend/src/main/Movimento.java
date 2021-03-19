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

public class Movimento {
	public Movimento() {
	}
	
	private int id;
	
	private float valor;
	
	private String timestamp;
	
	private boolean efetuado;
	
	private String nome;
	
	private float saldoResultante;
	
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
	
	public void setTimestamp(String value) {
		this.timestamp = value;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public void setEfetuado(boolean value) {
		this.efetuado = value;
	}
	
	public boolean getEfetuado() {
		return efetuado;
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setSaldoResultante(float value) {
		this.saldoResultante = value;
	}
	
	public float getSaldoResultante() {
		return saldoResultante;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
