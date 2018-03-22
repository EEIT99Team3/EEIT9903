package model.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.SupervisorBean;
import model.SupervisorDAO;

@Service
@Transactional
public class SupervisorService {
	@Autowired
	private SupervisorDAO supervisorDAO;

	public SupervisorBean login(String s_account, String s_pwd) {
		SupervisorBean bean = supervisorDAO.select(s_account);
		if (bean != null) {
			if (s_pwd != null && s_pwd.trim().length() != 0) {
				if (bean.getS_pwd().equals(s_pwd)) {
					return bean;
				}
			}
		}
		return null;
	}

	public SupervisorBean addSupervisor(SupervisorBean bean) {
		SupervisorBean result = null;
		if (bean != null) {
			result = supervisorDAO.insert(bean);
		}
		return result;
	}

	public Boolean deleteSupervisor(String s_account) {
		boolean result = false;
		SupervisorBean bean = supervisorDAO.select(s_account);
		if (bean != null) {
			result = supervisorDAO.delete(s_account);
		}
		return result;
	}

	public LinkedList<HashMap<String, Object>> select() {
		LinkedList<HashMap<String, Object>> result = new LinkedList<HashMap<String, Object>>();
 
			List<SupervisorBean> selectAll = supervisorDAO.select();
			for (int i = 0; i < selectAll.size(); i++) {
				SupervisorBean temp2 = selectAll.get(i);
				HashMap<String, Object> select2 = new HashMap<String, Object>();
				select2.put("s_account", temp2.getS_account());
				select2.put("s_pwd", temp2.getS_pwd());
				select2.put("ispowerful", temp2.isIspowerful());
				result.add(select2);
			}

		return result;
	}

	public SupervisorBean select(String s_account) {
		SupervisorBean result = null;
		if (s_account != null && s_account.trim().length() != 0) {
			result = supervisorDAO.select(s_account);
		}
		return result;
	}

}
