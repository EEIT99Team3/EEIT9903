package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import model.Member;
import model.service.MemberService;
@Controller
public class MemberUpdateController {
	@Autowired
	private MemberService memberService;
    @RequestMapping(path="/member/update", method= {RequestMethod.GET, RequestMethod.POST})
    public String updateMember(String nameupdate, String emailupdate, String oldpwdupdate, String newpwdupdate, MultipartFile file1, Model model, HttpSession session) throws IOException {
		Map<String, String> updateerror = new HashMap<>();
		model.addAttribute("updateerror", updateerror);
		Member updatebean = (Member) session.getAttribute("user");
		
//		if (nameupdate == null || nameupdate.trim().length() == 0) {
//			updateerror.put("updatenameerror", "請輸入名稱");
//		}
//		
//		if (emailupdate == null || emailupdate.trim().length() == 0) {
//			updateerror.put("updatemailerror", "請輸入email");
//		}
//		
//		if (oldpwdupdate == null || oldpwdupdate.trim().length() == 0) {
//			updateerror.put("oldpwderror", "輸入有誤");
//		}
//		
//		if (newpwdupdate == null || newpwdupdate.trim().length() == 0) {
//			updateerror.put("newpwderror", "輸入有誤");
//		}
		if(file1==null) {
			System.out.println("這是null");
		}
		
		Blob photo = null;
		String fileName = null;
		InputStream in = null;
		if (file1 != null && !file1.isEmpty()) {
			System.out.println("test1");
			fileName = file1.getOriginalFilename();
			String extension = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toLowerCase();
			if (!extension.equals("jpg") && !extension.equals("jpeg") && !extension.equals("gif")
					&& !extension.equals("bmp") && !extension.equals("png") && !extension.equals("tif")
					&& !extension.equals("tiff") && !extension.equals("wmf")) {
				System.out.println("輸入非圖片檔，不動作");
			} else {
				in = file1.getInputStream();
				long size = file1.getSize();
				byte[] b = new byte[(int) size];
				in.read(b);
				try {
					photo = new SerialBlob(b);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
		
//		if (updateerror!=null && !updateerror.isEmpty()) {
//			return "update.error";
//		}
		
		
		
		memberService.updateInfo(updatebean.getMAccount(), oldpwdupdate, newpwdupdate, emailupdate, nameupdate, photo);    	
    	return "update.success";
	}
    
    
    
}
