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
	RatioService service =null;
	@Override
	public void init() throws ServletException {
		System.out.println(this.getServletContext());
		ApplicationContext context = (ApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		service = (RatioService) context.getBean("ratioService");
		System.out.println(service);
	}
	String[]statement=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("time for doGet/doPost");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("content-type", "application/Json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		// 接收前端丟進來的get條件陣列
		String stockid = request.getParameter("stockid");
//		String date = request.getParameter("date");
		ArrayList<String> list = new ArrayList<String>();
		if (stockid != null) {
			list.add("stock_id");
			list.add("=");
			list.add("'"+stockid+"'");

		}
//		if (date != null) {
//			list.add("price_date");
//			list.add("=");
//			list.add(date);
//
//		}
		if (list != null) {
			String[]a =new String[list.size()];
			statement=list.toArray(a);
			System.out.println(statement.toString());
			service.setStatement(statement);
		}
//		System.out.println(service);
		out.println(service.getRatioJson());
		System.out.println("doGet/doPost end");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
