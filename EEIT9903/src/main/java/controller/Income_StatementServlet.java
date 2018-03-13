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

import model.Income_statementBean;
import model.Income_statementPK;
import model.service.Income_StatementService;

public class Income_StatementServlet extends HttpServlet {

	private Income_StatementService service = null;

	@Override
	public void init() throws ServletException {
		ApplicationContext context = (ApplicationContext) this.getServletContext()
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		service = (Income_StatementService) context.getBean("income_StatementService");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 讀取資料
		String is_id = request.getParameter("iscorporation");
		String is_year = request.getParameter("isyear");
		String is_season = request.getParameter("isseason");

		// 轉換資料
		Map<String, String> errors = new HashMap<>();
		request.setAttribute("errors", errors);

		if (is_id == null || is_id.trim().length() == 0) {
			errors.put("input", "請輸入股票代碼");
		}

		Integer year = 0;
		if (is_year != null && is_year.trim().length() != 0) {
			try {
				year = Integer.parseInt(is_year);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("input", "年份別有誤，請輸入民國年");
			}
		}
		
		Integer season = 0;
		if (is_season != null && is_season.trim().length() != 0) {
			try {
				season = Integer.parseInt(is_season);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("input", "季節別有誤");
			}
		}

		// 驗證資料
		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher("/pages/IncomeStatement.jsp").forward(request, response);
			return;
		}

		// 呼叫model
		Income_statementPK PK1 = new Income_statementPK(is_id, year, season);
		Income_statementPK PK2 = new Income_statementPK(is_id, year-1, season);

		// 呼叫view
		Map<String, Income_statementBean> beans = new HashMap<>();
		Income_statementBean bean1 = service.select(PK1);
		Income_statementBean bean2 = service.select(PK2);
		beans.put("bean1", bean1);
		beans.put("bean2", bean2);
		
		request.setAttribute("is_data", beans);
		request.getRequestDispatcher("/pages/IncomeStatement.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
