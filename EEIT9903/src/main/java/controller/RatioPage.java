package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("ratio")
public class RatioPage {
	@RequestMapping(path= {"/choose"}, method= {RequestMethod.GET, RequestMethod.POST})
	public String method() {
		System.out.println("準備丟出choose page");
		return "RatioPage";
	}

}
