
		var table = null;
		var stockid = document.getElementById("stockid");
		var ratyear = document.getElementById("ratyear");
		var ratseason = document.getElementById("ratseason");
		var eps = document.getElementById("epst");
		var bvps = document.getElementById("bvpst");
		var gpmargin = document.getElementById("gpmargint");
		var opmargin = document.getElementById("opmargint");
		var nimargin = document.getElementById("nimargint");
		var roe = document.getElementById("roet");
		var roa = document.getElementById("roat");
		var arturnover = document.getElementById("arturnovert");
		var invturnover = document.getElementById("invturnovert");
		var apturnover = document.getElementById("apturnovert");
		var debtratio = document.getElementById("debtratiot");
		var currentratio = document.getElementById("currentratiot");
		var fcfgrowth = document.getElementById("fcfgrowtht");
		var ocfgrowth = document.getElementById("ocfgrowtht");
		var revenuesgrowth = document.getElementById("revenuesgrowtht");
		var dragged=null;
		var turnon=false;

		function condition() {//動態產生查詢條件
			var cond = "/EEIT9903/ratio/data?";
			cond += "stockid=" + stockid.value.toString();
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
				cond += "&currentratio=" + stockid.value.toString();
			}
			if (fcfgrowth.value != "") {
				cond += "&fcfgrowth=" + stockid.value.toString();
			}
			if (ocfgrowth.value != "") {
				cond += "&ocfgrowth=" + stockid.value.toString();
			}
			if (revenuesgrowth.value != "") {
				cond += "&revenuesgrowth=" + stockid.value.toString();
			}
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
//				ajax : "/EEIT9903/ratio/data?",
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
		$(".condition").draggable({stop:function(event, ui){
			if(turnon==true){
				dragged=$(this).attr('id').toString()+"t";
				document.getElementById(dragged).disabled=false;
				turnon=false;
				}
		dragged=$(this).attr('id').toString();console.log(dragged);
		}});
		$(".choosed").droppable({drop:function(event, ui){
			turnon=true;
			}});


// 		function condition() {
//			var cond = "/EEIT9903/ratio/data?";
//			cond += "stockid=" + stockid.value.toString();
//			if (ratyear.value != "") {
//				cond += "&ratyear=" + ratyear.value.toString();
//			}
//			if (ratseason.value != "") {
//				cond += "&ratseason=" + ratseason.value.toString();
//			}
//			if (eps.value != "") {
//				cond += "&eps=" + eps.value.toString();
//				table.column(3).visible(true);
//			}else{table.column(3).visible(false);
//			}
//			if (bvps.value != "") {
//				cond += "&bvps=" + bvps.value.toString();
//				table.column(4).visible(true);
//			}else{table.column(4).visible(false);
//			}
//			if (gpmargin.value != "") {
//				cond += "&gpmargin=" + gpmargin.value.toString();
//				table.column(5).visible(true);
//			}else{table.column(5).visible(false);
//			}
//			if (opmargin.value != "") {
//				cond += "&opmargin=" + opmargin.value.toString();
//				table.column(6).visible(true);
//			}else{table.column(6).visible(false);
//			}
//			if (nimargin.value != "") {
//				cond += "&nimargin=" + nimargin.value.toString();
//				table.column(7).visible(true);
//			}else{table.column(7).visible(false);
//			}
//			if (roe.value != "") {
//				cond += "&roe=" + roe.value.toString();
//				table.column(8).visible(true);
//			}else{table.column(8).visible(false);
//			}
//			if (roa.value != "") {
//				cond += "&roa=" + roa.value.toString();
//				table.column(9).visible(true);
//			}else{table.column(9).visible(false);
//			}
//			if (arturnover.value != "") {
//				cond += "&arturnover=" + arturnover.value.toString();
//				table.column(10).visible(true);
//			}else{table.column(10).visible(false);
//			}
//			if (invturnover.value != "") {
//				cond += "&invturnover=" + invturnover.value.toString();
//				table.column(11).visible(true);
//			}else{table.column(11).visible(false);
//			}
//			if (apturnover.value != "") {
//				cond += "&apturnover=" + apturnover.value.toString();
//				table.column(12).visible(true);
//			}else{table.column(12).visible(false);
//			}
//			if (debtratio.value != "") {
//				cond += "&debtratio=" + debtratio.value.toString();
//				table.column(13).visible(true);
//			}else{table.column(13).visible(false);
//			}
//			if (currentratio.value != "") {
//				cond += "&currentratio=" + stockid.value.toString();
//				table.column(14).visible(true);
//			}else{table.column(14).visible(false);
//			}
//			if (fcfgrowth.value != "") {
//				cond += "&fcfgrowth=" + stockid.value.toString();
//				table.column(15).visible(true);
//			}else{table.column(15).visible(false);
//			}
//			if (ocfgrowth.value != "") {
//				cond += "&ocfgrowth=" + stockid.value.toString();
//				table.column(16).visible(true);
//			}else{table.column(16).visible(false);
//			}
//			if (revenuesgrowth.value != "") {
//				cond += "&revenuesgrowth=" + stockid.value.toString();
//				table.column(17).visible(true);
//			}else{table.column(17).visible(false);
//			}
//			return cond;
//		}