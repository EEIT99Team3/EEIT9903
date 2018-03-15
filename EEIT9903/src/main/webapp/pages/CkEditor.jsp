<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<c:url value='../ckeditor/contents.css' />">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
 <script src="<c:url value="../ckfinder/ckfinder.js" />"></script>

<script src=" <c:url value="../ckeditor/ckeditor.js" />"></script>
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


</head>

<body>
	<div class="container">
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

</body>
</html>