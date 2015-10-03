$(document).ready(function() {
	$(".profileBox, .hobbyBox").hide();
	
	$(".carteMenu .button").click(function(){
		var menuId = $(this).attr("id");
		if (menuId == "baseInfo" || menuId == "profile") {
			$(".baseInfoBox, .profileBox").hide();
			if (menuId == "baseInfo") {
				$(".baseInfoBox").show(300);
			}else {
				$(".profileBox").show(300);
			}
		}else if (menuId == "moreInfo" || menuId == "hobby") {
			$(".moreInfoBox, .hobbyBox").hide();
			if (menuId == "moreInfo") {
				$(".moreInfoBox").show(300);
			}else {
				$(".hobbyBox").show(300);
			}
		}
	});
});