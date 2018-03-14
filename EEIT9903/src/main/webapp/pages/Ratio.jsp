<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EZStock綜合股情查詢系統</title>

<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/jumbotron.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/dt-1.10.16/datatables.min.css" />

</head>
<body>
	<jsp:include page="../common/header.html" />
	<main role="main" class="container mt-2" style="margin-left:50px">
	<div class="row" style="width: 700px">
		<div class="col-lg-3" style="padding: 0px; width: 180px">
			<jsp:include page="../common/nav.html" /></div>
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
							<th>股票代號</th>
							<th>股票名稱</th>
							<th>日期</th>
							<th>開盤價</th>
							<th>收盤價</th>
							<th>最高價</th>
							<th>最低價</th>
							<th>本益比</th>
							<th>殖利率</th>
							<th>買賣股數</th>
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
	<script src="../js/jquery-3.3.1.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/v/bs4/dt-1.10.16/datatables.min.js"></script>
<!-- 	<script> -->
<!--  		var table = null; -->
<!--  		var stockid = document.getElementById("stockid"); -->
<!--  		function condition() {//動態產生查詢條件 -->
<!--  			var cond = "/EEIT9903/h/RatioController?stock_id=" + stockid.value.toString(); -->
<!--  			return cond; -->
<!--  		} -->

<!--  		$(document).ready(function() { -->
<!--  			table = $('#table1').DataTable({ -->
<!--  				ajax : "/EEIT9903/h/RatioController?stock_id=2330", -->
<!--  				columns : [ { -->
<!--  					"data" : "stockId" -->
<!--  				}, { -->
<!--  					"data" : "stockName" -->
<!--  				}, { -->
<!--  					"data" : "priceDate" -->
<!--  				}, { -->
<!-- 					"data" : "priceOpen" -->
<!--  				}, { -->
<!--  					"data" : "priceClose" -->
<!--  				}, { -->
<!-- 				"data" : "priceHighest" -->
<!-- 				}, { -->
<!-- 					"data" : "priceLowest" -->
<!--  				}, { -->
<!-- 					"data" : "peRatio" -->
<!-- 				}, { -->
<!--  					"data" : "yieldRate" -->
<!--  				}, { -->
<!--  					"data" : "volume" -->
<!--  				} ] -->
<!-- 			}); -->

<!-- 		}); -->

<!--  		$('#sub').click(function() { -->
<!--  			table.ajax.url(condition()); -->
<!-- 			table.ajax.reload(); -->
<!-- 	}); -->
<!-- 	</script> -->
</body>
</html>