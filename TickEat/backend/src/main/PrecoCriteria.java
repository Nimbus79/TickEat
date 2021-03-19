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

public class PrecoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression tipoRefeicaoId;
	public final AssociationExpression tipoRefeicao;
	public final IntegerExpression tipoConsumidorId;
	public final AssociationExpression tipoConsumidor;
	public final FloatExpression valor;
	
	public PrecoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		tipoRefeicaoId = new IntegerExpression("tipoRefeicao.id", this);
		tipoRefeicao = new AssociationExpression("tipoRefeicao", this);
		tipoConsumidorId = new IntegerExpression("tipoConsumidor.id", this);
		tipoConsumidor = new AssociationExpression("tipoConsumidor", this);
		valor = new FloatExpression("valor", this);
	}
	
	public PrecoCriteria(PersistentSession session) {
		this(session.createCriteria(Preco.class));
	}
	
	public PrecoCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public TipoRefeicaoCriteria createTipoRefeicaoCriteria() {
		return new TipoRefeicaoCriteria(createCriteria("tipoRefeicao"));
	}
	
	public TipoConsumidorCriteria createTipoConsumidorCriteria() {
		return new TipoConsumidorCriteria(createCriteria("tipoConsumidor"));
	}
	
	public Preco uniquePreco() {
		return (Preco) super.uniqueResult();
	}
	
	public Preco[] listPreco() {
		java.util.List list = super.list();
		return (Preco[]) list.toArray(new Preco[list.size()]);
	}
}

