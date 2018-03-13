$(function(){
	toggleAside();
    showMyFafovrite();
    deleteMyFavrite();
});

function toggleAside(){	
    var duration = 300;
    // aside ----------------------------------------
    var $aside = $('.page-main > aside');
    var $asidButton = $aside.find('button')
        .on('click', function(){
            $aside.toggleClass('open');
            if($aside.hasClass('open')){
                $aside.stop(true).animate({right: '0px'}, duration, 'easeOutBack');
                $asidButton.find('img').attr('src', 'images/btn_close.png');
            }else{
                $aside.stop(true).animate({right: '-297px'}, duration, 'easeInBack');
                $asidButton.find('img').attr('src', 'images/btn_open.png');
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
					var cell1 = $('<td></td>').text(value.stock_id);
					var cell2 = $('<td></td>').html('<button>刪除</button>');
					var row =$('<tr></tr>').append([cell1,cell2]);	
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
		   var id = $(this).parents('tr').find('td:nth-child(1)').text();
		   $.get('stockDelete.do',{stock_id:id},function(data){
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
				var cell1 = $('<td></td>').text(value.stock_id);
				var cell2 = $('<td></td>').html('<button>刪除</button>');
				var row =$('<tr></tr>').append([cell1,cell2]);	
				tb.append(row);
			//	var cell5 = $('<td></td>').html('<button class="btn btn-danger"><i class="fas fa-trash-alt"></i></button>');
			//	$("#myList").append(cell1);
			//	console.log("index:" + index +" value:" + value.stock_id);
				
			})
		}
	})
}