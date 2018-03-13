package model;

public interface CompanyDAO {

	CompanyBean select(String stock_id);

	CompanyBean insert(CompanyBean bean);

}