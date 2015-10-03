$(document).ready(function() {
	//插入图片
	$(".adorePublishBox .insertPicture").click(function(){
		$(".adorePublishBox .pictureDialog").show(500);
		$(".adorePublishBox .pictureDialog").empty().append("<iframe id='' frameborder='0' scrolling='no' class='friendIframe' src='insertPhoto.html'></iframe>");
	});
	
	showInsertPhoto = function(uploadDate, uploadTime){
		$(".adorePublishBox .pictureDialog").hide();
		var keeno = $("#keeno").val();
		var	params = $.param({keeno:keeno, uploadDate:uploadDate, uploadTime:uploadTime}), callback = showInsertPhotoThum;
		jajax('insertPhotoThum.html', params, callback);
	}
	
	function showInsertPhotoThum(data){
		if (data != null) {
			$(".adorePublishBox .AlreadyJoin").append("<div class='joinPhotoNumber'>已添加 "+data.adorePhotoList.length+" 张照片</div>" +
					"<div class='joinPhoto'></div>");
			for(var i = 0, l = data.adorePhotoList.length; i < l; i++){
				var adorePhoto = data.adorePhotoList[i], keeno = adorePhoto.keeno, adorePhotoId = adorePhoto.adorePhotoId, photoName = adorePhoto.photoName;
				$('.adorePublishBox .joinPhoto').append("<div class='photoThum'><img src='http://localhost/kan/"+keeno+"/adore_thum/"+photoName+"' /></div>");
			}
			var adorePhoto = data.adorePhotoList[0], createDate = adorePhoto.createDate;
			$(".adorePublishBox .AlreadyJoin").append("<input type='hidden' value='"+createDate+"' id='createDate'/>");
		}
		
		$(".AlreadyJoin .joinPhoto").show(100);
		setTimeout(function(){$('.adorePublishBox .joinPhoto').fadeOut();}, (1 * 1000)); 
	}
	
	$(document).on("mouseover", ".AlreadyJoin .joinPhotoNumber", function() {
		$(".AlreadyJoin .joinPhoto").show(100);
    });
	
	$(document).on("mouseout", ".AlreadyJoin .joinPhotoNumber", function() {
		setTimeout(function(){$('.adorePublishBox .joinPhoto').fadeOut();}, (1 * 1000)); 
    });
	
	/*-------------------------------倾心提交---------------------------------*/
	$(".adorePublishBox .publish").click(function(){
		var content = $("#content").val(), createDate = $("#createDate").val();
		var	params = $.param({content:content, createDate:createDate}), callback = addAdoreCall;
		jajax('addAdore.html', params, callback);
	});
	
	function addAdoreCall(data){
		
	}
	//jquery ajax 
	function jajax(action, params, callback){
		$.ajax({url: action, type: "post", dataType: "json", data: params, success: callback, error: function(XMLHttpRequest, textStatus, errorThrown){alert(XMLHttpRequest);alert(textStatus);alert(errorThown);}});
	}
});
