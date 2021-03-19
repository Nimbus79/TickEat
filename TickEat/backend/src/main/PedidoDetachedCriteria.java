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

public class PedidoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression consumidorId;
	public final AssociationExpression consumidor;
	
	public PedidoDetachedCriteria() {
		super(main.Pedido.class, main.PedidoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		consumidorId = new StringExpression("consumidor.", this.getDetachedCriteria());
		consumidor = new AssociationExpression("consumidor", this.getDetachedCriteria());
	}
	
	public PedidoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.PedidoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		consumidorId = new StringExpression("consumidor.", this.getDetachedCriteria());
		consumidor = new AssociationExpression("consumidor", this.getDetachedCriteria());
	}
	
	public ConsumidorDetachedCriteria createConsumidorCriteria() {
		return new ConsumidorDetachedCriteria(createCriteria("consumidor"));
	}
	
	public Pedido uniquePedido(PersistentSession session) {
		return (Pedido) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Pedido[] listPedido(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Pedido[]) list.toArray(new Pedido[list.size()]);
	}
}

