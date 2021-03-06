package model.dao;


import java.sql.Blob;
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
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.ArticleBean;
import model.ArticleDAO;

//DAO 同時有Hibernate 及 DataSource兩種方式
//因select()方式取得的資料量比較大，考慮效能的情況下此方法仍用DataSource。
//(但其實是因為我不知道該如何用hibernate的方式把資料包成LinkedList<HashMap<String,String>> )


@Repository
public class ArticleDAOHibernate implements ArticleDAO {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SessionFactory sessionFactory ;
	
	
	
	public ArticleDAOHibernate() {
		 
	}
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	@Transactional
	public ArticleBean select(Integer article_number) {
		
		return this.getSession().get(ArticleBean.class, article_number);
	}

	@Override
	public LinkedList<HashMap<String,String>> select()  {
		
		
	

		LinkedList<HashMap<String,String>> l1 = null;
		try (Connection conn = dataSource.getConnection();
		PreparedStatement pstm = conn.prepareStatement(SELECT_ALL);
		ResultSet rs = pstm.executeQuery();){
			l1 = new LinkedList<HashMap<String,String>>();
			while (rs.next()) {
				HashMap<String, String> m1 = new HashMap<>();
				
				NativeQuery<Integer> replyCount = this.getSession().createNativeQuery("select count(*) from REPLY where article_number="+rs.getString("article_number"));
				NativeQuery<String> mName = this.getSession().createNativeQuery("select m_name from MEMBER where m_account=?");
				mName.setParameter(1, rs.getString("m_account"));
				Integer result = replyCount.uniqueResult();
				String result2 = mName.uniqueResult();
			
				m1.put("m_account",rs.getString("m_account"));
				m1.put("article_date",rs.getString("article_date"));
				m1.put("article_number",rs.getString("article_number"));
				m1.put("article_title",rs.getString("article_title"));
				m1.put("article",rs.getString("article"));
				m1.put("reply_count", Integer.toString(result));
				m1.put("m_name", result2);
				l1.add(m1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return l1;
	}


	@Override
	public boolean insert(ArticleBean bean) throws SQLException { 
		 Date date = new Date();	
		 if(bean !=null) {
			 bean.setArticle_date(date);
			 this.getSession().save(bean);
			 return true;
		 }
		 return false;
	}
	
	
	
	
	@Override
	public boolean delete(int article_number) throws SQLException {
		
		NativeQuery<Integer> query1 = this.getSession().createNativeQuery("delete from reply where article_number="+article_number);
		query1.executeUpdate();
		
		ArticleBean bean = this.getSession().get(ArticleBean.class, article_number);
		if(bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		
		return false;
	}
	@Override
	public boolean articleupdate(Integer article_number,String title,String article) {
		ArticleBean bean = this.getSession().get(ArticleBean.class, article_number);
		if(bean != null) {
			bean.setArticle(article);
			bean.setArticle_title(title);
			return true;
		}
		return false;
	}

}
