package edu.rit.datasec.Group3Project.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.rit.datasec.Group3Project.bo.Credentials;
import edu.rit.datasec.Group3Project.bo.Role;
import edu.rit.datasec.Group3Project.hibernate.util.HibernateUtil;

public class CredentialsDAO {

	private static CredentialsDAO credentialsDAO;

	private SessionFactory sessionFactory;

	private CredentialsDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public static CredentialsDAO getInstance() {
		if (credentialsDAO == null) {
			credentialsDAO = new CredentialsDAO();
		}
		return credentialsDAO;
	}

	public Role getRole(String login) {
		String statement = "FROM Credentials c WHERE c.loginId = :login ";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(statement);
		query.setParameter("login", login);
		Credentials credentials = null;
		try {
			credentials = (Credentials) query.uniqueResult();
			return credentials.getRole();
		} finally {
			session.close();
		}
	}

	public String getPasswordHash(String login) {
		String statement = "FROM Credentials c WHERE c.loginId = :login ";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(statement);
		query.setParameter("login", login);
		Credentials credentials = null;
		try {
			credentials = (Credentials) query.uniqueResult();
			return credentials.getHash();
		} finally {
			session.close();
		}
	}

}
