package model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import model.DividendBean;
import model.DividendDAO;

@Service
@Transactional
public class DividendService {
	
	@Autowired
	private DividendDAO dividendDao;
	
	public String search(String stock_id) {
		String url = "https://goodinfo.tw/StockInfo/StockDividendPolicy.asp?STOCK_ID=" + stock_id;
		String header = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36";
		
		if (stock_id != null && stock_id.length() == 4) {
			List<DividendBean> select = dividendDao.select(stock_id);
			for(int s=0 ; s < select.size() ; s++) {
				
			}
			
			if (select.size() != 0) {
				return "Select:<br>" + select;
			} else {
				try {
					Document doc = Jsoup.connect(url).header("user-agent", header).get();
					String[] divYears = doc.select("table.solid_1_padding_3_0_tbl tbody>tr td:eq(0)").text().split(" ");
					DividendBean bean = null;
					List<DividendBean> temp = new ArrayList<DividendBean>();
					
					for(int i=0 ; i < divYears.length-2 ; i++) {
						String divCash = doc.select("table.solid_1_padding_3_0_tbl tbody>tr td:eq(3)").get(i).text();
						String divStock = doc.select("table.solid_1_padding_3_0_tbl tbody>tr td:eq(6)").get(i).text();
						
						if(!divCash.equals("-") || !divStock.equals("-")) {
							
							bean = new DividendBean();
							bean.setStock_id(doc.select("a.link_blue").get(36).text().substring(0, 4));
							bean.setDiv_year(Integer.parseInt(divYears[i]));
							bean.setDiv_cash(Float.parseFloat(divCash));
							bean.setDiv_stock(Float.parseFloat(divStock));
							
							temp.add(bean);
						}
					}
					
					for(int k=0 ; k < temp.size() ; k++) {
						DividendBean data = temp.get(k);
						dividendDao.insert(data);
					}
					return "Insert:<br>"+temp;
				} catch (Exception e) {
					return null;
				}
			}
		} else {
			return null;
		}
	}
	
	public void insertAll() throws Exception {
		
		String urlSii = "http://mops.twse.com.tw/mops/web/t51sb01?encodeURIComponent=1&step=1&firstin=1&TYPEK=sii";
		String urlOtc = "http://mops.twse.com.tw/mops/web/t51sb01?encodeURIComponent=1&step=1&firstin=1&TYPEK=otc";
		String url = "https://goodinfo.tw/StockInfo/StockDividendPolicy.asp?STOCK_ID=";
		String header = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36";
		
		// 使用htmlunit建構一個webClient，模擬Chrome
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		// 隱藏日誌訊息
		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log" , "org.apache.commons.logging.impl.NoOpLog");
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		// 支援JavaScript
		webClient.getOptions().setJavaScriptEnabled(true);
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setActiveXNative(false);
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
		webClient.getOptions().setTimeout(5000);
		HtmlPage rootPageSii = webClient.getPage(urlSii);
		HtmlPage rootPageOtc = webClient.getPage(urlOtc);
		// 設定JavaScript執行時間
		webClient.waitForBackgroundJavaScript(5000);
		webClient.close();

		String htmlSii = rootPageSii.asXml();
		String htmlOtc = rootPageOtc.asXml();
		
		Document docSii = Jsoup.parse(htmlSii);
		Document docOtc = Jsoup.parse(htmlOtc);
		
		String[] Siis = docSii.select("tr.even td:eq(0),tr.odd td:eq(0)").text().replaceFirst(" ", "").split(Jsoup.parse("&nbsp;").text() + " " + Jsoup.parse("&nbsp;").text());
		String[] Otcs = docOtc.select("tr.even td:eq(0),tr.odd td:eq(0)").text().replaceFirst(" ", "").split(Jsoup.parse("&nbsp;").text() + " " + Jsoup.parse("&nbsp;").text());
		List<DividendBean> temp = new ArrayList<DividendBean>();
		DividendBean bean = null;
		
		
		for(int i=0 ; i < Siis.length ; i++) {
			Document doc = Jsoup.connect(url+Siis[i]).userAgent(header).referrer("https://goodinfo.tw/StockInfo/index.asp").get();
			String[] divYears = doc.select("table.solid_1_padding_3_0_tbl tbody>tr td:eq(0)").text().split(" ");
			
			if(Siis[i].length() == 4) {
				
				for(int j=0 ; j < divYears.length-2 ; j++) {
					String divCash = doc.select("table.solid_1_padding_3_0_tbl tbody>tr td:eq(3)").get(j).text();
					String divStock = doc.select("table.solid_1_padding_3_0_tbl tbody>tr td:eq(6)").get(j).text();
					
					if(!divCash.equals("-") || !divStock.equals("-")) {
						
						bean = new DividendBean();
						bean.setStock_id(doc.select("a.link_blue").get(36).text().substring(0, 4));
						bean.setDiv_year(Integer.parseInt(divYears[j]));
						bean.setDiv_cash(Float.parseFloat(divCash));
						bean.setDiv_stock(Float.parseFloat(divStock));
						
						temp.add(bean);
					}
//					if(i % 10 == 0) {
						Thread.currentThread();
						Thread.sleep(10000);
//					}
				}
			}
		}
		
		for(int k=0 ; k < Otcs.length ; k++) {
			Document doc = Jsoup.connect(url+Otcs[k]).userAgent(header).referrer("https://goodinfo.tw/StockInfo/index.asp").get();
			String[] divYears = doc.select("table.solid_1_padding_3_0_tbl tbody>tr td:eq(0)").text().split(" ");
			
			if(Otcs[k].length() == 4) {
				
				for(int h=0 ; h < divYears.length-2 ; h++) {
					String divCash = doc.select("table.solid_1_padding_3_0_tbl tbody>tr td:eq(3)").get(h).text();
					String divStock = doc.select("table.solid_1_padding_3_0_tbl tbody>tr td:eq(6)").get(h).text();
					
					if(!divCash.equals("-") || !divStock.equals("-")) {
						
						bean = new DividendBean();
						bean.setStock_id(doc.select("a.link_blue").get(36).text().substring(0, 4));
						bean.setDiv_year(Integer.parseInt(divYears[h]));
						bean.setDiv_cash(Float.parseFloat(divCash));
						bean.setDiv_stock(Float.parseFloat(divStock));
						
						temp.add(bean);
					}
//					if(k % 10 == 0) {
						Thread.currentThread();
						Thread.sleep(10000);
//					}
				}
			}
		}
		
		for(int m=0 ; m < temp.size() ; m++) {
			DividendBean data = temp.get(m);
			dividendDao.insert(data);
		}
	}
}
