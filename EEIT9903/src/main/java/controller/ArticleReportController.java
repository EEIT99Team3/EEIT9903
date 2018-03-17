package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.ArticleReportBean;
import model.Member;
import model.service.ArticleReportService;
import model.service.ArticleServise;

@Controller
public class ArticleReportController {
	@Autowired
	private ArticleReportService articleReportService;
	@RequestMapping(
			path="/report.article",
			method= {RequestMethod.GET,RequestMethod.POST}
			)
	public String report(String article_number,String m_account,String type_of_report
			,String report_content,ArticleReportBean bean,String prodaction,HttpSession session) { 
		Member member = (Member) session.getAttribute("user");
		
		bean.setArticle_number(Integer.parseInt(article_number));
		bean.setM_account(member.getMAccount());
		bean.setType_of_report(type_of_report);
		bean.setReport_content(report_content);
		
		if("insertReport".equals(prodaction)) {
			boolean insertResult = articleReportService.insertReport(bean);
			if(insertResult) {
				return "articleshow.do";
			}
		}
		
		return "";
	}
}
