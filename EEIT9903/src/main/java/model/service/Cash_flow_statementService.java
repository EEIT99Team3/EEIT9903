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

import model.Cash_flow_statementBean;
import model.Cash_flow_statementDAO;
import model.Cash_flow_statementPK;

@Service
public class Cash_flow_statementService {
	@Autowired
	private Cash_flow_statementDAO dao;
	
	public void insert() {
		List<Cash_flow_statementBean> beaninsert = this.crawler();
		for (int i = 0; i < beaninsert.size(); i++) {
			dao.insert(beaninsert.get(i));
		} 
	}

	public List<Cash_flow_statementBean> crawler() {
		List<Cash_flow_statementBean> cf_bean = new ArrayList<Cash_flow_statementBean>();
		String url = "http://mops.twse.com.tw/mops/web/t164sb05";// 現金流量表

		for (int m = 105; m < 107; m++) {
			String year = "" + m;
			for (int i = 1; i < 5; i++) {
				String season = "" + i;
				Document doc = null;
				try {
					doc = Jsoup.connect(url)
							.data("encodeURIComponent", "1", "step", "1", "firstin", "1", "off", "1", "queryName", "co_id",
									"inpuType", "co_id", "TYPEK", "all", "isnew", "false", "co_id", "2317", "year", year,
									"season", season)
							.post();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Elements tests = doc.select("tr");

				long op_cash = 0;
				long in_cash = 0;
				long fi_cash = 0;

				System.out.printf("\nTest: (%d)", tests.size());
				for (Element test : tests) {
					String temp = test.child(0).text().replaceAll("\\u3000", "").trim();
					if (temp.startsWith("營業活動之淨現金流入（流出）")) {
						op_cash = Long.parseLong(test.child(1).text().replaceAll(",", ""));
					}
					if (temp.startsWith("投資活動之淨現金流入（流出）")) {
						in_cash = Long.parseLong(test.child(1).text().replaceAll(",", ""));
					}
					if (temp.startsWith("籌資活動之淨現金流入（流出）")) {
						fi_cash = Long.parseLong(test.child(1).text().replaceAll(",", ""));
					}

				}

				Cash_flow_statementBean bean = new Cash_flow_statementBean();
				bean.setCash_flow_statementPK(new Cash_flow_statementPK("2317", m, i));
				bean.setOperating_cash_flow(op_cash);
				bean.setInvesting_cash_flow(in_cash);
				bean.setFinancing_cash_flow(fi_cash);
				
				cf_bean.add(bean);

			}
		}
		return cf_bean;
	}
}
