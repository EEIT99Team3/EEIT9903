<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="<c:url value='../ckeditor/contents.css' />">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">


<link rel="stylesheet" href="<c:url value='../css/blog.css' />">

	

<script src="<c:url value="../ckeditor/ckeditor.js" />"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

</head>
<body>
	<div class="container">

		<input type="button" class="btn btn-primary" id="post" value="發表文章">
		<!-- Page Content -->
		<div class="container">

			<div class="row">

				<!-- Blog Entries Column -->
				<div id="articlebody" class="col-md-12">

					<h1 class="my-4">
						文章專欄 
					</h1>

					<!-- Blog Post -->
					<div class="card mb-4">
					
					</div>

					
					<!-- Pagination -->
<!-- 					<ul class="pagination justify-content-center mb-4"> -->
<!-- 						<li class="page-item"><a class="page-link" href="#">&larr; -->
<!-- 								Older</a></li> -->
<!-- 						<li class="page-item disabled"><a class="page-link" href="#">Newer -->
<!-- 								&rarr;</a></li> -->
<!-- 					</ul> -->
					
				</div>

		
				<!-- Sidebar Widgets Column -->
		
				<!-- /.container -->

				<!-- Footer -->
<!-- 				<footer class="py-5 bg-dark"> -->
<!-- 				<div class="container"> -->
<!-- 					<p class="m-0 text-center text-white">Copyright &copy; Your -->
<!-- 						Website 2018</p> -->
<!-- 				</div> -->
				<!-- /.container --> </footer>

				<!-- Bootstrap core JavaScript -->
				
				


				<script>
					$('#post').click(function() {
						window.location.href = "<c:url value='CkEditor.jsp' />"
					})
					
					
				</script>

				<script >
				
			
				$(document).ready(function(){
				
				
					$.getJSON( "articleshow.article", function(data) {
						  var docFrag = $(document.createDocumentFragment());
							$.each(data,function(idx,articlemain){
							
								var eleImg = $("<img></img>").attr("src","http://via.placeholder.com/38x38").css("padding-right","20px");
							 	var eleh2 = $("<h2></h2>").addClass("card-title").html(articlemain.article_title+"&nbsp&nbsp")
								var eleAaccount = $("<a></a>").attr("href","#").html(articlemain.m_account);
								var eleSpan = $("<span></span>").html(articlemain.article_date.substring(0,16) + " by ").addClass("pull-left font-italic font-weight-normal")
								var eleDivacdate = $("<div></div>")
								eleSpan.append(eleAaccount);
							
								eleh2.prepend(eleImg);
								eleDivacdate.append(eleSpan);
								
								var eleArticleDiv = $("<div></div>").attr("class","article").html(articlemain.article).css({"overflow":"hidden","width":"800px","height":"200px"});	
								var eleADiv = $("<div></div>").css("text-align","right");
								var eleA = $("<a></a>").addClass("btn btn-primary ").attr("href","<c:url value='/pages/article.article?article_number=' />"+articlemain.article_number).html("Read More &rarr;")
								
							
								var div = $("<a></a>").addClass("btn btn-primary ").attr("href","<c:url value='/pages/article.article?article_number=' />"+articlemain.article_number).html("回覆("+articlemain.replycount+")");
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
			
			
</body>
</html>

