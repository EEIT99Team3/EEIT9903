package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.ArticleReplyBean;
import model.ArticleReplyDAO;

@Repository
public class ArticleReplyDAOHibernate implements ArticleReplyDAO {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SessionFactory sessionFactory;
	

	public ArticleReplyDAOHibernate() {
	
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public Integer select() {
		
		return  ((Integer)getSession().createQuery("select count(*) from REPLY").uniqueResult()).intValue();
	
		
	}
	
	@Override
	public LinkedList<HashMap<String, String>> select(Integer article_number) throws SQLException {

		Connection conn = dataSource.getConnection();
		PreparedStatement pstm = conn.prepareStatement(SELECT);
		pstm.setInt(1, article_number);
		ResultSet rs = pstm.executeQuery();

		LinkedList<HashMap<String, String>> l1 = new LinkedList<HashMap<String, String>>();

		while (rs.next()) {
			HashMap<String, String> m1 = new HashMap<>();
			m1.put("article_number", rs.getString(1));
			m1.put("reply", rs.getString(2));
			m1.put("reply_date", rs.getString(3));
			m1.put("m_account", rs.getString(4));
			l1.add(m1);
		}
		if (rs != null)
			rs.close();
		if (pstm != null)
			pstm.close();
		if (conn != null)
			conn.close();
		return l1;
	}
	
	
	@Override
	public boolean insert(ArticleReplyBean bean) {
		if(bean != null) {
		Date date = new Date();	
		 bean.setReply_date(date);;
		 this.getSession().save(bean);
		 return true;
		}
		
		return false;
	}

}
