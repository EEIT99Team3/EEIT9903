package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Member;
import model.Price;
import model.hibernate.HibernateUtil;

public class memberDAO {
	
	public memberDAO(SessionFactory sessionFactory, Session session) {
		super();
		this.sessionFactory = sessionFactory;
		this.session = session;
	}

	private SessionFactory sessionFactory = null;
	private Session session = null;
	public memberDAO(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	public Session getSession() {
		return 	this.sessionFactory.getCurrentSession();
	}

	public Member select(String MAccount) {
		return (Member) this.getSession().get(Member.class, MAccount);
	}

	public List<Member> select() {
		Query query = this.getSession().createQuery("from Member");
		return (List<Member>) query.list();
	}

	public Member insert(Member member) {
		Member temp = (Member) this.getSession().get(Member.class, member.getMAccount());
		if (temp == null) {
			this.getSession().save(member);
			return member;
		}
		return null;
	}

	public Member update(String MAccount, String MPwd, String email, String MName, String blacklist, byte[] photo) {
		Member result = (Member) this.getSession().get(Member.class, MAccount);
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

	public int delete(String MAccount) {
		Member bean = (Member) this.getSession().get(Member.class, MAccount);
		if (bean != null) {
			this.getSession().delete(bean);
			return 1;
		}
		return 0;
	}

//public static void main(String[] args) {
//	SessionFactory factory = HibernateUtil.getSessionFactory();
//	System.out.println(factory);
//
//	Session session = factory.getCurrentSession();
//	System.out.println(session);
//
//	Transaction trx = null;
//	try {
//		trx = session.beginTransaction();
//		memberDAO dao = new memberDAO(HibernateUtil.getSessionFactory());
//		//select all
//		List<Member> list = dao.select();
//		for (Member member : list) {
//			System.out.println(member);
//		}
		//select by primary key
//		 Member m = dao.select(new Member("001"));
//		 System.out.println(m);
		//insert(傳回null代表失敗，傳回bean代表成功)
//		PriceId id = new PriceId("0050",dao.date.parse("2018-02-17"));
//		Price input = new Price(id,new Company(id.getStockId()),BigDecimal.valueOf(17.5),BigDecimal.valueOf(17.5),BigDecimal.valueOf(17.5),BigDecimal.valueOf(17.5),Long.valueOf(2000000),BigDecimal.valueOf(0.1),BigDecimal.valueOf(0.1));
//		Price p=dao.insert(input);
//		System.out.println(p);
		//update(傳回bean代表成功)
//		dao.update(new PriceId("0050",dao.date.parse("2018-02-17")), null, null, null, null, null, BigDecimal.valueOf(1.0), null);
		//delete(1代表成功)
//		 System.out.println(dao.delete(new PriceId("0050",dao.date.parse("2018-02-17"))));
//		 trx.commit();
//		session.close();
//		HibernateUtil.closeSessionFactory();
//	} catch (Exception e) {
//		e.printStackTrace();
//		trx.rollback();
//		session.close();
//		HibernateUtil.closeSessionFactory();
//
//	} finally {
//
//		if (session != null) {
//			session.close();
//			HibernateUtil.closeSessionFactory();
//
//		}
//	}
//
//}

private Member select(Member member) {
	// TODO Auto-generated method stub
	return null;
}

}
