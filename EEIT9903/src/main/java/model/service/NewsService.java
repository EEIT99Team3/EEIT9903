package model.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<NewsBean> search (String stock_id) throws Exception {
		String url = "https://tw.stock.yahoo.com/q/h?s=" + stock_id + "&pg=1";
		String header = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36";
		NewsBean bean = null;
		List<NewsBean> temp = new ArrayList<NewsBean>();
		
		if(stock_id != null && stock_id.length() == 4) {
			List<NewsBean> select = newsDao.select(stock_id);
			if(select.size() != 0) {
				return select;
			} else {
//				try {
				Document doc = Jsoup.connect(url).header("user-agent", header).get();
					for(int i=0 ; i < 10 ; i++) {
						bean = new NewsBean();
						bean.setStock_id(doc.select("table b").text().substring(0, 4));
						bean.setNews_date(new SimpleDateFormat("yyyy/MM/dd").parse(doc.select("tbody tbody font").get(i).text().substring(1, 11)));
						bean.setNews_website("https://tw.stock.yahoo.com" + doc.select("tbody tbody tbody a").get(i).attr("href"));
						bean.setNews_source(doc.select("tbody tbody font").get(i).text().substring(12).replace(")", ""));
						
//						System.out.println(doc.select("tbody tbody font").get(0).text().substring(12).replace(")", ""));
						temp.add(bean);
					}
					
					for(int k=0 ; k < temp.size() ; k++) {
						NewsBean data = temp.get(k);
						newsDao.insert(data);
					}	
					return temp;
//				} catch (Exception e) {
//					return null;
//				}
			}
		} else {
			return null;
		}
	}
}
