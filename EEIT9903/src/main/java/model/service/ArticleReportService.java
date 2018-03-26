package model.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.ArticleReportBean;
import model.dao.ArticleReportDAOHibernate;
@Service
@Transactional
public class ArticleReportService {
	@Autowired
	public ArticleReportDAOHibernate dao;

	public boolean insertReport(ArticleReportBean bean) {
		boolean result = false;
		if (bean != null) {
			if (result = dao.insertReport(bean));
			return result;
		}
		return result;
	}
	public List<HashMap<String,String>> select(){
		return dao.select();
	}
	
	public boolean changeprocess(Integer article_number) {
		return dao.changeprocess(article_number);
	}
	
	
}
