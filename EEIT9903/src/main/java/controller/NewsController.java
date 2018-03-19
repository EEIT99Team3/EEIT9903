package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.service.NewsService;

@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;
	
	@RequestMapping(path= {"/baseinfo/news"} , produces= {"text/html;charset=UTF-8"})
	@ResponseBody
	public String getJson(HttpSession session) throws Exception {
		String stock_id = (String) session.getAttribute("data");
		String result = newsService.search(stock_id);
		return result;  
	}
}
