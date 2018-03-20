package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.service.HighStockService;

@Controller
public class HighStockController {

	@Autowired
	private HighStockService highStockService;

	@RequestMapping("/p/test.do") 
	public @ResponseBody
	String doAjax(HttpSession session) {
		String stock_id = (String) session.getAttribute("data");
		String result = highStockService.select(stock_id) +"";
		return result;
	}
	
}
