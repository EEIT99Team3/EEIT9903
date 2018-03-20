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

			<h2 style="padding-top: 50px">綜合損益表</h2>
			<form action="<c:url value="/Statement/IncomeStatement" />">
				<div class="table-responsive" style="padding-right: 400px">
					<div>
						<input type="text" name="iscorporation" width="20px"> <input
							type="text" name="isyear" size="5px"> <select
							name="isseason">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
						</select> <input id="isquery" type="submit" value="查詢">
					</div>
					<div>
						<span>${errors.input}</span><span>${errors.input2}</span><span>${errors.input3}</span>
					</div>
					<c:if test="${not empty is_data}">
						<div class="table-responsive" style="padding-right: 400px">
							<table class="table table-striped table-sm">
								<thead>
									<tr>
										<th>年份/季度(單位:仟元)</th>
										<th>${param.isyear}${param.isseason}</th>
										<th>${param.isyear-1}${param.isseason}</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${not empty is_data}">
										<tr>
											<td>營業收入</td>
											<td>${is_data.bean1.revenues}</td>
											<td>${is_data.bean2.revenues}</td>
										</tr>
										<tr>
											<td>營業成本</td>
											<td>${is_data.bean1.costs}</td>
											<td>${is_data.bean2.costs}</td>
										</tr>
										<tr>
											<td>營業毛利(毛損)</td>
											<td>${is_data.bean1.gross_profit}</td>
											<td>${is_data.bean2.gross_profit}</td>
										</tr>
										<tr>
											<td>營業費用</td>
											<td>${is_data.bean1.operating_expense}</td>
											<td>${is_data.bean2.operating_expense}</td>
										</tr>
										<tr>
											<td>營業利益(損失)</td>
											<td>${is_data.bean1.operating_income}</td>
											<td>${is_data.bean2.operating_income}</td>
										</tr>
										<tr>
											<td>營業外收入(費用)</td>
											<td>${is_data.bean1.other_revenues}</td>
											<td>${is_data.bean2.other_revenues}</td>
										</tr>
										<tr>
											<td>稅前淨利(淨損)</td>
											<td>${is_data.bean1.before_tax_income}</td>
											<td>${is_data.bean2.before_tax_income}</td>
										</tr>
										<tr>
											<td>所得稅費用</td>
											<td>${is_data.bean1.tax_expense}</td>
											<td>${is_data.bean2.tax_expense}</td>
										</tr>
										<tr>
											<td>稅後淨利(淨損)</td>
											<td>${is_data.bean1.net_income}</td>
											<td>${is_data.bean2.net_income}</td>
										</tr>
									</c:if>
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
