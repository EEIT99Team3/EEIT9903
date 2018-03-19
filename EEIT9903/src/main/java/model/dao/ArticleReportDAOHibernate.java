package model.dao;

import java.util.Date;

import javax.transaction.Transactional;

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
	@Transactional
	public ArticleReportBean select() {
		
		return new ArticleReportBean();
	}
	@Transactional
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
