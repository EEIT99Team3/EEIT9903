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
<link href="<c:url value="/lib/advanced Css/index.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/css/aside.css" />" rel="stylesheet"
	type="text/css">
<script src="<c:url value="/lib/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/lib/jquery-ui-1.10.3.custom.min.js" />"></script>
<script src="<c:url value="/js/aside.js" />"></script>
<!-- <link rel="shortcut icon" href="/images/stock.ico" type="image/icon" /> -->
<link rel="icon" href="<c:url value='/images/16x16.ico' />"  />
<!-- <link rel="icon" href="images/16x16.ico"  /> -->
</head>

<body>
	<jsp:include page="/common/header.html"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<%-- 			<jsp:include page="/common/nav.html"></jsp:include>		 --%>
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
			<%-- 			<jsp:include page="/common/aside.jsp" /> --%> <!-- 			<!-- 以下輸入各網頁不同的地方 -->
			--> <!-- 			<div class="row" style="padding-top: 800px"> --> <!-- 				<a href="#"><span data-feather="activity"></span>關鍵的財報圖表</a> <a -->
			<!-- 					href="#"><span data-feather=""></span></a> --> <!-- 			</div> -->
<!-- 			<div class="row" style="padding-right: 300px; padding-top: 770px"> -->
<!-- 				<div class="col-sm-4"> -->
<!-- 					<div class="card"> -->
<!-- 						<a href="#" class="btn"><span data-feather="bar-chart-2"></span>關鍵的財務報表</a> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="col-sm-4"> -->
<!-- 					<div class="card"> -->
<!-- 						<a href="#" class="btn"><span data-feather="crosshair"></span>精確的選股程式</a> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="col-sm-4"> -->
<!-- 					<div class="card"> -->
<!-- 						<div class="card"> -->
<!-- 							<a href="#" class="btn"><span data-feather="users"></span>深入的股票討論區</a> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
			<!-- 以上輸入各網頁不同的地方 --> </main>
		</div>
	</div>
	<jsp:include page="/common/footer.jsp" />
	<%-- 	<script src="<c:url value="/lib/jquery-3.3.1.min.js" />"></script> --%>
	<script>
		feather.replace()
	</script>
</body>

</html>
