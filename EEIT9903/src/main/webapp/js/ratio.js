		var table = null;
//		var stockid = document.getElementById("stockid");
		var stockid = $('#stockid>select').val();
//		var ratyear = document.getElementById("ratyear");
		var ratyear = $('#ratyear>select').val();
//		var ratseason = document.getElementById("ratseason");
		var ratseason = $('#ratseason>select').val();
//		var eps = document.getElementById("epst");
		var eps = $('#epst>select').val();
//		var bvps = document.getElementById("bvpst");
		var bvps = $('#bvpst>select').val();
//		var gpmargin = document.getElementById("gpmargint");
		var gpmargin =  $('#gpmargint>select').val();
//		var opmargin = document.getElementById("opmargint");
		var opmargin = $('#opmargint>select').val();
//		var nimargin = document.getElementById("nimargint");
		var nimargin = $('#nimargint>select').val();
//		var roe = document.getElementById("roet");
		var roe = $('#roet>select').val();
//		var roa = document.getElementById("roat");
		var roa = $('#roat>select').val();
//		var arturnover = document.getElementById("arturnovert");
		var arturnover =$('#arturnover>select').val();
//		var invturnover = document.getElementById("invturnovert");		
		var invturnover = $('#invturnover>select').val();
//		var apturnover = document.getElementById("apturnovert");
		var apturnover = $('#apturnovert>select').val();
//		var debtratio = document.getElementById("debtratiot");
		var debtratio = $('#debtratiot>select').val();
//		var currentratio = document.getElementById("currentratiot");
		var currentratio = $('#currentratiot>select').val();
//		var fcfgrowth = document.getElementById("fcfgrowtht");
		var fcfgrowth =  $('#fcfgrowtht>select').val();
//		var ocfgrowth = document.getElementById("ocfgrowtht");
		var ocfgrowth = $('#ocfgrowtht>select').val();
//		var revenuesgrowth = document.getElementById("revenuesgrowtht");
		var revenuesgrowth = $('#revenuesgrowtht>select').val();
		var dragged=null;
		var turnon=false;
		var count = 0;
		function condition() {//動態產生查詢條件
			var cond = "/EEIT9903/ratio/data?stockid=";
			if (ratyear.value != "") {
				cond += "&ratyear=" + ratyear.value.toString();
			}
			
			if (ratseason.value != "") {
				cond += "&ratseason=" + ratseason.value.toString();
			}
			
			if (eps.value != "") {
				cond += "&eps=" + eps.value.toString();
			}
			
			if (bvps.value != "") {
				cond += "&bvps=" + bvps.value.toString();
			}
			
			if (gpmargin.value != "") {
				cond += "&gpmargin=" + gpmargin.value.toString();
			};
			if (opmargin.value != "") {
				cond += "&opmargin=" + opmargin.value.toString();
			}
			if (nimargin.value != "") {
				cond += "&nimargin=" + nimargin.value.toString();
			}
			if (roe.value != "") {
				cond += "&roe=" + roe.value.toString();
			}
			if (roa.value != "") {
				cond += "&roa=" + roa.value.toString();
			}
			if (arturnover.value != "") {
				cond += "&arturnover=" + arturnover.value.toString();
			}
			if (invturnover.value != "") {
				cond += "&invturnover=" + invturnover.value.toString();
			}
			if (apturnover.value != "") {
				cond += "&apturnover=" + apturnover.value.toString();
			};
			if (debtratio.value != "") {
				cond += "&debtratio=" + debtratio.value.toString();
			}
			if (currentratio.value != "") {
				cond += "&currentratio=" + currentratio.value.toString();
			}
			if (fcfgrowth.value != "") {
				cond += "&fcfgrowth=" + fcfgrowth.value.toString();
			}
			if (ocfgrowth.value != "") {
				cond += "&ocfgrowth=" + ocfgrowth.value.toString();
			}
			if (revenuesgrowth.value != "") {
				cond += "&revenuesgrowth=" + revenuesgrowth.value.toString();
			}
			console.log(cond);
			return cond;
		}
		
		function dynamicolumn(){
		if (eps.value != "") {
			table.column(3).visible(true);
		}else{table.column(3).visible(false);
		}
		;
		if (bvps.value != "") {
			table.column(4).visible(true);
		}else{table.column(4).visible(false);
		}
		;
		if (gpmargin.value != "") {
			table.column(5).visible(true);
		}else{table.column(5).visible(false);
		}
		;
		if (opmargin.value != "") {
			table.column(6).visible(true);
		}else{table.column(6).visible(false);
		}
		;
		if (nimargin.value != "") {
			table.column(7).visible(true);
		}else{table.column(7).visible(false);
		}
		;
		if (roe.value != "") {
			table.column(8).visible(true);
		}else{table.column(8).visible(false);
		}
		;
		if (roa.value != "") {
			table.column(9).visible(true);
		}else{table.column(9).visible(false);
		}
		;
		if (arturnover.value != "") {
			table.column(10).visible(true);
		}else{table.column(10).visible(false);
		}
		;
		if (invturnover.value != "") {
			table.column(11).visible(true);
		}else{table.column(11).visible(false);
		}
		;
		if (apturnover.value != "") {
			table.column(12).visible(true);
		}else{table.column(12).visible(false);
		}
		;
		if (debtratio.value != "") {
			table.column(13).visible(true);
		}else{table.column(13).visible(false);
		}
		;
		if (currentratio.value != "") {
			table.column(14).visible(true);
		}else{table.column(14).visible(false);
		}
		;
		if (fcfgrowth.value != "") {
			table.column(15).visible(true);
		}else{table.column(15).visible(false);
		}
		;
		if (ocfgrowth.value != "") {
			table.column(16).visible(true);
		}else{table.column(16).visible(false);
		}
		;
		if (revenuesgrowth.value != "") {
			table.column(17).visible(true);
		}else{table.column(17).visible(false);
		}}
		$(document).ready(function() {
			table = $('#table1').DataTable({
				columns : [ {
					"visible" : true,
					"data" : "stock_id"
				}, {
					"visible" : true,
					"data" : "rat_year"
				}, {
					"visible" : true,
					"data" : "rat_season"
				}, {
					"visible" : false,
					"data" : "eps"
				}, {
					"visible" : false,
					"data" : "bvps"
				}, {
					"visible" : false,
					"data" : "gp_margin"
				}, {
					"visible" : false,
					"data" : "op_margin"
				}, {
					"visible" : false,
					"data" : "ni_margin"
				}, {
					"visible" : false,
					"data" : "roe"
				}, {
					"visible" : false,
					"data" : "roa"
				}, {
					"visible" : false,
					"data" : "ar_turnover"
				}, {
					"visible" : false,
					"data" : "inv_turnover"
				}, {
					"visible" : false,
					"data" : "ap_turnover"
				}, {
					"visible" : false,
					"data" : "debt_ratio"
				}, {
					"visible" : false,
					"data" : "current_ratio"
				}, {
					"visible" : false,
					"data" : "fcf_growth"
				}, {
					"visible" : false,
					"data" : "ocf_growth"
				}, {
					"visible" : false,
					"data" : "revenues_growth"
				} ]
			});

		});

		$('#sub').click(function() {
			table.ajax.url(condition());
			table.ajax.reload();
			dynamicolumn();
		});
		
		$(".condition").click(function(event, ui){
				$(this).css('visibility','hidden');
				clickeds=$(this).attr('id').toString()+"s";
				$(document.getElementById(clickeds)).css('visibility','visible');
				$('#start').css('visibility','visible');
				$('#selected').css('visibility','visible');
				clicked=$(this).attr('id').toString()+"t";
				var t=document.getElementById(clicked);
				$(t).css('display','block');
		});
		
		$(".ccondition").click(function(event, ui){
			$(this).css('visibility','hidden');
			clickback=$(this).attr('id').toString().slice(0,$(this).attr('id').toString().length-1);
			$(document.getElementById(clickback)).css('visibility','visible');
			clickbackt=clickback+"t";
			$(document.getElementById(clickbackt)).css('display','none').value("");
	});