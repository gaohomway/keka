$(document).ready(function() {
	
	var avatarSize = $(".avatarBox").attr("id");
	$(".avatarBox").css("width", avatarSize*90+"px");
	
	if (avatarSize > 7) {
		$(".prevAvatar, .nextAvatar").css("display","inline");
	}
	 
	$(".prevAvatar").click(function() {
		var avatarBoxLeft = $(".avatarBox").css("left");
		var avatarLeft = avatarBoxLeft.substring(0, avatarBoxLeft.length - 2);
		if (avatarLeft < 0 ) {
			$(".avatarBox").animate({left:"+=90px"}, 100);
			$(".timeLine").animate({left:"+=90px"}, 100);
		}
	});
	$(".nextAvatar").click(function() {
		var avatarBoxWidth = (avatarSize-7) * 90;
		var avatarBoxLeft = $(".avatarBox").css("left");
		
		var avatarLeft = avatarBoxLeft.substring(0, avatarBoxLeft.length - 2);
		
		if (-avatarLeft < avatarBoxWidth ) {
			$(".avatarBox").animate({left : "-=90px"}, 100);
			$(".timeLine").animate({left : "-=90px"}, 100);
		}
	});
	
	//鼠标置上显示时间
	$('.avatarBox img, .timeLine .round').bind('mouseover',function(){
		var avatarId = $(this).attr('id');
		if (avatarId.length > 2) {
			var str = avatarId.substring(7, 8) 
			avatarId = str;
		}
		$('.timeLine .timeBox #roundId'+avatarId).css("border","3px solid #33ccff");
		$('.timeLine .timeBox #timeId'+avatarId).css("display","inline");
	});
	$('.avatarBox img, .timeLine .round').bind('mouseout',function(){
		var avatarId = $(this).attr('id');
		if (avatarId.length > 2) {
			var str = avatarId.substring(7, 8) 
			avatarId = str;
		}
		$('.timeLine .timeBox #roundId'+avatarId).css("border","3px solid #0099ff");
		$('.timeLine .timeBox #timeId'+avatarId).css("display","none");
	});
	
	
	//编辑标签
	$(".labelBox #label").click(function(){
		var	params = $.param({}), callback = tag;
		jajax('tag.html', params, callback);
		$(".tagSelectBox").css("display","inline");
	});
	//标签库显示
	function tag(data){
		if (data != "") {
			for(var i = 0; i < data.tagList.length; i++){
				var tag = data.tagList[i];
				var tagId = tag.tagId, tagName = tag.tagName;
				$(".tagSelect").append("<div class='tag' id='tagId"+tagId+"'><p class='tagName'>"+tagName+"</p></div>");
				$(".tagPage").append("<div class='page' id='"+tagId+"'></div>");
				
				for ( var j = 0; j < data.tagsList.length; j++) {
					var tags = data.tagsList[j];
					var tagsId = tags.tagsId, tagsName = tags.tagsName, ownTagId = tags.ownTagId;
					if (tagId == ownTagId) {
						$(".tagSelect .tag#tagId"+tagId).append("<div class='tags' id='"+tagsId+"'><p id='"+ownTagId+"'>"+tagsName+"</p></div>");
					}
				}
			}
		}
		$(".tagSelect .tag").hide();
		$(".tagSelect .tag:first").show();
	}
	
	//标签翻页
	$(document).on("click", ".tagPage .page", function(){
		$(".tagPage .page").removeClass("pageCurrent");
		$(this).addClass("pageCurrent");
		var tagId = $(this).attr("id");
		$(".tagSelect .tag").hide();
		$(".tagSelect #tagId"+tagId).show();
	});
	 
	//jquery ajax 
	function jajax(action, params, callback){
		$.ajax({url: action, type: "post", dataType: "json", data: params, success: callback, error: function(XMLHttpRequest, textStatus, errorThrown){alert(XMLHttpRequest);alert(textStatus);alert(errorThown);}});
	}
});