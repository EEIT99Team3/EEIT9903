package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.simple.JSONValue;

public class TrackMyFavoriteDAO_JDBC {
	
	public String TrackMyFavorite(String account) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Context ctx = null;
		DataSource dataSource = null;

		String query = " select TRACKING.stock_id,PRICE.price_open" + 
				"  from ( TRACKING INNER JOIN PRICE on TRACKING.stock_id = PRICE.stock_id )" + 
				"  where TRACKING.m_account ="+"'"+ account+"'" +" AND price_date = (select MAX(price_date) from PRICE)" + 
				"  order by price_date desc";
		
		// System.out.println(query);
		
		try {
			ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/Project1");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(query);

			rs = stmt.executeQuery();

			LinkedList<HashMap<String, String>> l1 = new LinkedList<HashMap<String, String>>();
			while (rs.next()) {
				HashMap<String, String> m1 = new HashMap<String, String>();
				m1.put("stock_id", rs.getString(1));
				m1.put("stock_price", rs.getString(2));
				l1.add(m1);
			}
			 String jsonString = JSONValue.toJSONString(l1);
			return jsonString;
		} catch (SQLException e) {
			return "Error:" + e.getMessage();	
		//	out.println("Error:" + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se2) {
			}
		}
	}

}
