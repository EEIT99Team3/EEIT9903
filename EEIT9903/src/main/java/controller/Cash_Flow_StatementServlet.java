package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import model.Cash_flow_statementBean;
import model.Cash_flow_statementPK;
import model.service.Cash_flow_statementService;

public class Cash_Flow_StatementServlet extends HttpServlet {

	private Cash_flow_statementService service = null;

	@Override
	public void init() throws ServletException {
		ApplicationContext context = (ApplicationContext) this.getServletContext()
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		service = (Cash_flow_statementService) context.getBean("cash_flow_statementService");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 讀取資料
		String cf_id = request.getParameter("cfcorporation");
		String cf_year = request.getParameter("cfyear");
		String cf_season = request.getParameter("cfseason");

		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		request.setAttribute("errors", errors);

		if (cf_id == null || cf_id.trim().length() == 0) {
			errors.put("input", "請輸入股票代碼");
		}

		Integer year = 0;
		if (cf_year != null && cf_year.trim().length() != 0) {
			try {
				year = Integer.parseInt(cf_year);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("input", "年份別有誤，請輸入民國年");
			}
		}
		
		Integer season = 0;
		if (cf_season != null && cf_season.trim().length() != 0) {
			try {
				season = Integer.parseInt(cf_season);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("input", "季節別有誤");
			}
		}

		// 驗證資料
		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher("/pages/CashFlowStatement.jsp").forward(request, response);
			return;
		}

		// 呼叫model
		Cash_flow_statementPK PK1 = new Cash_flow_statementPK(cf_id, year, season);
		Cash_flow_statementPK PK2 = new Cash_flow_statementPK(cf_id, year-1, season);

		// 呼叫view
		Map<String, Cash_flow_statementBean> beans = new HashMap<>();
		Cash_flow_statementBean bean1 = service.select(PK1);
		Cash_flow_statementBean bean2 = service.select(PK2);
		beans.put("bean1", bean1);
		beans.put("bean2", bean2);
		
		request.setAttribute("cf_data", beans);
		request.getRequestDispatcher("/pages/CashFlowStatement.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
