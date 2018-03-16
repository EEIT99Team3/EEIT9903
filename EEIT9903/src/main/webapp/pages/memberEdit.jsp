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

<link href="<c:url value="/lib/bootstrap.min.css" />" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/lib/bootstrap.min.js" />" />
<!-- Custom styles for this template -->
<link href="<c:url value="/lib/advanced Css/editmember.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/css/aside.css" />" rel="stylesheet"
	type="text/css">

<script src="<c:url value="/lib/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/lib/jquery-ui-1.10.3.custom.min.js" />"></script>
<script src="<c:url value="/js/aside.js" />"></script>

</head>

<body>

<div class="container">
	<div class="row">
<!-- 		<div class="full-width bg-transparent"> -->
<!--         <h1 class="text-center color">Custom Input file Upload</h1> -->

<!--     <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-xs-12"> -->
<!--         <div class="full-width"> -->
<!--         <input type="file" id="base-input" class="form-control form-input form-style-base"> -->
<!--         <input type="text" id="fake-input" class="form-control form-input form-style-fake" placeholder="Choose your File" readonly> -->
<!--         <span class="glyphicon glyphicon-open input-place"></span> -->
<!--     </div> -->

        <!--================== Snippet for custom input type file on button ================-->

        <div class="full-width">
            <h1 class="text-center color">Custom Input file Upload button</h1>
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <input type="file" id="main-input" class="form-control form-input form-style-base">
                    <h4 id="fake-btn" class="form-input fake-styled-btn text-center truncate"><span class="margin"> Choose File</span></h4>
                </div>

        </div>

        <!--=========================input type file change on button ends here====================-->


        <div class="full-width">
            <h1 class="text-center color">Edit Profile Snippet</h1>
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="custom-form">
                <div class="text-center bg-form">
                    <div class="img-section">
                        <img src="http://lorempixel.com/200/200/nature/" class="imgCircle" alt="Profile picture">
                        <span class="fake-icon-edit" id="PicUpload" style="color: #ffffff;"><span class="glyphicon glyphicon-camera camera"></span></span>
                    <div class="col-lg-12">
                        <h4 class="text-right col-lg-12"><span class="glyphicon glyphicon-edit"></span> Edit Profile</h4>
                        <input type="checkbox" class="form-control" id="checker">
                    </div>
                    </div>
                    <input type="file" id="image-input" onchange="readURL(this);" accept="image/*" disabled class="form-control form-input Profile-input-file" >
                </div>
                <div class="col-lg-12 col-md-12">
                    <input type="text" class="form-control form-input" value="" placeholder="Name" >
                    <span class="glyphicon glyphicon-user input-place"></span>
                </div>
                <div class="col-lg-12 col-md-12">
                    <input type="text" class="form-control form-input" value="" placeholder="Email ID" >
                    <span class="glyphicon glyphicon-envelope input-place"></span>
                </div>
                <div class="col-lg-12 col-md-12">
                    <input type="text" class="form-control form-input" value="" placeholder="Password" >
                    <span class="glyphicon glyphicon-earphone input-place"></span>
                </div>
                <div class="col-lg-12 col-md-12">
                    <input type="text" class="form-control form-input" value="" placeholder="Address" >
                    <span class="glyphicon glyphicon-map-marker input-place"></span>
                </div>
                <div class="col-lg-12 col-md-12 text-center">
                    <button class="btn btn-info btn-lg custom-btn" id="submit" disabled><span class="glyphicon glyphicon-save"></span> Save</button>
                </div>
                </div>
            </div>
        </div>

    </div>
    </div>
        
	</div>
</div>


<!--==================================== sorry I am a newbie in bootsnipp so I am unable to link js to html in bootsnipp thats why I have included the script in html ===================-->

<script>

    $('input[id=base-input]').change(function() {
        $('#fake-input').val($(this).val().replace("C:\\fakepath\\", ""));
    });

    <!--==================Javascript code for custom input type file on button ================-->

    $('input[id=main-input]').change(function() {
        console.log($(this).val());
        var mainValue = $(this).val();
        if(mainValue == ""){
            document.getElementById("fake-btn").innerHTML = "Choose File";
        }else{
            document.getElementById("fake-btn").innerHTML = mainValue.replace("C:\\fakepath\\", "");
        }
    });

    <!--=========================input type file change on button ends here====================-->

//    ===================== snippet for profile picture change ============================ //

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('.imgCircle')
                        .attr('src', e.target.result)
                        .width(200)
                        .height(200);
            };
            reader.readAsDataURL(input.files[0]);
        }
    }

//    =================================== ends here ============================================ //

    var checkme = document.getElementById('checker');
    var userImage = document.getElementById('image-input');
    var userName = document.getElementById('name');
    var userPhone = document.getElementById('phone');
    var userEmail = document.getElementById('email');
    var userPlace = document.getElementById('place');
    var UserSend = document.getElementById('submit');
    var editPic = document.getElementById('PicUpload');
    checkme.onchange = function() {
        UserSend.disabled = !this.checked;
        userImage.disabled = !this.checked;
        userName.disabled = !this.checked;
        userPhone.disabled = !this.checked;
        userEmail.disabled = !this.checked;
        userPlace.disabled = !this.checked;
        editPic.style.display = this.checked ? 'block' : 'none';
    };
    </script>
	


	</main>

	<script src="<c:url value="/lib/jquery-3.3.1.min.js" />"></script> 
	<script>
		feather.replace()
	</script>
</body>

</html>
