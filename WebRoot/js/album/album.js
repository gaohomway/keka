$(document).ready(function() {
	
	$(".albumGroupBox .albumGroup:first").addClass("focus");
	$(".albumMainBox .albumBox:first").show();
	
	/**----------------相册管理菜单------------------*/
	var timeOut = 500, closeTimer = 0, ddmenuitem = 0;
	$(".albumMenuBox > li").bind('mouseover', albumMenuOpen);
	$(".albumMenuBox > li").bind('mouseout',  albumMenuTimer);
	function albumMenuOpen() {
		$(".albumMenuBox .albumMenu").addClass("focus");
		albumMenuCancelTimer();
		//albumMenuClose();
		ddmenuitem = $(this).find('ul').eq(0).css('visibility', 'visible');
	}
	function albumMenuClose() {	
		if(ddmenuitem) ddmenuitem.css('visibility', 'hidden');
		$(".albumMenuBox .albumMenu").removeClass("focus");
	}
	function albumMenuTimer() {	
		closeTimer = window.setTimeout(albumMenuClose, timeOut);
	}
	function albumMenuCancelTimer() {	
		if(closeTimer) {	
			window.clearTimeout(closeTimer);
			closeTimer = null;
		}
	}
	document.onclick = albumMenuClose;
	
	/**---------------------相册管理菜单分配-----------------------**/
	//菜单分配
	$(".albumMenuBox li ul li").click(function(){
		var menuId = $(this).attr("id");
		if (menuId == "uploadPhoto") {
			$(window.parent.uploadPhoto(menuId));
		}
		if (menuId == "addAlbumGroup") {
			$('.albumListBox').append("<div class='AddAlbumGroup' id=''><div class='addSign'><div></div></div><div class='addGroup'>添加分组</div></div><div class='close'>完成</div>");
		}else if(menuId == "deleteAlbumGroup"){
			$('.albumGroup').after("<div class='EDS'><div class='D' title='删除此分类'></div></div>");
		}else if (menuId == "editAlbumGroup") {
			$('.albumGroup').after("<div class='EDS'><div class='E' title='编辑此分类'></div></div>");
		
		}else if (menuId == "addAlbum") {
			$('.albumGroup').after("<div class='ADES'><div class='addAlbumB' title='创建相册'></div></div>");
		}else if (menuId == "deleteAlbum") {
			$('.albumGroup').after("<div class='ADES'><div class='deleteAlbumB' title='删除相册'></div></div>");
		}else if (menuId == "editAlbum") {
			$('.albumGroup').after("<div class='ADES'><div class='editAlbumB' title='编辑相册'></div></div>");
		}
	});
	
	/**---------------------相册分组切换-----------------------**/
	$(".albumGroupBox .albumGroup").click(function(){
		var albumGroupId = $(this).attr("id");
		$(".albumGroupBox .albumGroup").removeClass("focus");
		$(this).addClass("focus");
		$(".albumMainBox .albumBox").hide();
		$(".albumMainBox #album"+albumGroupId).show();
	});
	
	/**-----------------------查看缩略图----------------------------**/
	$(".albumMainBox .album").click(function(){
		var albumId = $(this).attr('id'), params = $.param({albumId:albumId,startPhoto:0}), callback = viewPhotoThum;
		jajax('photoThum.html', params, callback);
	});
	
	//查看缩略图
	function viewPhotoThum(data){
		if(data != ""){
			viewAlbumInfo(data);
			viewThum(data);
			viewThumPaged(data);
			$(".photoMainBox").css("display","inline");
		}
	}
	
	//添加相册信息
	function viewAlbumInfo(data){
		$(".photoMainBox .photoThumMainBox").empty().append("<div class='albumInfo' id="+data.albumId+">" +
				"<div class='return'></div><div class='albumName'>"+data.albumList[0].albumName+"</div>" +
				"</div><div class='photoThumBox'></div>");
	}
	
	//显示照片缩略图
	function viewThum(data){
		var keeno = $("#keeno").val();
		$(".photoMainBox .photoThumMainBox .photoThumBox").empty();
		for(var i = 0, l = data.photoList.length; i < l; i++){
			var photo = data.photoList[i], photoId = photo.photoId, rawPhotoName = photo.rawPhotoName, photoName = photo.photoName, belongAlbumId = photo.belongAlbumId;
			$(".photoThumMainBox .photoThumBox").append("<div class='photoThum' id='"+rawPhotoName+"'><img src='http://localhost/kan/"+keeno+"/photo_thum/"+photoName+"' id='"+photoId+"'/></div>");
		}
	}
	
	//显示分页
	function viewThumPaged(data){
		if (data.sumPage >= 2) {
			$(".photoMainBox .photoThumMainBox").append("<div class='thumPagedBox' id='"+data.sumPage+"'></div>");
			for(var i = 1, l = data.sumPage; i <= l; i++){
				$(".photoMainBox .thumPagedBox").append("<a class='thumPaged' id='page"+i+"'>&nbsp;</a>");
			}
			$(".photoMainBox .thumPagedBox .thumPaged:first").addClass("focus");
		}
	}
	
	//翻页操作
	$(".photoMainBox .thumPagedBox .thumPaged").live("click", function(){
		var pageId = $(this).attr("id");
		var focusId = $(".photoMainBox .thumPagedBox .thumPaged.focus").attr("id");
		if (pageId != focusId) {
			$(".photoMainBox .thumPagedBox .thumPaged").removeClass("focus");
			$(this).addClass("focus");
			var pageId = pageId.substring(4, pageId.length);
			var albumId = $(".photoMainBox .albumInfo").attr('id');
			var params = $.param({albumId:albumId, pageId:pageId}), callback = viewThum;
			jajax('viewPhotoPage.html', params, callback);
		}
	});
	
	//返回相册
	$(".photoThumMainBox .return").live("click", function(){
		$(".photoMainBox .photoThumMainBox").empty();
		$(".photoMainBox").css("display","none");
	});
	
	/**-----------------------查看照片----------------------------**/
	$(".photoThumBox .photoThum img").live('click', function(){
		var photoId = $(this).attr('id'), params = $.param({photoId:photoId}), callback = viewPhotoReview;
		jajax('viewPhotoAction.html', params, callback);
	});
	
	//显示照片|评论
	function viewPhotoReview(data){
		$(".photoReviewMainBox").css("display","inline");
		if (data != null) {
			viewPhoto(data);
			viewReview(data);
			scrollInit("reviewBox");
			//autoHeight();
			
		}
	}
	//显示照片
	function viewPhoto(data){
		var keeno = $("#keeno").val(), photo = data.photoList[0], photoId = photo.photoId, photoName = photo.photoName, photoDescription = photo.photoDescription, belongAlbumId = photo.belongAlbumId;
		$(".photoReviewMainBox").append("<div class='photoBox'><img class='photo' id='"+photoId+"' src='http://localhost/kan/"+keeno+"/photo/"+photoName+"' id='"+photoId+"'/></div>");
		
		//$('.photoMainBox .photoDescribe .avatar').append("<img class='avatar' src='http://localhost/kan/"+keeno+"/avatar/"+data.avatarList[0].midAvatar+"' id='avatar' />");
		//$('.photoMainBox .photoDescribe .describe').append("<p>"+photoDescription+"</p>");
		//showComment(data);
	}
	
	
	//显示评论
	function viewReview(data){
		var keeno = $("#keeno").val();
		var nickname = data.userList[0].nickname;
		$(".photoReviewMainBox").append("<div class='photoReviewBox'>" +
				"<div class='avatarBox'>" +
					"<img class='avatar' src='http://localhost/kan/"+keeno+"/avatar/"+data.avatar[0].midAvatar+"' id='avatar' />" +
					"<div class='nickname'>"+nickname+"</div>" +
				"</div>" +
				"<div class='reviewBox'>" +
				
				"</div>"+
				"<div class='publishBox'>" +
				"<textarea class='reviewContent' name='reviewContent' id='reviewContent'></textarea>" +
				"<div class='operate'>" +
					"<input type='button' value='发表' id='review'/>" +
				"</div>" +
			"</div>" +
			"</div>");
		if (data.reviewList != null) {
			
			for ( var i = 0; i < data.reviewList.length; i++) {
				 
				var r = data.reviewList[i], a = data.avatarReview[i], u = data.userReview[i];
				
				var reviewId = r.reviewId, reviewKeeno = r.reviewKeeno, reviewDate = r.reviewDate, reviewContent = r.reviewContent;
				
				var nickname = u.nickname;
				var smallAvatar = a.smallAvatar;
				
				$('.photoReviewMainBox .reviewBox').append(
						"<div class='review' id='"+reviewId+"'>" +
							"<div class='avatar'>" +
								"<img src='http://localhost/kan/"+reviewKeeno+"/avatar/"+smallAvatar+"' alt=''/>" +
							"</div>" +
							"<div class='nickname' id='"+nickname+"'>" +
									"<a href='#'>"+nickname+"</a>" +
							"</div>" +
							"<div class='reviewContent'>"+reviewContent+"</div>" +
							"<div class='reviewDate'>"+reviewDate+"<a href='javascript:void(0);' id='"+reviewId+"'>回复</a></div>" +
						"</div>");
			}
		}
	}
	
	//提交评论 
	$(".photoReviewMainBox #review").live("click", function(){
		var keeno = $("#keeno").val(), reviewContent = $(".photoReviewMainBox #reviewContent").val();
		var photoId = $(".photoReviewMainBox .photoBox .photo").attr('id');
		reviewSubmit(keeno, photoId, reviewContent);
		
	});
	
	//提交评论
	function reviewSubmit(keeno, photoId, reviewContent){
		var params = $.param({reviewKeeno:keeno, photoId:photoId, reviewContent:reviewContent}), callback = reviewSuccess;
		jajax('photoReview.html', params, callback);
	}
	//评论回调
	function reviewSuccess(data){
		if(data != ""){
			var photoId = data.photoId, reviewId = data.reviewId, reviewKeeno = data.reviewKeeno, reviewContent = data.reviewContent, reviewDate = data.reviewDate;
			var midAvatar = data.avatarList[0].midAvatar;
			var nickname = data.userList[0].nickname; 
			$('.photoReviewMainBox .reviewBox').append(
					"<div class='review' id='"+reviewId+"'>" +
						"<div class='avatar'>" +
							"<img src='http://localhost/kan/"+reviewKeeno+"/avatar/"+midAvatar+"' alt=''/>" +
						"</div>" +
						"<div class='nickname' id='"+nickname+"'><a href='#'>"+nickname+"</a></div>" +
						"<div class='reviewContent'>"+reviewContent+"</div>" +
						"<div class='reviewDate'>"+reviewDate+"<a href='javascript:void(0);' id='"+reviewId+"'>回复</a></div>" +
					"</div>");
		}
	}
	
	//框架自适应高度
	function autoHeight(){
		document.getElementById("photoId").onload = function() {
			var autoHeight = $(".photoReviewMainBox .photoBox .photo").height();
			var height = autoHeight + 150;
			$(window.parent.document).find("#main").height(height);
		}; 
	}
	
	//jquery ajax 
	function jajax(action, params, callback){
		$.ajax({url: action, type: "post", dataType: "json", data: params, success: callback, error: function(XMLHttpRequest, textStatus, errorThrown){alert(XMLHttpRequest);alert(textStatus);alert(errorThown);}});
	}
	
	//缩略图滚动条
	function scrollInit(scrollId){
		$("."+scrollId).jscroll({ W:"7px"								//设置滚动条宽度
			,Bg:"#F5F5F5"												//设置滚动条背景图片position,颜色等
			,Bar:{Pos:"up"
			,Bd:{Out:"#CDCDCD",Hover:"#A6A6A6"}							//设置滚动滚轴边框颜色：鼠标离开(默认)，经过
			,Bg:{Out:"#CDCDCD",Hover:"#A6A6A6",Focus:"#606060"}}		//设置滚动条滚轴背景：鼠标离开(默认)，经过，点击
			,Btn:{btn:false												//是否显示上下按钮 false为不显示
			,uBg:{Out:"0 0",Hover:"-15px 0",Focus:"-30px 0"}			//设置上按钮背景：鼠标离开(默认)，经过，点击
			,dBg:{Out:"0 -15px",Hover:"-15px -15px",Focus:"-30px -15px"}}//设置下按钮背景：鼠标离开(默认)，经过，点击
			,Fn:function(){}											//滚动时候触发的方法
			});
	}
});
