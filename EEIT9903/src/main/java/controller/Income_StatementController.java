package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Income_statementBean;
import model.Income_statementPK;
import model.service.Income_StatementService;

@Controller
public class Income_StatementController {

	@Autowired
	private Income_StatementService service;

	@RequestMapping(path = { "/Statement/IncomeStatement" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String isMethod(String iscorporation, String isyear, String isseason, Model model, HttpSession session) {

		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (iscorporation == null || iscorporation.trim().length() == 0) {
			errors.put("input", "請輸入股票代碼　");
		}

		Integer year = 0;
		if (isyear == null || isyear.trim().length() == 0) {
			errors.put("input2", "年份別有誤，請輸入民國年　");
		}
		if (isyear != null && isyear.trim().length() != 0) {
			try {
				year = Integer.parseInt(isyear);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("input2", "年份別有誤，請輸入民國年　");
			}
		}

		Integer season = 0;
		if (isseason == null || isseason.trim().length() == 0) {
			errors.put("input3", "季節別有誤　");
		}
		if (isseason != null && isseason.trim().length() != 0) {
			try {
				season = Integer.parseInt(isseason);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("input3", "季節別有誤　");
			}
		}

		// 驗證資料
		if (errors != null && !errors.isEmpty()) {
			return "isstatement.error";
		}

		// 呼叫model
		Income_statementPK PK1 = new Income_statementPK(iscorporation, year, season);
		Income_statementPK PK2 = new Income_statementPK(iscorporation, year - 1, season);

		// 呼叫view
		Map<String, Income_statementBean> beans = new HashMap<>();
		Income_statementBean bean1 = service.select(PK1);
		Income_statementBean bean2 = service.select(PK2);
		beans.put("bean1", bean1);
		beans.put("bean2", bean2);

		session.setAttribute("is_data", beans);
		return "isstatement.success";

	}

}
