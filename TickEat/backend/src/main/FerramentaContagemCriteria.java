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

public class FerramentaContagemCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression cantinaId;
	public final AssociationExpression cantina;
	public final BooleanExpression ativo;
	
	public FerramentaContagemCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		cantinaId = new IntegerExpression("cantina.id", this);
		cantina = new AssociationExpression("cantina", this);
		ativo = new BooleanExpression("ativo", this);
	}
	
	public FerramentaContagemCriteria(PersistentSession session) {
		this(session.createCriteria(FerramentaContagem.class));
	}
	
	public FerramentaContagemCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public CantinaCriteria createCantinaCriteria() {
		return new CantinaCriteria(createCriteria("cantina"));
	}
	
	public FerramentaContagem uniqueFerramentaContagem() {
		return (FerramentaContagem) super.uniqueResult();
	}
	
	public FerramentaContagem[] listFerramentaContagem() {
		java.util.List list = super.list();
		return (FerramentaContagem[]) list.toArray(new FerramentaContagem[list.size()]);
	}
}

