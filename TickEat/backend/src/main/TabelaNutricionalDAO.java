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

public class TabelaNutricionalDAO {
	public static TabelaNutricional loadTabelaNutricionalByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadTabelaNutricionalByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TabelaNutricional getTabelaNutricionalByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return getTabelaNutricionalByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TabelaNutricional loadTabelaNutricionalByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadTabelaNutricionalByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TabelaNutricional getTabelaNutricionalByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return getTabelaNutricionalByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TabelaNutricional loadTabelaNutricionalByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (TabelaNutricional) session.load(main.TabelaNutricional.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TabelaNutricional getTabelaNutricionalByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (TabelaNutricional) session.get(main.TabelaNutricional.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TabelaNutricional loadTabelaNutricionalByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (TabelaNutricional) session.load(main.TabelaNutricional.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TabelaNutricional getTabelaNutricionalByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (TabelaNutricional) session.get(main.TabelaNutricional.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTabelaNutricional(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return queryTabelaNutricional(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTabelaNutricional(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return queryTabelaNutricional(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TabelaNutricional[] listTabelaNutricionalByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return listTabelaNutricionalByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TabelaNutricional[] listTabelaNutricionalByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return listTabelaNutricionalByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTabelaNutricional(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.TabelaNutricional as TabelaNutricional");
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
	
	public static List queryTabelaNutricional(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.TabelaNutricional as TabelaNutricional");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("TabelaNutricional", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TabelaNutricional[] listTabelaNutricionalByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryTabelaNutricional(session, condition, orderBy);
			return (TabelaNutricional[]) list.toArray(new TabelaNutricional[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TabelaNutricional[] listTabelaNutricionalByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTabelaNutricional(session, condition, orderBy, lockMode);
			return (TabelaNutricional[]) list.toArray(new TabelaNutricional[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TabelaNutricional loadTabelaNutricionalByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadTabelaNutricionalByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TabelaNutricional loadTabelaNutricionalByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadTabelaNutricionalByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TabelaNutricional loadTabelaNutricionalByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		TabelaNutricional[] tabelaNutricionals = listTabelaNutricionalByQuery(session, condition, orderBy);
		if (tabelaNutricionals != null && tabelaNutricionals.length > 0)
			return tabelaNutricionals[0];
		else
			return null;
	}
	
	public static TabelaNutricional loadTabelaNutricionalByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		TabelaNutricional[] tabelaNutricionals = listTabelaNutricionalByQuery(session, condition, orderBy, lockMode);
		if (tabelaNutricionals != null && tabelaNutricionals.length > 0)
			return tabelaNutricionals[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateTabelaNutricionalByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return iterateTabelaNutricionalByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTabelaNutricionalByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return iterateTabelaNutricionalByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTabelaNutricionalByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.TabelaNutricional as TabelaNutricional");
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
	
	public static java.util.Iterator iterateTabelaNutricionalByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.TabelaNutricional as TabelaNutricional");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("TabelaNutricional", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TabelaNutricional createTabelaNutricional() {
		return new main.TabelaNutricional();
	}
	
	public static boolean save(main.TabelaNutricional tabelaNutricional) throws PersistentException {
		try {
			tickeatPersistentManager.instance().saveObject(tabelaNutricional);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(main.TabelaNutricional tabelaNutricional) throws PersistentException {
		try {
			tickeatPersistentManager.instance().deleteObject(tabelaNutricional);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(main.TabelaNutricional tabelaNutricional) throws PersistentException {
		try {
			tickeatPersistentManager.instance().getSession().refresh(tabelaNutricional);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(main.TabelaNutricional tabelaNutricional) throws PersistentException {
		try {
			tickeatPersistentManager.instance().getSession().evict(tabelaNutricional);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TabelaNutricional loadTabelaNutricionalByCriteria(TabelaNutricionalCriteria tabelaNutricionalCriteria) {
		TabelaNutricional[] tabelaNutricionals = listTabelaNutricionalByCriteria(tabelaNutricionalCriteria);
		if(tabelaNutricionals == null || tabelaNutricionals.length == 0) {
			return null;
		}
		return tabelaNutricionals[0];
	}
	
	public static TabelaNutricional[] listTabelaNutricionalByCriteria(TabelaNutricionalCriteria tabelaNutricionalCriteria) {
		return tabelaNutricionalCriteria.listTabelaNutricional();
	}
}
