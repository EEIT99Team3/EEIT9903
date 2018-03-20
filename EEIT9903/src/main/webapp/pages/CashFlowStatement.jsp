<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
<title>EZStock綜合股情查詢系統</title>

<!-- Bootstrap core CSS -->
<c:url value="/js/aside.js" />
<link href="<c:url value="/lib/bootstrap.min.css" />" rel="stylesheet"
	type="text/css" />
<!-- Custom styles for this template -->
<link href="<c:url value="/lib/advanced Css/dashboard.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/css/aside.css" />" rel="stylesheet"
	type="text/css">
<script src="<c:url value="/lib/jquery-1.10.2.min.js" />"></script>
<script src="<c:url value="/lib/jquery-ui-1.10.3.custom.min.js" />"></script>
<script src="<c:url value="/js/aside.js" />"></script>
</head>

<body>
	<jsp:include page="/common/header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<jsp:include page="/common/nav.html"></jsp:include>
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
			<jsp:include page="/common/aside.jsp" /> <!-- 以下輸入各網頁不同的地方 -->

			<h2 style="padding-top: 50px">現金流量表</h2>
			<form action="<c:url value="/Statement/CashFlowStatement" />">
				<div>
					公司代號：<input type="text" name="cfcorporation" width="10px" value="${data}" >
					年度：<input type="text" name="cfyear" size="5px"> 
					季別：<select
						name="cfseason">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
					</select> <input id="cfquery" type="submit" value="查詢">
				</div>
				<div>
					<span>${errors.input}</span><span>${errors.input2}</span><span>${errors.input3}</span>
				</div>
				<c:if test="${not empty cf_data}">
					<div class="table-responsive" style="padding-right: 400px">
						<table id="cftable" class="table table-striped table-sm">
							<thead>
								<tr>
									<th>年份/季度(單位:仟元)</th>
									<th>${param.cfyear}${param.cfseason}</th>
									<th>${param.cfyear-1}${param.cfseason}</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>營業現金流量</td>
									<td>${cf_data.bean1.operating_cash_flow}</td>
									<td>${cf_data.bean2.operating_cash_flow}</td>
								</tr>
								<tr>
									<td>投資現金流量</td>
									<td>${cf_data.bean1.investing_cash_flow}</td>
									<td>${cf_data.bean2.investing_cash_flow}</td>
								</tr>
								<tr>
									<td>融資現金流量</td>
									<td>${cf_data.bean1.financing_cash_flow}</td>
									<td>${cf_data.bean2.financing_cash_flow}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</c:if>
			</form>

			<!-- 以上輸入各網頁不同的地方 --> </main>
		</div>
	</div>
	<jsp:include page="/common/footer.jsp" />
	<%-- 	<script src="<c:url value="/lib/jquery-3.3.1.min.js" />"></script> --%>
	<script>
		feather.replace()
	</script>
</body>

</html>
