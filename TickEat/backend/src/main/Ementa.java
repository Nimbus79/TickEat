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

public class Ementa {
	public Ementa() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_EMENTA_TABELANUTRICIONAL) {
			this.tabelaNutricional = (main.TabelaNutricional) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id;
	
	private main.TabelaNutricional tabelaNutricional;
	
	private String comida;
	
	private String tipo;
	
	private int previsao;
	
	private int contagemValidados;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setComida(String value) {
		this.comida = value;
	}
	
	public String getComida() {
		return comida;
	}
	
	public void setTipo(String value) {
		this.tipo = value;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setPrevisao(int value) {
		this.previsao = value;
	}
	
	public int getPrevisao() {
		return previsao;
	}
	
	public void setContagemValidados(int value) {
		this.contagemValidados = value;
	}
	
	public int getContagemValidados() {
		return contagemValidados;
	}
	
	public void setTabelaNutricional(main.TabelaNutricional value) {
		this.tabelaNutricional = value;
	}
	
	public main.TabelaNutricional getTabelaNutricional() {
		return tabelaNutricional;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
