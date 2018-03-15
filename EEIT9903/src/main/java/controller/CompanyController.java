package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(path= {"/baseinfo/company"} , produces= {"text/html;charset=UTF-8"})
	@ResponseBody
	public String getJson(HttpSession session) {
		String stock_id = (String) session.getAttribute("data");
		String result = companyService.search(stock_id);
		return result;  
	}
}
