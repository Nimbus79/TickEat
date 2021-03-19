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

public class TipoRefeicao {
	public TipoRefeicao() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_TIPOREFEICAO_COMPONENTES) {
			return ORM_componentes;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private String nome;
	
	private boolean ativo;
	
	private java.util.Set ORM_componentes = new java.util.HashSet();
	
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
	
	private void setORM_Componentes(java.util.Set value) {
		this.ORM_componentes = value;
	}
	
	private java.util.Set getORM_Componentes() {
		return ORM_componentes;
	}
	
	public final main.ComponenteSetCollection componentes = new main.ComponenteSetCollection(this, _ormAdapter, ORMConstants.KEY_TIPOREFEICAO_COMPONENTES, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
