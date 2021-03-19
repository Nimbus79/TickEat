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

public class Carregamento extends main.Movimento {
	public Carregamento() {
	}
	
	private int referencia;
	
	private int entidade;
	
	private String validade;
	
	private java.sql.Blob fatura;
	
	private String metodo;
	
	public void setReferencia(int value) {
		this.referencia = value;
	}
	
	public int getReferencia() {
		return referencia;
	}
	
	public void setEntidade(int value) {
		this.entidade = value;
	}
	
	public int getEntidade() {
		return entidade;
	}
	
	public void setValidade(String value) {
		this.validade = value;
	}
	
	public String getValidade() {
		return validade;
	}
	
	public void setFatura(java.sql.Blob value) {
		this.fatura = value;
	}
	
	public java.sql.Blob getFatura() {
		return fatura;
	}
	
	public void setMetodo(String value) {
		this.metodo = value;
	}
	
	public String getMetodo() {
		return metodo;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
