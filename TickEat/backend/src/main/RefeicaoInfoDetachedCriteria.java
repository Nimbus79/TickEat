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

public class RefeicaoInfoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression nome;
	public final BooleanExpression ativo;
	public final StringExpression horaInicio;
	public final StringExpression horaFim;
	public final StringExpression horaLimite;
	public final FloatExpression desconto;
	public final FloatExpression taxaCancelamento;
	public final BooleanExpression segunda;
	public final BooleanExpression terca;
	public final BooleanExpression quarta;
	public final BooleanExpression quinta;
	public final BooleanExpression sexta;
	public final BooleanExpression sabado;
	public final BooleanExpression domingo;
	
	public RefeicaoInfoDetachedCriteria() {
		super(main.RefeicaoInfo.class, main.RefeicaoInfoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		horaInicio = new StringExpression("horaInicio", this.getDetachedCriteria());
		horaFim = new StringExpression("horaFim", this.getDetachedCriteria());
		horaLimite = new StringExpression("horaLimite", this.getDetachedCriteria());
		desconto = new FloatExpression("desconto", this.getDetachedCriteria());
		taxaCancelamento = new FloatExpression("taxaCancelamento", this.getDetachedCriteria());
		segunda = new BooleanExpression("segunda", this.getDetachedCriteria());
		terca = new BooleanExpression("terca", this.getDetachedCriteria());
		quarta = new BooleanExpression("quarta", this.getDetachedCriteria());
		quinta = new BooleanExpression("quinta", this.getDetachedCriteria());
		sexta = new BooleanExpression("sexta", this.getDetachedCriteria());
		sabado = new BooleanExpression("sabado", this.getDetachedCriteria());
		domingo = new BooleanExpression("domingo", this.getDetachedCriteria());
	}
	
	public RefeicaoInfoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.RefeicaoInfoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		horaInicio = new StringExpression("horaInicio", this.getDetachedCriteria());
		horaFim = new StringExpression("horaFim", this.getDetachedCriteria());
		horaLimite = new StringExpression("horaLimite", this.getDetachedCriteria());
		desconto = new FloatExpression("desconto", this.getDetachedCriteria());
		taxaCancelamento = new FloatExpression("taxaCancelamento", this.getDetachedCriteria());
		segunda = new BooleanExpression("segunda", this.getDetachedCriteria());
		terca = new BooleanExpression("terca", this.getDetachedCriteria());
		quarta = new BooleanExpression("quarta", this.getDetachedCriteria());
		quinta = new BooleanExpression("quinta", this.getDetachedCriteria());
		sexta = new BooleanExpression("sexta", this.getDetachedCriteria());
		sabado = new BooleanExpression("sabado", this.getDetachedCriteria());
		domingo = new BooleanExpression("domingo", this.getDetachedCriteria());
	}
	
	public RefeicaoInfo uniqueRefeicaoInfo(PersistentSession session) {
		return (RefeicaoInfo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public RefeicaoInfo[] listRefeicaoInfo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (RefeicaoInfo[]) list.toArray(new RefeicaoInfo[list.size()]);
	}
}

