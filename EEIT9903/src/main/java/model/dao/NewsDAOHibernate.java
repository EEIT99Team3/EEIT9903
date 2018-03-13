package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.NewsBean;
import model.NewsDAO;

@Repository
public class NewsDAOHibernate implements NewsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<NewsBean> select(String stock_id) {
		Query<NewsBean> query = this.getSession().createQuery("from NewsBean where stock_id = :stock_id", NewsBean.class);
		query.setParameter("stock_id", stock_id);
		return query.list();
	}

	@Override
	public NewsBean insert(NewsBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			this.getSession().flush();
			this.getSession().clear();
			return bean;
		}
		return null;
	}
}
