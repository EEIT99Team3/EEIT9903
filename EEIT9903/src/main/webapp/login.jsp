﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">


<title>EZStock綜合股情查詢系統</title>

<!-- Bootstrap core CSS -->

<link href="lib/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!-- Custom styles for this template -->
<link href="lib/advanced Css/dashboard.css" rel="stylesheet"
	type="text/css" />
</head>

<body>
	<jsp:include page="common/header.html"></jsp:include>

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
			<!-- 每頁不同的內容從這裡開始 -->

			<div>
			<form  method="post" action=" <c:url value='/login.controller'/>"  >
				<table>
					<tr>
						<td>ACCOUNT :</td>
						<td><input type="text" name="account"
							value="${param.account}"></td>
						<td>${ErrorMsgKey.AccountEmptyError}</td>
					</tr>
					<tr>
						<td>PWD :</td>
						<td><input type="text" name="password"
							value="${param.password}"></td>
						<td>${ErrorMsgKey.PasswordEmptyError}</td>
					</tr>
					<tr>
						<td></td>
						<td align="right"><input type="submit" value="確定"></td>
					</tr>
				</table>
			</form>
			</div>
			<!-- 每頁不同的內容到這裡結束 -->
		</div>

	</div>
	<jsp:include page="common/footer.jsp" />
</body>

</html>

