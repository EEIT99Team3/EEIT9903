package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.ArticleBean;
import model.ArticleReportBean;
import model.Member;
import model.service.ArticleReportService;
import model.service.ArticleServise;

@Controller
public class ArticleReportController {
	@Autowired
	private ArticleReportService articleReportService;
	@Autowired
	private ArticleServise articleServise;
	@RequestMapping(
			path="/pages/check/report.article",
			method= {RequestMethod.GET,RequestMethod.POST}
			)
	public String report(String article_number,String m_account,String type_of_report
			,String report_content,ArticleReportBean bean,String prodaction,HttpSession session,String article_title) { 
		Member member = (Member) session.getAttribute("user");
		
		bean.setArticle_number(Integer.parseInt(article_number));
		bean.setM_account(m_account);
		bean.setType_of_report(type_of_report);
		bean.setReport_content(report_content);
	    bean.setArticle_title(article_title);
		
		
		if("insertReport".equals(prodaction)) {
			boolean insertResult = articleReportService.insertReport(bean);
			if(insertResult) {
				return "articleshow.do";
			}
		}
		
		return "";
	}
	@RequestMapping(
			path="/pages/backendcheck/reportshow.article",
			method= {RequestMethod.GET,RequestMethod.POST},
			produces="application/json;charset=UTF-8"
			)
	public @ResponseBody String reportshow() {
		
		List<HashMap<String, String>> result = new LinkedList<HashMap<String, String>>();
		result = articleReportService.select();
		if (result != null) {
			String jsonString = JSONValue.toJSONString(result);
			return jsonString; 
		}
	
		return "";
	}
	@RequestMapping(
			path="/pages/check/processreport.article",
			method= {RequestMethod.GET,RequestMethod.POST}
			)
	public String processreport(String article_number,ArticleBean bean,String prodaction) {
		bean.setArticle_number(Integer.parseInt(article_number));
		boolean deleteresult = articleServise.delete(bean);
	    boolean updateresult = articleReportService.changeprocess(Integer.parseInt(article_number));
		return "changeprocess.do";
	}
	
	@RequestMapping(
			path="/pages/check/processreportok.article",
			method= {RequestMethod.GET,RequestMethod.POST}
			)
	public String processreportok(String article_number,ArticleBean bean,String prodaction) {
		bean.setArticle_number(Integer.parseInt(article_number));
		
	    boolean updateresult = articleReportService.changeprocess(Integer.parseInt(article_number));
		return "changeprocess.do";
	}
	
}
