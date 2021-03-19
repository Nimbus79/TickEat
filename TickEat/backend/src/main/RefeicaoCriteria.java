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

public class RefeicaoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression refeicaoInfoId;
	public final AssociationExpression refeicaoInfo;
	public final StringExpression data;
	public final IntegerExpression previsaoGeral;
	public final IntegerExpression contagemEntrada;
	public final IntegerExpression contagemValidados;
	public final BooleanExpression aDecorrer;
	public final CollectionExpression ementas;
	
	public RefeicaoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		refeicaoInfoId = new IntegerExpression("refeicaoInfo.id", this);
		refeicaoInfo = new AssociationExpression("refeicaoInfo", this);
		data = new StringExpression("data", this);
		previsaoGeral = new IntegerExpression("previsaoGeral", this);
		contagemEntrada = new IntegerExpression("contagemEntrada", this);
		contagemValidados = new IntegerExpression("contagemValidados", this);
		aDecorrer = new BooleanExpression("aDecorrer", this);
		ementas = new CollectionExpression("ORM_Ementas", this);
	}
	
	public RefeicaoCriteria(PersistentSession session) {
		this(session.createCriteria(Refeicao.class));
	}
	
	public RefeicaoCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public RefeicaoInfoCriteria createRefeicaoInfoCriteria() {
		return new RefeicaoInfoCriteria(createCriteria("refeicaoInfo"));
	}
	
	public EmentaCriteria createEmentasCriteria() {
		return new EmentaCriteria(createCriteria("ORM_Ementas"));
	}
	
	public Refeicao uniqueRefeicao() {
		return (Refeicao) super.uniqueResult();
	}
	
	public Refeicao[] listRefeicao() {
		java.util.List list = super.list();
		return (Refeicao[]) list.toArray(new Refeicao[list.size()]);
	}
}

