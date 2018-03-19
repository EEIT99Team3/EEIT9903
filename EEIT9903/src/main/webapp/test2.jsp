<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="model.*" %>
<%@ page import="model.service.*"%>
<%@ page import="org.hibernate.*" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.util.*" %>

<% 
ApplicationContext context = (ApplicationContext)
     application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
// Balance_sheetDAO dao = (Balance_sheetDAO) context.getBean("balance_sheetDAOHibernate");
// Balance_sheetBean bean = dao.select(new Balance_sheetPK("2330", 105, 4));
// out.println(bean);

// Income_statementDAO dao2 = (Income_statementDAO) context.getBean("income_statementDAOHibernate");
// Income_statementBean bean2 = dao2.select(new Income_statementPK("2317", 105, 4));
// out.println(bean2);

// Cash_flow_statementDAO dao3 = (Cash_flow_statementDAO) context.getBean("cash_flow_statementDAOHibernate");
// Cash_flow_statementBean bean3 = dao3.select(new Cash_flow_statementPK("2317", 105, 4));
// out.println(bean3);

// Balance_sheetService test = (Balance_sheetService) context.getBean("balance_sheetService");
// test.insert();

Income_StatementService test2 = (Income_StatementService) context.getBean("income_StatementService");
test2.insert();

// Cash_flow_statementService test3 = (Cash_flow_statementService) context.getBean("cash_flow_statementService");
// test3.insert();

// SupervisorService service = (SupervisorService) context.getBean("supervisorService");
// LinkedList<HashMap<String, Object>> test = service.select(null);
// out.println(test);

%>

</body>
</html>