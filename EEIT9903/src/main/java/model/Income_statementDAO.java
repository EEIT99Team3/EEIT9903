package model;

import java.util.List;

public interface Income_statementDAO {

	Income_statementBean insert(Income_statementBean bean);

	Income_statementBean select(Income_statementPK pk);

	List<Income_statementBean> select(Integer ratyear, Integer ratseason);

}