<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<link rel="icon" href="<c:url value="boostrap/blog/ez.ico" />">
<title>EZstock</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">


<!-- Custom styles for this template -->
<link
	href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900"
	rel="stylesheet">
	
<link href="<c:url value="boostrap/blog/blog.css" />" rel="stylesheet">
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
		<header class="blog-header py-3">
		<div
			class="row flex-nowrap justify-content-between align-items-center">
			<div class="col-4 pt-1">
				<a class="text-muted" href="#">Subscribe</a>
			</div>
			<div class="col-4 text-center">
				<a class="blog-header-logo text-dark" href="index.jsp">EZstock</a>
			</div>
			<div class="col-4 d-flex justify-content-end align-items-center">
				<a class="text-muted" href="#"> <svg
						xmlns="http://www.w3.org/2000/svg" width="20" height="20"
						viewBox="0 0 24 24" fill="none" stroke="currentColor"
						stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
						class="mx-3"> <circle cx="10.5" cy="10.5" r="7.5"></circle>
					<line x1="21" y1="21" x2="15.8" y2="15.8"></line></svg>
				</a> <a class="btn btn-sm btn-outline-secondary" href="#">Sign up</a>
			</div>
		</div>

		</header>

		<div class="nav-scroller py-1 mb-2">
			<nav class="nav d-flex justify-content-between"> <a
				class="p-2 text-muted" href="#">World</a> <a class="p-2 text-muted"
				href="#">U.S.</a> <a class="p-2 text-muted" href="#">Technology</a>
			<a class="p-2 text-muted" href="#">Design</a> <a
				class="p-2 text-muted" href="#">Culture</a> <a
				class="p-2 text-muted" href="ForumIndex.jsp">討論區</a> <a
				class="p-2 text-muted" href="#">Politics</a> <a
				class="p-2 text-muted" href="#">Opinion</a> <a
				class="p-2 text-muted" href="#">Science</a> <a
				class="p-2 text-muted" href="#">Health</a> <a class="p-2 text-muted"
				href="#">Style</a> <a class="p-2 text-muted" href="#">Travel</a> </nav>
		</div>


		<!-- Page Content -->
		<div class="container">

			<div class="row border border-primary">

				<!-- Post Content Column -->
				<div class="col-lg-8">

					<!-- Title -->
					<h1 class="mt-4">${article_title}</h1>

					<!-- Author -->
					<p class="lead">				 
						by <a href="#">${M_account}</a> ${fn:substring(articleDate, 0,16)} <a role="button" data-toggle="modal" data-target="#exampleModalCenter" href="<c:url value='/pages/article.article?prodaction=articleDelete&article_number='/>${article_number}" style="margin-left:60% " class="btn btn-danger">刪除</a>
				
					</p>
					<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      	 確定刪除文章嗎?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
        <a href="<c:url value='/pages/article.article?prodaction=articleDelete&article_number='/>${article_number}"  class="btn btn-primary">確定</a>
      </div>
    </div>
  </div>
</div>


					<hr>

					<!-- Preview Image -->



					<!-- Post Content -->


					<div id="post_Content">${article}</div>
					<hr>


					<!-- Comments Form -->
					<div  class="card my-4">
						<h5 class="card-header">Leave a Comment:</h5>
						<div class="card-body">
					
							<form action="	<c:url value="/pages/reply.article" />">
						
								<div class="form-group">
									<textarea name="reply" class="form-control" rows="3"></textarea>
								</div>
								<button name="prodaction" value="insertreply" type="submit" class="btn btn-primary">Submit</button>
							</form>
						</div>
					</div>

					<!-- Single Comment -->
					
					<div id="replybody">
					
					
<!-- 					<div  class="media mb-4"> -->
					
<!-- 						<img class="d-flex mr-3 rounded-circle" -->
<!-- 							src="http://placehold.it/50x50" alt=""> -->
<!-- 						<div class="media-body"> -->
<!-- 							<h5 class="mt-0">456</h5> -->
<!-- 						</div> -->
<!-- 					</div> -->
					</div>
				
				
					
				</div>
			</div>
		</div>

	</div>

	<!-- Sidebar Widgets Column -->
	<div class="col-md-4">


		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
	<div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; Your
			Website 2018</p>
	</div>
	<!-- /.container --> </footer>
</body>




<footer class="blog-footer">
<p>
	Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a>
	by <a href="https://twitter.com/mdo">@mdo</a>.
</p>
<p>
	<a href="#">Back to top</a>
</p>
</footer>

<script type="text/javascript">
$(function(){
	
  $.getJSON('replyshow.article',{article_number: ${article_number}},function(data){
	  if(data!=null){
	  var docFrag = $(document.createDocumentFragment());
	  $.each(data,function(idx,replymain){
		  
		  var eleImg = $("<img></img>").addClass("d-flex mr-3 rounded-circle").attr("src","http://placehold.it/50x50");
		  var eleH5 = $("<h5></h5>").addClass("mt-0").html(replymain.m_account);
		  var eleDivreply = $("<div></div>").html(replymain.reply);
		  var eleDivmain = $("<div></div>").addClass("media-body");
	      
		  eleDivmain.append(eleH5);
		  eleDivmain.append(eleDivreply);
		
		  var eleDiv = $("<div></div>").addClass("media mb-4");
		  eleDiv.append(eleImg);
		  eleDiv.append(eleDivmain);
		
		  docFrag.append(eleDiv);
	  })}
	 $('#replybody').append(docFrag);
   })
   
})

</script>


</body>
</html>