<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.hibernate.*" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.*" %>
<%@ page import="model.*" %>
<%@ page import="model.dao.*" %>
<%@ page import="model.service.*" %>
<%@ page import="java.util.*" %>

<%
ApplicationContext context = (ApplicationContext)
		application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

// HighStockService highStockService = (HighStockService) context.getBean("highStockService");
// highStockService bean1 = highStockServicelogin("Alex", "A");
// out.println("<h3>bean="+bean1+"</h3>");

PriceDAO priceDAO = (PriceDAO) context.getBean("priceDAOHibernate");
List<Price> beans1 = priceDAO.select();
//out.println("<h3>beans1="+beans1+"</h3>");

HighStockService service = (HighStockService) context.getBean("highStockService");
org.json.JSONArray beans2 = service.select("0050");
out.println("<h3>beans2="+beans2+"</h3>");
%>

</body>
</html>
