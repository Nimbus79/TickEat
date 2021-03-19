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

public class CozinheiroDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression email;
	public final StringExpression password;
	public final StringExpression nome;
	public final StringExpression tipo;
	public final BooleanExpression ativo;
	public final IntegerExpression cantinaId;
	public final AssociationExpression cantina;
	
	public CozinheiroDetachedCriteria() {
		super(main.Cozinheiro.class, main.CozinheiroCriteria.class);
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		cantinaId = new IntegerExpression("cantina.id", this.getDetachedCriteria());
		cantina = new AssociationExpression("cantina", this.getDetachedCriteria());
	}
	
	public CozinheiroDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.CozinheiroCriteria.class);
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		cantinaId = new IntegerExpression("cantina.id", this.getDetachedCriteria());
		cantina = new AssociationExpression("cantina", this.getDetachedCriteria());
	}
	
	public CantinaDetachedCriteria createCantinaCriteria() {
		return new CantinaDetachedCriteria(createCriteria("cantina"));
	}
	
	public Cozinheiro uniqueCozinheiro(PersistentSession session) {
		return (Cozinheiro) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Cozinheiro[] listCozinheiro(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Cozinheiro[]) list.toArray(new Cozinheiro[list.size()]);
	}
}

