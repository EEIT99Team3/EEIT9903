package model;

import java.util.List;
public interface Balance_sheetDAO {

	Balance_sheetBean insert(Balance_sheetBean bean);
	
	Balance_sheetBean select(Balance_sheetPK pk);

	List<Balance_sheetBean> select(Integer ratyear,Integer ratseason);

}