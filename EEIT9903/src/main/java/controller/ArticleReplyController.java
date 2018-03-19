package controller;

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

import model.ArticleReplyBean;
import model.Member;
import model.service.ArticleReplyServise;
@Controller
public class ArticleReplyController {
	@Autowired
	private ArticleReplyServise articleReplyServise;
	@RequestMapping(
			path="/pages/replyshow.article",
			method= {RequestMethod.GET,RequestMethod.POST},
			produces="application/json;charset=UTF-8"
			)
	public @ResponseBody String replyShow(String article_number) {
	
			List<HashMap<String, String>> result = new LinkedList<HashMap<String, String>>();
		result = articleReplyServise.select(Integer.parseInt(article_number));
			if (result != null) {
				String jsonString = JSONValue.toJSONString(result);
				
				return jsonString; 
			}
		
		return "";
	}
	@RequestMapping(
			path="/pages/reply.article",
			method= {RequestMethod.GET,RequestMethod.POST}
			)
	public String replyEditor(String prodaction,String reply,HttpSession session
			,ArticleReplyBean bean) {
		Member member = (Member) session.getAttribute("user");
		
		Integer article_number = (Integer) session.getAttribute("article_number");
		System.out.println(article_number);
		bean.setArticle_number(article_number);
		bean.setReply(reply);
		bean.setM_account(member.getMAccount());
		
		if ("insertreply".equals(prodaction)) {
			boolean insertreply = articleReplyServise.insert(bean);
			if (insertreply) {
				return "reply.do";
			}
		}
		
		return "";
		
	}
	
}
