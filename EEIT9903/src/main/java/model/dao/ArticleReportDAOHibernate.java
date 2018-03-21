package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.ArticleReportBean;
@Repository
public class ArticleReportDAOHibernate {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private DataSource dataSource;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Transactional
	public LinkedList<HashMap<String,String>> select() {
		LinkedList<HashMap<String,String>> l1 = new LinkedList<>();
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstm = conn.prepareStatement("select * from report");
				ResultSet rs = pstm.executeQuery();){
					while (rs.next()) {
						HashMap<String, String> m1 = new HashMap<>();
						m1.put("article_number", rs.getString(2));
						m1.put("m_account",rs.getString(3));
						m1.put("type_of_report",rs.getString(4));
						m1.put("report_content",rs.getString(5));
						m1.put("report_date",rs.getString(6));
						m1.put("article_title",rs.getString(7));
						m1.put("processed", rs.getString(8));
						l1.add(m1);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
		return l1;
		
	}
	@Transactional
	public boolean insertReport(ArticleReportBean bean) {
		 Date date = new Date();	
		if (bean != null) {
			bean.setReport_date(date);
			this.getSession().save(bean);
			return true;
		}

		return false;
	}
	@Transactional
	public boolean changeprocess(Integer article_number) {
		
		NativeQuery query = this.getSession().createNativeQuery(" update report set processed = 1 where article_number = "+article_number);
		query.executeUpdate();
		
		return true;
	}
	
	
}
