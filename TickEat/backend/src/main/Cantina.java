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

public class Cantina {
	public Cantina() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CANTINA_REFEICOESINFO) {
			return ORM_refeicoesInfo;
		}
		else if (key == ORMConstants.KEY_CANTINA_TIPOSREFEICAO) {
			return ORM_tiposRefeicao;
		}
		else if (key == ORMConstants.KEY_CANTINA_REFEICOES) {
			return ORM_refeicoes;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private String localizacao;
	
	private String descricao;
	
	private String nome;
	
	private boolean ativo;
	
	private java.util.Set ORM_refeicoesInfo = new java.util.HashSet();
	
	private java.util.Set ORM_tiposRefeicao = new java.util.HashSet();
	
	private java.util.Set ORM_refeicoes = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setLocalizacao(String value) {
		this.localizacao = value;
	}
	
	public String getLocalizacao() {
		return localizacao;
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
	
	public void setAtivo(boolean value) {
		this.ativo = value;
	}
	
	public boolean getAtivo() {
		return ativo;
	}
	
	private void setORM_RefeicoesInfo(java.util.Set value) {
		this.ORM_refeicoesInfo = value;
	}
	
	private java.util.Set getORM_RefeicoesInfo() {
		return ORM_refeicoesInfo;
	}
	
	public final main.RefeicaoInfoSetCollection refeicoesInfo = new main.RefeicaoInfoSetCollection(this, _ormAdapter, ORMConstants.KEY_CANTINA_REFEICOESINFO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_TiposRefeicao(java.util.Set value) {
		this.ORM_tiposRefeicao = value;
	}
	
	private java.util.Set getORM_TiposRefeicao() {
		return ORM_tiposRefeicao;
	}
	
	public final main.TipoRefeicaoSetCollection tiposRefeicao = new main.TipoRefeicaoSetCollection(this, _ormAdapter, ORMConstants.KEY_CANTINA_TIPOSREFEICAO, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Refeicoes(java.util.Set value) {
		this.ORM_refeicoes = value;
	}
	
	private java.util.Set getORM_Refeicoes() {
		return ORM_refeicoes;
	}
	
	public final main.RefeicaoSetCollection refeicoes = new main.RefeicaoSetCollection(this, _ormAdapter, ORMConstants.KEY_CANTINA_REFEICOES, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
