$(document).ready(function() {
	
	 //保存照片信息
	$('#save').click(function(){
		var rawPhotoName = $('input[name=rawPhotoName]').val();
		var photoDescription = $('#photoDescription').val();
		var ownAlbumId = $('#ownAlbumId').val();
		var uploadDate = $('#uploadDate').val();
		var uploadTime = $('#uploadTime').val();
		var params = {rawPhotoName:rawPhotoName, photoDescription:photoDescription, ownAlbumId:ownAlbumId, uploadDate:uploadDate, uploadTime:uploadTime};
		var param = $.param(params);
		$.ajax({url: "savePhotoInof.html", success: function(data) {friendGroupShow(data)}, type: "post", dataType: "json", data: params, error: function(XMLHttpRequest, textStatus, errorThrown){alert(errorThown);}});
		
	});
	function friendGroupShow(data){
		
		alert("更新成功，转向相册！");
		window.location.href = "album.html";
	}
});
