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

public class CantinaVisivelCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression consumidorId;
	public final AssociationExpression consumidor;
	public final IntegerExpression cantinaId;
	public final AssociationExpression cantina;
	public final BooleanExpression visivel;
	public final IntegerExpression posicao;
	
	public CantinaVisivelCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		consumidorId = new StringExpression("consumidor.", this);
		consumidor = new AssociationExpression("consumidor", this);
		cantinaId = new IntegerExpression("cantina.id", this);
		cantina = new AssociationExpression("cantina", this);
		visivel = new BooleanExpression("visivel", this);
		posicao = new IntegerExpression("posicao", this);
	}
	
	public CantinaVisivelCriteria(PersistentSession session) {
		this(session.createCriteria(CantinaVisivel.class));
	}
	
	public CantinaVisivelCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public ConsumidorCriteria createConsumidorCriteria() {
		return new ConsumidorCriteria(createCriteria("consumidor"));
	}
	
	public CantinaCriteria createCantinaCriteria() {
		return new CantinaCriteria(createCriteria("cantina"));
	}
	
	public CantinaVisivel uniqueCantinaVisivel() {
		return (CantinaVisivel) super.uniqueResult();
	}
	
	public CantinaVisivel[] listCantinaVisivel() {
		java.util.List list = super.list();
		return (CantinaVisivel[]) list.toArray(new CantinaVisivel[list.size()]);
	}
}

