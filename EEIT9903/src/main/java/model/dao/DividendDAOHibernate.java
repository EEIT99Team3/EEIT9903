package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.DividendBean;
import model.DividendDAO;

@Repository
public class DividendDAOHibernate implements DividendDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<DividendBean> select(String stock_id) {
		Query<DividendBean> query = this.getSession().createQuery("from DividendBean where stock_id = :stock_id", DividendBean.class);
		query.setParameter("stock_id", stock_id);
		return query.list();
	}
	
	@Override
	public DividendBean insert(DividendBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			this.getSession().flush();
			this.getSession().clear();
			return bean;
		}
		return null;
	}
}
