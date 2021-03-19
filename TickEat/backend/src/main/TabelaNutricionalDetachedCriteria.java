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

public class TabelaNutricionalDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression energia;
	public final FloatExpression lipidos;
	public final FloatExpression saturados;
	public final FloatExpression hidratos;
	public final FloatExpression acucar;
	public final FloatExpression fibra;
	public final FloatExpression proteinas;
	public final FloatExpression sal;
	
	public TabelaNutricionalDetachedCriteria() {
		super(main.TabelaNutricional.class, main.TabelaNutricionalCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		energia = new IntegerExpression("energia", this.getDetachedCriteria());
		lipidos = new FloatExpression("lipidos", this.getDetachedCriteria());
		saturados = new FloatExpression("saturados", this.getDetachedCriteria());
		hidratos = new FloatExpression("hidratos", this.getDetachedCriteria());
		acucar = new FloatExpression("acucar", this.getDetachedCriteria());
		fibra = new FloatExpression("fibra", this.getDetachedCriteria());
		proteinas = new FloatExpression("proteinas", this.getDetachedCriteria());
		sal = new FloatExpression("sal", this.getDetachedCriteria());
	}
	
	public TabelaNutricionalDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.TabelaNutricionalCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		energia = new IntegerExpression("energia", this.getDetachedCriteria());
		lipidos = new FloatExpression("lipidos", this.getDetachedCriteria());
		saturados = new FloatExpression("saturados", this.getDetachedCriteria());
		hidratos = new FloatExpression("hidratos", this.getDetachedCriteria());
		acucar = new FloatExpression("acucar", this.getDetachedCriteria());
		fibra = new FloatExpression("fibra", this.getDetachedCriteria());
		proteinas = new FloatExpression("proteinas", this.getDetachedCriteria());
		sal = new FloatExpression("sal", this.getDetachedCriteria());
	}
	
	public TabelaNutricional uniqueTabelaNutricional(PersistentSession session) {
		return (TabelaNutricional) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public TabelaNutricional[] listTabelaNutricional(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (TabelaNutricional[]) list.toArray(new TabelaNutricional[list.size()]);
	}
}

