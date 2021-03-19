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

public class CantinaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression localizacao;
	public final StringExpression descricao;
	public final StringExpression nome;
	public final BooleanExpression ativo;
	public final CollectionExpression refeicoesInfo;
	public final CollectionExpression tiposRefeicao;
	public final CollectionExpression refeicoes;
	
	public CantinaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		localizacao = new StringExpression("localizacao", this);
		descricao = new StringExpression("descricao", this);
		nome = new StringExpression("nome", this);
		ativo = new BooleanExpression("ativo", this);
		refeicoesInfo = new CollectionExpression("ORM_RefeicoesInfo", this);
		tiposRefeicao = new CollectionExpression("ORM_TiposRefeicao", this);
		refeicoes = new CollectionExpression("ORM_Refeicoes", this);
	}
	
	public CantinaCriteria(PersistentSession session) {
		this(session.createCriteria(Cantina.class));
	}
	
	public CantinaCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public RefeicaoInfoCriteria createRefeicoesInfoCriteria() {
		return new RefeicaoInfoCriteria(createCriteria("ORM_RefeicoesInfo"));
	}
	
	public TipoRefeicaoCriteria createTiposRefeicaoCriteria() {
		return new TipoRefeicaoCriteria(createCriteria("ORM_TiposRefeicao"));
	}
	
	public RefeicaoCriteria createRefeicoesCriteria() {
		return new RefeicaoCriteria(createCriteria("ORM_Refeicoes"));
	}
	
	public Cantina uniqueCantina() {
		return (Cantina) super.uniqueResult();
	}
	
	public Cantina[] listCantina() {
		java.util.List list = super.list();
		return (Cantina[]) list.toArray(new Cantina[list.size()]);
	}
}

