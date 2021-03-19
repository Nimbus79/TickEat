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

public class AvaliacaoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression refeicaoId;
	public final AssociationExpression refeicao;
	public final StringExpression consumidorId;
	public final AssociationExpression consumidor;
	public final IntegerExpression pontuacao;
	public final CollectionExpression comentarios;
	
	public AvaliacaoDetachedCriteria() {
		super(main.Avaliacao.class, main.AvaliacaoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		refeicaoId = new IntegerExpression("refeicao.id", this.getDetachedCriteria());
		refeicao = new AssociationExpression("refeicao", this.getDetachedCriteria());
		consumidorId = new StringExpression("consumidor.", this.getDetachedCriteria());
		consumidor = new AssociationExpression("consumidor", this.getDetachedCriteria());
		pontuacao = new IntegerExpression("pontuacao", this.getDetachedCriteria());
		comentarios = new CollectionExpression("ORM_Comentarios", this.getDetachedCriteria());
	}
	
	public AvaliacaoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.AvaliacaoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		refeicaoId = new IntegerExpression("refeicao.id", this.getDetachedCriteria());
		refeicao = new AssociationExpression("refeicao", this.getDetachedCriteria());
		consumidorId = new StringExpression("consumidor.", this.getDetachedCriteria());
		consumidor = new AssociationExpression("consumidor", this.getDetachedCriteria());
		pontuacao = new IntegerExpression("pontuacao", this.getDetachedCriteria());
		comentarios = new CollectionExpression("ORM_Comentarios", this.getDetachedCriteria());
	}
	
	public RefeicaoDetachedCriteria createRefeicaoCriteria() {
		return new RefeicaoDetachedCriteria(createCriteria("refeicao"));
	}
	
	public ConsumidorDetachedCriteria createConsumidorCriteria() {
		return new ConsumidorDetachedCriteria(createCriteria("consumidor"));
	}
	
	public ComentarioDetachedCriteria createComentariosCriteria() {
		return new ComentarioDetachedCriteria(createCriteria("ORM_Comentarios"));
	}
	
	public Avaliacao uniqueAvaliacao(PersistentSession session) {
		return (Avaliacao) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Avaliacao[] listAvaliacao(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Avaliacao[]) list.toArray(new Avaliacao[list.size()]);
	}
}

