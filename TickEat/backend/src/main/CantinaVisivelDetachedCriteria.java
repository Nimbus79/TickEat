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

public class CantinaVisivelDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression consumidorId;
	public final AssociationExpression consumidor;
	public final IntegerExpression cantinaId;
	public final AssociationExpression cantina;
	public final BooleanExpression visivel;
	public final IntegerExpression posicao;
	
	public CantinaVisivelDetachedCriteria() {
		super(main.CantinaVisivel.class, main.CantinaVisivelCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		consumidorId = new StringExpression("consumidor.", this.getDetachedCriteria());
		consumidor = new AssociationExpression("consumidor", this.getDetachedCriteria());
		cantinaId = new IntegerExpression("cantina.id", this.getDetachedCriteria());
		cantina = new AssociationExpression("cantina", this.getDetachedCriteria());
		visivel = new BooleanExpression("visivel", this.getDetachedCriteria());
		posicao = new IntegerExpression("posicao", this.getDetachedCriteria());
	}
	
	public CantinaVisivelDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.CantinaVisivelCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		consumidorId = new StringExpression("consumidor.", this.getDetachedCriteria());
		consumidor = new AssociationExpression("consumidor", this.getDetachedCriteria());
		cantinaId = new IntegerExpression("cantina.id", this.getDetachedCriteria());
		cantina = new AssociationExpression("cantina", this.getDetachedCriteria());
		visivel = new BooleanExpression("visivel", this.getDetachedCriteria());
		posicao = new IntegerExpression("posicao", this.getDetachedCriteria());
	}
	
	public ConsumidorDetachedCriteria createConsumidorCriteria() {
		return new ConsumidorDetachedCriteria(createCriteria("consumidor"));
	}
	
	public CantinaDetachedCriteria createCantinaCriteria() {
		return new CantinaDetachedCriteria(createCriteria("cantina"));
	}
	
	public CantinaVisivel uniqueCantinaVisivel(PersistentSession session) {
		return (CantinaVisivel) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public CantinaVisivel[] listCantinaVisivel(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (CantinaVisivel[]) list.toArray(new CantinaVisivel[list.size()]);
	}
}

