package model.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Balance_sheetBean;
import model.Balance_sheetDAO;
import model.Balance_sheetPK;
import model.CompanyBean;

@Service
@Transactional
public class Balance_sheetService {
	@Autowired
	private Balance_sheetDAO dao;
	@Autowired
	private CompanyService service;
	
	public Balance_sheetBean select(Balance_sheetPK pk) {
		Balance_sheetBean result = dao.select(pk);
		if (result != null) {
			return result;
		}
		return null;
	}

	public void insert() {
		List<Balance_sheetBean> beaninsert = this.crawler();
		for (int i = 0; i < beaninsert.size(); i++) {
			dao.insert(beaninsert.get(i));
		} 
	}

	public List<Balance_sheetBean> crawler() {
		// 資產負債表
		String url = "http://mops.twse.com.tw/mops/web/t164sb03";
		List<Balance_sheetBean> bs_bean = new ArrayList<Balance_sheetBean>();
		Boolean check = true;
		Boolean count = true;
		for (int n = 2497; n <= 2499; n++) {
			String co_id = "" + n;

//			 利用Company的Bean來做Select檢查是否有這間公司，若無此公司則跳過
			CompanyBean temp2 = service.select(co_id);
			if (temp2 == null) {
				continue;
			}
			
		for (int m = 103; m < 107; m++) {
			String year = "" + m;
			for (int i = 1; i <= 5; i++) {
				
				try {
					Thread.currentThread().sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(!count) {
					i = i - 1;
					System.out.println(i);
					count = true;
				}
				
				if(!check) {
					
				// 每個請求設置延遲
				try {
					Thread.currentThread().sleep(120000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				check = true;
				
				}
				
				if(i == 5) {
					break;
				}
				
				String season = "" + i;
				Document doc = null;
				try {
					doc = Jsoup.connect(url)
							.data("encodeURIComponent", "1", "step", "1", "firstin", "1", "off", "1", "queryName",
									"co_id", "inpuType", "co_id", "TYPEK", "all", "isnew", "false", "co_id", co_id,
									"year", year, "season", season)
							.post();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Elements tests = doc.select("tr");

				long ar = 0;
				long inv = 0;
				long ca = 0;
				long non_ca = 0;
				long total_a = 0;
				long ap = 0;
				long cl = 0;
				long non_cl = 0;
				long total_l = 0;
				long stock = 0;
				long total_e = 0;
				long total_ar = 0;
				long total_ap = 0;

				System.out.printf("\nTest: (%d)", tests.size());
				for (Element test : tests) {
					String temp = test.child(0).text().replaceAll("\\u3000", "").trim();
					
					if(temp.startsWith("Overrun - 查詢過於頻繁,請稍後再試!!") || temp.startsWith("Forbidden - 查詢過於頻繁,請稍後再試!!")) {
						System.out.println("過於頻繁");
						check = false;
						count = false;
						break;
					}
					
					if (temp.startsWith("應收帳款") || temp.startsWith("應收票據")) {
						ar = Long.parseLong(test.child(1).text().replaceAll(",", ""));
						total_ar = total_ar + ar;
					}
					if (temp.startsWith("存貨")) {
						inv = Long.parseLong(test.child(1).text().replaceAll(",", ""));
					}
					if (temp.startsWith("流動資產合計")) {
						ca = Long.parseLong(test.child(1).text().replaceAll(",", ""));
					}
					if (temp.startsWith("非流動資產合計")) {
						non_ca = Long.parseLong(test.child(1).text().replaceAll(",", ""));
					}
					if (temp.startsWith("資產總")) {
						total_a = Long.parseLong(test.child(1).text().replaceAll(",", ""));
					}
					if (temp.startsWith("應付帳款") || temp.startsWith("應付票據")) {
						ap = Long.parseLong(test.child(1).text().replaceAll(",", ""));
						total_ap = total_ap + ap;
					}
					if (temp.startsWith("流動負債合計")) {
						cl = Long.parseLong(test.child(1).text().replaceAll(",", ""));
					}
					if (temp.startsWith("非流動負債合計")) {
						non_cl = Long.parseLong(test.child(1).text().replaceAll(",", ""));
					}
					if (temp.startsWith("負債總")) {
						total_l = Long.parseLong(test.child(1).text().replaceAll(",", ""));
					}
					if (temp.startsWith("股本合計")) {
						stock = Long.parseLong(test.child(1).text().replaceAll(",", ""));
					}
					if (temp.startsWith("權益總")) {
						total_e = Long.parseLong(test.child(1).text().replaceAll(",", ""));
					}
				}

				Balance_sheetBean bean = new Balance_sheetBean();
				bean.setBalance_sheetPK(new Balance_sheetPK(co_id, m, i));
				bean.setAccount_receivables(total_ar);
				bean.setInventories(inv);
				bean.setCurrent_assets(ca);
				bean.setNon_current_assets(non_ca);
				bean.setTotal_assets(total_a);
				bean.setAccount_payables(total_ap);
				bean.setCurrent_liabilities(cl);
				bean.setNon_current_liabilities(non_cl);
				bean.setTotal_liabilities(total_l);
				bean.setCaptial_stock(stock);
				bean.setTotal_equity(total_e);
				bs_bean.add(bean);

			}
		}
		}
		return bs_bean;
	}
}
