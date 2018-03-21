package model.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import model.Income_statementBean;
import model.Income_statementDAO;
import model.Income_statementPK;
import model.service.RatioService;

@Repository
public class Income_statementDAOHibernate implements Income_statementDAO {
	@Autowired
	RatioService service;
	@Autowired
	private SessionFactory sessionFactory;
//	public Income_statementBeanDAOHibernate(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.Income_statementDAO#insert(model.Income_StatementBean)
	 */
	@Override
	@Transactional
	public Income_statementBean insert(Income_statementBean bean) {
		if(bean!=null) {
			Income_statementBean temp =
					this.getSession().get(Income_statementBean.class, bean.getIncome_StatementPK());
			if(temp==null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.Income_statementDAO#select(int)
	 */
	@Override
	@Transactional
	public Income_statementBean select(Income_statementPK pk) {
		return this.getSession().get(Income_statementBean.class, pk);
	}
	
	@Transactional
	public List<Income_statementBean> select(Integer ratyear, Integer ratseason) {
		Query<Income_statementBean> query = this.getSession().createQuery(
				"FROM Income_statementBean where is_year = :year AND is_season = :season", Income_statementBean.class);
		query.setParameter("year", ratyear);
		query.setParameter("season", ratseason);
		return query.list();
	}
}
