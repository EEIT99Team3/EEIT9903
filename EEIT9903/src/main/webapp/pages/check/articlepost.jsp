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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="<c:url value="/lib/bootstrap.min.css" />" rel="stylesheet"
	type="text/css" />
<!-- Custom styles for this template -->
<link href="<c:url value="/lib/advanced Css/dashboard.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/css/aside.css" />" rel="stylesheet" type="text/css">

<script src="<c:url value="/lib/jquery-1.10.2.min.js" />"></script>
<script src="<c:url value="/lib/jquery-ui-1.10.3.custom.min.js" />"></script>
<script src="<c:url value="/js/aside.js" />"></script>


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
	<jsp:include page="/common/header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
<%-- 			<jsp:include page="/common/nav.html"></jsp:include>		 --%>
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <jsp:include page="/common/aside.jsp" />
			<!-- 以下輸入各網頁不同的地方 -->

	<div class="container" style="margin-right: 300px ;margin-top: 10px">

	


		<!-- Page Content -->
		<div class="container">
			
			<div class="row">

				<!-- Post Content Column -->
				<div class="col-lg-12">

					<!-- Title -->
					<h1 class="mt-4">${article_title}</h1>

					<!-- Author -->
					<p class="lead">				 
						by <a href="#">${M_account}</a> ${articleDate} 
						<a role="button" href="<c:url value='/pages/check/article.article?prodaction=articleEdit&article_number='/>${article_number}" style="margin-left:50% " class="btn btn-info fa fa-edit d-none" id="editorbotton">編輯</a>
						<a role="button"  class="btn btn-danger fa fa-close d-none" data-toggle="modal" data-target="#exampleModalCenter" id="deletebotton">刪除</a>
						<a role="button"  class="btn btn-warning fa fa-ban d-inline-block" data-toggle="modal" data-target="#reportModal" data-whatever="@mdo" id="reportbotton" style="margin-left:60%" >檢舉</a>
					</p>
					<!-- Modal -->
					
<!-- 刪除文章的互動視窗  -->
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
        <a href="<c:url value='/pages/check/article.article?prodaction=articleDelete&article_number='/>${article_number}"  class="btn btn-primary">確定</a>
      </div>
    </div>
  </div>
</div>

<!-- 檢舉文章的互動視窗 -->
<div class="modal fade" id="reportModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content" id="aaa" >
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">檢舉:</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="report.article">
          <div class="form-group">
            <label for="dropdownMenuButton" class="col-form-label">檢舉:</label>
            <div class="dropdown">
			  <button class="btn btn-info dropdown-toggle btn-block" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			   	檢舉選項
			  </button>
			  <div class="dropdown-menu btn-block " aria-labelledby="dropdownMenuButton">
			    <button class="dropdown-item" type="button">1.內容與股市無關</button>
  				<button class="dropdown-item" type="button">2.謾罵</button>
    			<button class="dropdown-item" type="button">3.轉載未註明出處</button>
    			<button class="dropdown-item" type="button">4.內容明顯釣魚引戰</button>
    			<button class="dropdown-item" type="button">5.技術不純熟的分析師</button>
			  </div>
			</div>
<!--             <input type="text" class="form-control" id="recipient-name"> -->
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">檢舉補充:</label>
            <textarea class="form-control" id="message-text" name="report_content"></textarea>
          </div>
          <input type="hidden" name="article_number" value="${article_number}"> 
          <input type="hidden" name="type_of_report" id="type_of_report"> 
          <input type="hidden" name="m_account" value="${M_account}" id="type_of_report"> 
          <input type="hidden" name="article_title" value="${article_title}" id="type_of_report"> 
         	<div class="modal-footer">
        		<button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
        		<button id="reportsubmit" type="submit" class="btn btn-primary" name="prodaction" value="insertReport">確定</button>
      		</div>
        </form>
      </div>
    
    </div>
  </div>
</div>

				<hr>
					<div id="post_Content">${article}</div>
					<hr>


					<!-- Comments Form -->
					<div  class="card my-4">
						<h5 class="card-header">回覆文章:</h5>
						<div class="card-body">
					
							<form action="	<c:url value="/pages/check/reply.article#replybody" />">
						
								<div class="form-group">
									<textarea name="reply" class="form-control" rows="3"></textarea>
								</div>
								<button name="prodaction" value="insertreply" type="submit" class="btn btn-primary" >發送</button>
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


<script type="text/javascript">
$(function(){

	var aa = ${article_number};
	var a_account = "${user.MAccount}";
	
$.get("showbotton.article",{article_number:aa},function(data){
	
		
			if(data == a_account){
				$("#deletebotton").addClass('d-inline-block');
				$("#editorbotton").addClass('d-inline-block');
				$("#reportbotton").removeClass('d-inline-block').css({"margin-left":"0","display":"none"});
				
			}
		})
})

$(function(){

	$("#reportsubmit").click(function(){
		 alert("檢舉完成!");
		
		})
	
	
	

	$(".dropdown-item").click(function(){
			
			var xxx=  $(this).text();

			$("#dropdownMenuButton").text(xxx);
			$("#type_of_report").attr("value",xxx);
		})


	
  $.getJSON('replyshow.article',{article_number:'${article_number}'},function(data){

	 	
	  if(data!=null){
	  var docFrag = $(document.createDocumentFragment());
	  $.each(data,function(idx,replymain){

	
		  var eleImg = $("<img></img>").addClass("d-flex mr-3 rounded-circle").attr("src","/EEIT9903/pages/check/getImage.article?m_account="+replymain.m_account).css({"width":"50px","height":"50px"});;
		  var eleH5 = $("<h5></h5>").addClass("mt-0").html(replymain.m_name);
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

	<script>
		feather.replace()
	</script>
	<div style="height:100px "></div>
</body>

</html>
