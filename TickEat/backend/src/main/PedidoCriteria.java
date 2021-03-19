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

public class PedidoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression consumidorId;
	public final AssociationExpression consumidor;
	
	public PedidoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		consumidorId = new StringExpression("consumidor.", this);
		consumidor = new AssociationExpression("consumidor", this);
	}
	
	public PedidoCriteria(PersistentSession session) {
		this(session.createCriteria(Pedido.class));
	}
	
	public PedidoCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public ConsumidorCriteria createConsumidorCriteria() {
		return new ConsumidorCriteria(createCriteria("consumidor"));
	}
	
	public Pedido uniquePedido() {
		return (Pedido) super.uniqueResult();
	}
	
	public Pedido[] listPedido() {
		java.util.List list = super.list();
		return (Pedido[]) list.toArray(new Pedido[list.size()]);
	}
}

