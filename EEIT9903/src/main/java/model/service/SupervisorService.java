package model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.SupervisorBean;
import model.SupervisorDAO;
@Service
public class SupervisorService {
	@Autowired
	private SupervisorDAO supervisorDAO;
	
	public SupervisorBean login(String s_account, String s_pwd) {
		SupervisorBean bean = supervisorDAO.select(s_account);
		if(bean!=null) {
			if(s_pwd!=null && s_pwd.trim().length()!=0) {
				if(bean.getS_pwd().equals(s_pwd)) {
					return bean;
				}
			}
		}
		return null;
	}
	
	public SupervisorBean addSupervisor(SupervisorBean bean) {
		SupervisorBean result = null;
		if(bean!=null) {
			result = supervisorDAO.insert(bean);
		}
		return result;
	}
	
	public boolean deleteSupervisor(SupervisorBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = supervisorDAO.delete(bean.getS_account());
		}
		return result;
	}
	
	public SupervisorBean select(String s_account) {
		SupervisorBean temp = null;
		if(s_account!=null && s_account.trim().length()!=0) {
			temp = supervisorDAO.select(s_account);
			return temp;
		}
		return temp;
	}
	
}
