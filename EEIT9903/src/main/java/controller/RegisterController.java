package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.service.MemberService;

@Controller
public class RegisterController {
    @Autowired
	private MemberService memberService;
	
	@RequestMapping(path="/member/register", method= {RequestMethod.GET, RequestMethod.POST})
	public String registerMethod(String addaccount, String addpassword, String addname, String addemail, Model model, HttpSession session) {
		
		Map<String, String> registererrors = new HashMap<>();
		model.addAttribute("registererrors", registererrors);
		
		if (addaccount == null || addaccount.trim().length() == 0) {
			registererrors.put("newaccounterror", "What is your account.");
		}
		
		if (addpassword == null || addpassword.trim().length() == 0) {
			registererrors.put("newpassworderror", "What is your password.");
		}
		
		if (addname == null || addname.trim().length() == 0) {
			registererrors.put("newnameerror", "What is your name.");
		}
		
		if (addemail == null || addemail.trim().length() == 0) {
			registererrors.put("newemailerror", "What is your E-mail.");
		}
		
		if (registererrors!=null && !registererrors.isEmpty()) {
			return "register.error";
		}
		
		boolean check = memberService.isExist(addaccount);
		if(check) {
			registererrors.put("newaccounterror", "This account is already existed");
			return "register.error";
		}
		
		memberService.register(addaccount, addpassword, addemail, addname, false, null);	
		return "register.success";
	}
	
}
