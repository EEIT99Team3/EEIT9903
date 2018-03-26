package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
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
	public LinkedList<HashMap<String, String>> select(Integer article_number) throws SQLException  {

		LinkedList<HashMap<String, String>> l1 = new LinkedList<HashMap<String, String>>();
		ResultSet rs = null;
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstm = conn.prepareStatement(SELECT);
			){
			pstm.setInt(1, article_number);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				NativeQuery<String> mName = this.getSession().createNativeQuery("select m_name from MEMBER where m_account=?");
				mName.setParameter(1, rs.getString("m_account"));
				String result2 = mName.uniqueResult();
				HashMap<String, String> m1 = new HashMap<>();
				m1.put("article_number", rs.getString("article_number"));
				m1.put("reply", rs.getString("reply"));
				m1.put("reply_date", rs.getString("reply_date"));
				m1.put("m_account", rs.getString("m_account"));
				m1.put("m_name", result2);
				l1.add(m1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				rs.close();
			}
		}
		

		
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
	



	public boolean delete(int article_number) {
		
		this.getSession().delete(article_number);
				
		return true;
	
	}

}
