$(document).ready(function() {
	
	//默认选中菜单[焦点菜单]
	$(".photoSelectMenu #uploadPhoto").addClass("current");
	$('.photoUploadBox').css("display","inline");
	$(".photoSelectMenu .menu").click(function() {
		$(".photoSelectMenu .menu").removeClass("current");
		$(this).addClass("current");
		var menuId = $(this).attr("id");
		avatarSelect(menuId);
		
	});
	//查看相册
	function avatarSelect(menuId){
		if (menuId == "uploadPhoto") {
			location.reload();
			$('.photoUploadBox').css("display","inline");
			$('.photoSelectBox').css("display","none");
			$('.photoSelectMenu .album-list-box').empty();
		}else if (menuId == "albumPhoto") {
			disableJcrop();
			$('.photoSelectBox').css("display","inline");
			var keeno = $("#keeno").val();
			var params = {keeno:keeno};
			var jsonDate = $.param(params);
			$.ajax({url: "albumOfAvatar.html", success: function(data) {addAlbum(data)}, type: "post", dataType: "json", data: params, error: function(XMLHttpRequest, textStatus, errorThrown){alert(errorThown);}});
		}
	}
	//添加相册
	function addAlbum(data){
		if(data != ""){
			$('.photoSelectMenu .album-list-box').empty();
			
			for(var i = 0, l = data.albumGroupList.length; i < l; i++){
				var albumGroup = data.albumGroupList[i];
				var albumGroupId = albumGroup.albumGroupId;
				var albumGroupName = albumGroup.albumGroupName;
				$('.photoSelectMenu .album-list-box').append("<div class='album-group' id='group"+albumGroupId+"'><p>"+albumGroupName+"<p></div>");
				
				for(var j = 0, k = data.albumNameList.length; j < k; j++) {
					var albumNames = data.albumNameList[j];
					var albumId = albumNames.albumId;
					var albumName = albumNames.albumName;
					var belongAlbumGroupId = albumNames.belongAlbumGroupId;
					
					$('.photoSelectMenu .album-list-box').append("<div class='album-box' id='albumgroup'"+albumGroupId+"'></div>");
						if (belongAlbumGroupId == albumGroupId) {
							$('.photoSelectMenu .album-list-box').append("<div class='album' id='"+albumId+"'><div class='album-cover'><img src='keekan/img/album.jpg' alt='无法显示时的替代文字' /></div><div class='album-name'>"+albumName+"</div></div>");
						}
				}
			}
		}
	}
	
	//查看缩略图
	$(".album").dblclick(function(){
		var albumId = $(this).attr('id');
		viewPhotoThumbnail(albumId);
		alert(albumId);
	});
	
	//查看缩略图
	function viewPhotoThumbnail(albumId){
		var params = "albumId="+ albumId;// 序列化表单的值
		$.ajax({url: "photoThumbnailAction.html", success: function(data) {addPhotoThumbnail(data)}, type: "post", dataType: "json", data: params, error: function(XMLHttpRequest, textStatus, errorThrown){alert(errorThown);}});
	}
	function addPhotoThumbnail(){
		if(data != ""){
			for(var i = 0, l = data.photoList.length; i < l; i++){
				var photo = data.photoList[i];
				var photoId = photo.photoId;
				var photoName = photo.photoName;
				var belongAlbumId = photo.belongAlbumId;
				$('.avatarSelect-main .uploadPhoto-box').empty().append("<img src='keekan/photo/"+photoName+"' id='"+photoId+"'/>");
			}
		}
	}
	
	//上传照片
	$("#fileInput").bind('change',function(){
		var settings = {reg:"png|jpe?g|gif|bmp", error:'照片格式不正确，请重新选择。'};
		var fileVal = $(this).val();
		var imgName = fileVal.slice(fileVal.lastIndexOf("\\")+1);
		if(fileVal.match(new RegExp(".(" + settings.reg + ")$", "i"))){
			var options = {url:"avatarUpload.html", type:"POST", dataType:"script", success : function(msg) {showPhoto(msg);}};
			$("#form").ajaxSubmit(options);
		}else{
			alert(settings.error);
			$("#fileInput").val("");
		}
		return false;
	});
	//显示上传的照片
	var photoName;
	function showPhoto(msg){
		if (msg.indexOf("#") > 0) {
			var data = msg.split("#");
			photoName = data[1];
			$('.photoUploadBox, .photoSelectBox').css("display","none");
			$('.photoEditorBox').css("display","inline");
			$('.avatarEditorBox .avatarImg').empty().append("<img id='imgCrop' src='http://localhost/kan/"+data[0]+"/avatar/"+data[1]+"' />");
			$('.avatarPreviewBox .preview100').empty().append("<img id='preview100' src='http://localhost/kan/"+data[0]+"/avatar/"+data[1]+"' />");
			$('.avatarPreviewBox .preview50').empty().append("<img id='preview50' src='http://localhost/kan/"+data[0]+"/avatar/"+data[1]+"' />");
			$('.avatarPreviewBox .preview30').empty().append("<img id='preview30' src='http://localhost/kan/"+data[0]+"/avatar/"+data[1]+"' />");
			showJcrop();
		} else {
			$(".photoUploadMain").html(msg);
		}
	}
	var x, y, w, h;
	//显示切割工具
	
	var jcrop_api, boundx, boundy;
	function showJcrop(){
		initJcrop();
		function initJcrop() {
			$('#imgCrop').Jcrop({bgOpacity: 0.5, bgColor: 'white', addClass: 'jcrop-light',onChange : updatePreview}, 
				function() {
					var bounds = this.getBounds();
					boundx = bounds[0];
					boundy = bounds[1];
					jcrop_api = this;
					jcrop_api.animateTo( [10, 10, 101, 101 ]);
				});
		};
		function updatePreview(c) {
			x = Math.floor(c.x);
			y = Math.floor(c.y);
			//$('#x2').val(Math.floor(c.x2));
			//$('#y2').val(Math.floor(c.y2));
			w = Math.floor(c.w);
			h = Math.floor(c.h);
			if (parseInt(c.w) > 0) {
				var rx = 100 / c.w;
				var ry = 100 / c.h;
				var rx5 = 50 / c.w;
				var ry5 = 50 / c.h;
				var rx3 = 30 / c.w;
				var ry3 = 30 / c.h;
				$('#preview100').css({width: Math.round(rx * boundx) + 'px',height: Math.round(ry * boundy) + 'px', marginLeft: '-' + Math.round(rx * c.x) + 'px',marginTop: '-' + Math.round(ry * c.y) + 'px'});
				$('#preview50').css({ width: Math.round(rx5 * boundx) + 'px', height: Math.round(ry5 * boundy) + 'px', marginLeft: '-' + Math.round(rx5 * c.x) + 'px', marginTop: '-' + Math.round(ry5 * c.y) + 'px'});
				$('#preview30').css({ width: Math.round(rx3 * boundx) + 'px', height: Math.round(ry3 * boundy) + 'px', marginLeft: '-' + Math.round(rx3 * c.x) + 'px', marginTop: '-' + Math.round(ry3 * c.y) + 'px'});
			}
		};
	}
	function disableJcrop(){
		jcrop_api.destroy();
	}
	$("#avatarCut").click(function(){
		var params = {x:x, y:y, w:w, h:h, photoName:photoName};
		var jsonDate = $.param(params);
		$.ajax({url: "avatarCut.html", success: function(data) {cutSuccess(data)}, type: "post", dataType: "json", data: params, error: function(XMLHttpRequest, textStatus, errorThrown){alert(errorThown);}});
	});
	function cutSuccess(data){
		alert("保存成功");
		location.reload();
	}
});
























 