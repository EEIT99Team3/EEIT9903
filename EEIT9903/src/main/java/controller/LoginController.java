package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Member;
import model.service.MemberService;

@Controller
public class LoginController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(path = { "/member/login" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String loginMethod(String frontloginaccount, String frontloginpassword, Model model, HttpSession session) {
		Map<String, String> loginerrors = new HashMap<>();
		model.addAttribute("loginerrors", loginerrors);
        //測試有無輸入帳號密碼
		if (frontloginaccount == null || frontloginaccount.trim().length() == 0) {
			loginerrors.put("frontaccounterror", "Please enter your account.");
		}
		if (frontloginpassword == null || frontloginpassword.trim().length() == 0) {
			loginerrors.put("frontpassworderror", "Please enter your password.");
		}
        //有錯誤導回登入頁面
		if (loginerrors != null && !loginerrors.isEmpty()) {
			return "frontlogin.error";
		}
        //測試登入成功與否
		Member login = memberService.login(frontloginaccount, frontloginpassword);
		if (login == null) {
			loginerrors.put("frontpassworderror", "Account or Password is wrong.");
			return "frontlogin.error";   //失敗導回登入頁
		} else {
			session.setAttribute("user", login);			
			return "frontlogin.success"; //成功導向下一頁
		}	
	}
}
