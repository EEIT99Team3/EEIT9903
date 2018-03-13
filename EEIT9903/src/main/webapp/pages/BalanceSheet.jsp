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

<form action="<c:url value="/Statement/BalanceSheet" />">
<%-- 	<jsp:include page="/partial/header.html" /> --%>
		<main role="main" class="container mt-2">
		<div class="row">
			<div class="col-lg-3">
<%-- 				<jsp:include page="/partial/nav.html" /></div> --%>
			<div class="col-lg-9">

				<div class="card">
					<div class="card-body">
						<div>
							<input type="text" name="bscorporation" width="20px"> 
							<input type="text" name="bsyear" size="5px">
							<select
								name="bsseason">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
							</select> 
							<input id="bsquery" type="submit" value="查詢">
						</div>
						<div>${errors.input}</div>
						<table id="productTable" class="table table-bordered">
							<thead>
								<tr>
									<th>資產負債表</th>
									<th>2017</th>
									<th>2016</th>
								</tr>
							</thead>
							<tbody>
							<c:if test="${not empty bs_data}">
								<tr>
									<td>應收帳款</td>
									<td>${bs_data.bean1.account_receivables}</td>
									<td>${bs_data.bean2.account_receivables}</td>
								</tr>
								<tr>
									<td>存貨</td>
									<td>${bs_data.bean1.inventories}</td>
									<td>${bs_data.bean2.inventories}</td>
								</tr>
								<tr>
									<td>流動資產</td>
									<td>${bs_data.bean1.current_assets}</td>
									<td>${bs_data.bean2.current_assets}</td>
								</tr>
								<tr>
									<td>非流動資產</td>
									<td>${bs_data.bean1.non_current_assets}</td>
									<td>${bs_data.bean2.non_current_assets}</td>
								</tr>
								<tr>
									<td>總資產</td>
									<td>${bs_data.bean1.total_assets}</td>
									<td>${bs_data.bean2.total_assets}</td>
								</tr>
								<tr>
									<td>應付帳款</td>
									<td>${bs_data.bean1.account_payables}</td>
									<td>${bs_data.bean2.account_payables}</td>
								</tr>
								<tr>
									<td>流動負債</td>
									<td>${bs_data.bean1.current_liabilities}</td>
									<td>${bs_data.bean2.current_liabilities}</td>
								</tr>
								<tr>
									<td>非流動負債</td>
									<td>${bs_data.bean1.non_current_liabilities}</td>
									<td>${bs_data.bean2.non_current_liabilities}</td>
								</tr>
								<tr>
									<td>總負債</td>
									<td>${bs_data.bean1.total_liabilities}</td>
									<td>${bs_data.bean2.total_liabilities}</td>
								</tr>
								<tr>
									<td>股本</td>
									<td>${bs_data.bean1.captial_stock}</td>
									<td>${bs_data.bean2.captial_stock}</td>
								</tr>
								<tr>
									<td>總權益</td>
									<td>${bs_data.bean1.total_equity}</td>
									<td>${bs_data.bean2.total_equity}</td>
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