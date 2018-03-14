package model;

public interface SupervisorDAO {

	SupervisorBean insert(SupervisorBean bean);

	boolean delete(String s_account);
	
	SupervisorBean select(String s_account);

}