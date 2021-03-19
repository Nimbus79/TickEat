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

public class Refeicao {
	public Refeicao() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_REFEICAO_EMENTAS) {
			return ORM_ementas;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_REFEICAO_REFEICAOINFO) {
			this.refeicaoInfo = (main.RefeicaoInfo) owner;
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
	
	private main.RefeicaoInfo refeicaoInfo;
	
	private String data;
	
	private int previsaoGeral;
	
	private int contagemEntrada;
	
	private int contagemValidados;
	
	private boolean aDecorrer;
	
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
	
	public void setData(String value) {
		this.data = value;
	}
	
	public String getData() {
		return data;
	}
	
	public void setPrevisaoGeral(int value) {
		this.previsaoGeral = value;
	}
	
	public int getPrevisaoGeral() {
		return previsaoGeral;
	}
	
	public void setContagemEntrada(int value) {
		this.contagemEntrada = value;
	}
	
	public int getContagemEntrada() {
		return contagemEntrada;
	}
	
	public void setContagemValidados(int value) {
		this.contagemValidados = value;
	}
	
	public int getContagemValidados() {
		return contagemValidados;
	}
	
	public void setaDecorrer(boolean value) {
		this.aDecorrer = value;
	}
	
	public boolean getaDecorrer() {
		return aDecorrer;
	}
	
	public void setRefeicaoInfo(main.RefeicaoInfo value) {
		this.refeicaoInfo = value;
	}
	
	public main.RefeicaoInfo getRefeicaoInfo() {
		return refeicaoInfo;
	}
	
	private void setORM_Ementas(java.util.Set value) {
		this.ORM_ementas = value;
	}
	
	private java.util.Set getORM_Ementas() {
		return ORM_ementas;
	}
	
	public final main.EmentaSetCollection ementas = new main.EmentaSetCollection(this, _ormAdapter, ORMConstants.KEY_REFEICAO_EMENTAS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
