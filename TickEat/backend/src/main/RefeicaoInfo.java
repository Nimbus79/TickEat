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

public class RefeicaoInfo {
	public RefeicaoInfo() {
	}
	
	private int id;
	
	private String nome;
	
	private boolean ativo;
	
	private String horaInicio;
	
	private String horaFim;
	
	private String horaLimite;
	
	private float desconto;
	
	private float taxaCancelamento;
	
	private boolean segunda;
	
	private boolean terca;
	
	private boolean quarta;
	
	private boolean quinta;
	
	private boolean sexta;
	
	private boolean sabado;
	
	private boolean domingo;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setAtivo(boolean value) {
		this.ativo = value;
	}
	
	public boolean getAtivo() {
		return ativo;
	}
	
	public void setHoraInicio(String value) {
		this.horaInicio = value;
	}
	
	public String getHoraInicio() {
		return horaInicio;
	}
	
	public void setHoraFim(String value) {
		this.horaFim = value;
	}
	
	public String getHoraFim() {
		return horaFim;
	}
	
	public void setHoraLimite(String value) {
		this.horaLimite = value;
	}
	
	public String getHoraLimite() {
		return horaLimite;
	}
	
	public void setDesconto(float value) {
		this.desconto = value;
	}
	
	public float getDesconto() {
		return desconto;
	}
	
	public void setTaxaCancelamento(float value) {
		this.taxaCancelamento = value;
	}
	
	public float getTaxaCancelamento() {
		return taxaCancelamento;
	}
	
	public void setSegunda(boolean value) {
		this.segunda = value;
	}
	
	public boolean getSegunda() {
		return segunda;
	}
	
	public void setTerca(boolean value) {
		this.terca = value;
	}
	
	public boolean getTerca() {
		return terca;
	}
	
	public void setQuarta(boolean value) {
		this.quarta = value;
	}
	
	public boolean getQuarta() {
		return quarta;
	}
	
	public void setQuinta(boolean value) {
		this.quinta = value;
	}
	
	public boolean getQuinta() {
		return quinta;
	}
	
	public void setSexta(boolean value) {
		this.sexta = value;
	}
	
	public boolean getSexta() {
		return sexta;
	}
	
	public void setSabado(boolean value) {
		this.sabado = value;
	}
	
	public boolean getSabado() {
		return sabado;
	}
	
	public void setDomingo(boolean value) {
		this.domingo = value;
	}
	
	public boolean getDomingo() {
		return domingo;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
