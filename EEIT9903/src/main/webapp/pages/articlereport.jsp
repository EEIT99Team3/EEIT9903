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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="<c:url value="/lib/bootstrap.min.css" />" rel="stylesheet"
	type="text/css" />
<!-- Custom styles for this template -->
<link rel="stylesheet" href="<c:url value='../ckeditor/contents.css' />">
<link href="<c:url value="/lib/advanced Css/dashboard.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/css/aside.css" />" rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.css"/>
<script src="<c:url value="/lib/jquery-1.10.2.min.js" />"></script>
<script src="<c:url value="/lib/jquery-ui-1.10.3.custom.min.js" />"></script>
<script src="<c:url value="/js/aside.js" />"></script>
<script src="<c:url value="../ckfinder/ckfinder.js" />"></script>
<script src=" <c:url value="../ckeditor/ckeditor.js" />"></script>

 
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>

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


<style type="text/css">
   table{
   	border-collapse: collapse;
   	width: 600px; 	
   	/*自動斷行*/
   	word-wrap: break-word;
   	table-layout: fixed;
   	border:1px solid black; 
   }   
   td{
     vertical-align:middle !important;
   }  
   botton{
   	margin-left: 5px;
   }   

</style>
</head>

<body>
	<jsp:include page="/common/header.html"></jsp:include>

	<div class="container-fluid">
		<div class="row">
<%-- 			<jsp:include page="/common/nav.html"></jsp:include>		 --%>
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <jsp:include page="/common/aside.jsp" />
			<!-- 以下輸入各網頁不同的地方 -->
				<div class="card">
				<div class="card-header">檢舉處理</div>
				<div class="card-body">
				
					<table id="table1"
						class="table table-bordered table-striped table-hover border border-dark">
						<thead>
							<tr>
								<th>被檢舉帳號</th>
								<th>文章標題</th>
								<th>檢舉選項</th>
								<th>檢舉補充內容</th>
								<th>檢舉時間</th>
								<th>處理狀態</th>
								<th>處理操作</th>
							</tr>
						</thead>
						<tbody >

						</tbody>
					</table>
				
				</div>
			</div>

		<!-- 以上輸入各網頁不同的地方 -->  </main>
		</div>
	</div>
	
	<jsp:include page="/common/footer.jsp" />

	<script>
		feather.replace()
	</script>
	<div style="height:100px "></div>
	
	<script>
		$(document).ready(function() {
				
			  $.getJSON('reportshow.article', function (data) {
	              
// 	                $('#table1>tbody').empty();
	                $.each(data, function (idx, report) {
	                    //console.log(product.ProductName);
	                    var cell1 = $("<td></td>").text(report.m_account);
	                    var cell2 = $("<td></td>").text(report.article_title);
	                    var cell3 = $("<td></td>").text(report.type_of_report);
	                    var cell4 = $("<td></td>").text(report.report_content);
	                    var cell5 = $("<td></td>").text(report.report_date.substring(0,16));
						var cell6 = $("<td></td>").html("未處理");
						var showbotton = $("<a></a>").addClass("fa fa-eye btn btn-warning").css("margin-left","10px").attr("href","check/article.article?article_number="+report.article_number);
						var deletebotton = $("<a></a>").addClass("fa fa-close btn btn-danger").css("margin-left","10px").attr("href","processreport.article?article_number="+report.article_number);
		                if(report.processed == 0){
	                    var cell7 = $("<td></td>")
	                    cell7.append(showbotton);
	                    cell7.append(deletebotton);
	                    }else if(report.processed == 1){
	                    	cell6.text("已處理");
	                    	 var cell7 = $("<td></td>")
	                    	 
	 	                    cell7.append(deletebotton);
		            
		                }

						
	                    var row = $('<tr></tr>').append([cell1, cell2, cell3, cell4, cell5, cell6 ,cell7]);

	                    $('#table1>tbody').append(row);
	                });

	            
	            })
			
	            
		})
	</script>
	
</body>

</html>
