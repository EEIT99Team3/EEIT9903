<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EZStock綜合股情查詢系統</title>

<link rel="stylesheet" href="<c:url value="/lib/bootstrap.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/lib/jumbotron.css"/>" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/dt-1.10.16/datatables.min.css" />
</head>
<body>
	<jsp:include page="/common/header.html" />
	<main role="main" class="container mt-2" style="margin-left:50px">
	<div class="row" style="width: 700px">
		<div class="col-lg-3" style="padding: 0px; width: 180px">
			<div class="col-lg-9" style="width: 1800px">

				<!-- 下面這個是table外框 -->
				<div class="card" style="width: 1800px">
					<div class="card-header" style="width: 1800px">基本面指標建議選股</div>
					<div class="card-body" style="width: 1800px">
						<!-- 每頁不同的內容從這裡開始 -->
			<div id="draggable" class="ui-widget-content">
				<p>Drag me to my target</p>
			</div>
			<div style="border:solid black 1px;width:450px;height:450px;margin:20px;float:left">
			<div class=condition id=epst style="border:solid black 1px;width:100px;height:100px;margin:20px;float:left">EPS</div>
			<div class=condition id=bvpst style="border:solid black 1px;width:100px;height:100px;margin:20px;float:left">每股淨值</div>
			<div class=condition id=gpmargint style="border:solid black 1px;width:100px;height:100px;margin:20px;float:left">毛利率</div>
			<div class=condition id=opmargint style="border:solid black 1px;width:100px;height:100px;margin:20px;float:left">營業利益率</div>
			<div class=condition id=nimargint style="border:solid black 1px;width:100px;height:100px;margin:20px;float:left">稅後淨利率</div>
			<div class=condition id=roet style="border:solid black 1px;width:100px;height:100px;margin:20px;float:left">稅後淨利率</div>
			<div class=condition id=roat style="border:solid black 1px;width:100px;height:100px;margin:20px;float:left">ROE</div>
			<div class=condition id=arturnovert style="border:solid black 1px;width:100px;height:100px;margin:20px;float:left">ROA</div>
			</div>
						<div class=choosed style="border:solid black 1px;width:500px;height:500px;margin:20px;float:left">選擇條件</div>
						
						<input class=condition id="stockid" type="text" value="" placeholder="請輸入股票代號" disabled>
						<input class=condition id="ratyear" type="text" value="" placeholder="請輸入年" disabled>
						<input class=condition id="ratseason" type="text" value="" placeholder="請輸入季" disabled>
						<input class=condition id="eps" type="text" value="" placeholder="請輸入EPS>?" disabled>
						<input class=condition id="bvps" type="text" value="" placeholder="請輸入每股淨值>?" disabled>
						<input class=condition id="gpmargin" type="text" value="" placeholder="毛利率>?" disabled>
						<input class=condition id="opmargin" type="text" value="" placeholder="營業利益率>?" disabled>
						<input class=condition id="nimargin" type="text" value="" placeholder="稅後淨利率>?" disabled>
						<input class=condition id="roe" type="text" value="" placeholder="ROE(股東權益報酬率)>?" disabled>
						<input class=condition id="roa" type="text" value="" placeholder="ROA(資產報酬率)>?" disabled>
						<input class=condition id="arturnover" type="text" value=""
							placeholder="應收帳款周轉率>?" disabled>
						<input id="invturnover" type="text" value="" placeholder="存貨周轉率 >?" disabled>
						<input id="apturnover" type="text" value="" placeholder="應付帳款周轉率 <?" disabled>
						<input id="debtratio" type="text" value="" placeholder="負債比率 <?" disabled>
						<input id="currentratio" type="text" value=""
							placeholder="流動比率 <?" disabled> <input id="fcfgrowth" type="text"
							value="" placeholder="自由現金流量年成長率 >?" disabled>
							<input
							id="ocfgrowth" type="text" value="" placeholder="營業現金流量年成長率>?" disabled>
						<input id="revenuesgrowth" type="text" value=""
							placeholder="營收成長率>?" disabled>
<!-- 							<div class="choosed"><p>Drop here</p></div> -->
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

			<jsp:include page="/common/sections.html" />
		</div>
	</div>
	</main>

	<jsp:include page="/common/footer.jsp" />
	<script src="<c:url value="/lib/jquery-3.3.1.min.js"/>"></script>
	<script src="<c:url value="/lib/bootstrap.min.js"/>"></script>
	<script type="text/javascript"
		src="cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/v/bs4/dt-1.10.16/datatables.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
		var dragged=null;
		function condition() {
			var cond = "/EEIT9903/ratio/data?";
			cond += "stockid=" + stockid.value.toString();
			if (ratyear.value != "") {
				cond += "&ratyear=" + ratyear.value.toString();
			}
			if (ratseason.value != "") {
				cond += "&ratseason=" + ratseason.value.toString();
			}
			if (eps.value != "") {
				cond += "&eps=" + eps.value.toString();
				table.column(3).visible(true);
			}else{table.column(3).visible(false);
			}
			if (bvps.value != "") {
				cond += "&bvps=" + bvps.value.toString();
				table.column(4).visible(true);
			}else{table.column(4).visible(false);
			}
			if (gpmargin.value != "") {
				cond += "&gpmargin=" + gpmargin.value.toString();
				table.column(5).visible(true);
			}else{table.column(5).visible(false);
			}
			if (opmargin.value != "") {
				cond += "&opmargin=" + opmargin.value.toString();
				table.column(6).visible(true);
			}else{table.column(6).visible(false);
			}
			if (nimargin.value != "") {
				cond += "&nimargin=" + nimargin.value.toString();
				table.column(7).visible(true);
			}else{table.column(7).visible(false);
			}
			if (roe.value != "") {
				cond += "&roe=" + roe.value.toString();
				table.column(8).visible(true);
			}else{table.column(8).visible(false);
			}
			if (roa.value != "") {
				cond += "&roa=" + roa.value.toString();
				table.column(9).visible(true);
			}else{table.column(9).visible(false);
			}
			if (arturnover.value != "") {
				cond += "&arturnover=" + arturnover.value.toString();
				table.column(10).visible(true);
			}else{table.column(10).visible(false);
			}
			if (invturnover.value != "") {
				cond += "&invturnover=" + invturnover.value.toString();
				table.column(11).visible(true);
			}else{table.column(11).visible(false);
			}
			if (apturnover.value != "") {
				cond += "&apturnover=" + apturnover.value.toString();
				table.column(12).visible(true);
			}else{table.column(12).visible(false);
			}
			if (debtratio.value != "") {
				cond += "&debtratio=" + debtratio.value.toString();
				table.column(13).visible(true);
			}else{table.column(13).visible(false);
			}
			if (currentratio.value != "") {
				cond += "&currentratio=" + stockid.value.toString();
				table.column(14).visible(true);
			}else{table.column(14).visible(false);
			}
			if (fcfgrowth.value != "") {
				cond += "&fcfgrowth=" + stockid.value.toString();
				table.column(15).visible(true);
			}else{table.column(15).visible(false);
			}
			if (ocfgrowth.value != "") {
				cond += "&ocfgrowth=" + stockid.value.toString();
				table.column(16).visible(true);
			}else{table.column(16).visible(false);
			}
			if (revenuesgrowth.value != "") {
				cond += "&revenuesgrowth=" + stockid.value.toString();
				table.column(17).visible(true);
			}else{table.column(17).visible(false);
			}
			return cond;
		}

// 		function condition() {//動態產生查詢條件
// 			var cond = "/EEIT9903/ratio/data?";
// 			cond += "stockid=" + stockid.value.toString();
// 			if (ratyear.value != "") {
// 				cond += "&ratyear=" + ratyear.value.toString();
// 			}
			
// 			if (ratseason.value != "") {
// 				cond += "&ratseason=" + ratseason.value.toString();
// 			}
			
// 			if (eps.value != "") {
// 				cond += "&eps=" + eps.value.toString();
// 			}
			
// 			if (bvps.value != "") {
// 				cond += "&bvps=" + bvps.value.toString();
// 			}
			
// 			if (gpmargin.value != "") {
// 				cond += "&gpmargin=" + gpmargin.value.toString();
// 			};
// 			if (opmargin.value != "") {
// 				cond += "&opmargin=" + opmargin.value.toString();
// 			}
// 			if (nimargin.value != "") {
// 				cond += "&nimargin=" + nimargin.value.toString();
// 			}
// 			if (roe.value != "") {
// 				cond += "&roe=" + roe.value.toString();
// 			}
// 			if (roa.value != "") {
// 				cond += "&roa=" + roa.value.toString();
// 			}
// 			if (arturnover.value != "") {
// 				cond += "&arturnover=" + arturnover.value.toString();
// 			}
// 			if (invturnover.value != "") {
// 				cond += "&invturnover=" + invturnover.value.toString();
// 			}
// 			if (apturnover.value != "") {
// 				cond += "&apturnover=" + apturnover.value.toString();
// 			};
// 			if (debtratio.value != "") {
// 				cond += "&debtratio=" + debtratio.value.toString();
// 			}
// 			if (currentratio.value != "") {
// 				cond += "&currentratio=" + stockid.value.toString();
// 			}
// 			if (fcfgrowth.value != "") {
// 				cond += "&fcfgrowth=" + stockid.value.toString();
// 			}
// 			if (ocfgrowth.value != "") {
// 				cond += "&ocfgrowth=" + stockid.value.toString();
// 			}
// 			if (revenuesgrowth.value != "") {
// 				cond += "&revenuesgrowth=" + stockid.value.toString();
// 			}
// 			return cond;
// 		}
		
		function dynamicolumn(){
		if (eps.value != "") {
			table.column(3).visible(true);
		}else{table.column(3).visible(false);
		}
		;
		if (bvps.value != "") {
			table.column(4).visible(true);
		}else{table.column(4).visible(false);
		}
		;
		if (gpmargin.value != "") {
			table.column(5).visible(true);
		}else{table.column(5).visible(false);
		}
		;
		if (opmargin.value != "") {
			table.column(6).visible(true);
		}else{table.column(6).visible(false);
		}
		;
		if (nimargin.value != "") {
			table.column(7).visible(true);
		}else{table.column(7).visible(false);
		}
		;
		if (roe.value != "") {
			table.column(8).visible(true);
		}else{table.column(8).visible(false);
		}
		;
		if (roa.value != "") {
			table.column(9).visible(true);
		}else{table.column(9).visible(false);
		}
		;
		if (arturnover.value != "") {
			table.column(10).visible(true);
		}else{table.column(10).visible(false);
		}
		;
		if (invturnover.value != "") {
			table.column(11).visible(true);
		}else{table.column(11).visible(false);
		}
		;
		if (apturnover.value != "") {
			table.column(12).visible(true);
		}else{table.column(12).visible(false);
		}
		;
		if (debtratio.value != "") {
			table.column(13).visible(true);
		}else{table.column(13).visible(false);
		}
		;
		if (currentratio.value != "") {
			table.column(14).visible(true);
		}else{table.column(14).visible(false);
		}
		;
		if (fcfgrowth.value != "") {
			table.column(15).visible(true);
		}else{table.column(15).visible(false);
		}
		;
		if (ocfgrowth.value != "") {
			table.column(16).visible(true);
		}else{table.column(16).visible(false);
		}
		;
		if (revenuesgrowth.value != "") {
			table.column(17).visible(true);
		}else{table.column(17).visible(false);
		}}
		$(document).ready(function() {
			table = $('#table1').DataTable({
				ajax : "/EEIT9903/ratio/data?",
				columns : [ {
					"visible" : true,
					"data" : "stock_id"
				}, {
					"visible" : true,
					"data" : "rat_year"
				}, {
					"visible" : true,
					"data" : "rat_season"
				}, {
					"visible" : false,
					"data" : "eps"
				}, {
					"visible" : false,
					"data" : "bvps"
				}, {
					"visible" : false,
					"data" : "gp_margin"
				}, {
					"visible" : false,
					"data" : "op_margin"
				}, {
					"visible" : false,
					"data" : "ni_margin"
				}, {
					"visible" : false,
					"data" : "roe"
				}, {
					"visible" : false,
					"data" : "roa"
				}, {
					"visible" : false,
					"data" : "ar_turnover"
				}, {
					"visible" : false,
					"data" : "inv_turnover"
				}, {
					"visible" : false,
					"data" : "ap_turnover"
				}, {
					"visible" : false,
					"data" : "debt_ratio"
				}, {
					"visible" : false,
					"data" : "current_ratio"
				}, {
					"visible" : false,
					"data" : "fcf_growth"
				}, {
					"visible" : false,
					"data" : "ocf_growth"
				}, {
					"visible" : false,
					"data" : "revenues_growth"
				} ]
			});

		});

		$('#sub').click(function() {
			table.ajax.url(condition());
			table.ajax.reload();
			dynamicolumn();
		});
		$(".condition").draggable({stop:function(){dragged=$(this).attr('id').toString();alert(dragged);}});
		$(".choosed").droppable({drop : function(event, ui){
			document.getElementById(dragged.toString()).disabled=false;
			}});
	</script>
</head>
<body>


</body>
</html>