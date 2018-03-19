package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Member;
import model.service.MemberService;
@Controller
public class MemberUpdateController {
	@Autowired
	private MemberService memberService;
    @RequestMapping(path="/member/update", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateMember(String nameupdate, String emailupdate, String oldpwdupdate, String newpwdupdate, Model model, HttpSession session) {
		Map<String, String> updateerror = new HashMap<>();
		model.addAttribute("updateerror", updateerror);
		Member updatebean = (Member) session.getAttribute("user");
		
		if (nameupdate == null || nameupdate.trim().length() == 0) {
			updateerror.put("updatenameerror", "請輸入名稱");
		}
		
		if (emailupdate == null || emailupdate.trim().length() == 0) {
			updateerror.put("updatemailerror", "請輸入email");
		}
		
		if (oldpwdupdate == null || oldpwdupdate.trim().length() == 0) {
			updateerror.put("oldpwderror", "輸入有誤");
		}
		
		if (newpwdupdate == null || newpwdupdate.trim().length() == 0) {
			updateerror.put("newpwderror", "輸入有誤");
		}
		
		if (updateerror!=null && !updateerror.isEmpty()) {
			return "update.error";
		}
		
		memberService.updateInfo(updatebean.getMAccount(), oldpwdupdate, newpwdupdate, emailupdate, nameupdate, null);    	
    	return "update.success";
	}
}
