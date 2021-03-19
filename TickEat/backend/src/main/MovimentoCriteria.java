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

public class MovimentoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final FloatExpression valor;
	public final StringExpression timestamp;
	public final BooleanExpression efetuado;
	public final StringExpression nome;
	public final FloatExpression saldoResultante;
	
	public MovimentoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		valor = new FloatExpression("valor", this);
		timestamp = new StringExpression("timestamp", this);
		efetuado = new BooleanExpression("efetuado", this);
		nome = new StringExpression("nome", this);
		saldoResultante = new FloatExpression("saldoResultante", this);
	}
	
	public MovimentoCriteria(PersistentSession session) {
		this(session.createCriteria(Movimento.class));
	}
	
	public MovimentoCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public Movimento uniqueMovimento() {
		return (Movimento) super.uniqueResult();
	}
	
	public Movimento[] listMovimento() {
		java.util.List list = super.list();
		return (Movimento[]) list.toArray(new Movimento[list.size()]);
	}
}

