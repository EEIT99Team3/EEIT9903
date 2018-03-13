package model.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory = createSessionFactory();
	private static SessionFactory createSessionFactory() {
		try {
			StandardServiceRegistry serviceRegistry =
					new StandardServiceRegistryBuilder().configure("hibernate/hibernate.cfg.xml").build();
			return new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void closeSessionFactory() {
		if(sessionFactory!=null) {
			sessionFactory.close();
		}
	}
}
