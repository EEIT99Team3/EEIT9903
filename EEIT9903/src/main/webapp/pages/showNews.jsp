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
	<jsp:include page="/common/header.html"></jsp:include>

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

			<h2 style="padding-top: 20px">Section title</h2>
			<div>
				<div class="col-xl-3 col-sm-6 mb-3 ">
<!-- 					<ul> -->
<!-- 						<li>公司: 代號:</li> -->
<!-- 					</ul> -->
					<ul style="font-size: 30px">
						<li>news</li>
						<li>news</li>
						<li>news</li>
						<li>news</li>
						<li>news</li>
						<li>news</li>
						<li>news</li>
						<li>news</li>
						<li>news</li>
						<li>news</li>
					</ul>

				</div>

			</div>

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
