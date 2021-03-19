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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ConsumidorDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public ConsumidorDetachedCriteria() {
		super(main.Consumidor.class, main.ConsumidorCriteria.class);
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		saldoDisponivel = new FloatExpression("saldoDisponivel", this.getDetachedCriteria());
		saldoContabilistico = new FloatExpression("saldoContabilistico", this.getDetachedCriteria());
		contribuinte = new IntegerExpression("contribuinte", this.getDetachedCriteria());
		fotografia = new BlobExpression("fotografia", this.getDetachedCriteria());
		identificador = new BlobExpression("identificador", this.getDetachedCriteria());
		tipoConsumidorId = new IntegerExpression("tipoConsumidor.id", this.getDetachedCriteria());
		tipoConsumidor = new AssociationExpression("tipoConsumidor", this.getDetachedCriteria());
		notificacoes = new CollectionExpression("ORM_Notificacoes", this.getDetachedCriteria());
		movimentos = new CollectionExpression("ORM_Movimentos", this.getDetachedCriteria());
		reservas = new CollectionExpression("ORM_Reservas", this.getDetachedCriteria());
	}
	
	public ConsumidorDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.ConsumidorCriteria.class);
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		saldoDisponivel = new FloatExpression("saldoDisponivel", this.getDetachedCriteria());
		saldoContabilistico = new FloatExpression("saldoContabilistico", this.getDetachedCriteria());
		contribuinte = new IntegerExpression("contribuinte", this.getDetachedCriteria());
		fotografia = new BlobExpression("fotografia", this.getDetachedCriteria());
		identificador = new BlobExpression("identificador", this.getDetachedCriteria());
		tipoConsumidorId = new IntegerExpression("tipoConsumidor.id", this.getDetachedCriteria());
		tipoConsumidor = new AssociationExpression("tipoConsumidor", this.getDetachedCriteria());
		notificacoes = new CollectionExpression("ORM_Notificacoes", this.getDetachedCriteria());
		movimentos = new CollectionExpression("ORM_Movimentos", this.getDetachedCriteria());
		reservas = new CollectionExpression("ORM_Reservas", this.getDetachedCriteria());
	}
	
	public TipoConsumidorDetachedCriteria createTipoConsumidorCriteria() {
		return new TipoConsumidorDetachedCriteria(createCriteria("tipoConsumidor"));
	}
	
	public NotificacaoDetachedCriteria createNotificacoesCriteria() {
		return new NotificacaoDetachedCriteria(createCriteria("ORM_Notificacoes"));
	}
	
	public MovimentoDetachedCriteria createMovimentosCriteria() {
		return new MovimentoDetachedCriteria(createCriteria("ORM_Movimentos"));
	}
	
	public ReservaDetachedCriteria createReservasCriteria() {
		return new ReservaDetachedCriteria(createCriteria("ORM_Reservas"));
	}
	
	public Consumidor uniqueConsumidor(PersistentSession session) {
		return (Consumidor) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Consumidor[] listConsumidor(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Consumidor[]) list.toArray(new Consumidor[list.size()]);
	}
}

