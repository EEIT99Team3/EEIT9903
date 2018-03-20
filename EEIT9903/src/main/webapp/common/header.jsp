<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<nav
	class="navbar navbar-expand-md mr-auto navbar-dark fixed-top bg-dark">
	<a class="navbar-brand bg-dark" href="/EEIT9903/index.jsp">EZStock綜合股情查詢系統 <span
		data-feather="search"></span></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item "><a class="nav-link" href="/EEIT9903/baseinfo/search?stock_id=2330">個股概況<span
					class="sr-only">(current)</span></a></li>

			<li class="nav-item "><a class="nav-link" href="/EEIT9903/pages/check/ForumIndex.jsp">文章專欄</a></li>		
			<li class="nav-item"><a class="nav-link" href="/EEIT9903/pages/check/Ratio.jsp">選股總覽</a></li>
			<c:if test="${not empty user}">
			<li class="nav-item"><a class="nav-link" href="/EEIT9903/pages/check/EditMemeber.jsp">會員專區</a></li>
			</c:if>
		</ul>
		<form class="form-inline mt-2 mt-md-0" action="/EEIT9903/pages/Company.jsp">
			<input class="form-control mr-sm-2 mainInput" type="text" placeholder="Search"
				aria-label="Search" value="${data}">
			<button class="btn btn-outline-success my-2 my-sm-0 mainSearch" type="submit">Search</button>
		</form>
		<ul class="navbar-nav px-4">
		    <c:if test="${empty user}">
			<li class="nav-item text-nowrap"><a class="nav-link"
				href='/EEIT9903/pages/login.jsp'>登入</a></li>
			</c:if>
		    <c:if test="${not empty user}">
			<li id="logout" class="nav-item text-nowrap"><a class="nav-link"
				href='/EEIT9903/pages/commonpage2.jsp'>登出</a></li>
			</c:if>
			<li class="nav-item text-nowrap"><a class="nav-link"
				href='/EEIT9903/pages/login.jsp'>註冊</a></li>
		</ul>
	</div>
</nav>
<script>

		$('.mainSearch').click(function() {
			stock_id = $('.mainInput').val();
// 			console.log(stock_id);	
			$.get("/EEIT9903/baseinfo/search",{"stock_id":stock_id},function(){	
				$('.mainSearch').submit();	
			})
		})

</script>