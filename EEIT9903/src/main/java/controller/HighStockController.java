package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.service.HighStockService;

@Controller
public class HighStockController {

	@Autowired
	private HighStockService highStockService;

	@RequestMapping("/p/test.do") 
	public @ResponseBody
	String doAjax(@RequestParam("stock_id")  String stockId) {
		
		String result = highStockService.select(stockId) +"";
		return result;
	}
	
}
