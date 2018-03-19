package model;

import java.util.List;

public interface NewsDAO {

	List<NewsBean> select(String stock_id);

	NewsBean insert(NewsBean bean);
	
	Boolean matchTitle(String news_title);

}