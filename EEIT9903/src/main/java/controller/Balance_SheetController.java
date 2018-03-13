package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Balance_sheetBean;
import model.Balance_sheetPK;
import model.service.Balance_sheetService;

@Controller
public class Balance_SheetController {
	@Autowired
	private Balance_sheetService service;
	
	@RequestMapping(path= {"/Statement/BalanceSheet"}, method= {RequestMethod.GET, RequestMethod.POST})
	public String bsMethod(String bscorporation, String bsyear, String bsseason, Model model, HttpSession session) {

		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (bscorporation == null || bscorporation.trim().length() == 0) {
			errors.put("input", "請輸入股票代碼");
		}

		Integer year = 0;
		if (bsyear != null && bsyear.trim().length() != 0) {
			try {
				year = Integer.parseInt(bsyear);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("input", "年份別有誤，請輸入民國年");
			}
		}
		
		Integer season = 0;
		if (bsseason != null && bsseason.trim().length() != 0) {
			try {
				season = Integer.parseInt(bsseason);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("input", "季節別有誤");
			}
		}

		// 驗證資料
		if (errors != null && !errors.isEmpty()) {
			return "bsstatement.error";
		}

		// 呼叫model
		Balance_sheetPK PK1 = new Balance_sheetPK(bscorporation, year, season);
		Balance_sheetPK PK2 = new Balance_sheetPK(bscorporation, year-1, season);

		// 呼叫view
		Map<String, Balance_sheetBean> beans = new HashMap<>();
		Balance_sheetBean bean1 = service.select(PK1);
		Balance_sheetBean bean2 = service.select(PK2);
		beans.put("bean1", bean1);
		beans.put("bean2", bean2);
		
		session.setAttribute("bs_data", beans);
        return "bsstatement.success";
	}

}
