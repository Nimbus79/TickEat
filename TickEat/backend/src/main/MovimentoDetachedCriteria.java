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

public class MovimentoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final FloatExpression valor;
	public final StringExpression timestamp;
	public final BooleanExpression efetuado;
	public final StringExpression nome;
	public final FloatExpression saldoResultante;
	
	public MovimentoDetachedCriteria() {
		super(main.Movimento.class, main.MovimentoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		valor = new FloatExpression("valor", this.getDetachedCriteria());
		timestamp = new StringExpression("timestamp", this.getDetachedCriteria());
		efetuado = new BooleanExpression("efetuado", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		saldoResultante = new FloatExpression("saldoResultante", this.getDetachedCriteria());
	}
	
	public MovimentoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.MovimentoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		valor = new FloatExpression("valor", this.getDetachedCriteria());
		timestamp = new StringExpression("timestamp", this.getDetachedCriteria());
		efetuado = new BooleanExpression("efetuado", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		saldoResultante = new FloatExpression("saldoResultante", this.getDetachedCriteria());
	}
	
	public Movimento uniqueMovimento(PersistentSession session) {
		return (Movimento) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Movimento[] listMovimento(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Movimento[]) list.toArray(new Movimento[list.size()]);
	}
}

