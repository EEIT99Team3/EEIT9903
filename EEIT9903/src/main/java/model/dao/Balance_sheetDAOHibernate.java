package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	public Balance_sheetBean select(Balance_sheetPK pk) {
		return this.getSession().get(Balance_sheetBean.class, pk);
	}


	public List<Balance_sheetBean> select(Integer ratyear, Integer ratseason) {
		Query<Balance_sheetBean> query = this.getSession().createQuery(
				"FROM Balance_sheetBean where bs_year = :year AND bs_season = :season", Balance_sheetBean.class);
		query.setParameter("year", ratyear);
		query.setParameter("season", ratseason);
		return query.list();
	}
}
