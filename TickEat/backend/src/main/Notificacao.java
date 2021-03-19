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

public class Notificacao {
	public Notificacao() {
	}
	
	private int id;
	
	private String descricao;
	
	private String nome;
	
	private boolean vista;
	
	private String timestamp;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setDescricao(String value) {
		this.descricao = value;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setVista(boolean value) {
		this.vista = value;
	}
	
	public boolean getVista() {
		return vista;
	}
	
	public void setTimestamp(String value) {
		this.timestamp = value;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
