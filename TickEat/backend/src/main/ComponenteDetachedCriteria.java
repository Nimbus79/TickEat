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

public class ComponenteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression nome;
	public final CollectionExpression ementas;
	
	public ComponenteDetachedCriteria() {
		super(main.Componente.class, main.ComponenteCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		ementas = new CollectionExpression("ORM_Ementas", this.getDetachedCriteria());
	}
	
	public ComponenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.ComponenteCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		ementas = new CollectionExpression("ORM_Ementas", this.getDetachedCriteria());
	}
	
	public EmentaDetachedCriteria createEmentasCriteria() {
		return new EmentaDetachedCriteria(createCriteria("ORM_Ementas"));
	}
	
	public Componente uniqueComponente(PersistentSession session) {
		return (Componente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Componente[] listComponente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Componente[]) list.toArray(new Componente[list.size()]);
	}
}

