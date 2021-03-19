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

public class RefeicaoInfoCriteria extends AbstractORMCriteria {
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
	
	public RefeicaoInfoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nome = new StringExpression("nome", this);
		ativo = new BooleanExpression("ativo", this);
		horaInicio = new StringExpression("horaInicio", this);
		horaFim = new StringExpression("horaFim", this);
		horaLimite = new StringExpression("horaLimite", this);
		desconto = new FloatExpression("desconto", this);
		taxaCancelamento = new FloatExpression("taxaCancelamento", this);
		segunda = new BooleanExpression("segunda", this);
		terca = new BooleanExpression("terca", this);
		quarta = new BooleanExpression("quarta", this);
		quinta = new BooleanExpression("quinta", this);
		sexta = new BooleanExpression("sexta", this);
		sabado = new BooleanExpression("sabado", this);
		domingo = new BooleanExpression("domingo", this);
	}
	
	public RefeicaoInfoCriteria(PersistentSession session) {
		this(session.createCriteria(RefeicaoInfo.class));
	}
	
	public RefeicaoInfoCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public RefeicaoInfo uniqueRefeicaoInfo() {
		return (RefeicaoInfo) super.uniqueResult();
	}
	
	public RefeicaoInfo[] listRefeicaoInfo() {
		java.util.List list = super.list();
		return (RefeicaoInfo[]) list.toArray(new RefeicaoInfo[list.size()]);
	}
}

