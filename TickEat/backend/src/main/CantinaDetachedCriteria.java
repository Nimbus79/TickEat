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

public class CantinaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression localizacao;
	public final StringExpression descricao;
	public final StringExpression nome;
	public final BooleanExpression ativo;
	public final CollectionExpression refeicoesInfo;
	public final CollectionExpression tiposRefeicao;
	public final CollectionExpression refeicoes;
	
	public CantinaDetachedCriteria() {
		super(main.Cantina.class, main.CantinaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		localizacao = new StringExpression("localizacao", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		refeicoesInfo = new CollectionExpression("ORM_RefeicoesInfo", this.getDetachedCriteria());
		tiposRefeicao = new CollectionExpression("ORM_TiposRefeicao", this.getDetachedCriteria());
		refeicoes = new CollectionExpression("ORM_Refeicoes", this.getDetachedCriteria());
	}
	
	public CantinaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.CantinaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		localizacao = new StringExpression("localizacao", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		refeicoesInfo = new CollectionExpression("ORM_RefeicoesInfo", this.getDetachedCriteria());
		tiposRefeicao = new CollectionExpression("ORM_TiposRefeicao", this.getDetachedCriteria());
		refeicoes = new CollectionExpression("ORM_Refeicoes", this.getDetachedCriteria());
	}
	
	public RefeicaoInfoDetachedCriteria createRefeicoesInfoCriteria() {
		return new RefeicaoInfoDetachedCriteria(createCriteria("ORM_RefeicoesInfo"));
	}
	
	public TipoRefeicaoDetachedCriteria createTiposRefeicaoCriteria() {
		return new TipoRefeicaoDetachedCriteria(createCriteria("ORM_TiposRefeicao"));
	}
	
	public RefeicaoDetachedCriteria createRefeicoesCriteria() {
		return new RefeicaoDetachedCriteria(createCriteria("ORM_Refeicoes"));
	}
	
	public Cantina uniqueCantina(PersistentSession session) {
		return (Cantina) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Cantina[] listCantina(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Cantina[]) list.toArray(new Cantina[list.size()]);
	}
}

