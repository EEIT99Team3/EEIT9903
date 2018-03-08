package model;

public interface Balance_sheetDAO {

	Balance_sheetBean insert(Balance_sheetBean bean);
	
	Balance_sheetBean select(Balance_sheetPK pk);

}