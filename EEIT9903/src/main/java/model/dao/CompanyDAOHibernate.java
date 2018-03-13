package model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.CompanyBean;
import model.CompanyDAO;

@Repository
public class CompanyDAOHibernate implements CompanyDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public CompanyBean select(String stock_id) {
		return this.getSession().get(CompanyBean.class, stock_id);
	}

	@Override
	public CompanyBean insert(CompanyBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}
}
