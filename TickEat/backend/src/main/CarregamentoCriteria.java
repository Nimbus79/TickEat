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

public class CarregamentoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final FloatExpression valor;
	public final StringExpression timestamp;
	public final BooleanExpression efetuado;
	public final StringExpression nome;
	public final FloatExpression saldoResultante;
	public final IntegerExpression referencia;
	public final IntegerExpression entidade;
	public final StringExpression validade;
	public final BlobExpression fatura;
	public final StringExpression metodo;
	
	public CarregamentoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		valor = new FloatExpression("valor", this);
		timestamp = new StringExpression("timestamp", this);
		efetuado = new BooleanExpression("efetuado", this);
		nome = new StringExpression("nome", this);
		saldoResultante = new FloatExpression("saldoResultante", this);
		referencia = new IntegerExpression("referencia", this);
		entidade = new IntegerExpression("entidade", this);
		validade = new StringExpression("validade", this);
		fatura = new BlobExpression("fatura", this);
		metodo = new StringExpression("metodo", this);
	}
	
	public CarregamentoCriteria(PersistentSession session) {
		this(session.createCriteria(Carregamento.class));
	}
	
	public CarregamentoCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public Carregamento uniqueCarregamento() {
		return (Carregamento) super.uniqueResult();
	}
	
	public Carregamento[] listCarregamento() {
		java.util.List list = super.list();
		return (Carregamento[]) list.toArray(new Carregamento[list.size()]);
	}
}

