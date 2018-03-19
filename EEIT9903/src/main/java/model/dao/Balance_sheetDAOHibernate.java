package model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Balance_sheetBean;
import model.Balance_sheetDAO;
import model.Balance_sheetPK;

@Repository
public class Balance_sheetDAOHibernate implements Balance_sheetDAO {

	@Autowired
	private SessionFactory sessionFactory;
//	public Balance_sheetBeanDAOHibernate(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	@Transactional
	public Balance_sheetBean insert(Balance_sheetBean bean) {
		if(bean!=null) {
			Balance_sheetBean temp =
					this.getSession().get(Balance_sheetBean.class, bean.getBalance_sheetPK());
			if(temp==null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
	
	@Override
	@Transactional
	public Balance_sheetBean select(Balance_sheetPK pk) {
		return this.getSession().get(Balance_sheetBean.class, pk);
	}

}
