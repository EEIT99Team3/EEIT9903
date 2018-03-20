<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.highcharts.com/stock/highstock.js"></script>
<script src="https://code.highcharts.com/stock/modules/drag-panes.js"></script>
<script src="https://code.highcharts.com/stock/modules/exporting.js"></script>
<title>EZStock_HighStock</title>

<!-- Bootstrap core CSS -->

<link href="lib/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!-- Custom styles for this template -->
<link href="lib/advanced Css/dashboard.css" rel="stylesheet"
	type="text/css" />
</head>

<body>
	<jsp:include page="common/header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<jsp:include page="common/nav.html"></jsp:include>
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
			<div
				class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
				<h1 class="h2">DemoPage</h1>
				<div class="btn-toolbar mb-2 mb-md-0">
					<div class="btn-group mr-2">
						<button class="btn btn-sm btn-outline-secondary">Share</button>
						<button class="btn btn-sm btn-outline-secondary">Export</button>
					</div>
					<button class="btn btn-sm btn-outline-secondary dropdown-toggle">
						<span data-feather="calendar"></span> This week
					</button>
				</div>

			</div>
			<!-- 每頁不同的內容從這裡開始  -->
			<div class="container">
				<div class="main_highstock">
					<h2>穩健的報酬,更悠閒的生活</h2>
					<form id="search" method="post">
						<input type="text" id="stock_id" name="stock_id" value=""
							placeholder="請輸入股價代號"> <input type="button" value="查詢">
						<div id="stock_name"></div>
					</form>
				</div>
				<div id="container" style="height: 400px; min-width: 310px">準備載入股票圖表...</div>
			</div>

			<script>
				$(document).ready(function() {
					$("#search").change(function(event) {
														var url = '/EEIT9903/p/test.do';
														var stock_id = $(
																'#stock_id')
																.val();
														//		console.log("stock_id:" + stock_id);
														url = url
																+ "?stock_id="
																+ stock_id;
														//    /testWEB9903/p/test
														//    https://www.highcharts.com/samples/data/jsonp.php?filename=aapl-ohlcv.json&callback=?

														// 			if(stock_id == "2330" || stock_id == "0050" || stock_id == "2371")	
														// 			{	
														$.ajax({
																	type : "get",
																	url : url,
																	dataType : "json",
																	success : function(data) {
																		console.log(stock_id);
																		$('#stock_name').html("<h2>"
																								+ stock_id
																								+ "股價走勢圖"
																								+ "</h2>");
																		// split the data set into ohlc and volume
																		console.log(data);
																		var ohlc = [], volume = [], dataLength = data.length,
																		// set the allowed units for data grouping
																		groupingUnits = [
																				[
																						'week', // unit name
																						[ 1 ] // allowed multiples
																				],
																				[
																						'month',
																						[
																								1,
																								2,
																								3,
																								4,
																								6 ] ] ],

																		i = 0;

																		for (i; i < dataLength; i += 1) {
																			ohlc.push([
																							data[i][0], // the date
																							data[i][1], // open
																							data[i][2], // high
																							data[i][3], // low
																							data[i][4] // close
																					]);

																			volume.push([
																							data[i][0], // the date
																							data[i][5] // the volume
																					]);
																		}

																		// create the chart
																		Highcharts.stockChart(
																						'container',
																						{

																							rangeSelector : {
																								selected : 1
																							},

																							title : {
																								text : ''
																							},

																							yAxis : [
																									{
																										labels : {
																											align : 'right',
																											x : -3
																										},
																										title : {
																											text : '股價'
																										},
																										height : '60%',
																										lineWidth : 2,
																										resize : {
																											enabled : true
																										}
																									},
																									{
																										labels : {
																											align : 'right',
																											x : -3
																										},
																										title : {
																											text : '成交量'
																										},
																										top : '65%',
																										height : '35%',
																										offset : 0,
																										lineWidth : 2
																									} ],

																							tooltip : {
																								split : true
																							},

																							series : [
																									{
																										type : 'candlestick',
																										color : 'green',
																										lineColor : 'green',
																										upColor : 'red',
																										upLineColor : 'red',
																										type : 'candlestick',
																										data : ohlc,
																										dataGrouping : {
																											units : groupingUnits
																										}
																									},
																									{
																										type : 'column',
																										name : 'Volume',
																										data : volume,
																										yAxis : 1,
																										dataGrouping : {
																											units : groupingUnits
																										}
																									} ]
																						});
																	}
																})
														// 			}else{
														// 				alert("很抱歉,你輸入的股票代號無資料");
														// 				}    //end if
													}); //end event
								}); //end ready
			</script> <!-- 每頁不同的內容到這裡結束  -->
		</div>

	</div>
	<jsp:include page="common/footer.jsp" />
</body>
<style>
.main_highstock {
	margin-right: 150px;
	text-align: center;
}

#container {
	text-align: center;
}
</style>
</html>
