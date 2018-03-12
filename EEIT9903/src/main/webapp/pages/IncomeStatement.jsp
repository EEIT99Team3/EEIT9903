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

<form action="<c:url value="/IncomeStatemet.controller" />">
	<jsp:include page="/common/header.html" />
		<main role="main" class="container mt-2">
		<div class="row">
			<div class="col-lg-3">
				<jsp:include page="/common/nav.html" /></div>
			<div class="col-lg-9">

				<div class="card">
					<div class="card-body">
						<div>
							<input type="text" name="iscorporation" width="20px"> 
							<input type="text" name="isyear" size="5px">
							<select
								name="isseason">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
							</select> 
							<input id="isquery" type="submit" value="查詢">
						</div>
						<div>${errors.input}</div>
						<table id="productTable" class="table table-bordered">
							<thead>
								<tr>
									<th>綜合損益表</th>
									<th>2017</th>
									<th>2016</th>
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
				</div>

			</div>
		</div>
		</main>  
</form>

	<script src="<c:url value="/js/jquery-3.3.1.min.js" />"></script>
	<script src="<c:url value="/js/bootstrap.min.js" />"></script>

</body>
</html>