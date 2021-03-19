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

import org.orm.*;
import org.hibernate.Query;

import java.util.List;

public class MovimentoDAO {
	public static Movimento loadMovimentoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadMovimentoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movimento getMovimentoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return getMovimentoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movimento loadMovimentoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadMovimentoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movimento getMovimentoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return getMovimentoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movimento loadMovimentoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Movimento) session.load(main.Movimento.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movimento getMovimentoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Movimento) session.get(main.Movimento.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movimento loadMovimentoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Movimento) session.load(main.Movimento.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movimento getMovimentoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Movimento) session.get(main.Movimento.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMovimento(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return queryMovimento(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMovimento(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return queryMovimento(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movimento[] listMovimentoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return listMovimentoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movimento[] listMovimentoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return listMovimentoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMovimento(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Movimento as Movimento");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMovimento(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Movimento as Movimento");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Movimento", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movimento[] listMovimentoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryMovimento(session, condition, orderBy);
			return (Movimento[]) list.toArray(new Movimento[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movimento[] listMovimentoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryMovimento(session, condition, orderBy, lockMode);
			return (Movimento[]) list.toArray(new Movimento[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movimento loadMovimentoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadMovimentoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movimento loadMovimentoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadMovimentoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movimento loadMovimentoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Movimento[] movimentos = listMovimentoByQuery(session, condition, orderBy);
		if (movimentos != null && movimentos.length > 0)
			return movimentos[0];
		else
			return null;
	}
	
	public static Movimento loadMovimentoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Movimento[] movimentos = listMovimentoByQuery(session, condition, orderBy, lockMode);
		if (movimentos != null && movimentos.length > 0)
			return movimentos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateMovimentoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return iterateMovimentoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMovimentoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return iterateMovimentoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMovimentoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Movimento as Movimento");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMovimentoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Movimento as Movimento");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Movimento", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movimento createMovimento() {
		return new main.Movimento();
	}
	
	public static boolean save(main.Movimento movimento) throws PersistentException {
		try {
			tickeatPersistentManager.instance().saveObject(movimento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(main.Movimento movimento) throws PersistentException {
		try {
			tickeatPersistentManager.instance().deleteObject(movimento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(main.Movimento movimento) throws PersistentException {
		try {
			tickeatPersistentManager.instance().getSession().refresh(movimento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(main.Movimento movimento) throws PersistentException {
		try {
			tickeatPersistentManager.instance().getSession().evict(movimento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Movimento loadMovimentoByCriteria(MovimentoCriteria movimentoCriteria) {
		Movimento[] movimentos = listMovimentoByCriteria(movimentoCriteria);
		if(movimentos == null || movimentos.length == 0) {
			return null;
		}
		return movimentos[0];
	}
	
	public static Movimento[] listMovimentoByCriteria(MovimentoCriteria movimentoCriteria) {
		return movimentoCriteria.listMovimento();
	}
}
