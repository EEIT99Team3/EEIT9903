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
<link href="<c:url value="/lib/advanced Css/dashboard.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/css/aside.css" />" rel="stylesheet" type="text/css">
<script src="<c:url value="/lib/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/lib/jquery-ui-1.10.3.custom.min.js" />"></script>
<script src="<c:url value="/js/aside.js" />"></script>
<script src="https://code.highcharts.com/stock/highstock.js"></script>
<script src="https://code.highcharts.com/stock/modules/drag-panes.js"></script>
<script src="https://code.highcharts.com/stock/modules/exporting.js"></script>
</head>

<body>
	<jsp:include page="/common/header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<jsp:include page="/common/nav.html"></jsp:include>		
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
			<jsp:include page="/common/aside.jsp" /> 
			<!-- 以下輸入各網頁不同的地方 -->
			<div class="container">
                <div class="main_highstock">
<!--                     <div> -->
<!--                         <input type="text" id="stockNum" name="stockNum" value="" -->
<!--                             placeholder="請輸入股價代號"> <input type="button"  id="search" value="查詢" class="searchHS"> -->
<!--                         <div id="stock_name"></div> -->
<!--                     </div> -->
            </div>
			<div id="container" style="height: 400px; min-width: 310px">準備載入股票圖表...</div>
            </div>
	
			<!-- 以上輸入各網頁不同的地方 --> </main>
		</div>
	</div>
	<jsp:include page="/common/footer.jsp" />
	<%-- 	<script src="<c:url value="/lib/jquery-3.3.1.min.js" />"></script> --%>
	<script>
		feather.replace()
	</script>
	<script>
 $(document).ready(function() {
                        var url = '/EEIT9903/p/test.do?';
                        var stockNum = $('').val();
                        url = url + "stock_id=" + stockNum;
                        //    /testWEB9903/p/test
                        //    https://www.highcharts.com/samples/data/jsonp.php?filename=aapl-ohlcv.json&callback=?

                        //          if(stock_id == "2330" || stock_id == "0050" || stock_id == "2371")    
                        //          {   
                        $.ajax({
                                    type : "get",
                                    url : url,
                                    dataType : "json",
                                    success : function(data) {
                                        console.log(stock_id);
                                        $('#stock_name').html("<h2>"
                                                                + stockNum
                                                                + "股價走勢圖"
                                                                + "</h2>");
                                        // split the data set into ohlc and volume
                                        console.log(data);
                                        var ohlc = [], volume = [], dataLength = data.length,
                                        // set the allowed units for data grouping
                                        groupingUnits = [
                                                [
                                                        'week', // unit name
                                                        [ 1 ] // allowed multiples
                                                ],
                                                [
                                                        'month',
                                                        [
                                                                1,
                                                                2,
                                                                3,
                                                                4,
                                                                6 ] ] ],

                                        i = 0;

                                        for (i; i < dataLength; i += 1) {
                                            ohlc.push([
                                                            data[i][0], // the date
                                                            data[i][1], // open
                                                            data[i][2], // high
                                                            data[i][3], // low
                                                            data[i][4] // close
                                                    ]);

                                            volume.push([
                                                            data[i][0], // the date
                                                            data[i][5] // the volume
                                                    ]);
                                        }

                                        // create the chart
                                        Highcharts.stockChart(
                                                        'container',
                                                        {

                                                            rangeSelector : {
                                                                selected : 1
                                                            },

                                                            title : {
                                                                text : ''
                                                            },

                                                            yAxis : [
                                                                    {
                                                                        labels : {
                                                                            align : 'right',
                                                                            x : -3
                                                                        },
                                                                        title : {
                                                                            text : '股價'
                                                                        },
                                                                        height : '60%',
                                                                        lineWidth : 2,
                                                                        resize : {
                                                                            enabled : true
                                                                        }
                                                                    },
                                                                    {
                                                                        labels : {
                                                                            align : 'right',
                                                                            x : -3
                                                                        },
                                                                        title : {
                                                                            text : '成交量'
                                                                        },
                                                                        top : '65%',
                                                                        height : '35%',
                                                                        offset : 0,
                                                                        lineWidth : 2
                                                                    } ],

                                                            tooltip : {
                                                                split : true
                                                            },

                                                            series : [
                                                                    {
                                                                        type : 'candlestick',
                                                                        color : 'green',
                                                                        lineColor : 'green',
                                                                        upColor : 'red',
                                                                        upLineColor : 'red',
                                                                        type : 'candlestick',
                                                                        data : ohlc,
                                                                        dataGrouping : {
                                                                            units : groupingUnits
                                                                        }
                                                                    },
                                                                    {
                                                                        type : 'column',
                                                                        name : 'Volume',
                                                                        data : volume,
                                                                        yAxis : 1,
                                                                        dataGrouping : {
                                                                            units : groupingUnits
                                                                        }
                                                                    } ]
                                                        });
                                    }
                                })
                        //          }else{
                        //              alert("很抱歉,你輸入的股票代號無資料");
                        //              }    //end if
               }); //end ready
            </script> 
</body>
<style>
.main_highstock {
    margin-right: 219px;
    margin-top: 33px;
    text-align: center;
}
 
#container {
	margin-left: -205px;
    text-align: center;
}

.searchHS{
	border-radius: 5px;
}

</style>
</html>
