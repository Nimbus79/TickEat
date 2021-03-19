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

public class DespesaDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public DespesaDetachedCriteria() {
		super(main.Despesa.class, main.DespesaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		valor = new FloatExpression("valor", this.getDetachedCriteria());
		timestamp = new StringExpression("timestamp", this.getDetachedCriteria());
		efetuado = new BooleanExpression("efetuado", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		saldoResultante = new FloatExpression("saldoResultante", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
		refeicaoId = new IntegerExpression("refeicao.id", this.getDetachedCriteria());
		refeicao = new AssociationExpression("refeicao", this.getDetachedCriteria());
		reservaId = new IntegerExpression("reserva.id", this.getDetachedCriteria());
		reserva = new AssociationExpression("reserva", this.getDetachedCriteria());
	}
	
	public DespesaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.DespesaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		valor = new FloatExpression("valor", this.getDetachedCriteria());
		timestamp = new StringExpression("timestamp", this.getDetachedCriteria());
		efetuado = new BooleanExpression("efetuado", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		saldoResultante = new FloatExpression("saldoResultante", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
		refeicaoId = new IntegerExpression("refeicao.id", this.getDetachedCriteria());
		refeicao = new AssociationExpression("refeicao", this.getDetachedCriteria());
		reservaId = new IntegerExpression("reserva.id", this.getDetachedCriteria());
		reserva = new AssociationExpression("reserva", this.getDetachedCriteria());
	}
	
	public RefeicaoDetachedCriteria createRefeicaoCriteria() {
		return new RefeicaoDetachedCriteria(createCriteria("refeicao"));
	}
	
	public ReservaDetachedCriteria createReservaCriteria() {
		return new ReservaDetachedCriteria(createCriteria("reserva"));
	}
	
	public Despesa uniqueDespesa(PersistentSession session) {
		return (Despesa) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Despesa[] listDespesa(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Despesa[]) list.toArray(new Despesa[list.size()]);
	}
}

