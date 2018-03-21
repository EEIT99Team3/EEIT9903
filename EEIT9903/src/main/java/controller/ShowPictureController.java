package controller;

import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Member;
import model.service.MemberService;
@Controller
public class ShowPictureController {
	@Autowired
	private MemberService memberService;
	@RequestMapping(value = "/member/getImage", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<byte[]> getImageAsResponseEntity(HttpSession session) {
		Member member = null;
		if (session.getAttribute("user") != null) {
			member = (Member) session.getAttribute("user");
		}
		HttpHeaders headers = new HttpHeaders();
		byte[] media = null;
		Blob blob = null;
		try {
			if (member != null) {
				Member result = memberService.selectMember(member.getMAccount());
				if(result.getPhoto() != null) {
					System.out.println("not null");
				    blob = memberService.memberPhoto(member.getMAccount());
				    media = blob.getBytes(1, (int) blob.length());
				} else {
					System.out.println("null");
					blob = memberService.memberPhoto("test");
					media = blob.getBytes(1, (int) blob.length());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		if (media != null) {
			ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
			return responseEntity;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/pages/check/getImage.article", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<byte[]> getImageAsResponseEntity(String m_account) {
		HttpHeaders headers = new HttpHeaders();
		byte[] media = null;
		Blob blob = null;
		try {
				if(m_account !=null) {
//				blob = member.getPhoto();
				blob = memberService.memberPhoto(m_account);
				media = blob.getBytes(1, (int) blob.length());
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		if (media != null) {
			ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
			System.out.println(responseEntity);
			return responseEntity;
		} else {
			return null;
		}
	}

}
