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

<link rel="icon" href="<c:url value="/images/ez.ico" />">
<link href="<c:url value="/lib/bootstrap.min.css" />" rel="stylesheet"
	type="text/css" />
<!-- Custom styles for this template -->
<link href="<c:url value="/lib/advanced Css/dashboard.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/css/aside.css" />" rel="stylesheet" type="text/css">
<script src="<c:url value="/lib/jquery-1.10.2.min.js" />"></script>
<script src="<c:url value="/lib/jquery-ui-1.10.3.custom.min.js" />"></script>
<script src="<c:url value="/js/aside.js" />"></script>

</head>

<body>

	<jsp:include page="/common/header.jsp"></jsp:include>

	<div class="container-fluid" >
		<div class="row" >
<%-- 			<jsp:include page="/common/nav.html"></jsp:include>		 --%>
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
<%--             <jsp:include page="/common/aside.jsp" /> --%>
			<!-- 以下輸入各網頁不同的地方 -->
	
		<div class="container" style="margin-right:350px;margin-top:100px;" >
		<a class="btn btn-primary" href="article.article?prodaction=articlepost" >發表文章</a>
		<!-- Page Content -->
		<div class="container" >

			<div class="row" >

				<!-- Blog Entries Column -->
				<div id="articlebody" class="col-md-12">
					<h1 class="my-4">
						文章專欄 
						
					</h1>

					<!-- Blog Post -->
					<div class="card mb-4">
					
					</div>
				</div>

		

				<script >

				$(document).ready(function(){
					$.getJSON( "articleshow.article", function(data) {
						  var docFrag = $(document.createDocumentFragment());
							$.each(data,function(idx,articlemain){
											
								
									var eleImg = $("<img></img>").attr("src","/EEIT9903/pages/check/getImage.article?m_account="+articlemain.m_account).css({"padding-right":"20px","width":"80px","height":"60px"});
									var eleh2 = $("<h2></h2>").addClass("card-title").html(articlemain.article_title+"&nbsp&nbsp")
									var eleAaccount = $("<a></a>").attr("href","#").html(articlemain.m_name);
									var eleSpan = $("<span></span>").html(articlemain.article_date.substring(0,16) + " by ").addClass("pull-left font-italic font-weight-normal")
									var eleDivacdate = $("<div></div>")
									eleSpan.append(eleAaccount);
								
									eleh2.prepend(eleImg);
									eleDivacdate.append(eleSpan);
									
									var eleArticleDiv = $("<div></div>").attr("class","article").html(articlemain.article).css({"overflow":"hidden","width":"800px","height":"200px"});	
									var eleADiv = $("<div></div>").addClass("abc").css("text-align","right");
									var eleA = $("<a></a>").addClass("btn btn-primary ").attr("href","<c:url value='/pages/check/article.article?article_number=' />"+articlemain.article_number).html("Read More &rarr;")
									
									var div = $("<a></a>").addClass("btn btn-success mr-2").attr("href","<c:url value='/pages/check/article.article?article_number=' />"+articlemain.article_number+"#replybody").html("回覆("+articlemain.reply_count+")");
									eleADiv.append(div);
									eleADiv.append(eleA);
									eleADiv.append(eleDivacdate);
								
									
									var eleBodyDiv = $("<div></div>").addClass("card-body rounded m-2 ").css({"width":"1000px","padding":"0 20px 0 20px","border-bottom": "1px solid #8c8b8b"})
								    
									eleBodyDiv.append(eleh2);
									eleBodyDiv.append(eleDivacdate);
									eleBodyDiv.append(eleArticleDiv);
									eleBodyDiv.append(eleADiv);
									docFrag.prepend(eleBodyDiv);							

							})
							$('#articlebody').append(docFrag);

							//限制文章顯示字數
							$(function() {
								var len = 400; // 超過400個字以"..."取代
							
								$(".article").each(
										function() {
					
											if ($(this).text().length > len) {
												
												var text = $(this).text().substring(0,
														len - 1)
														+ "...";
												$(this).text(text);
											}
										});
							});

					})

					
				})
		</script>
		</div>
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
	<div style="height:100px "></div>
</body>

</html>
