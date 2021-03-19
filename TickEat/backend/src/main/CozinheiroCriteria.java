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

public class CozinheiroCriteria extends AbstractORMCriteria {
	public final StringExpression email;
	public final StringExpression password;
	public final StringExpression nome;
	public final StringExpression tipo;
	public final BooleanExpression ativo;
	public final IntegerExpression cantinaId;
	public final AssociationExpression cantina;
	
	public CozinheiroCriteria(Criteria criteria) {
		super(criteria);
		email = new StringExpression("email", this);
		password = new StringExpression("password", this);
		nome = new StringExpression("nome", this);
		tipo = new StringExpression("tipo", this);
		ativo = new BooleanExpression("ativo", this);
		cantinaId = new IntegerExpression("cantina.id", this);
		cantina = new AssociationExpression("cantina", this);
	}
	
	public CozinheiroCriteria(PersistentSession session) {
		this(session.createCriteria(Cozinheiro.class));
	}
	
	public CozinheiroCriteria() throws PersistentException {
		this(tickeatPersistentManager.instance().getSession());
	}
	
	public CantinaCriteria createCantinaCriteria() {
		return new CantinaCriteria(createCriteria("cantina"));
	}
	
	public Cozinheiro uniqueCozinheiro() {
		return (Cozinheiro) super.uniqueResult();
	}
	
	public Cozinheiro[] listCozinheiro() {
		java.util.List list = super.list();
		return (Cozinheiro[]) list.toArray(new Cozinheiro[list.size()]);
	}
}

