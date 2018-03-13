package model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;

import model.hibernate.HibernateUtil;

@Entity
@Table(name = "MEMBER", schema = "dbo", catalog = "Project1")
public class Member implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String MAccount;
	@Override
	public String toString() {
		return "Member [MAccount=" + MAccount + ", MPwd=" + MPwd + ", email=" + email + ", MName=" + MName
				+ ", blacklist=" + blacklist + ", photo=" + Arrays.toString(photo) + "]";
	}

	private String MPwd;
	private String email;
	private String MName;
	private String blacklist;
	private byte[] photo;

	
	public Member() {
	}

	public Member(String MAccount) {
		this.MAccount = MAccount;
	}

	public Member(String MAccount, String MPwd, String email, String MName, String blacklist, byte[] photo) {
		this.MAccount = MAccount;
		this.MPwd = MPwd;
		this.email = email;
		this.MName = MName;
		this.blacklist = blacklist;
		this.photo = photo;
	}

	@Id
	@Column(name = "m_account", unique = true, nullable = false, length = 30)
	public String getMAccount() {
		return this.MAccount;
	}

	public void setMAccount(String MAccount) {
		this.MAccount = MAccount;
	}

	@Column(name = "m_pwd", length = 16)
	public String getMPwd() {
		return this.MPwd;
	}

	public void setMPwd(String MPwd) {
		this.MPwd = MPwd;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "m_name")
	public String getMName() {
		return this.MName;
	}

	public void setMName(String MName) {
		this.MName = MName;
	}

	@Column(name = "blacklist", length = 1)
	public String getBlacklist() {
		return this.blacklist;
	}

	public void setBlacklist(String blacklist) {
		this.blacklist = blacklist;
	}

	@Column(name = "photo")
	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			// insert
			Member insert = new Member();
			insert.setMAccount("thirdtry");
			insert.setMPwd("thirdtry");
			insert.setEmail("thirdtry@gmail.com");
			insert.setBlacklist(null);
			insert.setPhoto(null);
			session.save(insert);
			
			// delete
//			 Member delete = new Member();
//			 delete.setMAccount("xxx");
//			 session.delete(delete);
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
