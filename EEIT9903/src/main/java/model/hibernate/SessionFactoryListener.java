package model.hibernate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;

@WebListener
public class SessionFactoryListener implements ServletContextListener {
	private SessionFactory sessionFactory;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Create SessionFactory");
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("Close SessionFactory");
		if(sessionFactory!=null) {
			sessionFactory.close();
		}
	}
}
