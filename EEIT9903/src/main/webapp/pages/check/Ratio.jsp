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
	<jsp:include page="/common/header.jsp" />
	<main role="main" class="container mt-2" style="margin-left:50px">
	<div class="row" style="width: 700px">
		<div class="col-lg-3" style="padding: 0px; width: 180px">
			<div class="col-lg-9" style="width: 1800px">

				<!-- 下面這個是table外框 -->
				<div class="card" style="width: 1800px">
					<div class="card-header" style="width: 1800px">基本面指標建議選股</div>
					<div class="card-body" style="width: 1800px">
						<!-- 每頁不同的內容從這裡開始 -->
			<div id="notchoosed">
			<div class="condition" id="eps">EPS</div>
			<div class="condition" id="bvps">每股淨值</div>
			<div class="condition" id="gpmargin">毛利率</div>
			<div class="condition" id="opmargin">營業利益率</div>
			<div class="condition" id="nimargin">稅後淨利率</div>
			<div class="condition" id="roe">ROE</div>
			<div class="condition" id="roa">ROA</div>
			<div class="condition" id="arturnover">應收帳款周轉率</div>
			<div class="condition" id="invturnover">存貨周轉率</div>
			<div class="condition" id="apturnover">應付帳款周轉率 </div>
			<div class="condition" id="debtratio">負債比率</div>
			<div class="condition" id="currentratio">流動比率</div>
			<div class="condition" id="fcfgrowth">自由現金流量年成長率</div>
			<div class="condition" id="ocfgrowth">營業現金流量年成長率</div>
			<div class="condition" id="revenuesgrowth">營收成長率</div>
			</div>
			<div id="choosedchoosed">
			<div class="ccondition" id="epss">EPS</div>
			<div class="ccondition" id="bvpss">每股淨值</div>
			<div class="ccondition" id="gpmargins">毛利率</div>
			<div class="ccondition" id="opmargins">營業利益率</div>
			<div class="ccondition" id="nimargins">稅後淨利率</div>
			<div class="ccondition" id="roes">ROE</div>
			<div class="ccondition" id="roas">ROA</div>
			<div class="ccondition" id="arturnovers">應收帳款周轉率</div>
			<div class="ccondition" id="invturnovers">存貨周轉率</div>
			<div class="ccondition" id="apturnovers">應付帳款周轉率 </div>
			<div class="ccondition" id="debtratios">負債比率</div>
			<div class="ccondition" id="currentratios">流動比率</div>
			<div class="ccondition" id="fcfgrowths">自由現金流量年成長率</div>
			<div class="ccondition" id="ocfgrowths">營業現金流量年成長率</div>
			<div class="ccondition" id="revenuesgrowths">營收成長率</div>
			</div>
			<div id="selected">
			<span>年度</span>
			<select class="selectorc" id="ratyear" >
				<option value="">請選擇</option>
  				<option value="106">106年</option>
   				<option value="105">105年</option>
   				<option value="104">104年</option>
  			</select>
  			<span>季別</span>
  			<select class="selectorc" id="ratseason">
  				<option value="">請選擇</option>
  				<option value="1">Q1</option>
   				<option value="2">Q2</option>
   				<option value="3">Q3</option>
   				<option value="4">Q4</option>
  			</select>
  			<span>EPS</span>
  			<select class="selectorc" id="epst" disabled="true">
  			  	<option value="">請選擇</option>
   				<option value="0">普通篩選(>0))</option>
   				<option value="10">嚴格篩選(10以上)</option>
  			</select>
   			<span>每股淨值</span> 			
  			 <select class="selectorc" id="bvpst" disabled="true">
  			   	<option value="">請選擇</option>
   				<option value="20">普通篩選(>20))</option>
   				<option value="50">嚴格篩選(>50)</option>
  			</select>
  			<span>毛利率</span>
  			 <select class="selectorc" id="gpmargint" disabled="true">
   				<option value="">請選擇</option>
   				<option value="10">普通篩選(>10)</option>
   				<option value="30">嚴格篩選(>30)</option>
  			</select>
  			<span>營業利益率</span> 			
  			<select class="selectorc" id="opmargint" disabled="true">
  			  	<option value="">請選擇</option>
   				<option value="10">普通篩選(>10)</option>
   				<option value=20>嚴格篩選(>20)</option>
  			</select>
  	  		<span>稅後淨利率</span>
  			<select class="selectorc" id="nimargint" disabled="true">
  				<option value="">請選擇</option>
   				<option value="5">普通篩選(>5)</option>
   				<option value=20>嚴格篩選(>20)</option>
  			</select>
  			<span>ROE</span>
  			<select class="selectorc" id="roet" disabled="true">
   				<option value="">請選擇</option> 			
   				<option value="0">普通篩選(>0)</option>
   				<option value="5">嚴格篩選(>5)</option>
  			</select>
  			<span>ROA</span>
  			<select class="selectorc" id="roat" disabled="true">
   				<option value="">請選擇</option>
   				<option value="0">普通篩選(>0)</option>
   				<option value="5">嚴格篩選(>5)</option>
  			</select>
  			<span>應收帳款周轉率</span>
  			<select class="selectorc" id="arturnovert" disabled="true">
  				<option value="">請選擇</option>
   				<option value="3">普通篩選(>3)</option>
   				<option value="6">嚴格篩選(>6)</option>
  			</select>
  			<span>存貨周轉率</span>
  			<select class="selectorc" id="invturnovert" disabled="true">
  			  	<option value="">請選擇</option>
   				<option value="3">普通篩選(>3)</option>
   				<option value="6">嚴格篩選(>6)</option>
  			</select>			
  			<span>應付帳款周轉率</span>
  			<select class="selectorc" id="apturnovert" disabled="true">
  			  	<option value="">請選擇</option>
   				<option value="6">普通篩選(<6)</option>
   				<option value="3">嚴格篩選(<3)</option>
  			</select> 			
   			<span>負債比率</span>
  			
  			<select class="selectorc" id="debtratiot" disabled="true">
  			  	<option value="">請選擇</option>
   				<option value="0.50">普通篩選(<50%)</option>
   				<option value="0.25">嚴格篩選(<25%)</option>
  			</select>
  			<span>流動比率</span>		
  			<span>流動比率</span>		
  			<select class="selectorc" id="currentratiot" disabled="true">
    			<option value="">請選擇</option>	
   				<option value="0.75">普通篩選(>75%)</option>
   				<option value="1.5">嚴格篩選(>150%)</option>
  			</select>
  			<span>自由現金流量年成長率</span>		
  			<select class="selectorc" id="fcfgrowtht" disabled="true">
  			  	<option value="">請選擇</option>
   				<option value="0">普通篩選(>0)</option>
   				<option value="10">嚴格篩選(>10)</option>
  			</select>
  			<span>營業現金流量年成長率</span>		
  			<select class="selectorc" id="ocfgrowtht" disabled="true">
  	  			<option value="">請選擇</option>		
   				<option value="0">普通篩選(>0)</option>
   				<option value="10">嚴格篩選(>10)</option>
  			</select>
  			<span>營收成長率</span>		
   			<select class="selectorc" id="revenuesgrowtht" disabled="true">  			
   				<option value="">請選擇</option>
   				<option value="0">普通篩選(>0)</option>
   				<option value="10">嚴格篩選(>10)</option>
  			</select>
  			<input id="sub" type="submit" value="開始選股!">
  			</div> 			
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