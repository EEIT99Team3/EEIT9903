<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Ez_Stock 後台管理系統</title>
  <!-- Bootstrap core CSS-->
  <link href="<c:url value="/lib/bootstrap.min.css" />" rel="stylesheet" type="text/css"/>
  <!-- Custom fonts for this template-->
  <link href=<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"/>
   rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->

  <link href="<c:url value="/lib/advanced Css/sb-admin.css" />" rel="stylesheet" type="text/css"/>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">

<jsp:include page="/common/navbar.html"></jsp:include>
<jsp:include page="/common/footbar.jsp"></jsp:include>
  <div class="content-wrapper">
<!--     <div class="container-fluid"> -->
<!--       Breadcrumbs -->
<!--       <ol class="breadcrumb"> -->
<!--         <li class="breadcrumb-item"> -->
<!--           <a href="#">Dashboard</a> -->
<!--         </li> -->
<!--         <li class="breadcrumb-item active">Blank Page</li> -->
<!--       </ol> -->
<!--       <div class="row"> -->
<!--         <div class="col-12"> -->
<!--           <h1>Blank</h1> -->
<!--           <p>This is an example of a blank page that you can use as a starting point for creating new ones.</p> -->
<!--         </div> -->
<!--       </div> -->
<!--     </div> -->
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout 展開-->
<!--     <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"> -->
<!--       <div class="modal-dialog" role="document"> -->
<!--         <div class="modal-content"> -->
<!--           <div class="modal-header"> -->
<!--             <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5> -->
<!--             <button class="close" type="button" data-dismiss="modal" aria-label="Close"> -->
<!--               <span aria-hidden="true">×</span> -->
<!--             </button> -->
<!--           </div> -->
<!--           <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div> -->
<!--           <div class="modal-footer"> -->
<!--             <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button> -->
<!--             <a class="btn btn-primary" href="login.html">Logout</a> -->
<!--           </div> -->
<!--         </div> -->
<!--       </div> -->
<!--     </div> -->
    <!-- Bootstrap core JavaScript-->
	<script src="<c:url value="/lib/jquery-3.3.1.min.js" />"></script>
	<script src="<c:url value="/lib/bootstrap.bundle.min.js" />"></script>
    <!-- Core plugin JavaScript-->
    <script src="<c:url value="/lib/jquery.easing.min.js" />"></script>
    <!-- Custom scripts for all pages-->
    	<script src="<c:url value="/lib/sb-admin.min.js" />"></script>

  </div>
</body>

</html>