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

public class TabelaNutricionalCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression energia;
	public final FloatExpression lipidos;
	public final FloatExpression saturados;
	public final FloatExpression hidratos;
	public final FloatExpression acucar;
	public final FloatExpression fibra;
	public final FloatExpression proteinas;
	public final FloatExpression sal;
	
	public TabelaNutricionalCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		energia = new IntegerExpression("energia", this);
		lipidos = new FloatExpression("lipidos", this);
		saturados = new FloatExpression("saturados", this);
		hidratos = new FloatExpression("hidratos", this);
		acucar = new FloatExpression("acucar", this);
		fibra = new FloatExpression("fibra", this);
		proteinas = new FloatExpression("proteinas", this);
		sal = new FloatExpression("sal", this);
	}
	
	public TabelaNutricionalCriteria(PersistentSession session) {
		this(session.createCriteria(TabelaNutricional.class));
	}
	
	public TabelaNutricionalCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public TabelaNutricional uniqueTabelaNutricional() {
		return (TabelaNutricional) super.uniqueResult();
	}
	
	public TabelaNutricional[] listTabelaNutricional() {
		java.util.List list = super.list();
		return (TabelaNutricional[]) list.toArray(new TabelaNutricional[list.size()]);
	}
}

