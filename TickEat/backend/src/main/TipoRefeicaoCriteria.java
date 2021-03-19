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

public class TipoRefeicaoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression nome;
	public final BooleanExpression ativo;
	public final CollectionExpression componentes;
	
	public TipoRefeicaoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nome = new StringExpression("nome", this);
		ativo = new BooleanExpression("ativo", this);
		componentes = new CollectionExpression("ORM_Componentes", this);
	}
	
	public TipoRefeicaoCriteria(PersistentSession session) {
		this(session.createCriteria(TipoRefeicao.class));
	}
	
	public TipoRefeicaoCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public ComponenteCriteria createComponentesCriteria() {
		return new ComponenteCriteria(createCriteria("ORM_Componentes"));
	}
	
	public TipoRefeicao uniqueTipoRefeicao() {
		return (TipoRefeicao) super.uniqueResult();
	}
	
	public TipoRefeicao[] listTipoRefeicao() {
		java.util.List list = super.list();
		return (TipoRefeicao[]) list.toArray(new TipoRefeicao[list.size()]);
	}
}

