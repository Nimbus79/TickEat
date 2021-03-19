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

public class NotificacaoDAO {
	public static Notificacao loadNotificacaoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadNotificacaoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacao getNotificacaoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return getNotificacaoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacao loadNotificacaoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadNotificacaoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacao getNotificacaoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return getNotificacaoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacao loadNotificacaoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Notificacao) session.load(main.Notificacao.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacao getNotificacaoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Notificacao) session.get(main.Notificacao.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacao loadNotificacaoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Notificacao) session.load(main.Notificacao.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacao getNotificacaoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Notificacao) session.get(main.Notificacao.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryNotificacao(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return queryNotificacao(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryNotificacao(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return queryNotificacao(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacao[] listNotificacaoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return listNotificacaoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacao[] listNotificacaoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return listNotificacaoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryNotificacao(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Notificacao as Notificacao");
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
	
	public static List queryNotificacao(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Notificacao as Notificacao");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Notificacao", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacao[] listNotificacaoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryNotificacao(session, condition, orderBy);
			return (Notificacao[]) list.toArray(new Notificacao[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacao[] listNotificacaoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryNotificacao(session, condition, orderBy, lockMode);
			return (Notificacao[]) list.toArray(new Notificacao[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacao loadNotificacaoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadNotificacaoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacao loadNotificacaoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadNotificacaoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacao loadNotificacaoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Notificacao[] notificacaos = listNotificacaoByQuery(session, condition, orderBy);
		if (notificacaos != null && notificacaos.length > 0)
			return notificacaos[0];
		else
			return null;
	}
	
	public static Notificacao loadNotificacaoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Notificacao[] notificacaos = listNotificacaoByQuery(session, condition, orderBy, lockMode);
		if (notificacaos != null && notificacaos.length > 0)
			return notificacaos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateNotificacaoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return iterateNotificacaoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateNotificacaoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return iterateNotificacaoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateNotificacaoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Notificacao as Notificacao");
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
	
	public static java.util.Iterator iterateNotificacaoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Notificacao as Notificacao");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Notificacao", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacao createNotificacao() {
		return new main.Notificacao();
	}
	
	public static boolean save(main.Notificacao notificacao) throws PersistentException {
		try {
			tickeatPersistentManager.instance().saveObject(notificacao);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(main.Notificacao notificacao) throws PersistentException {
		try {
			tickeatPersistentManager.instance().deleteObject(notificacao);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(main.Notificacao notificacao) throws PersistentException {
		try {
			tickeatPersistentManager.instance().getSession().refresh(notificacao);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(main.Notificacao notificacao) throws PersistentException {
		try {
			tickeatPersistentManager.instance().getSession().evict(notificacao);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacao loadNotificacaoByCriteria(NotificacaoCriteria notificacaoCriteria) {
		Notificacao[] notificacaos = listNotificacaoByCriteria(notificacaoCriteria);
		if(notificacaos == null || notificacaos.length == 0) {
			return null;
		}
		return notificacaos[0];
	}
	
	public static Notificacao[] listNotificacaoByCriteria(NotificacaoCriteria notificacaoCriteria) {
		return notificacaoCriteria.listNotificacao();
	}
}
