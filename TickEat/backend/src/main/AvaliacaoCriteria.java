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

public class AvaliacaoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression refeicaoId;
	public final AssociationExpression refeicao;
	public final StringExpression consumidorId;
	public final AssociationExpression consumidor;
	public final IntegerExpression pontuacao;
	public final CollectionExpression comentarios;
	
	public AvaliacaoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		refeicaoId = new IntegerExpression("refeicao.id", this);
		refeicao = new AssociationExpression("refeicao", this);
		consumidorId = new StringExpression("consumidor.", this);
		consumidor = new AssociationExpression("consumidor", this);
		pontuacao = new IntegerExpression("pontuacao", this);
		comentarios = new CollectionExpression("ORM_Comentarios", this);
	}
	
	public AvaliacaoCriteria(PersistentSession session) {
		this(session.createCriteria(Avaliacao.class));
	}
	
	public AvaliacaoCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public RefeicaoCriteria createRefeicaoCriteria() {
		return new RefeicaoCriteria(createCriteria("refeicao"));
	}
	
	public ConsumidorCriteria createConsumidorCriteria() {
		return new ConsumidorCriteria(createCriteria("consumidor"));
	}
	
	public ComentarioCriteria createComentariosCriteria() {
		return new ComentarioCriteria(createCriteria("ORM_Comentarios"));
	}
	
	public Avaliacao uniqueAvaliacao() {
		return (Avaliacao) super.uniqueResult();
	}
	
	public Avaliacao[] listAvaliacao() {
		java.util.List list = super.list();
		return (Avaliacao[]) list.toArray(new Avaliacao[list.size()]);
	}
}

