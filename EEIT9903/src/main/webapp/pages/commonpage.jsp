<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<link href="<c:url value="/lib/bootstrap.min.css" />" rel="stylesheet" type="text/css"/>
<!-- Custom styles for this template -->
<link href="<c:url value="/lib/advanced Css/index.css" />" rel="stylesheet" type="text/css"/>
</head>

<body>
	<jsp:include page="/common/header.html"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<jsp:include page="/common/nav.html"></jsp:include>
			
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

			<!-- 每頁不同的內容從這裡開始  --> 
			<!-- 每頁不同的內容到這裡結束  -->
		</div>

	</div>
	<jsp:include page="/common/footer.jsp" />
	<script src="<c:url value="/lib/jquery-3.3.1.min.js" />"></script>
    <script>
      feather.replace()
    </script>
</body>

</html>
