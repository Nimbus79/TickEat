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

public class RefeicaoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression refeicaoInfoId;
	public final AssociationExpression refeicaoInfo;
	public final StringExpression data;
	public final IntegerExpression previsaoGeral;
	public final IntegerExpression contagemEntrada;
	public final IntegerExpression contagemValidados;
	public final BooleanExpression aDecorrer;
	public final CollectionExpression ementas;
	
	public RefeicaoDetachedCriteria() {
		super(main.Refeicao.class, main.RefeicaoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		refeicaoInfoId = new IntegerExpression("refeicaoInfo.id", this.getDetachedCriteria());
		refeicaoInfo = new AssociationExpression("refeicaoInfo", this.getDetachedCriteria());
		data = new StringExpression("data", this.getDetachedCriteria());
		previsaoGeral = new IntegerExpression("previsaoGeral", this.getDetachedCriteria());
		contagemEntrada = new IntegerExpression("contagemEntrada", this.getDetachedCriteria());
		contagemValidados = new IntegerExpression("contagemValidados", this.getDetachedCriteria());
		aDecorrer = new BooleanExpression("aDecorrer", this.getDetachedCriteria());
		ementas = new CollectionExpression("ORM_Ementas", this.getDetachedCriteria());
	}
	
	public RefeicaoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.RefeicaoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		refeicaoInfoId = new IntegerExpression("refeicaoInfo.id", this.getDetachedCriteria());
		refeicaoInfo = new AssociationExpression("refeicaoInfo", this.getDetachedCriteria());
		data = new StringExpression("data", this.getDetachedCriteria());
		previsaoGeral = new IntegerExpression("previsaoGeral", this.getDetachedCriteria());
		contagemEntrada = new IntegerExpression("contagemEntrada", this.getDetachedCriteria());
		contagemValidados = new IntegerExpression("contagemValidados", this.getDetachedCriteria());
		aDecorrer = new BooleanExpression("aDecorrer", this.getDetachedCriteria());
		ementas = new CollectionExpression("ORM_Ementas", this.getDetachedCriteria());
	}
	
	public RefeicaoInfoDetachedCriteria createRefeicaoInfoCriteria() {
		return new RefeicaoInfoDetachedCriteria(createCriteria("refeicaoInfo"));
	}
	
	public EmentaDetachedCriteria createEmentasCriteria() {
		return new EmentaDetachedCriteria(createCriteria("ORM_Ementas"));
	}
	
	public Refeicao uniqueRefeicao(PersistentSession session) {
		return (Refeicao) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Refeicao[] listRefeicao(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Refeicao[]) list.toArray(new Refeicao[list.size()]);
	}
}

