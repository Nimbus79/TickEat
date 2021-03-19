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

public class FerramentaValidacaoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression cantinaId;
	public final AssociationExpression cantina;
	public final BooleanExpression ativo;
	public final IntegerExpression tipoRefeicaoId;
	public final AssociationExpression tipoRefeicao;
	
	public FerramentaValidacaoDetachedCriteria() {
		super(main.FerramentaValidacao.class, main.FerramentaValidacaoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		cantinaId = new IntegerExpression("cantina.id", this.getDetachedCriteria());
		cantina = new AssociationExpression("cantina", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		tipoRefeicaoId = new IntegerExpression("tipoRefeicao.id", this.getDetachedCriteria());
		tipoRefeicao = new AssociationExpression("tipoRefeicao", this.getDetachedCriteria());
	}
	
	public FerramentaValidacaoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.FerramentaValidacaoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		cantinaId = new IntegerExpression("cantina.id", this.getDetachedCriteria());
		cantina = new AssociationExpression("cantina", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		tipoRefeicaoId = new IntegerExpression("tipoRefeicao.id", this.getDetachedCriteria());
		tipoRefeicao = new AssociationExpression("tipoRefeicao", this.getDetachedCriteria());
	}
	
	public TipoRefeicaoDetachedCriteria createTipoRefeicaoCriteria() {
		return new TipoRefeicaoDetachedCriteria(createCriteria("tipoRefeicao"));
	}
	
	public CantinaDetachedCriteria createCantinaCriteria() {
		return new CantinaDetachedCriteria(createCriteria("cantina"));
	}
	
	public FerramentaValidacao uniqueFerramentaValidacao(PersistentSession session) {
		return (FerramentaValidacao) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public FerramentaValidacao[] listFerramentaValidacao(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (FerramentaValidacao[]) list.toArray(new FerramentaValidacao[list.size()]);
	}
}

