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

public class NotificacaoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression descricao;
	public final StringExpression nome;
	public final BooleanExpression vista;
	public final StringExpression timestamp;
	
	public NotificacaoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		descricao = new StringExpression("descricao", this);
		nome = new StringExpression("nome", this);
		vista = new BooleanExpression("vista", this);
		timestamp = new StringExpression("timestamp", this);
	}
	
	public NotificacaoCriteria(PersistentSession session) {
		this(session.createCriteria(Notificacao.class));
	}
	
	public NotificacaoCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public Notificacao uniqueNotificacao() {
		return (Notificacao) super.uniqueResult();
	}
	
	public Notificacao[] listNotificacao() {
		java.util.List list = super.list();
		return (Notificacao[]) list.toArray(new Notificacao[list.size()]);
	}
}

