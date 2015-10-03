$(document).ready(function() {
	/**---------------------选项卡头添加样式-----------------------**/
	$(".insertTabHead .uploadPhoto").addClass("current");

	$(".insertTabHead .uploadPhoto").click(function() {
		$(".insertTabBody .uploadPhotoBox").show();
		$(".insertTabBody .selectAlbumBox").hide();
		$(".insertTabHead .uploadPhoto").addClass("current");
		$(".insertTabHead .selectAlbum").removeClass("current");
	});
	
	$(".insertTabHead .selectAlbum").click(function() {
		$(".insertTabBody .selectAlbumBox").show();
		$(".insertTabBody .uploadPhotoBox").hide();
		$(".insertTabHead .selectAlbum").addClass("current");
		$(".insertTabHead .uploadPhoto").removeClass("current");
	});
	
	showInsertPhoto = function (){
		$(window.parent.showInsertPhoto($(uploadDate).val(), $(uploadTime).val()));
	}

});
