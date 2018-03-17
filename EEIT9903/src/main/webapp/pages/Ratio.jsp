<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EZStock綜合股情查詢系統</title>

<link rel="stylesheet" href="<c:url value="/lib/bootstrap.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/lib/jumbotron.css"/>" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/dt-1.10.16/datatables.min.css" />
<link rel="stylesheet" type="text/css" href="<c:url value="/css/ratio.css" />" />
</head>
<body>
	<jsp:include page="/common/header.html" />
	<main role="main" class="container mt-2" style="margin-left:50px">
	<div class="row" style="width: 700px">
		<div class="col-lg-3" style="padding: 0px; width: 180px">
			<div class="col-lg-9" style="width: 1800px">

				<!-- 下面這個是table外框 -->
				<div class="card" style="width: 1800px">
					<div class="card-header" style="width: 1800px">基本面指標建議選股</div>
					<div class="card-body" style="width: 1800px">
						<!-- 每頁不同的內容從這裡開始 -->
			<div id="draggable" class="ui-widget-content">
				<p>Drag me to my target</p>
			</div>
			<div id="notchoosed">
			<div class=condition id=eps>EPS</div>
			<div class=condition id=bvps>每股淨值</div>
			<div class=condition id=gpmargin>毛利率</div>
			<div class=condition id=opmargin>營業利益率</div>
			<div class=condition id=nimargin>稅後淨利率</div>
			<div class=condition id=roe>ROE</div>
			<div class=condition id=roa>ROA</div>
			<div class=condition id=arturnover>應收帳款周轉率</div>
			<div class=condition id=invturnover>存貨周轉率</div>
			<div class=condition id=apturnover>應付帳款周轉率 </div>
			<div class=condition id=debtratio>負債比率</div>
			<div class=condition id=currentratio>流動比率</div>
			<div class=condition id=fcfgrowth>自由現金流量年成長率</div>
			<div class=condition id=ocfgrowth>營業現金流量年成長率</div>
			<div class=condition id=revenuesgrowth>營收成長率</div>
			
			</div>
			<div class=choosed >選擇條件</div>
						
			<input id="stockid" type="text" value="" placeholder="請輸入股票代號" disabled="true">
			<input id="ratyear" type="text" value="" placeholder="請輸入年" disabled="true">
			<input id="ratseason" type="text" value="" placeholder="請輸入季" disabled="true">
			<input id="epst" type="text" value="" placeholder="請輸入EPS>?" disabled="true">
			<input id="bvpst" type="text" value="" placeholder="請輸入每股淨值>?" disabled="true">
			<input id="gpmargint" type="text" value="" placeholder="毛利率>?" disabled="true">
			<input id="opmargint" type="text" value="" placeholder="營業利益率>?" disabled="true">
			<input id="nimargint" type="text" value="" placeholder="稅後淨利率>?" disabled="true">
			<input id="roet" type="text" value="" placeholder="ROE(股東權益報酬率)>?" disabled="true">
			<input id="roat" type="text" value="" placeholder="ROA(資產報酬率)>?" disabled="true">
			<input id="arturnovert" type="text" value=""
							placeholder="應收帳款周轉率>?" disabled="true">
			<input id="invturnovert" type="text" value="" placeholder="存貨周轉率 >?" disabled="true">
			<input id="apturnovert" type="text" value="" placeholder="應付帳款周轉率 <?" disabled="true">
			<input id="debtratiot" type="text" value="" placeholder="負債比率 <?" disabled="true">
			<input id="currentratiot" type="text" value=""
							placeholder="流動比率 <?" disabled="true"> <input id="fcfgrowtht" type="text"
							value="" placeholder="自由現金流量年成長率 >?" disabled="true">
							<input
							id="ocfgrowtht" type="text" value="" placeholder="營業現金流量年成長率>?" disabled="true">
			<input id="revenuesgrowtht" type="text" value=""
							placeholder="營收成長率>?" disabled="true">
			<input id="sub" type="submit">
					</div>
			<table id="table1"
						class="table table-bordered table-striped table-hover"
						style="width: 1800px">
					<thead>
							<tr>
								<th>股票代號</th>
								<th>年份</th>
								<th>季別</th>
								<th>EPS</th>
								<th>每股淨值</th>
								<th>毛利率</th>
								<th>營業利益率</th>
								<th>稅後淨利率</th>
								<th>ROE</th>
								<th>ROA</th>
								<th>應收帳款周轉率</th>
								<th>存貨周轉率</th>
								<th>應付帳款周轉率</th>
								<th>負債比率</th>
								<th>流動比率</th>
								<th>自由現金流量年成長率</th>
								<th>營業現金流量年成長率>?</th>
								<th>營收成長率</th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
					<!-- 每頁不同的內容到這裡結束 -->
				</div>
			</div>

			<jsp:include page="/common/sections.html" />
		</div>
	</div>
	</main>

	<jsp:include page="/common/footer.jsp" />
	<script src="<c:url value="/lib/jquery-3.3.1.min.js"/>"></script>
	<script src="<c:url value="/lib/bootstrap.min.js"/>"></script>
	<script type="text/javascript"
		src="cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/v/bs4/dt-1.10.16/datatables.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="<c:url value="/js/ratio.js"/>"></script>
</head>
<body>


</body>
</html>