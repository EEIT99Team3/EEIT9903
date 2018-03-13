<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EZStock綜合股情查詢系統</title>

<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />">
<link rel="stylesheet" href="<c:url value="/css/jumbotron.css" />">
<script defer
	src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
</head>
<body>

<form action="<c:url value="/Statement/CashFlowStatement" />">
<%-- 	<jsp:include page="/partial/header.html" /> --%>
		<main role="main" class="container mt-2">
		<div class="row">
			<div class="col-lg-3">
<%-- 				<jsp:include page="/partial/nav.html" /></div> --%>
			<div class="col-lg-9">

				<div class="card">
					<div class="card-body">
						<div>
							<input type="text" name="cfcorporation" width="20px"> 
							<input type="text" name="cfyear" size="5px">
							<select
								name="cfseason">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
							</select> 
							<input id="cfquery" type="submit" value="查詢">
						</div>
						<div>${errors.input}</div>
						<c:if test="${not empty cf_data}">
						<table id="productTable" class="table table-bordered">
							<thead>
								<tr>
									<th>現金流量表</th>
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
                        </c:if>
					</div>
				</div>

			</div>
		</div>
		</main>  
</form>

	<script src="<c:url value="/js/jquery-3.3.1.min.js" />"></script>
	<script src="<c:url value="/js/bootstrap.min.js" />"></script>

</body>
</html>