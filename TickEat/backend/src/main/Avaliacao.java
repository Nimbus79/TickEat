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

public class Avaliacao {
	public Avaliacao() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_AVALIACAO_COMENTARIOS) {
			return ORM_comentarios;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private main.Refeicao refeicao;
	
	private main.Consumidor consumidor;
	
	private int pontuacao;
	
	private java.util.Set ORM_comentarios = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setPontuacao(int value) {
		this.pontuacao = value;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	public void setConsumidor(main.Consumidor value) {
		this.consumidor = value;
	}
	
	public main.Consumidor getConsumidor() {
		return consumidor;
	}
	
	public void setRefeicao(main.Refeicao value) {
		this.refeicao = value;
	}
	
	public main.Refeicao getRefeicao() {
		return refeicao;
	}
	
	private void setORM_Comentarios(java.util.Set value) {
		this.ORM_comentarios = value;
	}
	
	private java.util.Set getORM_Comentarios() {
		return ORM_comentarios;
	}
	
	public final main.ComentarioSetCollection comentarios = new main.ComentarioSetCollection(this, _ormAdapter, ORMConstants.KEY_AVALIACAO_COMENTARIOS, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
