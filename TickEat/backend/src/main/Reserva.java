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

public class Reserva {
	public Reserva() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_RESERVA_EMENTAS) {
			return ORM_ementas;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_RESERVA_REFEICAO) {
			this.refeicao = (main.Refeicao) owner;
		}
		
		else if (key == ORMConstants.KEY_RESERVA_TIPOREFEICAO) {
			this.tipoRefeicao = (main.TipoRefeicao) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id;
	
	private main.TipoRefeicao tipoRefeicao;
	
	private main.Refeicao refeicao;
	
	private boolean validada;
	
	private String timestamp;
	
	private java.util.Set ORM_ementas = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setValidada(boolean value) {
		this.validada = value;
	}
	
	public boolean getValidada() {
		return validada;
	}
	
	public void setTimestamp(String value) {
		this.timestamp = value;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public void setRefeicao(main.Refeicao value) {
		this.refeicao = value;
	}
	
	public main.Refeicao getRefeicao() {
		return refeicao;
	}
	
	private void setORM_Ementas(java.util.Set value) {
		this.ORM_ementas = value;
	}
	
	private java.util.Set getORM_Ementas() {
		return ORM_ementas;
	}
	
	public final main.EmentaSetCollection ementas = new main.EmentaSetCollection(this, _ormAdapter, ORMConstants.KEY_RESERVA_EMENTAS, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
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
