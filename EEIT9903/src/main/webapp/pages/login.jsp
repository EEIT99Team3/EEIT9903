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

<link href="<c:url value="/lib/bootstrap.min.css" />" rel="stylesheet"
	type="text/css" />
<!-- Custom styles for this template -->
<link href="<c:url value="/lib/advanced Css/login.css" />"
	rel="stylesheet" type="text/css" />
<!-- 添加物 -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
</head>

<body class="main">

	<!-- 每頁不同的內容從這裡開始  -->
	<div class="login-screen"></div>
	<div class="login-center">
		<div class="container min-height"
			style="margin-top: 20px; padding-right: 600px; padding-top: 200px">
			<div class="row">
				<div class="col-xs-4 col-md-offset-8">
					<div class="login" id="card">
						<div class="front signin_form">
							<p>Login Your Account</p>
							<form class="login-form" method="post"
								action=" <c:url value='/member/login'/>">
								<div class="form-group">
									<div class="input-group">
										<input type="text" class="form-control" name="frontloginaccount"
											value="${param.frontloginaccount}" placeholder="Type your account">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-user"></i>
										</span>
									</div>
									<span>${loginerrors.frontaccounterror}</span>
								</div>
								<div class="form-group">
									<div class="input-group">
										<input type="password" class="form-control" name="frontloginpassword"
											value="${param.frontloginpassword}" placeholder="Type your password">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-lock"></i>
										</span>
									</div>
									<span>${loginerrors.frontpassworderror}</span>
								</div>
								<div class="checkbox">
									<label><input type="checkbox">Remember me next
										time.</label>
								</div>

								<div class="form-group sign-btn">
									<input type="submit" class="btn" value="Log in">
									<p>
										<a href="#" class="forgot">Can't access your account?</a>
									</p>
									<p>
										<strong>New to Ez_Stock ?</strong><br> <a href="#"
											id="flip-btn" class="signup signup_link">Sign up for a
											new account</a>
									</p>
								</div>
							</form>
						</div>
						<div class="back signup_form" style="opacity: 0;">
							<p>Sign Up for Your New Account</p>
							<form class="login-form" method="post"
							    action="<c:url value='/member/register'/>">
								<div class="form-group">
									<div class="input-group">
										<input type="text" class="form-control addname"
											placeholder="Member Name" name="addname" value=""> <span
											class="input-group-addon"> <i
											class="glyphicon glyphicon-user"></i>
										</span>
									</div>
								</div>
								<div class="form-group">
									<div class="input-group">
										<input type="text" class="form-control addaccount" placeholder="Account"
											name="addaccount" value=""> <span
											class="input-group-addon"> <i
											class="glyphicon glyphicon-user"></i>
										</span>
									</div>
								</div>
								<div class="form-group">
									<div class="input-group">
										<input type="password" class="form-control password" name="addpassword"
											value="" placeholder="Password"> <span
											class="input-group-addon"> <i
											class="glyphicon glyphicon-lock"></i>
										</span>
									</div>
								</div>
								<div class="form-group">
									<div class="input-group">
										<input type="email" class="form-control email" 
										name="addemail" placeholder="Email">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-envelope"></i>
										</span></div>
									
								</div>

								<div class="form-group sign-btn">
									<input type="submit" class="btn register-btn" value="Sign up"> <br>
									<br>
									<p>
										You have already Account So <a href="#" id="unflip-btn"
											class="signup">Log in</a>
									</p>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value="/lib/jquery-3.3.1.min.js" />"></script>
	<script type="text/javascript">
		$().ready(function() {
			$("#card").flip({
				trigger : 'manual'
			});

			$('.register-btn').attr('disabled','disabled');

			$('.email,.password,.addaccount,.addname').blur(function(){
				let email=$('.email').val();
				let password=$('.password').val();
				let addaccount=$('.addaccount').val();
				let addname=$('.addname').val();
				if(email != "" && password != "" && password != "" && addname != ""){
					$('.register-btn').removeAttr('disabled');
					
				}
			});
			
			$('.register-btn').click(function(){
				alert("Registered Success");
				//alert(email+password+addaccount+addname);
				});
		});

		$(".signup_link").click(function() {

			$(".signin_form").css('opacity', '0');
			$(".signup_form").css('opacity', '100');

			$("#card").flip(true);

			return false;
		});

		$("#unflip-btn").click(function() {

			$(".signin_form").css('opacity', '100');
			$(".signup_form").css('opacity', '0');

			$("#card").flip(false);

			return false;

		});
	</script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jQuery-Flip/1.0.18/jquery.flip.js"></script>
	<!-- 每頁不同的內容到這裡結束  -->

	<%-- 	<jsp:include page="/partial/footer.jsp" /> --%>


	<script>
		feather.replace()
	</script>
</body>

</html>
