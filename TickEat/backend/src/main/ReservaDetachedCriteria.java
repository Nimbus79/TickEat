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

public class ReservaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression tipoRefeicaoId;
	public final AssociationExpression tipoRefeicao;
	public final IntegerExpression refeicaoId;
	public final AssociationExpression refeicao;
	public final BooleanExpression validada;
	public final StringExpression timestamp;
	public final CollectionExpression ementas;
	
	public ReservaDetachedCriteria() {
		super(main.Reserva.class, main.ReservaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipoRefeicaoId = new IntegerExpression("tipoRefeicao.id", this.getDetachedCriteria());
		tipoRefeicao = new AssociationExpression("tipoRefeicao", this.getDetachedCriteria());
		refeicaoId = new IntegerExpression("refeicao.id", this.getDetachedCriteria());
		refeicao = new AssociationExpression("refeicao", this.getDetachedCriteria());
		validada = new BooleanExpression("validada", this.getDetachedCriteria());
		timestamp = new StringExpression("timestamp", this.getDetachedCriteria());
		ementas = new CollectionExpression("ORM_Ementas", this.getDetachedCriteria());
	}
	
	public ReservaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.ReservaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipoRefeicaoId = new IntegerExpression("tipoRefeicao.id", this.getDetachedCriteria());
		tipoRefeicao = new AssociationExpression("tipoRefeicao", this.getDetachedCriteria());
		refeicaoId = new IntegerExpression("refeicao.id", this.getDetachedCriteria());
		refeicao = new AssociationExpression("refeicao", this.getDetachedCriteria());
		validada = new BooleanExpression("validada", this.getDetachedCriteria());
		timestamp = new StringExpression("timestamp", this.getDetachedCriteria());
		ementas = new CollectionExpression("ORM_Ementas", this.getDetachedCriteria());
	}
	
	public TipoRefeicaoDetachedCriteria createTipoRefeicaoCriteria() {
		return new TipoRefeicaoDetachedCriteria(createCriteria("tipoRefeicao"));
	}
	
	public RefeicaoDetachedCriteria createRefeicaoCriteria() {
		return new RefeicaoDetachedCriteria(createCriteria("refeicao"));
	}
	
	public EmentaDetachedCriteria createEmentasCriteria() {
		return new EmentaDetachedCriteria(createCriteria("ORM_Ementas"));
	}
	
	public Reserva uniqueReserva(PersistentSession session) {
		return (Reserva) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Reserva[] listReserva(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Reserva[]) list.toArray(new Reserva[list.size()]);
	}
}

