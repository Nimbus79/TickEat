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

public class TipoConsumidorDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression nome;
	public final BooleanExpression ativo;
	
	public TipoConsumidorDetachedCriteria() {
		super(main.TipoConsumidor.class, main.TipoConsumidorCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
	}
	
	public TipoConsumidorDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.TipoConsumidorCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
	}
	
	public TipoConsumidor uniqueTipoConsumidor(PersistentSession session) {
		return (TipoConsumidor) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public TipoConsumidor[] listTipoConsumidor(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (TipoConsumidor[]) list.toArray(new TipoConsumidor[list.size()]);
	}
}

