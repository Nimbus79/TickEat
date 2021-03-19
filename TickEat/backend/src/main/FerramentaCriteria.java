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

public class FerramentaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression cantinaId;
	public final AssociationExpression cantina;
	public final BooleanExpression ativo;
	
	public FerramentaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		cantinaId = new IntegerExpression("cantina.id", this);
		cantina = new AssociationExpression("cantina", this);
		ativo = new BooleanExpression("ativo", this);
	}
	
	public FerramentaCriteria(PersistentSession session) {
		this(session.createCriteria(Ferramenta.class));
	}
	
	public FerramentaCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public CantinaCriteria createCantinaCriteria() {
		return new CantinaCriteria(createCriteria("cantina"));
	}
	
	public Ferramenta uniqueFerramenta() {
		return (Ferramenta) super.uniqueResult();
	}
	
	public Ferramenta[] listFerramenta() {
		java.util.List list = super.list();
		return (Ferramenta[]) list.toArray(new Ferramenta[list.size()]);
	}
}

