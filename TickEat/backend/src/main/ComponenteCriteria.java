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

public class ComponenteCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression nome;
	public final CollectionExpression ementas;
	
	public ComponenteCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nome = new StringExpression("nome", this);
		ementas = new CollectionExpression("ORM_Ementas", this);
	}
	
	public ComponenteCriteria(PersistentSession session) {
		this(session.createCriteria(Componente.class));
	}
	
	public ComponenteCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public EmentaCriteria createEmentasCriteria() {
		return new EmentaCriteria(createCriteria("ORM_Ementas"));
	}
	
	public Componente uniqueComponente() {
		return (Componente) super.uniqueResult();
	}
	
	public Componente[] listComponente() {
		java.util.List list = super.list();
		return (Componente[]) list.toArray(new Componente[list.size()]);
	}
}

