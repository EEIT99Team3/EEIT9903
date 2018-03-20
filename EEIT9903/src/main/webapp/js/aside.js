$(function(){
	toggleAside();
    showMyFafovrite();
    deleteMyFavrite();
    addMyFavorite();
});

function toggleAside(){	
    var duration = 300;
    // aside ----------------------------------------
    var $aside = $('.page-main > aside');
    var $asidButton = $aside.find('button.slider')
        .on('click', function(){
            $aside.toggleClass('open');
            if($aside.hasClass('open')){
                $aside.stop(true).animate({right: '0px'}, duration, 'easeOutBack');
                $asidButton.find('img').attr('src', 'http://localhost:8080/EEIT9903/images/btn_close.png');
            }else{
                $aside.stop(true).animate({right: '-297px'}, duration, 'easeInBack');
                $asidButton.find('img').attr('src', 'http://localhost:8080/EEIT9903/images/btn_open.png');
            };
        });
};


function showMyFafovrite(){
	var $aside = $('.page-main > aside');
	var $asidButton = $aside.find('button');
    $asidButton.on('click',function(){
    	var url = '/EEIT9903/p/tracking.do';
    	$.ajax({
			type : "get",
			url : url,
			dataType : "json",
			success : function(data){
				var tb=$('#stockTable>tbody').empty();
				
				$.each(data,function(index,value){
					var cell1 = $('<td class="myFav"></td>').text(value.stock_id);
					var cell2 = $('<td class="myFav"></td>').text(value.stock_price);
					var cell3 = $('<td class="myFav"></td>').html('<button class="deleteBtn">刪除</button>');
					var row =$('<tr class="myFav"></tr>').append([cell1,cell2,cell3]);	
					tb.append(row);
				//	var cell5 = $('<td></td>').html('<button class="btn btn-danger"><i class="fas fa-trash-alt"></i></button>');
				//	$("#myList").append(cell1);
				//	console.log("index:" + index +" value:" + value.stock_id);
					
				})
			}
    	})
    })
}

function deleteMyFavrite(){
	$('#stockTable>tbody').on('click','tr button:nth-child(1)',function(){
		   var stock_id = $(this).parents('tr').find('td:nth-child(1)').text();
		   
		   var url = '/EEIT9903/p/stockDelete.do?';
//			url = url +"stock_id=" + stock_id;
//			$.ajax({
//				type : "get",
//				url : url,
//				dataType : "json",
//				success : function(data){
//					alert(data);
//					refreshpage();
//					}
//				})
		   
		   $.get('/EEIT9903/p/stockDelete.do',{stock_id:stock_id},function(data){
			   alert(data);
			   refreshpage();
		   })
	  })
}

function refreshpage(){
	var url = '/EEIT9903/p/tracking.do';
	$.ajax({
		type : "get",
		url : url,
		dataType : "json",
		success : function(data){
			var tb=$('#stockTable>tbody').empty();
			
			$.each(data,function(index,value){
				var cell1 = $('<td class="myFav"></td>').text(value.stock_id);
				var cell2 = $('<td class="myFav"></td>').text(value.stock_price);
				var cell3 = $('<td class="myFav"></td>').html('<button class="deleteBtn">刪除</button>');
				var row =$('<tr class="myFav"></tr>').append([cell1,cell2,cell3]);	
				tb.append(row);
			//	var cell5 = $('<td></td>').html('<button class="btn btn-danger"><i class="fas fa-trash-alt"></i></button>');
			//	$("#myList").append(cell1);
			//	console.log("index:" + index +" value:" + value.stock_id);
				
			})
		}
	})
}

function addMyFavorite(){
	$('.addBtn').click(function(){
		var stock_id = $("#stock_id").val();
		
		var url = '/EEIT9903/p/stockAdd.do?';
//		url = url +"stock_id=" + stock_id;
//		
//		$.ajax({
//			type : "get",
//			url : url,
//			dataType : "json",
//			success : function(data){
//				alert(data);
//				refreshpage();
//				}
//			})
			
		//console.log(stock_id);
		$.get('/EEIT9903/p/stockAdd.do',{stock_id:stock_id},function(data){
		  alert(data);
		  refreshpage();
		});
	});
};

