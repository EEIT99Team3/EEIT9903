package model.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONValue;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.NewsBean;
import model.NewsDAO;

@Service
@Transactional
public class NewsService {
	
	@Autowired
	private NewsDAO newsDao;
	
	public List<NewsBean> select(String stock_id) {
		List<NewsBean> select = null;
		
		if (stock_id != null && stock_id.length() == 4) {
			select = newsDao.select(stock_id);
		}
		return select;
	}
	
	public String search (String stock_id) throws Exception {
		String url = "https://tw.stock.yahoo.com/q/h?s=" + stock_id + "&pg=1";
		String header = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36";
		NewsBean bean = null;
		List<NewsBean> temp = new ArrayList<NewsBean>();
		
		if(stock_id != null && stock_id.length() == 4) {
			
			Document doc = Jsoup.connect(url).header("user-agent", header).get();
			for(int i=0 ; i < 10 ; i++) {
				String news_title = doc.select("tbody tbody tbody a").get(i).text();
				
				if(!newsDao.matchTitle(news_title)) {
					
					bean = new NewsBean();
					bean.setStock_id(doc.select("table b").text().substring(0, 4));
					bean.setNews_title(news_title);
					bean.setNews_date(new SimpleDateFormat("yyyy/MM/dd").parse(doc.select("tbody tbody font").get(i).text().substring(1, 11)));
					bean.setNews_website("https://tw.stock.yahoo.com" + doc.select("tbody tbody tbody a").get(i).attr("href"));
					bean.setNews_source(doc.select("tbody tbody font").get(i).text().substring(12).replace(")", ""));
					
					temp.add(bean);
				}
			}
			
			if(temp.size() != 0) {
				for(int k=0 ; k < temp.size() ; k++) {
					NewsBean data = temp.get(k);
					newsDao.insert(data);
				}	
			}
			
			List<NewsBean> showNews = newsDao.select(stock_id);
			
			if (showNews.size() != 0) {
				
				LinkedList<HashMap<String,String>> listData = new LinkedList<HashMap<String,String>>();
				for(int s=0 ; s < showNews.size() ; s++) {
					HashMap<String,String>  mapData = new HashMap<String,String>();
					mapData.put("stock_id" , showNews.get(s).getStock_id());
					mapData.put("news_title" , showNews.get(s).getNews_title());
					mapData.put("news_date" , showNews.get(s).getNews_date().toString().substring(0 , 10));
					mapData.put("news_website" , showNews.get(s).getNews_website().toString());
					mapData.put("news_source" , showNews.get(s).getNews_source().toString());
					
					listData.add(mapData);
				}
				
				HashMap<String,LinkedList<HashMap<String,String>>> mapTemp = new HashMap<String,LinkedList<HashMap<String,String>>>();
				mapTemp.put("data" , listData);
				
				return JSONValue.toJSONString(mapTemp);
			}
		}
		return null;
	}
}
