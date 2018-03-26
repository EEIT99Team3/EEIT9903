package model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.simple.JSONValue;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import model.CompanyBean;
import model.CompanyDAO;

@Service
@Transactional
public class CompanyService {
	
	@Autowired
	private CompanyDAO companyDao;
	
	public CompanyBean select(String stock_id) {
		CompanyBean select = null;
		
		if (stock_id != null && stock_id.length() == 4) {
			select = companyDao.select(stock_id);
		}
		return select;
	}
	
	public String search(String stock_id) {
		String url = "http://mops.twse.com.tw/mops/web/t05st03?firstin=true&off=1&first=true&step=1&co_id=" + stock_id;
		String header = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36";
		
		if (stock_id != null && stock_id.length() == 4) {
			CompanyBean select = companyDao.select(stock_id);
			
			if (select != null) {
				HashMap<String,String> temp = new HashMap<String,String>();
				
				temp.put("stock_id" , select.getStockId());
				temp.put("stock_name" , select.getStockName());
				temp.put("chairman" , select.getChairman());
				temp.put("manager" , select.getManager());
				temp.put("captial" , select.getCaptial().toString());
				temp.put("stock_website" , select.getStockWebsite());
				temp.put("tax_number" , select.getTaxNumber());
				
				return JSONValue.toJSONString(temp);
			} else {
				try {
					JSONArray jsonCompany = new JSONArray();
					
					Document doc = Jsoup.connect(url).header("user-agent", header).get();
					CompanyBean bean = new CompanyBean();
					bean.setStockId(doc.select("table.hasBorder tr:eq(0) td").get(0).text());
					bean.setStockName(doc.select("table.hasBorder tr:eq(1) td").get(0).text());
					bean.setChairman(doc.select("table.hasBorder tr:eq(3) td").get(0).text());
					bean.setManager(doc.select("table.hasBorder tr:eq(3) td").get(1).text());
					bean.setCaptial(Long.parseLong(doc.select("table.hasBorder tr:eq(8) td").get(0).text().replace("元", "").replace(",", "")));
					bean.setStockWebsite(doc.select("table.hasBorder tr:eq(23) a").get(0).text());
					bean.setTaxNumber(doc.select("table.hasBorder tr:eq(7) td").get(1).text());
					companyDao.insert(bean);
					
					jsonCompany.put(bean.getStockId());
					jsonCompany.put(bean.getStockName());
					jsonCompany.put(bean.getChairman());
					jsonCompany.put(bean.getManager());
					jsonCompany.put(bean.getCaptial());
					jsonCompany.put(bean.getStockWebsite());
					jsonCompany.put(bean.getTaxNumber());
					
					return jsonCompany+"";
				} catch (Exception e) {
					return null;
				}
			}
		} else {
			return null;
		}
	}
	
	public List<CompanyBean> insertAll() throws Exception {
		
		String urlSii = "http://mops.twse.com.tw/mops/web/t51sb01?encodeURIComponent=1&step=1&firstin=1&TYPEK=sii";
		String urlOtc = "http://mops.twse.com.tw/mops/web/t51sb01?encodeURIComponent=1&step=1&firstin=1&TYPEK=otc";
		
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
		List<CompanyBean> temp = new ArrayList<CompanyBean>();
		CompanyBean bean = null;
		
		for(int i = 0 ; i < Siis.length ; i++) {
			String stockId = docSii.select("tr.even td:eq(0),tr.odd td:eq(0)").get(i).text().replace(Jsoup.parse("&nbsp;").text(), "");
			
			if(stockId.length() == 4) {
				
				bean = new CompanyBean();
				bean.setStockId(stockId);
				bean.setStockName(docSii.select("tr.even td:eq(1),tr.odd td:eq(1)").get(i).text());
				bean.setChairman(docSii.select("tr.even td:eq(4),tr.odd td:eq(4)").get(i).text());
				bean.setManager(docSii.select("tr.even td:eq(5),tr.odd td:eq(5)").get(i).text());
				bean.setCaptial(Long.parseLong(docSii.select("tr.even td:eq(13),tr.odd td:eq(13)").get(i).text().replace(",", "")));
				bean.setStockWebsite(docSii.select("tr.even td:eq(28),tr.odd td:eq(28)").get(i).text());
				bean.setTaxNumber(docSii.select("tr.even td:eq(3),tr.odd td:eq(3)").get(i).text().replace(Jsoup.parse("&nbsp;").text(), ""));
				
				temp.add(bean);
			}
		}
		
		for(int j = 0 ; j < Otcs.length ; j++) {
			String stockId = docOtc.select("tr.even td:eq(0),tr.odd td:eq(0)").get(j).text().replace(Jsoup.parse("&nbsp;").text(), "");
			
			if(stockId.length() == 4) {
				
				bean = new CompanyBean();
				bean.setStockId(stockId);
				bean.setStockName(docOtc.select("tr.even td:eq(1),tr.odd td:eq(1)").get(j).text());
				bean.setChairman(docOtc.select("tr.even td:eq(4),tr.odd td:eq(4)").get(j).text());
				bean.setManager(docOtc.select("tr.even td:eq(5),tr.odd td:eq(5)").get(j).text());
				bean.setCaptial(Long.parseLong(docOtc.select("tr.even td:eq(13),tr.odd td:eq(13)").get(j).text().replace(",", "")));
				bean.setStockWebsite(docOtc.select("tr.even td:eq(28),tr.odd td:eq(28)").get(j).text());
				bean.setTaxNumber(docOtc.select("tr.even td:eq(3),tr.odd td:eq(3)").get(j).text().replace(Jsoup.parse("&nbsp;").text(), ""));
				
				temp.add(bean);
			}
		}
		for (int k = 0; k < temp.size(); k++) {
			CompanyBean data = temp.get(k);
			companyDao.insert(data);
		}
		return temp;
	}
}
