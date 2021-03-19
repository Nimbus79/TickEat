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

public class PrecoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression tipoRefeicaoId;
	public final AssociationExpression tipoRefeicao;
	public final IntegerExpression tipoConsumidorId;
	public final AssociationExpression tipoConsumidor;
	public final FloatExpression valor;
	
	public PrecoDetachedCriteria() {
		super(main.Preco.class, main.PrecoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipoRefeicaoId = new IntegerExpression("tipoRefeicao.id", this.getDetachedCriteria());
		tipoRefeicao = new AssociationExpression("tipoRefeicao", this.getDetachedCriteria());
		tipoConsumidorId = new IntegerExpression("tipoConsumidor.id", this.getDetachedCriteria());
		tipoConsumidor = new AssociationExpression("tipoConsumidor", this.getDetachedCriteria());
		valor = new FloatExpression("valor", this.getDetachedCriteria());
	}
	
	public PrecoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.PrecoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipoRefeicaoId = new IntegerExpression("tipoRefeicao.id", this.getDetachedCriteria());
		tipoRefeicao = new AssociationExpression("tipoRefeicao", this.getDetachedCriteria());
		tipoConsumidorId = new IntegerExpression("tipoConsumidor.id", this.getDetachedCriteria());
		tipoConsumidor = new AssociationExpression("tipoConsumidor", this.getDetachedCriteria());
		valor = new FloatExpression("valor", this.getDetachedCriteria());
	}
	
	public TipoRefeicaoDetachedCriteria createTipoRefeicaoCriteria() {
		return new TipoRefeicaoDetachedCriteria(createCriteria("tipoRefeicao"));
	}
	
	public TipoConsumidorDetachedCriteria createTipoConsumidorCriteria() {
		return new TipoConsumidorDetachedCriteria(createCriteria("tipoConsumidor"));
	}
	
	public Preco uniquePreco(PersistentSession session) {
		return (Preco) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Preco[] listPreco(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Preco[]) list.toArray(new Preco[list.size()]);
	}
}

