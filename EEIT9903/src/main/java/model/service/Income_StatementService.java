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

import model.Income_statementBean;
import model.Income_statementDAO;
import model.Income_statementPK;

@Service
public class Income_StatementService {
	@Autowired
	private Income_statementDAO dao;
//	@Autowired
//	private CompanyService service;

	public Income_statementBean select(Income_statementPK pk) {
		Income_statementBean result = dao.select(pk);
		if (result != null) {
			return result;
		}
		return null;
	}

	public void insert() {
		List<Income_statementBean> beaninsert = this.crawler();
		for (int i = 0; i < beaninsert.size(); i++) {
			dao.insert(beaninsert.get(i));
		}
	}

	public List<Income_statementBean> crawler() {

		String url = "http://mops.twse.com.tw/mops/web/t164sb04";// 綜合損益表
		List<Income_statementBean> is_bean = new ArrayList<Income_statementBean>();

		for (int n = 1225; n <= 1236; n++) {
			String co_id = "" + n;

			// 利用Company的Bean來做Select檢查是否有這間公司，若無此公司則跳過
//			CompanyBean bean = service.select(co_id);
//			if (bean == null) {
//				continue;
//			}
			try {
				Thread.currentThread().sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (int m = 104; m < 107; m++) {
				String year = "" + m;
				try {
					Thread.currentThread().sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 1; i < 5; i++) {

					// 每個請求設置延遲
					try {
						Thread.currentThread().sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
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

					long sales = 0;
					long costs = 0;
					long gp = 0;
					long op_costs = 0;
					long op_income = 0;
					long other_costs = 0;
					long before_tax = 0;
					long tax = 0;
					long ni = 0;

					System.out.printf("\nTest: (%d)", tests.size());
					for (Element test : tests) {
						String temp = test.child(0).text().replaceAll("\\u3000", "").trim();

						if (i == 1 || i == 4) {

							if (temp.startsWith("營業收入合計")) {
								sales = Long.parseLong(test.child(1).text().replaceAll(",", ""));
							}
							if (temp.startsWith("營業成本合計")) {
								costs = Long.parseLong(test.child(1).text().replaceAll(",", ""));
							}
							if (temp.startsWith("營業毛利（毛損）淨額")) {
								gp = Long.parseLong(test.child(1).text().replaceAll(",", ""));
							}
							if (temp.startsWith("營業費用合計")) {
								op_costs = Long.parseLong(test.child(1).text().replaceAll(",", ""));
							}
							if (temp.startsWith("營業利益（損失）")) {
								op_income = Long.parseLong(test.child(1).text().replaceAll(",", ""));
							}
							if (temp.startsWith("營業外收入及支出合計")) {
								other_costs = Long.parseLong(test.child(1).text().replaceAll(",", ""));
							}
							if (temp.startsWith("稅前淨利（淨損）")) {
								before_tax = Long.parseLong(test.child(1).text().replaceAll(",", ""));
							}
							if (temp.startsWith("所得稅費用（利益）合計")) {
								tax = Long.parseLong(test.child(1).text().replaceAll(",", ""));
							}
							if (temp.startsWith("本期淨利（淨損）")) {
								ni = Long.parseLong(test.child(1).text().replaceAll(",", ""));
							}
						} else if (i == 2 || i == 3) {
							if (temp.startsWith("營業收入合計")) {
								sales = Long.parseLong(test.child(5).text().replaceAll(",", ""));
							}
							if (temp.startsWith("營業成本合計")) {
								costs = Long.parseLong(test.child(5).text().replaceAll(",", ""));
							}
							if (temp.startsWith("營業毛利（毛損）淨額")) {
								gp = Long.parseLong(test.child(5).text().replaceAll(",", ""));
							}
							if (temp.startsWith("營業費用合計")) {
								op_costs = Long.parseLong(test.child(5).text().replaceAll(",", ""));
							}
							if (temp.startsWith("營業利益（損失）")) {
								op_income = Long.parseLong(test.child(5).text().replaceAll(",", ""));
							}
							if (temp.startsWith("營業外收入及支出合計")) {
								other_costs = Long.parseLong(test.child(5).text().replaceAll(",", ""));
							}
							if (temp.startsWith("稅前淨利（淨損）")) {
								before_tax = Long.parseLong(test.child(5).text().replaceAll(",", ""));
							}
							if (temp.startsWith("所得稅費用（利益）合計")) {
								tax = Long.parseLong(test.child(5).text().replaceAll(",", ""));
							}
							if (temp.startsWith("本期淨利（淨損）")) {
								ni = Long.parseLong(test.child(5).text().replaceAll(",", ""));
							}
						}

					}

					// 如果得到0，代表該季季報尚未出，故不需存至資料庫
					// 營收、成本都有可能是0，故用稅後淨利檢查
					if (ni == 0) {
						continue;
					}

					Income_statementBean insert = new Income_statementBean();
					insert.setIncome_StatementPK(new Income_statementPK(co_id, m, i));
					insert.setRevenues(sales);
					insert.setCosts(costs);
					insert.setGross_profit(gp);
					insert.setOperating_expense(op_costs);
					insert.setOperating_income(op_income);
					insert.setOther_revenues(other_costs);
					insert.setBefore_tax_income(before_tax);
					insert.setTax_expense(tax);
					insert.setNet_income(ni);
					is_bean.add(insert);

				}
			}
		}
		return is_bean;
	}
}
