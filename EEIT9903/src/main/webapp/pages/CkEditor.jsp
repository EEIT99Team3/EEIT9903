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
<link rel="stylesheet" href="<c:url value='../ckeditor/contents.css' />">
<link href="<c:url value="/lib/advanced Css/dashboard.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/css/aside.css" />" rel="stylesheet" type="text/css">
<script src="<c:url value="/lib/jquery-1.10.2.min.js" />"></script>
<script src="<c:url value="/lib/jquery-ui-1.10.3.custom.min.js" />"></script>
<script src="<c:url value="/js/aside.js" />"></script>
<script src="<c:url value="../ckfinder/ckfinder.js" />"></script>
<script src="<c:url value="../ckeditor/ckeditor.js" />"></script>
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
            <jsp:include page="/common/aside.jsp" />
			<!-- 以下輸入各網頁不同的地方 -->

		<div class="container" style="margin-right:300px">
		<form name='form' action="<c:url value='/pages/article.article' />"
			method='post'>
			<div class="input-group input-group-sm mb-3 ">
				<div class="input-group-prepend ">
					<span class="input-group-text" id="inputGroup-sizing-sm">標題</span>
				</div>
				<input type="text" id="article-title" name="title"  class="form-control" aria-label="Small"
					aria-describedby="inputGroup-sizing-sm">
			</div>
			<textarea name="content" id="content" rows="10" cols="80"></textarea>
			
		
			
			<script>
			 var editor ;
			$(function(){
				editor = CKEDITOR.replace( 'content',{
					filebrowserBrowseUrl : '<c:url value="../ckfinder/ckfinder.html"/>',
					filebrowserImageBrowseUrl : '<c:url value="../ckfinder/ckfinder.html?type=Images"/>', 
					filebrowserFlashBrowseUrl : '<c:url value="../ckfinder/ckfinder.html?type=Flash" />',
					filebrowserUploadUrl : '	<c:url value="../ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files"/>', 
					filebrowserImageUploadUrl : '<c:url value="../ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images"/>', 
					filebrowserFlashUploadUrl : '<c:url value="../ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash"/>'  
		
				 } );
				 CKFinder.setupCKEditor( editor, '<c:url value="../ckfinder/"/>' );
			})
			
			</script>

			<button type="button" id="post" class="btn btn-success" value='送出'
				data-toggle="modal" data-target="#postconfirm">送出</button>
			<button type='button' id="cancelpost" class="btn btn-danger"
				value='取消' data-toggle="modal" data-target="#postcancel">取消</button>

			<div class="modal fade" id="postconfirm" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered " role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">提示</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body" id="pOfDiv">
							<p>確定發表文章?</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								id="submitcancle"  data-dismiss="modal">取消</button>
							<button type="submit" id="submitOk" name="prodaction"  value="submitOk" class="btn btn-primary">確定</button>
						</div>
					</div>
				</div>
			</div>

			<div class="modal fade" id="postcancel" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered " role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">提示</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<p>要取消編輯中的文章嗎?</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">取消</button>
							<button type="submit" name="prodaction" value="submitcancle" class="btn btn-primary">確定</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	

			
		
	<script>
	$(function(){

		$("#post").click(function(){

			if (editor.getData().length == 0){
			
			$("#pOfDiv").text("請輸入文章內容");
			$("#submitcancle").text("返回");
			$("#submitOk").css("display","none");
			
			}else if($("#article-title").val().length == ""){
				
				$("#pOfDiv").text("請輸入標題內容");
				$("#submitcancle").text("返回");
				$("#submitOk").css("display","none");
			}else {
				$("#pOfDiv").text("確定發表文章?");
				$("#submitcancle").text("取消");
				$("#submitOk").css("display","block");
			}
		})

	})

	</script>
		
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
