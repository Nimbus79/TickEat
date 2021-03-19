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

public class Despesa extends main.Movimento {
	public Despesa() {
	}
	
	private String descricao;
	
	private main.Refeicao refeicao;
	
	private main.Reserva reserva;
	
	public void setDescricao(String value) {
		this.descricao = value;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setReserva(main.Reserva value) {
		this.reserva = value;
	}
	
	public main.Reserva getReserva() {
		return reserva;
	}
	
	public void setRefeicao(main.Refeicao value) {
		this.refeicao = value;
	}
	
	public main.Refeicao getRefeicao() {
		return refeicao;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
