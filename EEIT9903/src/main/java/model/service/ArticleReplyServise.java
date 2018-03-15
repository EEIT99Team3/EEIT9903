package model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.ArticleReplyBean;
import model.ArticleReplyDAO;
@Service
public class ArticleReplyServise {
	@Autowired
	private ArticleReplyDAO dao = null;
	public ArticleReplyServise() {
	
	}
	
	public List<HashMap<String,String>> select(Integer article_number) {
		List<HashMap<String,String>> result =  null;
		if(article_number !=null) {
			try {
				result = dao.select(article_number);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public boolean insert(ArticleReplyBean bean) {
		
		if(bean != null) {
			if(dao.insert(bean));
			return true;
		}
	
		
		return false;
	}
}
