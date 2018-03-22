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
import model.Balance_sheetPK;
import model.Cash_flow_statementBean;
import model.Cash_flow_statementDAO;
import model.Cash_flow_statementPK;
import model.CompanyBean;

@Service
@Transactional
public class Cash_flow_statementService {
	@Autowired
	private Cash_flow_statementDAO dao;
	@Autowired
	private CompanyService service;

	public Cash_flow_statementBean select(Cash_flow_statementPK pk) {
		Cash_flow_statementBean result = dao.select(pk);
		if (result != null) {
			return result;
		}
		return null;
	}

	public void insert() {
		List<Cash_flow_statementBean> beaninsert = this.crawler();
		for (int i = 0; i < beaninsert.size(); i++) {
			dao.insert(beaninsert.get(i));
		}
	}

	public List<Cash_flow_statementBean> crawler() {
		List<Cash_flow_statementBean> cf_bean = new ArrayList<Cash_flow_statementBean>();
		String url = "http://mops.twse.com.tw/mops/web/t164sb05";// 現金流量表
		Boolean check = true;
		Boolean count = true;
		int countbreak = 0;

		a: for (int n = 2421; n <= 2450; n++) {
			String co_id = "" + n;

			// 利用Company的Bean來做Select檢查是否有這間公司，若無此公司則跳過
			CompanyBean beancheck = service.select(co_id);
			if (beancheck == null) {
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

					if (!count) {
						i = i - 1;
						System.out.println(i);
						count = true;
					}

					if (!check) {

						// 每個請求設置延遲
						try {
							Thread.currentThread().sleep(120000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						check = true;

					}

					if (i == 5) {
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

					long op_cash = 0;
					long in_cash = 0;
					long fi_cash = 0;

					System.out.printf("\nTest: (%d)", tests.size());
					for (Element test : tests) {
						String temp = test.child(0).text().replaceAll("\\u3000", "").trim();

						if (temp.startsWith("Overrun - 查詢過於頻繁,請稍後再試!!")
								|| temp.startsWith("Forbidden - 查詢過於頻繁,請稍後再試!!")) {
							System.out.println("過於頻繁");
							check = false;
							count = false;
							countbreak++;
							if (countbreak == 3) {
								break a;
							}
							break;
						}

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
					
					// 如果得到0，代表該季季報尚未出，故不需存至資料庫
					// 營收、成本都有可能是0，故用稅後淨利檢查
					if (op_cash == 0) {
						continue;
					}

					Cash_flow_statementBean bean = new Cash_flow_statementBean();
					bean.setCash_flow_statementPK(new Cash_flow_statementPK(co_id, m, i));
					bean.setOperating_cash_flow(op_cash);
					bean.setInvesting_cash_flow(in_cash);
					bean.setFinancing_cash_flow(fi_cash);

					cf_bean.add(bean);

				}
			}
		}
		return cf_bean;
	}
}
