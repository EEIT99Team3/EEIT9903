package model.dao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Ratio;
import model.RatioId;

@Repository
public class RatioDAOHibernate {
	@Autowired
	private SessionFactory sessionFactory;

	public String[] statement = null;

	public String[] getStatement() {
		return statement;
	}

	public void setStatement(String[] statement) {
		this.statement = statement;
	}

	public String generateStatement(String... fragment) {

		StringBuilder statement = new StringBuilder("from Ratio where 1=1");
		if (fragment != null) {
			for (int i = 0; i < fragment.length; i++) {
				if (i % 3 == 0) {
					statement.append(" AND ");
					statement.append(fragment[i]);
				} else {
					statement.append(fragment[i]);
					statement.append(" ");
				}
			}
		}
		return statement.toString();
	}

	public SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-DD");

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Ratio select(RatioId id) {
		return this.getSession().get(Ratio.class, id);
	}

	public List<Ratio> select() {
		Query<Ratio> query = this.getSession().createQuery(generateStatement(statement), Ratio.class);
		return query.list();
	}

	public Ratio insert(Ratio bean) {
		Ratio temp = this.getSession().get(Ratio.class, bean.getId());
		if (temp == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	public Ratio update(RatioId id, BigDecimal eps, BigDecimal bvps, BigDecimal gpMargin, BigDecimal opMargin,
			BigDecimal niMargin, BigDecimal roe, BigDecimal roa, BigDecimal arTurnover, BigDecimal invTurnover,
			BigDecimal apTurnover, BigDecimal debtRatio, BigDecimal currentRatio, BigDecimal fcfGrowth,
			BigDecimal ocfGrowth, BigDecimal revenuesGrowth) {
		Ratio result = this.getSession().get(Ratio.class, id);
		if (result != null) {
			result.setEps(eps);
			result.setGpMargin( bvps); 
			result.setGpMargin( gpMargin); 
			result.setGpMargin( opMargin); 
			result.setGpMargin( niMargin); 
			result.setGpMargin( roe); 
			result.setGpMargin( roa); 
			result.setGpMargin( arTurnover); 
			result.setGpMargin( invTurnover); 
			result.setGpMargin( apTurnover); 
			result.setGpMargin( debtRatio); 
			result.setGpMargin( currentRatio); 
			result.setGpMargin( fcfGrowth); 
			result.setGpMargin( ocfGrowth); 
			result.setGpMargin( revenuesGrowth);  

		}
		return result;
	}

	public int delete(RatioId id) {
		Ratio bean = this.getSession().get(Ratio.class, id);
		if (bean != null) {
			this.getSession().delete(bean);
			return 1;
		}
		return 0;
	}


}
