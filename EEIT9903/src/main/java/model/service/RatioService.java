package model.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Balance_sheetBean;
import model.Balance_sheetDAO;
import model.CompanyDAO;
import model.Income_statementBean;
import model.Income_statementDAO;
import model.Ratio;
import model.RatioId;
import model.dao.RatioDAOHibernate;

@Service
@Transactional
public class RatioService {
	public RatioService() {
	}

	@Autowired
	public RatioDAOHibernate ratioDAO;
	
	@Autowired
	public Income_statementDAO incomeDAO;
	
	@Autowired
	public CompanyService companyService;
	
	@Autowired
	public Balance_sheetDAO BalDAO;
	
	@Autowired
	public RatioService service;
	
	private List<String> key;

	public List<String> getKey() {
		return key;
	}

	public void setKey(List<String> key) {
		this.key = key;
	}

	String[] statement = null;

	public String[] getStatement() {
		return statement;
	}

	public void setStatement(String[] statement) {
		this.statement = statement;
	}

	// 選股
	public String getRatioJson() {
		if (this.statement != null) {
			ratioDAO.setStatement(this.getStatement());
		}
		List<Ratio> list = ratioDAO.select();
		LinkedList<HashMap<String, String>> l1 = new LinkedList<HashMap<String, String>>();
		for (Ratio p : list) {
			HashMap<String, String> m1 = new HashMap<String, String>();
			m1.put("stock_id", p.getId().getStockId());
			m1.put("rat_year", p.getId().getRatYear().toString());
			m1.put("rat_season", p.getId().getRatSeason().toString());
			m1.put("eps", p.getEps().toString());
			m1.put("bvps", p.getBvps().toString());
			m1.put("gp_margin", p.getGpMargin().toString());
			m1.put("op_margin", p.getOpMargin().toString());
			m1.put("ni_margin", p.getNiMargin().toString());
			m1.put("roe", p.getRoe().toString());
			m1.put("roa", p.getRoa().toString());
			m1.put("ar_turnover", p.getArTurnover().toString());
			m1.put("inv_turnover", p.getInvTurnover().toString());
			m1.put("ap_turnover", p.getApTurnover().toString());
			m1.put("debt_ratio", p.getDebtRatio().toString());
			m1.put("current_ratio", p.getCurrentRatio().toString());
			m1.put("fcf_growth", p.getFcfGrowth().toString());
			m1.put("ocf_growth", p.getOcfGrowth().toString());
			m1.put("revenues_growth", p.getRevenuesGrowth().toString());

			l1.add(m1);
		}
		HashMap<String, LinkedList<HashMap<String, String>>> m2 = new HashMap<String, LinkedList<HashMap<String, String>>>();
		m2.put("data", l1);

		String jsonString = JSONValue.toJSONString(m2);
		return jsonString;
	}

	// 取得
	public String getRatioJson(RatioId id) {
		return null;
	}

	public void calcRatio(Integer ratyear, Integer ratseason) {
		List<Income_statementBean> listI = incomeDAO.select(ratyear, ratseason);
		List<Balance_sheetBean> listB = BalDAO.select(ratyear, ratseason);
		List<Income_statementBean> listIlast = incomeDAO.select(ratyear - 1, ratseason);
		List<Balance_sheetBean> listBlast = BalDAO.select(ratyear - 1, ratseason);
		HashMap<String, Income_statementBean> mI = new HashMap<String, Income_statementBean>();
		HashMap<String, Income_statementBean> mIlast = new HashMap<String, Income_statementBean>();
		HashMap<String, Balance_sheetBean> mB = new HashMap<String, Balance_sheetBean>();
		HashMap<String, Balance_sheetBean> mBlast = new HashMap<String, Balance_sheetBean>();
		HashMap<String, Ratio> mR = new HashMap<String, Ratio>();
		HashMap<String, Ratio> mRlast = new HashMap<String, Ratio>();
		Set<String> set = new HashSet<String>();
//
//		this.setKey(new ArrayList<String>());
		for (Income_statementBean i : listI) {
			String stockid = i.getIncome_StatementPK().getStock_id();
			mI.put(stockid, i);
			set.add(stockid);
		}
		for (Income_statementBean i : listIlast) {
			String stockid = i.getIncome_StatementPK().getStock_id();
			mIlast.put(stockid, i);
			set.add(stockid);
		}
		for (Balance_sheetBean i : listB) {
			String stockid = i.getBalance_sheetPK().getStock_id();
			mB.put(stockid, i);
			set.add(stockid);

		}
		for (Balance_sheetBean i : listBlast) {
			String stockid = i.getBalance_sheetPK().getStock_id();
			mBlast.put(stockid, i);
			set.add(stockid);
		}
		Set<String> temp = new HashSet<String>();
		for (String s : set) {
			if (!(mI.containsKey(s) && mIlast.containsKey(s) && mB.containsKey(s) && mBlast.containsKey(s))) {
				mI.remove(s);
				mB.remove(s);
				mIlast.remove(s);
				mBlast.remove(s);
				temp.add(s);
			}

		}

		for (String s : temp) {
			set.remove(s);
		}


		ArrayList<RatioServiceBean> arr = new ArrayList();

		for (String s : set) {
			arr.add(new RatioServiceBean(mI.get(s), mB.get(s), mIlast.get(s), mBlast.get(s)));
		}

		if (arr.size() != 0) {
			for (RatioServiceBean r : arr) {
				String stockid = r.income_statementBean.getIncome_StatementPK().getStock_id();
//				System.out.println();
				System.out.println("stockid:" + stockid);
				mR.put(stockid, new Ratio());
				mR.get(stockid).setId(new RatioId(stockid, ratyear, ratseason));
				// IB
				mR.get(stockid).setEps(service.calcEPS(r,stockid));
				mR.get(stockid).setRoe(service.calcROE(r));
				mR.get(stockid).setRoa(service.calcROA(r));
				// B
				mR.get(stockid).setBvps(service.calcBVPS(r,stockid));
				mR.get(stockid).setDebtRatio(service.calcDeptRatio(r));
				mR.get(stockid).setCurrentRatio(service.calcCurrentRatio(r));
				// I
				mR.get(stockid).setGpMargin(service.calcGPMargin(r));
				mR.get(stockid).setOpMargin(service.calcOPMargin(r));
				mR.get(stockid).setNiMargin(service.calcNIMargin(r));
				// IB2
				mR.get(stockid).setArTurnover(service.calcARTurnover(r));
				mR.get(stockid).setInvTurnover(service.calcINVTurnover(r));
				mR.get(stockid).setApTurnover(service.calcAPTurnover(r));
				//
				mR.get(stockid).setOcfGrowth(service.calcOCFGrowth(r));
				mR.get(stockid).setFcfGrowth(service.calcFCFGrowth(r));
				//
				mR.get(stockid).setRevenuesGrowth(service.calcRevenuesGrowth(r));
				ratioDAO.insert(mR.get(stockid));
			}
		}
	}

	// IB:calcEPS(Integer ratyear,Integer ratseason); calcROE(Integer
	// ratyear,Integer ratseason);calcROA(Integer ratyear,Integer ratseason);
	public BigDecimal calcEPS(RatioServiceBean r,String stockid) {
//		System.out.println("calcEPS:");
//		System.out.println(r.income_statementBean.getNet_income());
//		System.out.println(r.balance_sheetBean.getCaptial_stock());
//		System.out.println("EPS:"+((double)(r.income_statementBean.getNet_income()) / (double)(companyDAO.select(stockid).getCaptial()/10)));
//		System.out.println("================");
		return BigDecimal.valueOf((double)(r.income_statementBean.getNet_income()) / 
				(double)(r.balance_sheetBean.getCaptial_stock()/10));
	}

	public BigDecimal calcROE(RatioServiceBean r) {
//		System.out.println("calcROE:");
//		System.out.println(r.income_statementBean.getNet_income());
//		System.out.println(r.balance_sheetBean.getTotal_equity());
//		System.out.println("================");
		return BigDecimal.valueOf((double)(r.income_statementBean.getNet_income()*100) /(double) (r.balance_sheetBean.getTotal_equity()));
	}

	public BigDecimal calcROA(RatioServiceBean r) {
//		System.out.println("calcROA:");
//		System.out.println(r.income_statementBean.getNet_income());
//		System.out.println(r.balance_sheetBean.getAccount_payables());
//		System.out.println("================");
		return BigDecimal
				.valueOf((double)(r.income_statementBean.getNet_income()*100) /(double) (r.balance_sheetBean.getTotal_assets()));
	}

	// ***兩期:calcARTurnover(Integer ratyear,Integer
	// ratseason);calcINVTurnover(Integer ratyear,Integer
	// ratseason);calcAPTurnover(Integer ratyear,Integer ratseason) {};
	public BigDecimal calcARTurnover(RatioServiceBean r) {
//		System.out.println("calcARTurnover:");
//		System.out.println(r.income_statementBean.getRevenues());
//		System.out.println(
//				r.balance_sheetBean.getAccount_receivables() + r.balance_sheetBeanlast.getAccount_receivables());
//		System.out.println("================");
		//分子其實要隨季別變換
		return BigDecimal.valueOf((double)r.income_statementBean.getRevenues()
				/ ((double)(r.balance_sheetBean.getAccount_receivables() + (double)r.balance_sheetBeanlast.getAccount_receivables())
						/ 2));
	}

	public BigDecimal calcINVTurnover(RatioServiceBean r) {
//		System.out.println("calcINVTurnover:");
//		System.out.println(r.income_statementBean.getCosts());
//		System.out.println(r.balance_sheetBean.getInventories() + r.balance_sheetBeanlast.getInventories());
//		System.out.println("================");
		return BigDecimal.valueOf((double)r.income_statementBean.getCosts()
				/ ((double)(r.balance_sheetBean.getInventories() +(double) r.balance_sheetBeanlast.getInventories()) / 2));
	}

	public BigDecimal calcAPTurnover(RatioServiceBean r) {
//		System.out.println("calcAPTurnover:");
//		System.out.println(r.income_statementBean.getCosts());
//		System.out.println(r.balance_sheetBean.getAccount_payables() + r.balance_sheetBeanlast.getAccount_payables());
//		System.out.println("================");
		return BigDecimal.valueOf((double)r.income_statementBean.getCosts()
				/ (((double)r.balance_sheetBean.getAccount_payables() +(double) r.balance_sheetBeanlast.getAccount_payables()) / 2));
	}

	// I:calcGPMargin(Integer ratyear,Integer ratseason);calcOPMargin(Integer
	// ratyear,Integer ratseason);calcNIMargin(Integer ratyear,Integer ratseason);
	public BigDecimal calcGPMargin(RatioServiceBean r) {
//		System.out.println("calcGPMargin:"+(double)r.income_statementBean.getGross_profit() / (double)r.income_statementBean.getRevenues());
//		System.out.println("toBigDecimal:"+BigDecimal.valueOf(((double)r.income_statementBean.getGross_profit() / (double)r.income_statementBean.getRevenues())));
//		System.out.println(r.income_statementBean.getCosts());
//		System.out.println(r.income_statementBean.getRevenues());
//		System.out.println("================");
		return BigDecimal.valueOf(((double)r.income_statementBean.getGross_profit() / (double)r.income_statementBean.getRevenues()));
	}

	public BigDecimal calcOPMargin(RatioServiceBean r) {
//		System.out.println("calcOPMargin:");
//		System.out.println(r.income_statementBean.getOperating_income());
//		System.out.println(r.income_statementBean.getRevenues());
//		System.out.println("================");
		return BigDecimal
				.valueOf(((double)r.income_statementBean.getOperating_income() /(double) r.income_statementBean.getRevenues()));
	}

	public BigDecimal calcNIMargin(RatioServiceBean r) {
//		System.out.println("calcNIMargin:");
//		System.out.println(r.income_statementBean.getNet_income());
//		System.out.println(r.income_statementBean.getRevenues());
//		System.out.println("================");
		return BigDecimal.valueOf(((double)r.income_statementBean.getNet_income() / (double)r.income_statementBean.getRevenues()));
	}

	// ***兩期:calcRevenuesGrowth(Integer ratyear,Integer ratseason);
	public BigDecimal calcRevenuesGrowth(RatioServiceBean r) {
//		System.out.println("calcRevenuesGrowth:");
//		System.out.println(r.income_statementBean.getRevenues() - r.income_statementBeanlast.getRevenues());
//		System.out.println(r.income_statementBeanlast.getRevenues());
//		System.out.println("================");
		return BigDecimal.valueOf(100*((double)r.income_statementBean.getRevenues() - (double)r.income_statementBeanlast.getRevenues())
				/(double) r.income_statementBeanlast.getRevenues());
	}

	// B:calcBVPS(Integer ratyear,Integer ratseason);calcDeptRatio(Integer
	// ratyear,Integer ratseason);calcCurrentRatio(Integer ratyear,Integer
	// ratseason);
	public BigDecimal calcBVPS(RatioServiceBean r,String stockid) {
		System.out.println("calcBVPS:");
		System.out.println(r);
		System.out.println(r.balance_sheetBean.getTotal_equity() );
//		System.out.println((companyDAO.select(stockid).getCaptial()/10));
//		System.out.println(companyDAO);
		System.out.println((companyService.select(stockid)));
//		System.out.println("================");
		return BigDecimal.valueOf((double)r.balance_sheetBean.getTotal_equity() / (double)(companyService.select(stockid).getCaptial()/10));
	}

	public BigDecimal calcDeptRatio(RatioServiceBean r) {
//		System.out.println("calcDeptRatio:");
//		System.out.println(r.balance_sheetBean.getTotal_liabilities());
//		System.out.println(r.balance_sheetBean.getCurrent_liabilities());
//		System.out.println("================");
		return BigDecimal
				.valueOf((double)r.balance_sheetBean.getTotal_liabilities()*100 /(double) r.balance_sheetBean.getTotal_assets());
	}

	public BigDecimal calcCurrentRatio(RatioServiceBean r) {
//		System.out.println("calcCurrentRatio:");
//		System.out.println(r.balance_sheetBean.getCurrent_assets());
//		System.out.println(r.balance_sheetBean.getCurrent_liabilities());
//		System.out.println("================");
		return BigDecimal
				.valueOf((double)r.balance_sheetBean.getCurrent_assets()*100 / (double)r.balance_sheetBean.getCurrent_liabilities());
	}

	// C:***兩期 calcOCFGrowth(Integer ratyear,Integer ratseason);
	public BigDecimal calcOCFGrowth(RatioServiceBean r) {
		return BigDecimal.valueOf(0);
	}

	// 計算有困難
	public BigDecimal calcFCFGrowth(RatioServiceBean r) {
		return BigDecimal.valueOf(0);
	}
}
