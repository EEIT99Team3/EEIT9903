$(function(){
    // 
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
    
    
    $asidButton.on('click',function(){
    	var url = '/EEIT9903/p/tracking.do';
    	$.ajax({
			type : "post",
			url : url,
			dataType : "json",
			success : function(data){
				console.log(data);
				console.log("success");
			}
    	})
    })

});