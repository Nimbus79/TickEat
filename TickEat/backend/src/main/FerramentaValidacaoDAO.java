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

public class FerramentaValidacaoDAO {
	public static FerramentaValidacao loadFerramentaValidacaoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadFerramentaValidacaoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaValidacao getFerramentaValidacaoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return getFerramentaValidacaoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaValidacao loadFerramentaValidacaoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadFerramentaValidacaoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaValidacao getFerramentaValidacaoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return getFerramentaValidacaoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaValidacao loadFerramentaValidacaoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (FerramentaValidacao) session.load(main.FerramentaValidacao.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaValidacao getFerramentaValidacaoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (FerramentaValidacao) session.get(main.FerramentaValidacao.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaValidacao loadFerramentaValidacaoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (FerramentaValidacao) session.load(main.FerramentaValidacao.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaValidacao getFerramentaValidacaoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (FerramentaValidacao) session.get(main.FerramentaValidacao.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFerramentaValidacao(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return queryFerramentaValidacao(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFerramentaValidacao(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return queryFerramentaValidacao(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaValidacao[] listFerramentaValidacaoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return listFerramentaValidacaoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaValidacao[] listFerramentaValidacaoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return listFerramentaValidacaoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFerramentaValidacao(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.FerramentaValidacao as FerramentaValidacao");
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
	
	public static List queryFerramentaValidacao(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.FerramentaValidacao as FerramentaValidacao");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("FerramentaValidacao", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaValidacao[] listFerramentaValidacaoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryFerramentaValidacao(session, condition, orderBy);
			return (FerramentaValidacao[]) list.toArray(new FerramentaValidacao[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaValidacao[] listFerramentaValidacaoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryFerramentaValidacao(session, condition, orderBy, lockMode);
			return (FerramentaValidacao[]) list.toArray(new FerramentaValidacao[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaValidacao loadFerramentaValidacaoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadFerramentaValidacaoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaValidacao loadFerramentaValidacaoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadFerramentaValidacaoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaValidacao loadFerramentaValidacaoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		FerramentaValidacao[] ferramentaValidacaos = listFerramentaValidacaoByQuery(session, condition, orderBy);
		if (ferramentaValidacaos != null && ferramentaValidacaos.length > 0)
			return ferramentaValidacaos[0];
		else
			return null;
	}
	
	public static FerramentaValidacao loadFerramentaValidacaoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		FerramentaValidacao[] ferramentaValidacaos = listFerramentaValidacaoByQuery(session, condition, orderBy, lockMode);
		if (ferramentaValidacaos != null && ferramentaValidacaos.length > 0)
			return ferramentaValidacaos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateFerramentaValidacaoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return iterateFerramentaValidacaoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFerramentaValidacaoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return iterateFerramentaValidacaoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFerramentaValidacaoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.FerramentaValidacao as FerramentaValidacao");
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
	
	public static java.util.Iterator iterateFerramentaValidacaoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.FerramentaValidacao as FerramentaValidacao");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("FerramentaValidacao", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaValidacao createFerramentaValidacao() {
		return new main.FerramentaValidacao();
	}
	
	public static boolean save(main.FerramentaValidacao ferramentaValidacao) throws PersistentException {
		try {
			tickeatPersistentManager.instance().saveObject(ferramentaValidacao);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(main.FerramentaValidacao ferramentaValidacao) throws PersistentException {
		try {
			tickeatPersistentManager.instance().deleteObject(ferramentaValidacao);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(main.FerramentaValidacao ferramentaValidacao) throws PersistentException {
		try {
			tickeatPersistentManager.instance().getSession().refresh(ferramentaValidacao);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(main.FerramentaValidacao ferramentaValidacao) throws PersistentException {
		try {
			tickeatPersistentManager.instance().getSession().evict(ferramentaValidacao);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static FerramentaValidacao loadFerramentaValidacaoByCriteria(FerramentaValidacaoCriteria ferramentaValidacaoCriteria) {
		FerramentaValidacao[] ferramentaValidacaos = listFerramentaValidacaoByCriteria(ferramentaValidacaoCriteria);
		if(ferramentaValidacaos == null || ferramentaValidacaos.length == 0) {
			return null;
		}
		return ferramentaValidacaos[0];
	}
	
	public static FerramentaValidacao[] listFerramentaValidacaoByCriteria(FerramentaValidacaoCriteria ferramentaValidacaoCriteria) {
		return ferramentaValidacaoCriteria.listFerramentaValidacao();
	}
}
