package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.SupervisorBean;
import model.SupervisorDAO;
@Repository
public class SupervisorDAOHibernate implements SupervisorDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.SupervisorDAO#insert(model.SupervisorBean)
	 */
	@Override
	@Transactional
	public SupervisorBean insert(SupervisorBean bean) {
		if(bean!=null) {
			SupervisorBean temp = this.getSession().get(SupervisorBean.class, bean.getS_account());
			if(temp==null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.SupervisorDAO#delete(java.lang.String)
	 */
	@Override
	@Transactional
	public Boolean delete(String s_account) {
		SupervisorBean temp = this.getSession().get(SupervisorBean.class, s_account);
		if(temp!=null) {
			this.getSession().delete(temp);
			return true;
		}		
		return false;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.SupervisorDAO#select(java.lang.String)
	 */
	@Override
	@Transactional
	public SupervisorBean select(String s_account) {
		return this.getSession().get(SupervisorBean.class, s_account);
	}
	
	/* (non-Javadoc)
	 * @see model.dao.SupervisorDAO#select()
	 */
	@Override
	@Transactional
	public List<SupervisorBean> select() {
		return this.getSession().createQuery("from SupervisorBean", SupervisorBean.class).list();
	}

}
