<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Ez_Stock 後台管理系統</title>
<!-- Bootstrap core CSS-->
<link href="<c:url value="/lib/bootstrap.min.css" />" rel="stylesheet"
	type="text/css" />
<!-- Custom fonts for this template-->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.css"/>
<link
	href=<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"/>
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->

<link href="<c:url value="/lib/advanced Css/sb-admin.css" />"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>	
<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">

	<jsp:include page="/common/navbar.html"></jsp:include>
	<jsp:include page="/common/footbar.jsp"></jsp:include>
	<div class="content-wrapper">
         <!--此頁內容由此開始 -->
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
				
         <!--此頁內容由此開始 -->
	</div>

		<!-- Logout 展開-->
		    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		      <div class="modal-dialog" role="document">
		        <div class="modal-content">
		          <div class="modal-header">
		            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
		            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
		              <span aria-hidden="true">×</span>
		            </button>
		          </div>
		          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
		          <div class="modal-footer">
		            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
		            <a class="btn btn-primary" href="login.html">Logout</a>
		          </div>
		        </div>
		      </div>
		    </div>
		<!-- Bootstrap core JavaScript-->
		<script src="<c:url value="/lib/jquery-3.3.1.min.js" />"></script>
		<script src="<c:url value="/lib/bootstrap.bundle.min.js" />"></script>
		<!-- Core plugin JavaScript-->
		<script src="<c:url value="/lib/jquery.easing.min.js" />"></script>
		<!-- Custom scripts for all pages-->
		<script src="<c:url value="/lib/sb-admin.min.js" />"></script>

	</div>
	
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
						var showbotton = $("<a></a>").addClass("fa fa-eye btn btn-warning").css("margin-left","10px").attr({"href":"../check/article.article?article_number="+report.article_number,"target":"_blank"});
						var deletebotton = $("<a></a>").addClass("fa fa-close btn btn-danger").css("margin-left","10px").attr("href","../check/processreport.article?article_number="+report.article_number);
		                if(report.processed == 0){
	                    var cell7 = $("<td></td>")
	                    cell7.append(showbotton);
	                    cell7.append(deletebotton);
	                    }else if(report.processed == 1){
	                    	cell6.text("已處理");
	                    	 var cell7 = $("<td></td>")
	                    	 var showbotton2 = $("<a></a>").addClass("fa fa-eye btn btn-warning disabled").css("margin-left","10px").attr({"href":"../check/article.article?article_number="+report.article_number,"target":"_blank","aria-disabled":"true"});
	                    	 var deletereport = $("<a></a>").addClass("fa fa-close btn btn-danger disabled").css("margin-left","10px").attr({"href":"processreport.article?article_number="+report.article_number,"aria-disabled":"true"});
	                    	 cell7.append(showbotton2);
		 	                 cell7.append(deletereport);
		            		
		                }

						
	                    var row = $('<tr></tr>').append([cell1, cell2, cell3, cell4, cell5, cell6 ,cell7]);

	                    $('#table1>tbody').append(row);
	                });

	            
	            })
			
	            
		})
	</script>
</body>

</html>