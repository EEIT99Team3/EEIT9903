package model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Income_statementBean;
import model.Income_statementDAO;
import model.Income_statementPK;
@Repository
public class Income_statementDAOHibernate implements Income_statementDAO {

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
	public Income_statementBean select(Income_statementPK pk) {
		return this.getSession().get(Income_statementBean.class, pk);
	}
}
