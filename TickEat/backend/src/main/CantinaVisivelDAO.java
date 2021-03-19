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

public class CantinaVisivelDAO {
	public static CantinaVisivel loadCantinaVisivelByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadCantinaVisivelByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CantinaVisivel getCantinaVisivelByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return getCantinaVisivelByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CantinaVisivel loadCantinaVisivelByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadCantinaVisivelByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CantinaVisivel getCantinaVisivelByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return getCantinaVisivelByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CantinaVisivel loadCantinaVisivelByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (CantinaVisivel) session.load(main.CantinaVisivel.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CantinaVisivel getCantinaVisivelByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (CantinaVisivel) session.get(main.CantinaVisivel.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CantinaVisivel loadCantinaVisivelByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (CantinaVisivel) session.load(main.CantinaVisivel.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CantinaVisivel getCantinaVisivelByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (CantinaVisivel) session.get(main.CantinaVisivel.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCantinaVisivel(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return queryCantinaVisivel(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCantinaVisivel(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return queryCantinaVisivel(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CantinaVisivel[] listCantinaVisivelByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return listCantinaVisivelByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CantinaVisivel[] listCantinaVisivelByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return listCantinaVisivelByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCantinaVisivel(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.CantinaVisivel as CantinaVisivel");
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
	
	public static List queryCantinaVisivel(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.CantinaVisivel as CantinaVisivel");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("CantinaVisivel", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CantinaVisivel[] listCantinaVisivelByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryCantinaVisivel(session, condition, orderBy);
			return (CantinaVisivel[]) list.toArray(new CantinaVisivel[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CantinaVisivel[] listCantinaVisivelByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryCantinaVisivel(session, condition, orderBy, lockMode);
			return (CantinaVisivel[]) list.toArray(new CantinaVisivel[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CantinaVisivel loadCantinaVisivelByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadCantinaVisivelByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CantinaVisivel loadCantinaVisivelByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadCantinaVisivelByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CantinaVisivel loadCantinaVisivelByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		CantinaVisivel[] cantinaVisivels = listCantinaVisivelByQuery(session, condition, orderBy);
		if (cantinaVisivels != null && cantinaVisivels.length > 0)
			return cantinaVisivels[0];
		else
			return null;
	}
	
	public static CantinaVisivel loadCantinaVisivelByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		CantinaVisivel[] cantinaVisivels = listCantinaVisivelByQuery(session, condition, orderBy, lockMode);
		if (cantinaVisivels != null && cantinaVisivels.length > 0)
			return cantinaVisivels[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCantinaVisivelByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return iterateCantinaVisivelByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCantinaVisivelByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return iterateCantinaVisivelByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCantinaVisivelByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.CantinaVisivel as CantinaVisivel");
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
	
	public static java.util.Iterator iterateCantinaVisivelByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.CantinaVisivel as CantinaVisivel");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("CantinaVisivel", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CantinaVisivel createCantinaVisivel() {
		return new main.CantinaVisivel();
	}
	
	public static boolean save(main.CantinaVisivel cantinaVisivel) throws PersistentException {
		try {
			tickeatPersistentManager.instance().saveObject(cantinaVisivel);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(main.CantinaVisivel cantinaVisivel) throws PersistentException {
		try {
			tickeatPersistentManager.instance().deleteObject(cantinaVisivel);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(main.CantinaVisivel cantinaVisivel) throws PersistentException {
		try {
			tickeatPersistentManager.instance().getSession().refresh(cantinaVisivel);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(main.CantinaVisivel cantinaVisivel) throws PersistentException {
		try {
			tickeatPersistentManager.instance().getSession().evict(cantinaVisivel);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CantinaVisivel loadCantinaVisivelByCriteria(CantinaVisivelCriteria cantinaVisivelCriteria) {
		CantinaVisivel[] cantinaVisivels = listCantinaVisivelByCriteria(cantinaVisivelCriteria);
		if(cantinaVisivels == null || cantinaVisivels.length == 0) {
			return null;
		}
		return cantinaVisivels[0];
	}
	
	public static CantinaVisivel[] listCantinaVisivelByCriteria(CantinaVisivelCriteria cantinaVisivelCriteria) {
		return cantinaVisivelCriteria.listCantinaVisivel();
	}
}
