package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SUPERVISOR")
public class SupervisorBean {
	@Id
	private String s_account;
	private String s_pwd;
	private boolean ispowerful;
	
	@Override
	public String toString() {
		return "SupervisorBean [s_account=" + s_account + ", s_pwd=" + s_pwd + ", ispowerful=" + ispowerful + "]";
	}
	
	public String getS_account() {
		return s_account;
	}
	public void setS_account(String s_account) {
		this.s_account = s_account;
	}
	public String getS_pwd() {
		return s_pwd;
	}
	public void setS_pwd(String s_pwd) {
		this.s_pwd = s_pwd;
	}
	public boolean isIspowerful() {
		return ispowerful;
	}
	public void setIspowerful(boolean ispowerful) {
		this.ispowerful = ispowerful;
	}
	

}
