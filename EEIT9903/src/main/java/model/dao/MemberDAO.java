package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Member;
@Repository
@Transactional
public class MemberDAO {
    @Autowired
	private SessionFactory sessionFactory = null;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Transactional
	public Member select(String MAccount) {
		return this.getSession().get(Member.class, MAccount);
	}
	@Transactional
	public List<Member> select() {
		return this.getSession().createQuery("from MEMBER", Member.class).list();
	}
	@Transactional
	public Member insert(Member member) {
		Member temp = (Member) this.getSession().get(Member.class, member.getMAccount());
		if (temp == null) {
			this.getSession().save(member);
			return member;
		}
		return null;
	}
	@Transactional
	public Member update(String MAccount, String MPwd, String email, String MName, Boolean blacklist, byte[] photo) {
		Member result = this.getSession().get(Member.class, MAccount);
		if (result != null) {
			result.setMAccount(MAccount);
			result.setMPwd(MPwd);
			result.setEmail(email);
			result.setBlacklist(blacklist);
			result.setPhoto(photo);
			return result;
		}
		return null;
	}
	@Transactional
	public int delete(String MAccount) {
		Member bean = (Member) this.getSession().get(Member.class, MAccount);
		if (bean != null) {
			this.getSession().delete(bean);
			return 1;
		}
		return 0;
	}

}
