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
<link href="<c:url value="/lib/advanced Css/dashboardTable.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/css/aside.css" />" rel="stylesheet"
	type="text/css">
<script src="<c:url value="/lib/jquery-1.10.2.min.js" />"></script>
<script src="<c:url value="/lib/jquery-ui-1.10.3.custom.min.js" />"></script>
<script src="<c:url value="/js/aside.js" />"></script>
</head>

<body>
	<jsp:include page="/common/header.jsp"></jsp:include>

	<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
		<a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Company
			name</a> <input class="form-control form-control-dark w-100" type="text"
			placeholder="Search" aria-label="Search">
		<ul class="navbar-nav px-3">
			<li class="nav-item text-nowrap"><a class="nav-link" href="#">Sign
					out</a></li>
		</ul>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<jsp:include page="/common/nav.html"></jsp:include>
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
			<jsp:include page="/common/aside.jsp" /> <!-- 以下輸入各網頁不同的地方 -->

			<h2 style="padding-top: 20px">基本資料</h2>
			<div class="table-responsive" style="padding-right: 300px">
				<table class="table table-striped  blueTable"
					style="border: 3px #cccccc solid;" cellpadding="10" border='1' >

					<tbody  style="  font-size: 30px;">
					<tr>
							<td class="blue">公司代號:</td>
							<td class="stock_id white"></td>
							<td class="blue">公司名稱:</td>
							<td class="stock_name white"></td>
						</tr>
						<tr>
							<td>公司資本額:</td>
							<td class="stock_captial white"></td>
							<td>統一編號:</td>
							<td class="tax_number white"></td>
						</tr>
						<tr>
							<td>董事長:</td>
							<td class="stock_chairman white"></td>
							<td>總經理:</td>
							<td class="stock_manager white"></td>
						</tr>
						<tr>
							<td>公司網站:</td>
							<td colspan=3 class="stock_website white"></td>
						</tr>
					</tbody>
				</table>
			</div>

			<!-- 以上輸入各網頁不同的地方 --> </main>
		</div>
	</div>
	<jsp:include page="/common/footer.jsp" />
	<%-- 	<script src="<c:url value="/lib/jquery-3.3.1.min.js" />"></script> --%>
	<script>
		feather.replace()
	</script>
	<script>
		
		$(document).ready(function() {

			$.getJSON("/EEIT9903/baseinfo/company", { }, function(data) {
				$('.stock_id').text(data.stock_id);
				$('.stock_name').text(data.stock_name);
				$('.stock_chairman').text(data.chairman);
				$('.stock_manager').text(data.manager);
				$('.stock_captial').text(data.captial);
				$('.stock_website').text(data.stock_website);
				$('.tax_number').text(data.tax_number);
				
// 				console.log(data.stock_id);
// 				console.log(data.stock_name);
// 				console.log(data.chairman);
// 				console.log(data.manager);
// 				console.log(data.captial);
// 				console.log(data.stock_website);
// 				console.log(data.tax_number);
			})
		})
	</script>
</body>

</html>
