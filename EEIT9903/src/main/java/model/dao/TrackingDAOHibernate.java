package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Tracking;
import model.TrackingDAO;
import model.TrackingId;

@Repository
public class TrackingDAOHibernate implements TrackingDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TrackingDAO#select(java.lang.String)
	 */
	@Override
	public List<Tracking> select(String account){
		String hql = "from Tracking where m_account = '"+ account + "'";
		System.out.println(hql);
		Query<Tracking> query = this.getSession().createQuery(hql,Tracking.class);
		return query.list();
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TrackingDAO#delete(model.TrackingId)
	 */
	@Override
	public int delete(TrackingId trackingId) {
		Tracking bean = this.getSession().get(Tracking.class, trackingId);
		if(bean != null) {
			this.getSession().delete(bean);
			return 1; 
		}
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TrackingDAO#insert(model.Tracking)
	 */
	@Override
	public Tracking insert(Tracking tracking){
		Tracking temp = this.getSession().get(Tracking.class, tracking.getId());
		if(temp == null) {
			System.out.println(temp);
			this.getSession().save(tracking);
		}
		return tracking;
	}
}
