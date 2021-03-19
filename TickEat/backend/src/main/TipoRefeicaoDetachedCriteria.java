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

public class TipoRefeicaoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression nome;
	public final BooleanExpression ativo;
	public final CollectionExpression componentes;
	
	public TipoRefeicaoDetachedCriteria() {
		super(main.TipoRefeicao.class, main.TipoRefeicaoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		componentes = new CollectionExpression("ORM_Componentes", this.getDetachedCriteria());
	}
	
	public TipoRefeicaoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.TipoRefeicaoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		componentes = new CollectionExpression("ORM_Componentes", this.getDetachedCriteria());
	}
	
	public ComponenteDetachedCriteria createComponentesCriteria() {
		return new ComponenteDetachedCriteria(createCriteria("ORM_Componentes"));
	}
	
	public TipoRefeicao uniqueTipoRefeicao(PersistentSession session) {
		return (TipoRefeicao) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public TipoRefeicao[] listTipoRefeicao(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (TipoRefeicao[]) list.toArray(new TipoRefeicao[list.size()]);
	}
}

