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

public class RefeicaoInfoDAO {
	public static RefeicaoInfo loadRefeicaoInfoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadRefeicaoInfoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RefeicaoInfo getRefeicaoInfoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return getRefeicaoInfoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RefeicaoInfo loadRefeicaoInfoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadRefeicaoInfoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RefeicaoInfo getRefeicaoInfoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return getRefeicaoInfoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RefeicaoInfo loadRefeicaoInfoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (RefeicaoInfo) session.load(main.RefeicaoInfo.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RefeicaoInfo getRefeicaoInfoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (RefeicaoInfo) session.get(main.RefeicaoInfo.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RefeicaoInfo loadRefeicaoInfoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (RefeicaoInfo) session.load(main.RefeicaoInfo.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RefeicaoInfo getRefeicaoInfoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (RefeicaoInfo) session.get(main.RefeicaoInfo.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRefeicaoInfo(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return queryRefeicaoInfo(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRefeicaoInfo(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return queryRefeicaoInfo(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RefeicaoInfo[] listRefeicaoInfoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return listRefeicaoInfoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RefeicaoInfo[] listRefeicaoInfoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return listRefeicaoInfoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRefeicaoInfo(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.RefeicaoInfo as RefeicaoInfo");
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
	
	public static List queryRefeicaoInfo(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.RefeicaoInfo as RefeicaoInfo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("RefeicaoInfo", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RefeicaoInfo[] listRefeicaoInfoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryRefeicaoInfo(session, condition, orderBy);
			return (RefeicaoInfo[]) list.toArray(new RefeicaoInfo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RefeicaoInfo[] listRefeicaoInfoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryRefeicaoInfo(session, condition, orderBy, lockMode);
			return (RefeicaoInfo[]) list.toArray(new RefeicaoInfo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RefeicaoInfo loadRefeicaoInfoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadRefeicaoInfoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RefeicaoInfo loadRefeicaoInfoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadRefeicaoInfoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RefeicaoInfo loadRefeicaoInfoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		RefeicaoInfo[] refeicaoInfos = listRefeicaoInfoByQuery(session, condition, orderBy);
		if (refeicaoInfos != null && refeicaoInfos.length > 0)
			return refeicaoInfos[0];
		else
			return null;
	}
	
	public static RefeicaoInfo loadRefeicaoInfoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		RefeicaoInfo[] refeicaoInfos = listRefeicaoInfoByQuery(session, condition, orderBy, lockMode);
		if (refeicaoInfos != null && refeicaoInfos.length > 0)
			return refeicaoInfos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRefeicaoInfoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return iterateRefeicaoInfoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRefeicaoInfoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return iterateRefeicaoInfoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRefeicaoInfoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.RefeicaoInfo as RefeicaoInfo");
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
	
	public static java.util.Iterator iterateRefeicaoInfoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.RefeicaoInfo as RefeicaoInfo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("RefeicaoInfo", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RefeicaoInfo createRefeicaoInfo() {
		return new main.RefeicaoInfo();
	}
	
	public static boolean save(main.RefeicaoInfo refeicaoInfo) throws PersistentException {
		try {
			tickeatPersistentManager.instance().saveObject(refeicaoInfo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(main.RefeicaoInfo refeicaoInfo) throws PersistentException {
		try {
			tickeatPersistentManager.instance().deleteObject(refeicaoInfo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(main.RefeicaoInfo refeicaoInfo) throws PersistentException {
		try {
			tickeatPersistentManager.instance().getSession().refresh(refeicaoInfo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(main.RefeicaoInfo refeicaoInfo) throws PersistentException {
		try {
			tickeatPersistentManager.instance().getSession().evict(refeicaoInfo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RefeicaoInfo loadRefeicaoInfoByCriteria(RefeicaoInfoCriteria refeicaoInfoCriteria) {
		RefeicaoInfo[] refeicaoInfos = listRefeicaoInfoByCriteria(refeicaoInfoCriteria);
		if(refeicaoInfos == null || refeicaoInfos.length == 0) {
			return null;
		}
		return refeicaoInfos[0];
	}
	
	public static RefeicaoInfo[] listRefeicaoInfoByCriteria(RefeicaoInfoCriteria refeicaoInfoCriteria) {
		return refeicaoInfoCriteria.listRefeicaoInfo();
	}
}
