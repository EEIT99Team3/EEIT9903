package model.dao;

import java.awt.List;
import java.util.Arrays;

import org.hibernate.Session;

import model.Member;
import model.hibernate.HibernateUtil;

public class memberService {
	private memberDAO memberDAO;

	public memberService() {
		memberDAO = new memberDAO(HibernateUtil.getSessionFactory());
	}

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			memberService mService1 = new memberService();
			Member member = mService1.login("001", "001");
			System.out.println("member:" + member);

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}

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
