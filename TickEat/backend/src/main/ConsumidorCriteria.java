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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ConsumidorCriteria extends AbstractORMCriteria {
	public final StringExpression email;
	public final StringExpression password;
	public final StringExpression nome;
	public final StringExpression tipo;
	public final BooleanExpression ativo;
	public final FloatExpression saldoDisponivel;
	public final FloatExpression saldoContabilistico;
	public final IntegerExpression contribuinte;
	public final BlobExpression fotografia;
	public final BlobExpression identificador;
	public final IntegerExpression tipoConsumidorId;
	public final AssociationExpression tipoConsumidor;
	public final CollectionExpression notificacoes;
	public final CollectionExpression movimentos;
	public final CollectionExpression reservas;
	
	public ConsumidorCriteria(Criteria criteria) {
		super(criteria);
		email = new StringExpression("email", this);
		password = new StringExpression("password", this);
		nome = new StringExpression("nome", this);
		tipo = new StringExpression("tipo", this);
		ativo = new BooleanExpression("ativo", this);
		saldoDisponivel = new FloatExpression("saldoDisponivel", this);
		saldoContabilistico = new FloatExpression("saldoContabilistico", this);
		contribuinte = new IntegerExpression("contribuinte", this);
		fotografia = new BlobExpression("fotografia", this);
		identificador = new BlobExpression("identificador", this);
		tipoConsumidorId = new IntegerExpression("tipoConsumidor.id", this);
		tipoConsumidor = new AssociationExpression("tipoConsumidor", this);
		notificacoes = new CollectionExpression("ORM_Notificacoes", this);
		movimentos = new CollectionExpression("ORM_Movimentos", this);
		reservas = new CollectionExpression("ORM_Reservas", this);
	}
	
	public ConsumidorCriteria(PersistentSession session) {
		this(session.createCriteria(Consumidor.class));
	}
	
	public ConsumidorCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public TipoConsumidorCriteria createTipoConsumidorCriteria() {
		return new TipoConsumidorCriteria(createCriteria("tipoConsumidor"));
	}
	
	public NotificacaoCriteria createNotificacoesCriteria() {
		return new NotificacaoCriteria(createCriteria("ORM_Notificacoes"));
	}
	
	public MovimentoCriteria createMovimentosCriteria() {
		return new MovimentoCriteria(createCriteria("ORM_Movimentos"));
	}
	
	public ReservaCriteria createReservasCriteria() {
		return new ReservaCriteria(createCriteria("ORM_Reservas"));
	}
	
	public Consumidor uniqueConsumidor() {
		return (Consumidor) super.uniqueResult();
	}
	
	public Consumidor[] listConsumidor() {
		java.util.List list = super.list();
		return (Consumidor[]) list.toArray(new Consumidor[list.size()]);
	}
}

