package model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

import org.hibernate.Session;

public interface ArticleDAO {

	Session getSession();

	ArticleBean select(Integer article_number);

	String SELECT_ALL = "select * from article";

	LinkedList<HashMap<String, String>> select() throws SQLException;

	boolean insert(ArticleBean bean) throws SQLException;

	boolean delete(int article_number) throws SQLException;
	
	boolean articleupdate(Integer integer,String title,String article);
}