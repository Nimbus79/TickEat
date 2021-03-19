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

public class EmentaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression tabelaNutricionalId;
	public final AssociationExpression tabelaNutricional;
	public final StringExpression comida;
	public final StringExpression tipo;
	public final IntegerExpression previsao;
	public final IntegerExpression contagemValidados;
	
	public EmentaDetachedCriteria() {
		super(main.Ementa.class, main.EmentaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tabelaNutricionalId = new IntegerExpression("tabelaNutricional.id", this.getDetachedCriteria());
		tabelaNutricional = new AssociationExpression("tabelaNutricional", this.getDetachedCriteria());
		comida = new StringExpression("comida", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		previsao = new IntegerExpression("previsao", this.getDetachedCriteria());
		contagemValidados = new IntegerExpression("contagemValidados", this.getDetachedCriteria());
	}
	
	public EmentaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.EmentaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tabelaNutricionalId = new IntegerExpression("tabelaNutricional.id", this.getDetachedCriteria());
		tabelaNutricional = new AssociationExpression("tabelaNutricional", this.getDetachedCriteria());
		comida = new StringExpression("comida", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		previsao = new IntegerExpression("previsao", this.getDetachedCriteria());
		contagemValidados = new IntegerExpression("contagemValidados", this.getDetachedCriteria());
	}
	
	public TabelaNutricionalDetachedCriteria createTabelaNutricionalCriteria() {
		return new TabelaNutricionalDetachedCriteria(createCriteria("tabelaNutricional"));
	}
	
	public Ementa uniqueEmenta(PersistentSession session) {
		return (Ementa) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ementa[] listEmenta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ementa[]) list.toArray(new Ementa[list.size()]);
	}
}

