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

public class ReservaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression tipoRefeicaoId;
	public final AssociationExpression tipoRefeicao;
	public final IntegerExpression refeicaoId;
	public final AssociationExpression refeicao;
	public final BooleanExpression validada;
	public final StringExpression timestamp;
	public final CollectionExpression ementas;
	
	public ReservaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		tipoRefeicaoId = new IntegerExpression("tipoRefeicao.id", this);
		tipoRefeicao = new AssociationExpression("tipoRefeicao", this);
		refeicaoId = new IntegerExpression("refeicao.id", this);
		refeicao = new AssociationExpression("refeicao", this);
		validada = new BooleanExpression("validada", this);
		timestamp = new StringExpression("timestamp", this);
		ementas = new CollectionExpression("ORM_Ementas", this);
	}
	
	public ReservaCriteria(PersistentSession session) {
		this(session.createCriteria(Reserva.class));
	}
	
	public ReservaCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public TipoRefeicaoCriteria createTipoRefeicaoCriteria() {
		return new TipoRefeicaoCriteria(createCriteria("tipoRefeicao"));
	}
	
	public RefeicaoCriteria createRefeicaoCriteria() {
		return new RefeicaoCriteria(createCriteria("refeicao"));
	}
	
	public EmentaCriteria createEmentasCriteria() {
		return new EmentaCriteria(createCriteria("ORM_Ementas"));
	}
	
	public Reserva uniqueReserva() {
		return (Reserva) super.uniqueResult();
	}
	
	public Reserva[] listReserva() {
		java.util.List list = super.list();
		return (Reserva[]) list.toArray(new Reserva[list.size()]);
	}
}

