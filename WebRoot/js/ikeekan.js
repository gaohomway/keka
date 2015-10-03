$(function() {
	
	$('.navigation-li a').click(function(ev) {
		var productId = $(this).attr("id");
		alterURL(productId);
		loadProduct(productId);									
		ev.preventDefault();									//取消超链接的事件和默认动作
	});
	
	if (window.location.hash) {									//此出是进入页面后，必须走的
		window.location.hash;
		var path = window.location.hash;
		var productId = path.substring(1, path.length);
		loadProduct(productId);											//根据path加载默认实例
	}		
	
	function alterURL(productId){					//改变URL
		window.location.hash = productId;
	}
	
	function loadProduct(productId){				//加载产品
		if (productId == "friend") {
			$('div.product-main-box').empty().append("<iframe frameborder='0' scrolling='no' class='product-iframe' src=''></iframe>");
		}else if(productId == "home"){
			$('div.product-main-box').empty().append("<iframe frameborder='0' scrolling='no' class='product-iframe' src='FriendAction!friendInit.html'></iframe>");
		}else{
			$('div.product-main-box').empty().append("<iframe frameborder='0' scrolling='no' class='product-iframe' src='keekan/jsp/"+productId+".jsp'></iframe>");
		}
	}
	 
});

//头像编辑弹框
function avatarEditorPop(pagePath, pageTitle){
	
	var $dialog = $('<div></div>')
		.html('<iframe id="avatarEditorIframe" frameborder="no" scrolling="no" src="' + pagePath + '"></iframe>')
		.dialog({
            autoOpen: false,
            modal: true,
            width: 440,
            height: 460,
            title: pageTitle,
            buttons: {
				"保存头像": function() {
					$(window.parent.document).contents().find("#createAlbumIframe")[0].contentWindow.submitCreateAlbumForm();
					$( this ).dialog( "close" );
				},
				"取消": function() {
					$( this ).dialog( "close" );
				}
			}
        });
        $dialog.dialog('open');
}

//创建相册弹框
function createAlbumPop(pagePath, pageTitle){
	
	var $dialog = $('<div></div>')
		.html('<iframe id="createAlbumIframe" frameborder="no" scrolling="no" src="' + pagePath + '"></iframe>')
		.dialog({
            autoOpen: false,
            modal: true,
            width: 440,
            height: 460,
            title: pageTitle,
            buttons: {
				"创建相册": function() {
					$(window.parent.document).contents().find("#createAlbumIframe")[0].contentWindow.checkCreateAlbumForm();
					$( this ).dialog( "close" );
				},
				"取消": function() {
					$( this ).dialog( "close" );
				}
			}
        });
        $dialog.dialog('open');
}