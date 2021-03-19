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

public class FerramentaValidacaoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression cantinaId;
	public final AssociationExpression cantina;
	public final BooleanExpression ativo;
	public final IntegerExpression tipoRefeicaoId;
	public final AssociationExpression tipoRefeicao;
	
	public FerramentaValidacaoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		cantinaId = new IntegerExpression("cantina.id", this);
		cantina = new AssociationExpression("cantina", this);
		ativo = new BooleanExpression("ativo", this);
		tipoRefeicaoId = new IntegerExpression("tipoRefeicao.id", this);
		tipoRefeicao = new AssociationExpression("tipoRefeicao", this);
	}
	
	public FerramentaValidacaoCriteria(PersistentSession session) {
		this(session.createCriteria(FerramentaValidacao.class));
	}
	
	public FerramentaValidacaoCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public TipoRefeicaoCriteria createTipoRefeicaoCriteria() {
		return new TipoRefeicaoCriteria(createCriteria("tipoRefeicao"));
	}
	
	public CantinaCriteria createCantinaCriteria() {
		return new CantinaCriteria(createCriteria("cantina"));
	}
	
	public FerramentaValidacao uniqueFerramentaValidacao() {
		return (FerramentaValidacao) super.uniqueResult();
	}
	
	public FerramentaValidacao[] listFerramentaValidacao() {
		java.util.List list = super.list();
		return (FerramentaValidacao[]) list.toArray(new FerramentaValidacao[list.size()]);
	}
}

