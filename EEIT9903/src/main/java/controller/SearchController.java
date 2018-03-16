package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {

	@RequestMapping("/baseinfo/search")
	public String setStockId(String stock_id , HttpSession session) {
		session.setAttribute("data", stock_id);
		return "info.page";  
	}
}
