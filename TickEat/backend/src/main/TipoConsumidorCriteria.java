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

public class TipoConsumidorCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression nome;
	public final BooleanExpression ativo;
	
	public TipoConsumidorCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nome = new StringExpression("nome", this);
		ativo = new BooleanExpression("ativo", this);
	}
	
	public TipoConsumidorCriteria(PersistentSession session) {
		this(session.createCriteria(TipoConsumidor.class));
	}
	
	public TipoConsumidorCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public TipoConsumidor uniqueTipoConsumidor() {
		return (TipoConsumidor) super.uniqueResult();
	}
	
	public TipoConsumidor[] listTipoConsumidor() {
		java.util.List list = super.list();
		return (TipoConsumidor[]) list.toArray(new TipoConsumidor[list.size()]);
	}
}

