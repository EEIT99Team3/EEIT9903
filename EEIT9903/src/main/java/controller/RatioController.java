package controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.service.RatioService;

@Controller("ratio")
public class RatioController {
	@Autowired
	RatioService service = null;
	String[] statement = null;
	@RequestMapping(path= {"/choose"}, method= {RequestMethod.GET, RequestMethod.POST})
	public String method() {
		System.out.println("準備丟出choose page");
		return "RatioController";
	}
	@RequestMapping(
			path= {"/data"},
			method= {RequestMethod.GET,RequestMethod.POST},
			produces = "application/json;charset=UTF-8"
			)
	public @ResponseBody String getData(String ratyear,String ratseason,String eps,String bvps,
			String gpmargin,String opmargin,String nimargin,String roe,String roa,String arturnover,String invturnover,
			String apturnover,String debtratio,String currentratio,String fcfgrowth,String ocfgrowth,String revenuesgrowth) {
		ArrayList<String> list = new ArrayList<String>();
		if (ratyear != null) {
			list.add("rat_year");
			list.add("=");
			list.add("'" + ratyear + "'");

		}
		if (ratseason != null) {
			list.add("rat_season");
			list.add("=");
			list.add("'" + ratseason + "'");

		}
		if (eps != null) {
			list.add("eps");
			list.add(">=");
			list.add("'" + eps + "'");

		}
		if (bvps != null) {
			list.add("bvps");
			list.add(">=");
			list.add("'" + bvps + "'");

		}
		if (gpmargin != null) {
			list.add("gp_margin");
			list.add(">=");
			list.add("'" + gpmargin + "'");

		}
		if (opmargin != null) {
			list.add("op_margin");
			list.add(">=");
			list.add("'" + opmargin + "'");

		}
		if (nimargin != null) {
			list.add("ni_margin");
			list.add(">=");
			list.add("'" + nimargin + "'");

		}
		if (roe != null) {
			list.add("roe");
			list.add(">=");
			list.add("'" + roe + "'");

		}
		if (roa != null) {
			list.add("roa");
			list.add(">=");
			list.add("'" + roa + "'");

		}
		if (arturnover != null) {
			list.add("ar_turnover");
			list.add(">=");
			list.add("'" + arturnover + "'");

		}
		if (invturnover != null) {
			list.add("inv_turnover");
			list.add(">=");
			list.add("'" + invturnover + "'");

		}
		if (apturnover != null) {
			list.add("ap_turnover");
			list.add("<=");
			list.add("'" + apturnover + "'");

		}
		if (debtratio != null) {
			list.add("debt_ratio");
			list.add("<=");
			list.add("'" + debtratio + "'");

		}
		if (currentratio != null) {
			list.add("current_ratio");
			list.add("<=");
			list.add("'" + currentratio + "'");

		}
		if (fcfgrowth != null) {
			list.add("fcf_growth");
			list.add(">=");
			list.add("'" + fcfgrowth + "'");

		}
		if (ocfgrowth != null) {
			list.add("ocf_growth");
			list.add(">=");
			list.add("'" + ocfgrowth + "'");

		}
		if (revenuesgrowth != null) {
			list.add("revenues_growth");
			list.add(">=");
			list.add("'" + revenuesgrowth + "'");

		}
		if (list != null) {
			String[] a = new String[list.size()];
			statement = list.toArray(a);
			System.out.println(statement.toString());
			service.setStatement(statement);
		}
		return service.getRatioJson();
		
	}
}
