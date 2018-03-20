package model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "MEMBER", schema = "dbo", catalog = "Project1")
public class Member {

	private static final long serialVersionUID = 1L;
	private String MAccount;

	private String MPwd;
	private String email;
	private String MName;
	private Boolean blacklist;
	private Blob photo;
	
	@Override
	public String toString() {
		return "Member [MAccount=" + MAccount + ", MPwd=" + MPwd + ", email=" + email + ", MName=" + MName
				+ ", blacklist=" + blacklist + ", photo=" + photo + "]";
	}

	public Member() {
	}

	public Member(String MAccount) {
		this.MAccount = MAccount;
	}

	public Member(String MAccount, String MPwd, String email, String MName, Boolean blacklist, Blob photo) {
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
	public Boolean getBlacklist() {
		return this.blacklist;
	}

	public void setBlacklist(Boolean blacklist) {
		this.blacklist = blacklist;
	}

	@Column(name = "photo")
	public Blob getPhoto() {
		return this.photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
}
