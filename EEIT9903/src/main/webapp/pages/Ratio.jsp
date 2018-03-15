<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EZStock綜合股情查詢系統</title>

<link rel="stylesheet" href="<c:url value="/lib/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/lib/jumbotron.css"/>"/>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/dt-1.10.16/datatables.min.css" />
</head>
<body>
	<jsp:include page="/common/header.html"/>
	<main role="main" class="container mt-2" style="margin-left:50px">
	<div class="row" style="width: 700px">
		<div class="col-lg-3" style="padding: 0px; width: 180px">
		<div class="col-lg-9" style="width: 1800px">

<!-- 下面這個是table外框 -->
			<div class="card" style="width: 1800px">
				<div class="card-header" style="width: 1800px">基本面指標建議選股</div>
				<div class="card-body" style="width: 1800px">
					<!-- 每頁不同的內容從這裡開始 -->
					<input id="stockid" type="text" value="" placeholder="請輸入股票代號">
					<input id="ratyear" type="text" value="" placeholder="請輸入年">
					<input id="ratseason" type="text" value="" placeholder="請輸入季">
					<input id="eps" type="text" value="" placeholder="請輸入EPS>?">
					<input id="bvps" type="text" value="" placeholder="請輸入每股淨值>?">
					<input id="gpmargin" type="text" value="" placeholder="毛利率>?">
					<input id="opmargin" type="text" value="" placeholder="營業利益率>?">
					<input id="nimargin" type="text" value="" placeholder="稅後淨利率>?">
					<input id="roe" type="text" value="" placeholder="ROE(股東權益報酬率)>?">
					<input id="roa" type="text" value="" placeholder="ROA(資產報酬率)>?">
					<input id="arturnover" type="text" value="" placeholder="應收帳款周轉率>?">
					<input id="invturnover" type="text" value="" placeholder="存貨周轉率 >?">
					<input id="apturnover" type="text" value="" placeholder="應付帳款周轉率 <?">
					<input id="debtratio" type="text" value="" placeholder="負債比率 <?">
					<input id="currentratio" type="text" value="" placeholder="流動比率 <?">
					<input id="fcfgrowth" type="text" value="" placeholder="自由現金流量年成長率 >?">
					<input id="ocfgrowth" type="text" value="" placeholder="營業現金流量年成長率>?">
					<input id="revenuesgrowth" type="text" value="" placeholder="營收成長率>?">
					<input id="sub" type="submit">
				</div>
				<table id="table1"
					class="table table-bordered table-striped table-hover"
					style="width: 1800px">
					<thead>
						<tr>
							<th>股票代號</th>
							<th>年份</th>
							<th>季別</th>
							<th>EPS</th>
							<th>每股淨值</th>
							<th>毛利率</th>
							<th>營業利益率</th>
							<th>稅後淨利率</th>
							<th>ROE</th>
							<th>ROA</th>
							<th>應收帳款周轉率</th>
							<th>存貨周轉率</th>
							<th>應付帳款周轉率</th>
							<th>負債比率</th>
							<th>流動比率</th>
							<th>自由現金流量年成長率</th>
							<th>營業現金流量年成長率>?</th>
							<th>營收成長率</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				<!-- 每頁不同的內容到這裡結束 -->
			</div>
		</div>


		<jsp:include page="/common/sections.html"/>
	</div>
	</div>
	</main>

	<jsp:include page="/common/footer.jsp"/>
	<script src="<c:url value="/lib/jquery-3.3.1.min.js"/>"></script>
	<script src="<c:url value="/lib/bootstrap.min.js"/>"></script>
	<script type="text/javascript" src="cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.16/datatables.min.js"></script>
		<script>
	 		var table = null;
	  		var stockid = document.getElementById("stockid");
	  		var ratyear = document.getElementById("ratyear");
	  		var ratseason = document.getElementById("ratseason");
	  		var eps = document.getElementById("eps");
	  		var bvps = document.getElementById("bvps");
	  		var gpmargin = document.getElementById("gpmargin");
	  		var opmargin = document.getElementById("opmargin");
	  		var nimargin = document.getElementById("nimargin");
	  		var roe = document.getElementById("roe");
	  		var roa = document.getElementById("roa");
	  		var arturnover = document.getElementById("arturnover");
	  		var invturnover = document.getElementById("invturnover");
	  		var apturnover = document.getElementById("apturnover");
	  		var debtratio = document.getElementById("debtratio");
	  		var currentratio = document.getElementById("currentratio");
	  		var fcfgrowth = document.getElementById("fcfgrowth");
	  		var ocfgrowth = document.getElementById("ocfgrowth");
	  		var revenuesgrowth = document.getElementById("revenuesgrowth");

	 		function condition() {//動態產生查詢條件
	  		var cond = "/EEIT9903/RatioController?";
	 		cond+="stockid="+stockid.value.toString();
	 		if(ratyear.value!=""){
		 		
		 		cond+="&ratyear="+ratyear.value.toString();};
	 		if(ratseason.value!=""){cond+="&ratseason="+ratseason.value.toString();
	 		table.column(0).visible(true);};
	 		if(eps.value!=""){cond+="&eps="+eps.value.toString()};
	 		if(bvps.value!=""){cond+="&bvps="+bvps.value.toString()};
	 		if(gpmargin.value!=""){cond+="&gpmargin="+gpmargin.value.toString()};
	 		if(opmargin.value!=""){cond+="&opmargin="+opmargin.value.toString()};
	 		if(nimargin.value!=""){cond+="&nimargin="+nimargin.value.toString()};
	 		if(roe.value!=""){cond+="&roe="+roe.value.toString()};
	 		if(roa.value!=""){cond+="&roa="+roa.value.toString()};
	 		if(arturnover.value!=""){cond+="&arturnover="+arturnover.value.toString()};
	 		if(invturnover.value!=""){cond+="&invturnover="+invturnover.value.toString()};
	 		if(apturnover.value!=""){cond+="&apturnover="+apturnover.value.toString()};
	 		if(debtratio.value!=""){cond+="&debtratio="+debtratio.value.toString()};
	 		if(currentratio.value!=""){cond+="&currentratio="+stockid.value.toString()};
	 		if(fcfgrowth.value!=""){cond+="&fcfgrowth="+stockid.value.toString()};
	 		if(ocfgrowth.value!=""){cond+="&ocfgrowth="+stockid.value.toString()};
	 		if(revenuesgrowth.value!=""){cond+="&revenuesgrowth="+stockid.value.toString()};
	  			return cond;
	  		}

	 		$(document).ready(function() {
	 			table = $('#table1').DataTable({
	 				ajax : "/EEIT9903/RatioController?",
	 				columns : [ {
	 					"visible": true,
	 					"data" : "stock_id"
	 				}, {
	 					"visible": true,
	 					"data" : "rat_year"
	 				}, {
	 					"visible": true,
	 					"data" : "rat_season"
	 				}, {
	 					"visible": false,
						"data" : "eps"
	 				}, {
	 					"visible": false,
	 					"data" : "bvps"
	 				}, {
	 					"visible": false,
						"data" : "gp_margin"
					}, {
						"visible": false,
						"data" : "op_margin"
	 				}, {
	 					"visible": false,
						"data" : "ni_margin"
					}, {
	 					"visible": false,
	 					"data" : "roe"
	 				}, {
	 					"data" : "roa"
	 				} , {
	 					"visible": false,
	 					"data" : "ar_turnover"
	 				} , {
	 					"visible": false,
	 					"data" : "inv_turnover"
	 				} , {
	 					"visible": false,
	 					"data" : "ap_turnover"
	 				} , {
	 					"visible": false,
	 					"data" : "debt_ratio"
	 				} , {
	 					"visible": false,
	 					"data" : "current_ratio"
	 				} , {
	 					"visible": false,
	 					"data" : "fcf_growth"
	 				} , {
	 					"visible": false,
	 					"data" : "ocf_growth"
	 				} , {
	 					"visible": false,
	 					"data" : "revenues_growth"
	 				}]
				});

			});

	 		$('#sub').click(function() {
	 			table.ajax.url(condition());
				table.ajax.reload();
// 				$('#table1 th:nth-child(3)').css('display','none');
// 				$('#table1>tbody tr td').css('display','none');
				
		});
		</script>
</body>
</html>