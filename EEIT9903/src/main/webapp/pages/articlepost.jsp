<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<link rel="stylesheet" href="<c:url value='../ckeditor/contents.css' />">
<link href="<c:url value="/lib/advanced Css/dashboard.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/css/aside.css" />" rel="stylesheet" type="text/css">
<script src="<c:url value="/lib/jquery-1.10.2.min.js" />"></script>
<script src="<c:url value="/lib/jquery-ui-1.10.3.custom.min.js" />"></script>
<script src="<c:url value="/js/aside.js" />"></script>
<script src="<c:url value="../ckfinder/ckfinder.js" />"></script>
<script src=" <c:url value="../ckeditor/ckeditor.js" />"></script>
</head>

<body>
	<jsp:include page="/common/header.html"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<jsp:include page="/common/nav.html"></jsp:include>		
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <jsp:include page="/common/aside.jsp" />
			<!-- 以下輸入各網頁不同的地方 -->

	<div class="container" style="margin-right: 300px ;margin-top: 10px">

	


		<!-- Page Content -->
		<div class="container">

			<div class="row border border-primary">

				<!-- Post Content Column -->
				<div class="col-lg-12">

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
					<div id="post_Content">${article}</div>
					<hr>


					<!-- Comments Form -->
					<div  class="card my-4">
						<h5 class="card-header">Leave a Comment:</h5>
						<div class="card-body">
					
							<form action="	<c:url value="/pages/reply.article#replybody" />">
						
								<div class="form-group">
									<textarea name="reply" class="form-control" rows="3"></textarea>
								</div>
								<button name="prodaction" value="insertreply" type="submit" class="btn btn-primary" >Submit</button>
							</form>
						</div>
					</div>

					<!-- Single Comment -->
					
					<div id="replybody">
					
					</div>
				
				
					
				</div>
			</div>
		</div>

	</div>
	<div id="new"></div>
	<!-- Sidebar Widgets Column -->
	<div class="col-md-4">


		<!-- /.row -->

	</div>

	<!-- /.container --> 
</body>






<script type="text/javascript">
$(function(){
	
  $.getJSON('replyshow.article',{article_number: ${article_number}},function(data){
	  if(data!=null){
	  var docFrag = $(document.createDocumentFragment());
	  $.each(data,function(idx,replymain){
		  
		  var eleImg = $("<img></img>").addClass("d-flex mr-3 rounded-circle").attr("src","http://placehold.it/50x50");
		  var eleH5 = $("<h5></h5>").addClass("mt-0").html(replymain.m_account);
		  var eleDivreply = $("<div></div>").html(replymain.reply);
		  var eleDivmain = $("<div></div>").addClass("media-body")
	      
		  eleDivmain.append(eleH5);
		  eleDivmain.append(eleDivreply);
		
		  var eleDiv = $("<div></div>").addClass("media mb-4")
		  eleDiv.append(eleImg);
		  eleDiv.append(eleDivmain);
		
		  docFrag.append(eleDiv);
	  })}
	 $('#replybody').append(docFrag);
	
   })
   
})

</script>

			<!-- 以上輸入各網頁不同的地方 -->  </main>
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
