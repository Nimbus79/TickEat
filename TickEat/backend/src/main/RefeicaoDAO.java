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

public class RefeicaoDAO {
	public static Refeicao loadRefeicaoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadRefeicaoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Refeicao getRefeicaoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return getRefeicaoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Refeicao loadRefeicaoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadRefeicaoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Refeicao getRefeicaoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return getRefeicaoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Refeicao loadRefeicaoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Refeicao) session.load(main.Refeicao.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Refeicao getRefeicaoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Refeicao) session.get(main.Refeicao.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Refeicao loadRefeicaoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Refeicao) session.load(main.Refeicao.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Refeicao getRefeicaoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Refeicao) session.get(main.Refeicao.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRefeicao(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return queryRefeicao(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRefeicao(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return queryRefeicao(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Refeicao[] listRefeicaoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return listRefeicaoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Refeicao[] listRefeicaoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return listRefeicaoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRefeicao(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Refeicao as Refeicao");
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
	
	public static List queryRefeicao(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Refeicao as Refeicao");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Refeicao", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Refeicao[] listRefeicaoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryRefeicao(session, condition, orderBy);
			return (Refeicao[]) list.toArray(new Refeicao[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Refeicao[] listRefeicaoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryRefeicao(session, condition, orderBy, lockMode);
			return (Refeicao[]) list.toArray(new Refeicao[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Refeicao loadRefeicaoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadRefeicaoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Refeicao loadRefeicaoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return loadRefeicaoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Refeicao loadRefeicaoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Refeicao[] refeicaos = listRefeicaoByQuery(session, condition, orderBy);
		if (refeicaos != null && refeicaos.length > 0)
			return refeicaos[0];
		else
			return null;
	}
	
	public static Refeicao loadRefeicaoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Refeicao[] refeicaos = listRefeicaoByQuery(session, condition, orderBy, lockMode);
		if (refeicaos != null && refeicaos.length > 0)
			return refeicaos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRefeicaoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return iterateRefeicaoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRefeicaoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = tickeatPersistentManager.instance().getSession();
			return iterateRefeicaoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRefeicaoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Refeicao as Refeicao");
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
	
	public static java.util.Iterator iterateRefeicaoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Refeicao as Refeicao");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Refeicao", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Refeicao createRefeicao() {
		return new main.Refeicao();
	}
	
	public static boolean save(main.Refeicao refeicao) throws PersistentException {
		try {
			tickeatPersistentManager.instance().saveObject(refeicao);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(main.Refeicao refeicao) throws PersistentException {
		try {
			tickeatPersistentManager.instance().deleteObject(refeicao);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(main.Refeicao refeicao) throws PersistentException {
		try {
			tickeatPersistentManager.instance().getSession().refresh(refeicao);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(main.Refeicao refeicao) throws PersistentException {
		try {
			tickeatPersistentManager.instance().getSession().evict(refeicao);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Refeicao loadRefeicaoByCriteria(RefeicaoCriteria refeicaoCriteria) {
		Refeicao[] refeicaos = listRefeicaoByCriteria(refeicaoCriteria);
		if(refeicaos == null || refeicaos.length == 0) {
			return null;
		}
		return refeicaos[0];
	}
	
	public static Refeicao[] listRefeicaoByCriteria(RefeicaoCriteria refeicaoCriteria) {
		return refeicaoCriteria.listRefeicao();
	}
}
