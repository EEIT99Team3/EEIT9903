package model.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Ratio;
import model.RatioId;
import model.dao.RatioDAOHibernate;

@Service
public class RatioService {
	public RatioService() {
	}
	@Autowired
	public RatioDAOHibernate RatioDAO;
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
			RatioDAO.setStatement(this.getStatement());
		}
		List<Ratio> list = RatioDAO.select();
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


}
