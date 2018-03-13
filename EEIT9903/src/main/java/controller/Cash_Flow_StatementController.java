package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Cash_flow_statementBean;
import model.Cash_flow_statementPK;
import model.service.Cash_flow_statementService;

@Controller
public class Cash_Flow_StatementController {
	@Autowired
	private Cash_flow_statementService service;
	
	@RequestMapping(path={"/Statement/CashFlowStatement"}, method= {RequestMethod.GET, RequestMethod.POST})
	public String cfMethod(String cfcorporation, String cfyear, String cfseason, Model model, HttpSession session) {

		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (cfcorporation == null || cfcorporation.trim().length() == 0) {
			errors.put("input", "請輸入股票代碼");
		}

		Integer year = 0;
		if (cfyear != null && cfyear.trim().length() != 0) {
			try {
				year = Integer.parseInt(cfyear);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("input", "年份別有誤，請輸入民國年");
			}
		}
		
		Integer season = 0;
		if (cfseason != null && cfseason.trim().length() != 0) {
			try {
				season = Integer.parseInt(cfseason);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("input", "季節別有誤");
			}
		}

		// 驗證資料
		if (errors != null && !errors.isEmpty()) {
			return "cfstatement.error";
		}

		// 呼叫model
		Cash_flow_statementPK PK1 = new Cash_flow_statementPK(cfcorporation, year, season);
		Cash_flow_statementPK PK2 = new Cash_flow_statementPK(cfcorporation, year-1, season);

		// 呼叫view
		Map<String, Cash_flow_statementBean> beans = new HashMap<>();
		Cash_flow_statementBean bean1 = service.select(PK1);
		Cash_flow_statementBean bean2 = service.select(PK2);
		beans.put("bean1", bean1);
		beans.put("bean2", bean2);
		
		session.setAttribute("cf_data", beans);
        return "cfstatement.success";
		
	}

}
