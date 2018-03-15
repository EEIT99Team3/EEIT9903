<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EZStock綜合股情查詢系統</title>

<link rel="stylesheet" href="../lib/bootstrap.min.css">
<link rel="stylesheet" href="../lib/jumbotron.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/dt-1.10.16/datatables.min.css" />

</head>
<body>
	<jsp:include page="../common/header.html" />
	<main role="main" class="container mt-2" style="margin-left:50px">
	<div class="row" style="width: 700px">
		<div class="col-lg-3" style="padding: 0px; width: 180px">
		<div class="col-lg-9" style="width: 1100px">

			<div class="card" style="width: 1100px">
				<div class="card-header" style="width: 1100px">歷史股價查詢</div>
				<div class="card-body" style="width: 1100px">
					<!-- 每頁不同的內容從這裡開始 -->
					<input id="stockid" type="text" value="" placeholder="請輸入股票代號">
					<input id="sub" type="submit">
				</div>
				<table id="table1"
					class="table table-bordered table-striped table-hover"
					style="width: 1000px">
					<thead>
						<tr>
							<th>stock_id</th>
							<th>rat_year</th>
							<th>rat_season</th>
							<th>eps</th>
							<th>bvps</th>
							<th>gp_margin</th>
							<th>op_margin</th>
							<th>ni_margin</th>
							<th>roe</th>
							<th>roa</th>
							<th>ar_turnover</th>
							<th>inv_turnover</th>
							<th>ap_turnover</th>
							<th>debt_ratio</th>
							<th>current_ratio</th>
							<th>fcf_growth</th>
							<th>ocf_growth</th>
							<th>revenues_growth</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				<!-- 每頁不同的內容到這裡結束 -->
			</div>
		</div>


		<jsp:include page="../common/sections.html" />
	</div>
	</div>
	</main>

	<jsp:include page="../common/footer.jsp" />
	<script src="../lib/jquery-3.3.1.min.js"></script>
	<script src="../lib/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.16/datatables.min.js"></script>
		<script>
	 		var table = null;
	  		var stockid = document.getElementById("stockid");
	 		function condition() {//動態產生查詢條件
	  			var cond = "/EEIT9903/h/RatioController?stock_id=" + stockid.value.toString();
	  			return cond;
	  		}

	 		$(document).ready(function() {
	 			table = $('#table1').DataTable({
	 				ajax : "/EEIT9903/RatioController?stock_id=2330",
	 				columns : [ {
	 					"data" : "stock_id"
	 				}, {
	 					"data" : "rat_year"
	 				}, {
	 					"data" : "rat_season"
	 				}, {
						"data" : "eps"
	 				}, {
	 					"data" : "bvps"
	 				}, {
						"data" : "gp_margin"
					}, {
						"data" : "op_margin"
	 				}, {
						"data" : "ni_margin"
					}, {
	 					"data" : "roe"
	 				}, {
	 					"data" : "roa"
	 				} , {
	 					"data" : "ar_turnover"
	 				} , {
	 					"data" : "inv_turnover"
	 				} , {
	 					"data" : "ap_turnover"
	 				} , {
	 					"data" : "debt_ratio"
	 				} , {
	 					"data" : "current_ratio"
	 				} , {
	 					"data" : "fcf_growth"
	 				} , {
	 					"data" : "ocf_growth"
	 				} , {
	 					"data" : "revenues_growth"
	 				}]
				});

			});

	 		$('#sub').click(function() {
	 			table.ajax.url(condition());
				table.ajax.reload();
		});
		</script>
</body>
</html>