<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.highcharts.com/stock/highstock.js"></script>
<script src="https://code.highcharts.com/stock/modules/drag-panes.js"></script>
<script src="https://code.highcharts.com/stock/modules/exporting.js"></script>


<!-- 目前不用CDN都會失敗 路徑問題需要修正 -->
<!-- <link rel="stylesheet" href=""> -->
<!-- <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script> -->
<!-- /test/src/main/webapp/js/jquery-3.3.1.min.js -->
<script>
	$(document).ready(function(){


	$("#search").change(function(event) {
			var url = '/EEIT9903/p/test.do';
			var stock_id = $('#stock_id').val();
	//		console.log("stock_id:" + stock_id);
			url = url + "?stock_id=" + stock_id;
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
					$('#stock_name').html("<h2>"+stock_id+"股價走勢圖"+"</h2>");
					// split the data set into ohlc and volume
					console.log(data);
					var ohlc = [], volume = [], dataLength = data.length,
					// set the allowed units for data grouping
					groupingUnits = [ [ 'week', // unit name
					[ 1 ] // allowed multiples
					], [ 'month', [ 1, 2, 3, 4, 6 ] ] ],

					i = 0;

					for (i; i < dataLength; i += 1) {
						ohlc.push([ data[i][0], // the date
						data[i][1], // open
						data[i][2], // high
						data[i][3], // low
						data[i][4] // close
						]);

						volume.push([ data[i][0], // the date
						data[i][5] // the volume
						]);
					}

					// create the chart
					Highcharts.stockChart('container', {

						rangeSelector : {
							selected : 1
						},

						title : {
							text : ''
						},

						yAxis : [ {
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
						}, {
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

						series : [ {
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
						}, {
							type : 'column',
							name : 'Volume',
							data : volume,
							yAxis : 1,
							dataGrouping : {
								units : groupingUnits
							}
						}]
					});
				}
			})
// 			}else{
// 				alert("很抱歉,你輸入的股票代號無資料");
// 				}    //end if
 		});   //end event
	});   //end ready
</script>

<title>股價走勢圖查詢</title>
</head>
<body>
	<div class="container">
	<div class="main">
	<p>穩健的報酬,更悠閒的生活</p>
		<form id= "search" method="post">
			<input type="text" id="stock_id" name="stock_id" value="" placeholder="請輸入股價代號">
			<input type="button" value="查詢">
			<div id="stock_name"></div>
		</form>
	</div>	
		<div id="container" style="height: 400px; min-width: 310px">準備載入股票圖表...</div>
	</div>
</body>
<style>
 .main{
  	margin-top: 100px;
    margin-bottom: 100px;
    margin-right: 150px;
    margin-left: 80px;
/*    background-color: lightblue; */
    text-align:center;
 }
 #container{
 	text-align:center;
 }
</html>