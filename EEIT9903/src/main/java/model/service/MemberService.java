package model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Member;
import model.dao.MemberDAO;
@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;

	// 登入 確認帳號比對密碼
	public Member login(String MAccount, String Mpwd) {
		Member member = memberDAO.select(MAccount);
		if (member != null && Mpwd.equals(member.getMPwd())) {
			return member;
		}
		return null;
	}

	// 註冊

}
