package model;

import java.util.List;

public interface SupervisorDAO {

	SupervisorBean insert(SupervisorBean bean);
	
	Boolean delete(String s_account);

	SupervisorBean select(String s_account);

	List<SupervisorBean> select();

}