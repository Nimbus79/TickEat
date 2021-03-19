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

public class EmentaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression tabelaNutricionalId;
	public final AssociationExpression tabelaNutricional;
	public final StringExpression comida;
	public final StringExpression tipo;
	public final IntegerExpression previsao;
	public final IntegerExpression contagemValidados;
	
	public EmentaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		tabelaNutricionalId = new IntegerExpression("tabelaNutricional.id", this);
		tabelaNutricional = new AssociationExpression("tabelaNutricional", this);
		comida = new StringExpression("comida", this);
		tipo = new StringExpression("tipo", this);
		previsao = new IntegerExpression("previsao", this);
		contagemValidados = new IntegerExpression("contagemValidados", this);
	}
	
	public EmentaCriteria(PersistentSession session) {
		this(session.createCriteria(Ementa.class));
	}
	
	public EmentaCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public TabelaNutricionalCriteria createTabelaNutricionalCriteria() {
		return new TabelaNutricionalCriteria(createCriteria("tabelaNutricional"));
	}
	
	public Ementa uniqueEmenta() {
		return (Ementa) super.uniqueResult();
	}
	
	public Ementa[] listEmenta() {
		java.util.List list = super.list();
		return (Ementa[]) list.toArray(new Ementa[list.size()]);
	}
}

