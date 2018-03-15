<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="page-main" role="main">
	    <aside>
	    	<h3>追蹤清單</h3>
	        <table id="stockTable">
	        <thead>
			  <tr class="myFav">
			    <th class="myFav">股價代號</th>
			    <th class="myFav">當日股價</th>
			    <th class="myFav">管理</th>
			  </tr class="myFav">
			</thead>
			<tbody>
<!-- 			  <tr> -->
<!-- 			    <td>2330</td> -->
<!-- 			    <td><button>刪除</td> -->
<!-- 			  </tr> -->
<!-- 			  <tr> -->
<!-- 			    <td>0050</td> -->
<!-- 			    <td><button>刪除</td> -->
<!-- 			  </tr> -->
<!-- 			  <tr> -->
<!-- 			    <td>2317</td> -->
<!-- 			    <td><button>刪除</td> -->
<!-- 			  </tr> -->
			</tbody>
			</table>
	        <button class="slider"><img src="../images/btn_open.png"></button>
	        <div class="addNew">        
	        	<input type="text" name="stock_id" id="stock_id" value="">
	        	<button class="addBtn">新增</button>
	        </div>
	    </aside>
	</div>
</body>
</html>