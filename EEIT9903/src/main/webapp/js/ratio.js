var table = null;
var stockid;
var ratyear;
var ratseason;
var eps;
var bvps;
var gpmargin;
var opmargin;
var nimargin;
var roe;
var roa;
var arturnover;
var invturnover;
var apturnover;
var debtratio;
var currentratio;
var fcfgrowth;
var ocfgrowth;
var revenuesgrowth;

function condition() {// 動態產生查詢條件
	var cond = "/EEIT9903/ratio/data?stockid=";

	if (ratyear != "") {
		cond += "&ratyear=" + ratyear.toString();
		console.log(cond);
	}

	if (ratseason != "") {
		cond += "&ratseason=" + ratseason.toString();
		console.log(cond);
	}
	if (eps != "") {
		cond += "&eps=" + eps.toString();
		console.log(cond);
	}

	if (bvps != "") {
		cond += "&bvps=" + bvps.toString();
		console.log(cond);
	}

	if (gpmargin != "") {
		cond += "&gpmargin=" + gpmargin.toString();
		console.log(cond);
	}
	;
	if (opmargin != "") {
		cond += "&opmargin=" + opmargin.toString();
		console.log(cond);
	}
	if (nimargin != "") {
		cond += "&nimargin=" + nimargin.toString();
		console.log(cond);
	}
	if (roe != "") {
		cond += "&roe=" + roe.toString();
		console.log(cond);
	}
	if (roa != "") {
		cond += "&roa=" + roa.toString();
		console.log(cond);
	}
	if (arturnover != "") {
		cond += "&arturnover=" + arturnover.toString();
		console.log(cond);
	}
	if (invturnover != "") {
		cond += "&invturnover=" + invturnover.toString();
		console.log(cond);
	}
	if (apturnover != "") {
		cond += "&apturnover=" + apturnover.toString();
		console.log(cond);
	}
	;
	if (debtratio != "") {
		cond += "&debtratio=" + debtratio.toString();
		console.log(cond);
	}
	if (currentratio != "") {
		cond += "&currentratio=" + currentratio.toString();
		console.log(cond);
	}
	if (fcfgrowth != "") {
		cond += "&fcfgrowth=" + fcfgrowth.toString();
	}
	if (ocfgrowth != "") {
		cond += "&ocfgrowth=" + ocfgrowth.toString();
	}
	if (revenuesgrowth != "") {
		cond += "&revenuesgrowth=" + revenuesgrowth.toString();
	}
	console.log(cond);
	return cond;
}

function dynamicolumn() {
	if (eps != "") {
		table.column(3).visible(true);
	} else {
		table.column(3).visible(false);
	}
	;
	if (bvps != "") {
		table.column(4).visible(true);
	} else {
		table.column(4).visible(false);
	}
	;
	if (gpmargin != "") {
		table.column(5).visible(true);
	} else {
		table.column(5).visible(false);
	}
	;
	if (opmargin != "") {
		table.column(6).visible(true);
	} else {
		table.column(6).visible(false);
	}
	;
	if (nimargin != "") {
		table.column(7).visible(true);
	} else {
		table.column(7).visible(false);
	}
	;
	if (roe != "") {
		table.column(8).visible(true);
	} else {
		table.column(8).visible(false);
	}
	;
	if (roa != "") {
		table.column(9).visible(true);
	} else {
		table.column(9).visible(false);
	}
	;
	if (arturnover != "") {
		table.column(10).visible(true);
	} else {
		table.column(10).visible(false);
	}
	;
	if (invturnover != "") {
		table.column(11).visible(true);
	} else {
		table.column(11).visible(false);
	}
	;
	if (apturnover != "") {
		table.column(12).visible(true);
	} else {
		table.column(12).visible(false);
	}
	;
	if (debtratio != "") {
		table.column(13).visible(true);
	} else {
		table.column(13).visible(false);
	}
	;
	if (currentratio != "") {
		table.column(14).visible(true);
	} else {
		table.column(14).visible(false);
	}
	;
	if (fcfgrowth != "") {
		table.column(15).visible(true);
	} else {
		table.column(15).visible(false);
	}
	;
	if (ocfgrowth != "") {
		table.column(16).visible(true);
	} else {
		table.column(16).visible(false);
	}
	;
	if (revenuesgrowth != "") {
		table.column(17).visible(true);
	} else {
		table.column(17).visible(false);
	}
}
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
// 選取條件時的動作
$(".condition").click(function(event, ui) {
	$(this).css('visibility', 'hidden');
	clickeds = $(this).attr('id').toString() + "s";
	$(document.getElementById(clickeds)).css('visibility', 'visible');
	$('#start').css('visibility', 'visible');
	$('#selected').css('visibility', 'visible');
	clicked = $(this).attr('id').toString() + "t";
	var t = document.getElementById(clicked);
	$(t).css('display', 'block');
});
// 刪除已選條件時的動作
$(".ccondition").click(
		function(event, ui) {
			$(this).css('visibility', 'hidden');
			clickback = $(this).attr('id').toString().slice(0,
					$(this).attr('id').toString().length - 1);
			$(document.getElementById(clickback)).css('visibility', 'visible');
			clickbackt = clickback + "t";
			$(document.getElementById(clickbackt)).css('display', 'none');
			// $(clickbacktselect)[0].selectedIndex = 0;
		});
// 取值後送出
$('#sub').click(function() {
	ratyear = document.getElementById('ratyearv').value;
	ratseason = document.getElementById('ratseasonv').value;
	eps = document.getElementById('epstv').value;
	console.log(eps);
	bvps = document.getElementById('bvpstv').value;
	gpmargin = document.getElementById('gpmargintv').value;
	opmargin = document.getElementById('opmargintv').value;
	nimargin = document.getElementById('nimargintv').value;
	roe = document.getElementById('roetv').value;
	roa = document.getElementById('roatv').value;
	arturnover = document.getElementById('arturnovertv').value;
	invturnover = document.getElementById('invturnovertv').value;
	apturnover = document.getElementById('apturnovertv').value;
	debtratio = document.getElementById('debtratiotv').value;
	currentratio = document.getElementById('currentratiotv').value;
	fcfgrowth = document.getElementById('fcfgrowthtv').value;
	ocfgrowth = document.getElementById('ocfgrowthtv').value;
	revenuesgrowth = document.getElementById('revenuesgrowthtv').value;

	table.ajax.url(condition());
	table.ajax.reload();
	dynamicolumn();
});