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
<link
	href=<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"/>
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->

<link href="<c:url value="/lib/advanced Css/sb-admin.css" />"
	rel="stylesheet" type="text/css" />
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">

	<jsp:include page="/common/navbar.html"></jsp:include>
	<jsp:include page="/common/footbar.jsp"></jsp:include>
	<div class="content-wrapper">

		<h2 style="padding-top: 20px; padding-left: 60px; padding-right: 300px">管理員一覽</h2>
		<div class="table-responsive"
			style="padding-left: 60px; padding-right: 300px">
			<table id="supervisortable" class="table table-striped table-sm">
				<thead>
					<tr>
						<th>帳號</th>
						<th>密碼</th>
						<th>權限</th>
					</tr>
				</thead>
				<tbody>

				</tbody>
				<tfoot>
				    <tr>
				      <form name="supervisorform">
						<td><input name="s_account" type="text" width="50px" placeholder="新增帳號"></td>
						<td><input name="s_password" type="text" width="50px" placeholder="新增密碼"></td>
						<td><button type="button" id="addsupervisor">新增管理員</button></td>				
				      </form>
				    </tr>
				</tfoot>
			</table>
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
		
		<script>

        $(document).ready(function(){

        loadsupervisor();

        function loadsupervisor(){

            $.getJSON("<c:url value="/Statement/all"/>" , function(datas){

                var tb = $("#supervisortable > tbody");
                tb.empty();
                var fragment = $(document.createDocumentFragment());
                $.each(datas, function(idx, data){

                    var td1 = $("<td></td>").text(data.s_account);
                    var td2 = $("<td></td>").text(data.s_pwd);
                    var td3 = $('<td><button type="button">刪除</button></td>');
                    var row = $("<tr></tr>").append([td1, td2, td3]);

                    fragment.append(row); 
                    })
                    tb.append(fragment);
                })   	
            }

        $("#addsupervisor").click(function(){
            var datas = $('form[name="supervisorform"]').serialize();
            $.post("<c:url value="/Statement/addnew"/>", datas, function(data){
                alert(data);
                loadsupervisor();
                $('input[name="s_account"]').val('');
                $('input[name="s_password"]').val('');
                })

            })

        $('#supervisortable > tbody').on('click', 'tr button:first-child', function(){
                var remove = $(this).parents('tr').find('td:first-child').text();
                $.get('<c:url value="/Statement/delete"/>', {s_delete:remove}, function(data){
                    alert(data);
                    loadsupervisor();
                    })

            })    

            
            })

		</script>

	</div>
</body>

</html>