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

public class NotificacaoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression descricao;
	public final StringExpression nome;
	public final BooleanExpression vista;
	public final StringExpression timestamp;
	
	public NotificacaoDetachedCriteria() {
		super(main.Notificacao.class, main.NotificacaoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		vista = new BooleanExpression("vista", this.getDetachedCriteria());
		timestamp = new StringExpression("timestamp", this.getDetachedCriteria());
	}
	
	public NotificacaoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.NotificacaoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		vista = new BooleanExpression("vista", this.getDetachedCriteria());
		timestamp = new StringExpression("timestamp", this.getDetachedCriteria());
	}
	
	public Notificacao uniqueNotificacao(PersistentSession session) {
		return (Notificacao) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Notificacao[] listNotificacao(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Notificacao[]) list.toArray(new Notificacao[list.size()]);
	}
}

