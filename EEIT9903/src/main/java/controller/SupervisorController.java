package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.SupervisorBean;
import model.service.SupervisorService;
@Controller
public class SupervisorController {
	@Autowired
	private SupervisorService supervisorService;
	@RequestMapping(path= {"/Statement/addnew"}, method= {RequestMethod.GET, RequestMethod.POST})
	public String addMethod(String s_account, String s_password, Model model) {
		
		Map<String, String> errorsadd = new HashMap<>();
		model.addAttribute("errorsadd", errorsadd);
		
		if(s_account==null || s_password.trim().length()==0) {
			errorsadd.put("accounterror", "請輸入帳號");
		}
		
		if(s_password==null || s_password.trim().length()==0) {
			errorsadd.put("passworderror", "請輸入密碼");
		}
		
		if(errorsadd !=null && !errorsadd.isEmpty()) {
			return "supervisoradd.error";
		}
		
		SupervisorBean bean = new SupervisorBean();
		bean.setS_account(s_account);
		bean.setS_pwd(s_password);
		bean.setIspowerful(false);
		
		supervisorService.addSupervisor(bean);
	
		return "supervisoradd.success";
	}
	@RequestMapping(path= {"/Statement/delete"}, method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteMethod(String s_delete, Model model) {
		
		Map<String, String> errorsdelete = new HashMap<>();
		model.addAttribute("errorsdelete", errorsdelete);
		
		if(s_delete==null || s_delete.trim().length()==0) {
			errorsdelete.put("deleteerror", "請選擇要刪除的帳號");
		}
		
		if(errorsdelete!=null && !errorsdelete.isEmpty()) {
			return "supervisordelete.error";
		}
		
	    SupervisorBean result = supervisorService.select(s_delete);
		supervisorService.deleteSupervisor(result);
		
		return "supervisordelete.success";
	}
	@RequestMapping(path= {"/Statement/login"}, method= {RequestMethod.GET, RequestMethod.POST})
	public String loginMethod(String login_account, String login_password, Model model, HttpSession session) {
		
		Map<String, String> errorslogin = new HashMap<>();
		model.addAttribute("errorslogin", errorslogin);
		
		if(login_account==null || login_account.trim().length()==0) {
			errorslogin.put("loginaccount", "請輸入帳號");
		}
		
		if(login_password==null || login_password.trim().length()==0) {
			errorslogin.put("loginpassword", "請輸入密碼");
		}
		
		if(errorslogin!=null && !errorslogin.isEmpty()) {
			return "backendlogin.error";
		}
		
		SupervisorBean bean = supervisorService.login(login_account, login_password);
		
		if(bean==null) {
			errorslogin.put("loginresult", "帳號或密碼有誤");
			return "backendlogin.error";
		}else {
			session.setAttribute("s_uesr", bean);
			errorslogin.put("loginresult", "登入成功");
			return "backendlogin.success";
		}
	}	
}
