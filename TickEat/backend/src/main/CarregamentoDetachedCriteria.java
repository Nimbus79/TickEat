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

public class CarregamentoDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public CarregamentoDetachedCriteria() {
		super(main.Carregamento.class, main.CarregamentoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		valor = new FloatExpression("valor", this.getDetachedCriteria());
		timestamp = new StringExpression("timestamp", this.getDetachedCriteria());
		efetuado = new BooleanExpression("efetuado", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		saldoResultante = new FloatExpression("saldoResultante", this.getDetachedCriteria());
		referencia = new IntegerExpression("referencia", this.getDetachedCriteria());
		entidade = new IntegerExpression("entidade", this.getDetachedCriteria());
		validade = new StringExpression("validade", this.getDetachedCriteria());
		fatura = new BlobExpression("fatura", this.getDetachedCriteria());
		metodo = new StringExpression("metodo", this.getDetachedCriteria());
	}
	
	public CarregamentoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.CarregamentoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		valor = new FloatExpression("valor", this.getDetachedCriteria());
		timestamp = new StringExpression("timestamp", this.getDetachedCriteria());
		efetuado = new BooleanExpression("efetuado", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		saldoResultante = new FloatExpression("saldoResultante", this.getDetachedCriteria());
		referencia = new IntegerExpression("referencia", this.getDetachedCriteria());
		entidade = new IntegerExpression("entidade", this.getDetachedCriteria());
		validade = new StringExpression("validade", this.getDetachedCriteria());
		fatura = new BlobExpression("fatura", this.getDetachedCriteria());
		metodo = new StringExpression("metodo", this.getDetachedCriteria());
	}
	
	public Carregamento uniqueCarregamento(PersistentSession session) {
		return (Carregamento) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Carregamento[] listCarregamento(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Carregamento[]) list.toArray(new Carregamento[list.size()]);
	}
}

