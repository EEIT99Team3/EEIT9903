package model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.ArticleBean;
import model.ArticleDAO;
@Service
public class ArticleServise {
	@Autowired
	private ArticleDAO dao = null;
	public ArticleServise() {
		
	}
	
	public ArticleBean select(int article_number) {
		ArticleBean result = null;
		if(article_number >= 0) {
			result = dao.select(article_number);
			
		}
		return result;
		
	}
	
	public List<HashMap<String,String>> select(){
		List<HashMap<String,String>> result = null ;
		try {
			result = dao.select();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public boolean insert(ArticleBean bean) {
		boolean result = false;
		if(bean	!=null) {
			try {
				if(result = dao.insert(bean));
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public boolean update(ArticleBean bean) {
		
		if(bean != null) {
			dao.articleupdate(bean.getArticle_number(),bean.getArticle_title(),bean.getArticle());
			return true;
		}
		return false;
	}
	
	public boolean delete(ArticleBean bean) {
		boolean result = false;
		if(bean !=null) {
			try {
				
				if(result = dao.delete(bean.getArticle_number())) {
					return result;
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}

		return result;
	}
}
