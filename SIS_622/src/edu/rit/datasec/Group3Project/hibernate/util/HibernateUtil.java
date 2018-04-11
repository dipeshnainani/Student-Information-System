package edu.rit.datasec.Group3Project.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Provides hibernate sessions
 * 
 * @author HARSH_KHANDHADIA
 *
 */
public class HibernateUtil {
	private static SessionFactory SESSION_FACTORY;

	private static SessionFactory initiateSessionFactory() {

		Configuration config = new Configuration();
		config = config.configure("hibernate.cfg.xml");
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		return config.buildSessionFactory(registry);

	}

	public static SessionFactory getSessionFactory() {
		if (SESSION_FACTORY == null)
			SESSION_FACTORY = initiateSessionFactory();
		return SESSION_FACTORY;
	}
	

}