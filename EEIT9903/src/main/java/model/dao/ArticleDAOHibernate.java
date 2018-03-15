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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	private SimpleDateFormat sdf;
	public ArticleDAOHibernate() {
		sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");	
	}
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public ArticleBean select(int article_number) {
		
		return this.getSession().get(ArticleBean.class, article_number);
	}
	
	
	@Override
	public LinkedList<HashMap<String,String>> select() throws SQLException {
		
		
		Connection conn = dataSource.getConnection();
		PreparedStatement pstm = conn.prepareStatement(SELECT_ALL);
		ResultSet rs =  pstm.executeQuery();
	
	
		LinkedList<HashMap<String,String>> l1 = new LinkedList<HashMap<String,String>>();
		
		while (rs.next()) {
			HashMap<String, String> m1 = new HashMap<>();
			m1.put("m_account",rs.getString(1));
			m1.put("article_date",rs.getString(2));
			m1.put("article_number",rs.getString(3));
			m1.put("article_title",rs.getString(4));
			m1.put("article",rs.getString(5));
			l1.add(m1);
		}
	
		
		if(rs!=null)
		rs.close();
		if(pstm!=null)
		pstm.close();
		if(conn!=null)
		conn.close();
		
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
		
		ArticleBean bean = this.getSession().get(ArticleBean.class, article_number);
		if(bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		
		return false;
	}
}
