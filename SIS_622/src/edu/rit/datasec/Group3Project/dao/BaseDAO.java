package edu.rit.datasec.Group3Project.dao;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.rit.datasec.Group3Project.bo.Address;
import edu.rit.datasec.Group3Project.hibernate.util.HibernateUtil;

/**
 * 
 * @author Base data access layer.
 *
 */
public class BaseDAO {
	private static BaseDAO dao;
	private SessionFactory sessionFactory;

	private BaseDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public static BaseDAO getInstance() {
		if (dao == null) {
			dao = new BaseDAO();
		}
		return dao;
	}

	public <T> void addAll(Collection<T> list) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int cnt = 0;
		tx = session.beginTransaction();
		try {
			for (T t : list) {
				try {
					session.saveOrUpdate(t);
				} catch (NonUniqueObjectException | IllegalArgumentException e) {
					continue;
				}
				cnt++;
				if (cnt % 100 == 0) {
					System.out.println(t.getClass() + " flush: " + ((float) cnt / (float) list.size()));
					session.flush();
				}
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw new RuntimeException(e);
		} finally {
			session.flush();
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz, Serializable id) {
		Session session = sessionFactory.openSession();
		try {
			return (T) session.get(clazz, id);
		} finally {
			session.close();
		}

	}

	public void saveOrUpdate(Object obj) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(obj);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.flush();
			session.close();
		}
	}

	public static void main(String[] args) {
		Address a = BaseDAO.getInstance().get(Address.class, 1);
		a.setLine2("123333");
		Session session = getInstance().sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.update(a);
		tx.commit();
		session.close();
	}

}
