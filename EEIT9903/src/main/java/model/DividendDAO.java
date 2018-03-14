package model;

import java.util.List;

public interface DividendDAO {

	List<DividendBean> select(String stock_id);

	DividendBean insert(DividendBean bean);

}