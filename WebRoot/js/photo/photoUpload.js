$(document).ready(function() {
	//相册列表隐藏/显示
	$(".album-box").hide();
	$(".album-group").click(function(){
		var groupId = $(this).attr('id');
		$("#album" + groupId).toggle();
	});
	
	$(".album").click(function(){
		var albumId = $(this).attr('id');
		$("input[name='albumId']").val(albumId);
		$(".album").css("background-color","#FFF");
		$(this).css("background-color","#56AAFF");
	});
	
	
});
