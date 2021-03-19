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

public class FerramentaContagemDAO {
	public static FerramentaContagem loadFerramentaContagemByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadFerramentaContagemByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaContagem getFerramentaContagemByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return getFerramentaContagemByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaContagem loadFerramentaContagemByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadFerramentaContagemByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaContagem getFerramentaContagemByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return getFerramentaContagemByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaContagem loadFerramentaContagemByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (FerramentaContagem) session.load(main.FerramentaContagem.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaContagem getFerramentaContagemByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (FerramentaContagem) session.get(main.FerramentaContagem.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaContagem loadFerramentaContagemByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (FerramentaContagem) session.load(main.FerramentaContagem.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaContagem getFerramentaContagemByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (FerramentaContagem) session.get(main.FerramentaContagem.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFerramentaContagem(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return queryFerramentaContagem(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFerramentaContagem(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return queryFerramentaContagem(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaContagem[] listFerramentaContagemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return listFerramentaContagemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaContagem[] listFerramentaContagemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return listFerramentaContagemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFerramentaContagem(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.FerramentaContagem as FerramentaContagem");
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
	
	public static List queryFerramentaContagem(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.FerramentaContagem as FerramentaContagem");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("FerramentaContagem", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaContagem[] listFerramentaContagemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryFerramentaContagem(session, condition, orderBy);
			return (FerramentaContagem[]) list.toArray(new FerramentaContagem[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaContagem[] listFerramentaContagemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryFerramentaContagem(session, condition, orderBy, lockMode);
			return (FerramentaContagem[]) list.toArray(new FerramentaContagem[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaContagem loadFerramentaContagemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadFerramentaContagemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaContagem loadFerramentaContagemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadFerramentaContagemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaContagem loadFerramentaContagemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		FerramentaContagem[] ferramentaContagems = listFerramentaContagemByQuery(session, condition, orderBy);
		if (ferramentaContagems != null && ferramentaContagems.length > 0)
			return ferramentaContagems[0];
		else
			return null;
	}
	
	public static FerramentaContagem loadFerramentaContagemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		FerramentaContagem[] ferramentaContagems = listFerramentaContagemByQuery(session, condition, orderBy, lockMode);
		if (ferramentaContagems != null && ferramentaContagems.length > 0)
			return ferramentaContagems[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateFerramentaContagemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return iterateFerramentaContagemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFerramentaContagemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return iterateFerramentaContagemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFerramentaContagemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.FerramentaContagem as FerramentaContagem");
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
	
	public static java.util.Iterator iterateFerramentaContagemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.FerramentaContagem as FerramentaContagem");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("FerramentaContagem", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaContagem createFerramentaContagem() {
		return new main.FerramentaContagem();
	}
	
	public static boolean save(main.FerramentaContagem ferramentaContagem) throws PersistentException {
		try {
			tickeatPersistentManager.instance().saveObject(ferramentaContagem);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(main.FerramentaContagem ferramentaContagem) throws PersistentException {
		try {
			tickeatPersistentManager.instance().deleteObject(ferramentaContagem);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(main.FerramentaContagem ferramentaContagem) throws PersistentException {
		try {
			tickeatPersistentManager.instance().getSession().refresh(ferramentaContagem);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(main.FerramentaContagem ferramentaContagem) throws PersistentException {
		try {
			tickeatPersistentManager.instance().getSession().evict(ferramentaContagem);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaContagem loadFerramentaContagemByCriteria(FerramentaContagemCriteria ferramentaContagemCriteria) {
		FerramentaContagem[] ferramentaContagems = listFerramentaContagemByCriteria(ferramentaContagemCriteria);
		if(ferramentaContagems == null || ferramentaContagems.length == 0) {
			return null;
		}
		return ferramentaContagems[0];
	}
	
	public static FerramentaContagem[] listFerramentaContagemByCriteria(FerramentaContagemCriteria ferramentaContagemCriteria) {
		return ferramentaContagemCriteria.listFerramentaContagem();
	}
}
