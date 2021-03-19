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

public class Consumidor extends main.Utilizador {
	public Consumidor() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CONSUMIDOR_NOTIFICACOES) {
			return ORM_notificacoes;
		}
		else if (key == ORMConstants.KEY_CONSUMIDOR_MOVIMENTOS) {
			return ORM_movimentos;
		}
		else if (key == ORMConstants.KEY_CONSUMIDOR_RESERVAS) {
			return ORM_reservas;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private float saldoDisponivel;
	
	private float saldoContabilistico;
	
	private int contribuinte;
	
	private java.sql.Blob fotografia;
	
	private java.sql.Blob identificador;
	
	private main.TipoConsumidor tipoConsumidor;
	
	private java.util.Set ORM_notificacoes = new java.util.HashSet();
	
	private java.util.Set ORM_movimentos = new java.util.HashSet();
	
	private java.util.Set ORM_reservas = new java.util.HashSet();
	
	public void setSaldoDisponivel(float value) {
		this.saldoDisponivel = value;
	}
	
	public float getSaldoDisponivel() {
		return saldoDisponivel;
	}
	
	public void setSaldoContabilistico(float value) {
		this.saldoContabilistico = value;
	}
	
	public float getSaldoContabilistico() {
		return saldoContabilistico;
	}
	
	public void setContribuinte(int value) {
		this.contribuinte = value;
	}
	
	public int getContribuinte() {
		return contribuinte;
	}
	
	public void setFotografia(java.sql.Blob value) {
		this.fotografia = value;
	}
	
	public java.sql.Blob getFotografia() {
		return fotografia;
	}
	
	public void setIdentificador(java.sql.Blob value) {
		this.identificador = value;
	}
	
	public java.sql.Blob getIdentificador() {
		return identificador;
	}
	
	private void setORM_Notificacoes(java.util.Set value) {
		this.ORM_notificacoes = value;
	}
	
	private java.util.Set getORM_Notificacoes() {
		return ORM_notificacoes;
	}
	
	public final main.NotificacaoSetCollection notificacoes = new main.NotificacaoSetCollection(this, _ormAdapter, ORMConstants.KEY_CONSUMIDOR_NOTIFICACOES, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setTipoConsumidor(main.TipoConsumidor value) {
		this.tipoConsumidor = value;
	}
	
	public main.TipoConsumidor getTipoConsumidor() {
		return tipoConsumidor;
	}
	
	private void setORM_Movimentos(java.util.Set value) {
		this.ORM_movimentos = value;
	}
	
	private java.util.Set getORM_Movimentos() {
		return ORM_movimentos;
	}
	
	public final main.MovimentoSetCollection movimentos = new main.MovimentoSetCollection(this, _ormAdapter, ORMConstants.KEY_CONSUMIDOR_MOVIMENTOS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Reservas(java.util.Set value) {
		this.ORM_reservas = value;
	}
	
	private java.util.Set getORM_Reservas() {
		return ORM_reservas;
	}
	
	public final main.ReservaSetCollection reservas = new main.ReservaSetCollection(this, _ormAdapter, ORMConstants.KEY_CONSUMIDOR_RESERVAS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
