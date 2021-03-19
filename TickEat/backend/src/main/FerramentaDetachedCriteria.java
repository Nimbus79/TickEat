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

public class FerramentaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression cantinaId;
	public final AssociationExpression cantina;
	public final BooleanExpression ativo;
	
	public FerramentaDetachedCriteria() {
		super(main.Ferramenta.class, main.FerramentaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		cantinaId = new IntegerExpression("cantina.id", this.getDetachedCriteria());
		cantina = new AssociationExpression("cantina", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
	}
	
	public FerramentaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.FerramentaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		cantinaId = new IntegerExpression("cantina.id", this.getDetachedCriteria());
		cantina = new AssociationExpression("cantina", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
	}
	
	public CantinaDetachedCriteria createCantinaCriteria() {
		return new CantinaDetachedCriteria(createCriteria("cantina"));
	}
	
	public Ferramenta uniqueFerramenta(PersistentSession session) {
		return (Ferramenta) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ferramenta[] listFerramenta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ferramenta[]) list.toArray(new Ferramenta[list.size()]);
	}
}

