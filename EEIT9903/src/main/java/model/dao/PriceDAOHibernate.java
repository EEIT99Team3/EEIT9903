package model.dao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.Price;
import model.PriceId;

@Repository
public class PriceDAOHibernate implements PriceDAO  {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
//	private SessionFactory factory=null;
//	private Session session = null;
//	
//	public PriceDAOHibernate(SessionFactory factory) {
//		this.factory = factory;
//	}
//
//	public Session getSession() {
//		return factory.getCurrentSession();
//	}
	

	public SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-DD");

	// 前端只要想辦法把查詢條件包成{"欄位","運算子","條件值",....}三個三個一組的格式丟進來即可
	// String[] statement = { "stock_id", "=", "'2330'", "price_date", "<",
	// "'2017-01-10'" };
	String[] statement = { "stock_id", "=", "0050" };

	public String generateStatement(String... fragment) {

		StringBuilder statement = new StringBuilder("from Price where 1=1");
		for (int i = 0; i < fragment.length; i++) {
			if (i % 3 == 0) {
				statement.append(" AND ");
				statement.append(fragment[i]);
			} else {
				statement.append(fragment[i]);
				statement.append(" ");
			}
		}
		System.out.println(statement.toString());
		return statement.toString();
	}

	/* (non-Javadoc)
	 * @see model.dao.PriceDAO#select(java.lang.String)
	 */
	@Override
	public List<Price> select(String stockId) {
		String hql = "from Price where 1=1 AND stock_id = " + "'" + stockId + "'";
		System.out.println(hql);
		Query<Price> query = this.getSession().createQuery(hql, Price.class);
		return query.list();
	}

	/* (non-Javadoc)
	 * @see model.dao.PriceDAO#select()
	 */
	@Override
	public List<Price> select() {
		Query<Price> query = this.getSession().createQuery(generateStatement(statement), Price.class);
		// System.out.println(query);
		return query.list();
	}

	/* (non-Javadoc)
	 * @see model.dao.PriceDAO#insert(model.Price)
	 */
	@Override
	public Price insert(Price bean) {
		Price temp = this.getSession().get(Price.class, bean.getId());
		if (temp == null) {
			System.out.println(temp);
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see model.dao.PriceDAO#update(model.PriceId, java.math.BigDecimal, java.math.BigDecimal, java.math.BigDecimal, java.math.BigDecimal, java.lang.Long, java.math.BigDecimal, java.math.BigDecimal)
	 */
	@Override
	public Price update(PriceId id, BigDecimal priceOpen, BigDecimal priceClose, BigDecimal priceHighest,
			BigDecimal priceLowest, Long volume, BigDecimal peRatio, BigDecimal yieldRate) {
		Price result = this.getSession().get(Price.class, id);
		if (result != null) {
			result.setPeRatio(peRatio);
			// result.setYieldRate(yieldRate);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see model.dao.PriceDAO#delete(model.PriceId)
	 */
	@Override
	public int delete(PriceId id) {
		Price bean = this.getSession().get(Price.class, id);
		if (bean != null) {
			this.getSession().delete(bean);
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

		sessionFactory.getCurrentSession().beginTransaction();

		try {
			PriceDAO priceDao = (PriceDAO) context.getBean("priceDAOHibernate");
			List<Price> bean = priceDao.select();
			System.out.println(bean);
			sessionFactory.getCurrentSession().getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			sessionFactory.getCurrentSession().getTransaction().rollback();
		} finally {
			sessionFactory.getCurrentSession().close();
			((ConfigurableApplicationContext) context).close();
		}

	}
}
