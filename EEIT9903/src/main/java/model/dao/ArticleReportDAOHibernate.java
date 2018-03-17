package model.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.ArticleReportBean;
@Repository
public class ArticleReportDAOHibernate {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public ArticleReportBean select() {
		
		return new ArticleReportBean();
	}
	
	public boolean insertReport(ArticleReportBean bean) {
		 Date date = new Date();	
		if (bean != null) {
			bean.setReport_date(date);
			this.getSession().save(bean);
			return true;
		}

		return false;
	}
}
