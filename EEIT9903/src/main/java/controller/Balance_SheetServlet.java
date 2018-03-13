package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import model.Balance_sheetBean;
import model.Balance_sheetPK;
import model.Income_statementBean;
import model.Income_statementPK;
import model.service.Balance_sheetService;
import model.service.Income_StatementService;

public class Balance_SheetServlet extends HttpServlet {

	private Balance_sheetService service = null;

	@Override
	public void init() throws ServletException {
		ApplicationContext context = (ApplicationContext) this.getServletContext()
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		service = (Balance_sheetService) context.getBean("balance_sheetService");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 讀取資料
		String bs_id = request.getParameter("bscorporation");
		String bs_year = request.getParameter("bsyear");
		String bs_season = request.getParameter("bsseason");

		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		request.setAttribute("errors", errors);

		if (bs_id == null || bs_id.trim().length() == 0) {
			errors.put("input", "請輸入股票代碼");
		}

		Integer year = 0;
		if (bs_year != null && bs_year.trim().length() != 0) {
			try {
				year = Integer.parseInt(bs_year);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("input", "年份別有誤，請輸入民國年");
			}
		}
		
		Integer season = 0;
		if (bs_season != null && bs_season.trim().length() != 0) {
			try {
				season = Integer.parseInt(bs_season);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("input", "季節別有誤");
			}
		}

		// 驗證資料
		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher("/pages/BalanceSheet.jsp").forward(request, response);
			return;
		}

		// 呼叫model
		Balance_sheetPK PK1 = new Balance_sheetPK(bs_id, year, season);
		Balance_sheetPK PK2 = new Balance_sheetPK(bs_id, year-1, season);

		// 呼叫view
		Map<String, Balance_sheetBean> beans = new HashMap<>();
		Balance_sheetBean bean1 = service.select(PK1);
		Balance_sheetBean bean2 = service.select(PK2);
		beans.put("bean1", bean1);
		beans.put("bean2", bean2);
		
		request.setAttribute("bs_data", beans);
		request.getRequestDispatcher("/pages/BalanceSheet.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
