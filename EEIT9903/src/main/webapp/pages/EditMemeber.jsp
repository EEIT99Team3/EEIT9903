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

			<h2 style="padding-top: 50px">Section title</h2>


			<form class="form-horizontal">
				<fieldset>

					<!-- Form Name -->
					<legend>Edit Form</legend>

					<!-- File Button -->
					<div class="form-group">
						<img style="width: 50px; height: 50px; padding-left: 15px"
							src="https://statementdog.com/img/user/default_icon.png"> <label
							class="col-md-4 control-label" for="Upload Photo">Upload
							Photo</label>
						<div class="col-md-4">
							<input id="Upload Photo" name="Upload Photo" class="input-file"
								type="file">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="textinput">顯示名稱</label>
						<div class="col-md-4">
							<input id="textinput" name="textinput" type="text"
								placeholder="顯示名稱" class="form-control input-md" required="">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="Realty Name">Email:</label>
						<div class="col-md-4">
							<input id="textinput" name="textinput" type="text"
								placeholder=" @mail" class="form-control input-md" required="">

						</div>
					</div>


					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="Tel:">Origin Password</label>
						<div class="col-md-4">
							<input id="Tel:" name="Tel:" type="text"
								placeholder="Origin Password" class="form-control input-md"
								required="">
						</div>
					</div>
				
					<div class="form-group">
						<label class="col-md-4 control-label" for="Tel:">New Password</label>
						<div class="col-md-4">
							<input id="Tel:" name="Tel:" type="text"
								placeholder="New Password" class="form-control input-md"
								required="">
						</div>
					</div>
				




					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="Submit"></label>
						<div class="col-md-4">
							<button id="Submit" name="Submit" class="btn btn-primary">Submit</button>
						</div>
					</div>

				</fieldset>
			</form>


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
