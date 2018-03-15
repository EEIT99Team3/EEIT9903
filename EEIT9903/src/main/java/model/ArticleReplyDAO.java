package model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

public interface ArticleReplyDAO {

	String SELECT = "select * from reply where article_number=?";

	LinkedList<HashMap<String, String>> select(Integer article_number) throws SQLException;

	boolean insert(ArticleReplyBean bean);

}