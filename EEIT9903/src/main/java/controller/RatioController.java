package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import model.service.RatioService;

@WebServlet("/RatioController")
public class RatioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RatioService service = null;

	@Override
	public void init() throws ServletException {
		System.out.println(this.getServletContext());
		ApplicationContext context = (ApplicationContext) this.getServletContext()
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		service = (RatioService) context.getBean("ratioService");
		System.out.println(service);
	}

	String[] statement = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("time for doGet/doPost");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("content-type", "application/Json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		// 接收前端丟進來的get條件陣列
//		String stockid = request.getParameter("stockid");
		String ratyear = request.getParameter("ratyear");
		String ratseason = request.getParameter("ratseason");
		String eps = request.getParameter("eps");
		String bvps = request.getParameter("bvps");
		String gpmargin = request.getParameter("gpmargin");
		String opmargin = request.getParameter("opmargin");
		String nimargin = request.getParameter("nimargin");
		String roe = request.getParameter("roe");
		String roa = request.getParameter("roa");
		String arturnover = request.getParameter("arturnover");
		String invturnover = request.getParameter("invturnover");
		String apturnover = request.getParameter("apturnover");
		String debtratio = request.getParameter("debtratio");
		String currentratio = request.getParameter("currentratio");
		String fcfgrowth = request.getParameter("fcfgrowth");
		String ocfgrowth = request.getParameter("ocfgrowth");
		String revenuesgrowth = request.getParameter("revenuesgrowth");
		ArrayList<String> list = new ArrayList<String>();
//		if (stockid != null) {
//			list.add("stock_id");
//			list.add("=");
//			list.add("'" + stockid + "'");
//
//		}
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
		out.println(service.getRatioJson());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
