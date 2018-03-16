package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.ArticleBean;
import model.service.ArticleServise;

@Controller
public class ArticleEditorController {
	@Autowired
	private ArticleServise articleServise;
	
	
	@InitBinder
	public void initializer(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		dateFormat.setLenient(false); 
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	@RequestMapping(
			path="/pages/article.article",
			method= {RequestMethod.GET,RequestMethod.POST})
	public String method(String title,String content,
			String articleAccount,String prodaction,ArticleBean bean,String article_number,Model model,HttpSession session,HttpServletResponse response) {
		
		bean.setArticle_title(title);
		bean.setArticle(content);
		bean.setM_account("aaa");
		if(article_number != null) {
		bean.setArticle_number(Integer.parseInt(article_number));
		}
		
		if("articleDelete".equals(prodaction)) {
	    	boolean deleteresult = articleServise.delete(bean);
	    	if(deleteresult) {
	    		return "deletesuccess.do";
	    	}
	    }
		
		if(bean.getArticle_number()!=null && !"articleDelete".equals(prodaction) && !"articleEdit".equals(prodaction) && !"articleEditok".equals(prodaction)) {
			
			bean = articleServise.select(Integer.parseInt(article_number));
	
			session.setAttribute("articleDate", bean.getArticle_date());	
			session.setAttribute("article", bean.getArticle());
			session.setAttribute("M_account", bean.getM_account());
			session.setAttribute("article_title", bean.getArticle_title());
			session.setAttribute("article_number", bean.getArticle_number());
			return "articleshow.do";
		}
		
		if("articlepost".equals(prodaction)) {
			session.setAttribute("article", "");
			session.setAttribute("article_title", "");
			return "ckeditor.do";
		}
		if("articleEdit".equals(prodaction)) {
			bean = articleServise.select(Integer.parseInt(article_number));
			
			model.addAttribute("article", bean.getArticle());
			model.addAttribute("article_title", bean.getArticle_title());
			return "ckeditor.do";
		}
		if("articleEditok".equals(prodaction)) {
			
			boolean updateresult = articleServise.update(bean);
			if(updateresult) {
				return "article.do";
			}
		}
	
		if ("submitOk".equals(prodaction)) {
			boolean insertresult = articleServise.insert(bean);
			if (insertresult) {
				return "article.do";
			}
		}
		if ("submitcancle".equals(prodaction)) {
			
			return "article.do"; 
		}else {
			return "article.do"; 
		}
		
	}

	@RequestMapping(
			path= {"/pages/articleshow.article"},
			method= {RequestMethod.GET,RequestMethod.POST},
			produces = "application/json;charset=UTF-8"
			)
	public @ResponseBody String Articleshow() {
		
			List<HashMap<String, String>> result = new LinkedList<HashMap<String, String>>();
			result = articleServise.select();
			if (result != null) {
				String jsonString = JSONValue.toJSONString(result);
				return jsonString;
			}

		return "";
	}
}
