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

public class DespesaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final FloatExpression valor;
	public final StringExpression timestamp;
	public final BooleanExpression efetuado;
	public final StringExpression nome;
	public final FloatExpression saldoResultante;
	public final StringExpression descricao;
	public final IntegerExpression refeicaoId;
	public final AssociationExpression refeicao;
	public final IntegerExpression reservaId;
	public final AssociationExpression reserva;
	
	public DespesaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		valor = new FloatExpression("valor", this);
		timestamp = new StringExpression("timestamp", this);
		efetuado = new BooleanExpression("efetuado", this);
		nome = new StringExpression("nome", this);
		saldoResultante = new FloatExpression("saldoResultante", this);
		descricao = new StringExpression("descricao", this);
		refeicaoId = new IntegerExpression("refeicao.id", this);
		refeicao = new AssociationExpression("refeicao", this);
		reservaId = new IntegerExpression("reserva.id", this);
		reserva = new AssociationExpression("reserva", this);
	}
	
	public DespesaCriteria(PersistentSession session) {
		this(session.createCriteria(Despesa.class));
	}
	
	public DespesaCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public RefeicaoCriteria createRefeicaoCriteria() {
		return new RefeicaoCriteria(createCriteria("refeicao"));
	}
	
	public ReservaCriteria createReservaCriteria() {
		return new ReservaCriteria(createCriteria("reserva"));
	}
	
	public Despesa uniqueDespesa() {
		return (Despesa) super.uniqueResult();
	}
	
	public Despesa[] listDespesa() {
		java.util.List list = super.list();
		return (Despesa[]) list.toArray(new Despesa[list.size()]);
	}
}

