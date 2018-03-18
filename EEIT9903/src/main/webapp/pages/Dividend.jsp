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
<script src="<c:url value="/lib/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/lib/jquery-ui-1.10.3.custom.min.js" />"></script>
<script src="<c:url value="/js/aside.js" />"></script>
</head>

<body>
	<jsp:include page="/common/header.html"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<jsp:include page="/common/nav.html"></jsp:include>
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
			<jsp:include page="/common/aside.jsp" /> <!-- 以下輸入各網頁不同的地方 -->

			<h2 style="padding-top: 20px">股利政策</h2>
			<canvas class="my-4" id="myChart" width="800" height="300"
				style="padding-right: 400px"></canvas>


			<!-- 以上輸入各網頁不同的地方 --> </main>
		</div>
	</div>
	<jsp:include page="/common/footer.jsp" />
	<%-- 	<script src="<c:url value="/lib/jquery-3.3.1.min.js" />"></script> --%>
	<script>
		feather.replace()
	</script>
	<!-- Graphs -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
	<script>
		
	</script>
	<script>
		
		$(document).ready(function() {

			$.getJSON("/EEIT9903/baseinfo/dividend", { }, function(data) {
// 				console.log(data.data[0].stock_id);

				var dataStock = [] , dataCash = [] , dataYear = [];

				for(var j=0 ; j < data.data.length ; j++) {
					dataCash.push([
						data.data[j].div_cash
					]);
				}
				
				for(var i=0 ; i < data.data.length ; i++) {
					dataStock.push([
						data.data[i].div_stock
					]);
				}
				
				for(var k=0 ; k < data.data.length ; k++) {
					dataYear.push([
						data.data[k].div_year
					]);
				}
// 				console.log(dataStock);
// 				console.log(dataCash);
// 				console.log(dataYear);

				var ctx = document.getElementById("myChart");
				var myChart = new Chart(ctx, {
					type : 'line',
					data : {
						labels : dataYear,
						datasets : [ {
							data : dataCash,
							lineTension : 0,
							backgroundColor : 'transparent',
							borderColor : '#007bff',
							borderWidth : 4,
							pointBackgroundColor : '#007bff'
						}, {
							data : dataStock,
							lineTension : 0,
							backgroundColor : 'transparent',
							borderColor : '#ff007f',
							borderWidth : 4,
							pointBackgroundColor : '#ff007f'
						} ]
					},
					options : {
						scales : {
							yAxes : [ {
								ticks : {
									beginAtZero : false
								}
							} ]
						},
						legend : {
							display : false,
						}
					}
				});
			})
		})
	</script>
</body>

</html>
