package model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Cash_flow_statementBean;
import model.Cash_flow_statementDAO;
import model.Cash_flow_statementPK;

@Repository
public class Cash_flow_statementDAOHibernate implements Cash_flow_statementDAO {

	@Autowired
	private SessionFactory sessionFactory;
//	public Income_statementBeanDAOHibernate(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.Cash_flow_statementBeanDAO#insert(model.Cash_flow_statementBean)
	 */
	@Override
	public Cash_flow_statementBean insert(Cash_flow_statementBean bean) {
		if(bean!=null) {
			Cash_flow_statementBean temp =
					this.getSession().get(Cash_flow_statementBean.class, bean.getCash_flow_statementPK());
			if(temp==null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.Cash_flow_statementBeanDAO#select(model.Cash_flow_statementPK)
	 */
	@Override
	public Cash_flow_statementBean select(Cash_flow_statementPK pk) {
		return this.getSession().get(Cash_flow_statementBean.class, pk);
	}
	
}
