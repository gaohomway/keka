$(document).ready(function() {
	
	/**
	 * jddm:jquery drop-down menu[jquery 下拉菜单]
	 */
	var timeout = 500;
	var closetimer = 0;
	var ddmenuitem = 0;
	
	$('.navigate-show').bind('mouseover', jddm_open);
	$('.navigate-show').bind('mouseout',  jddm_timer);
	document.onclick = jddm_close;
	
	function jddm_open() {
		jddm_canceltimer();
		jddm_close();
		ddmenuitem = $('.navigate-box').css('visibility', 'visible');
	}
	function jddm_close() {	
		if(ddmenuitem) {
			ddmenuitem.css('visibility', 'hidden');
		}
	}
	function jddm_timer() {	
		closetimer = window.setTimeout(jddm_close, timeout);
	}
	function jddm_canceltimer() {	
		if(closetimer) {
			window.clearTimeout(closetimer);
			closetimer = null;
		}
	}
	
	
	/**
	 * 头像点击处理
	 */
	$('.avatarBox .avatar').click(function(ev) {
		var productId = $(this).attr("id");
		alterURL(productId);
		loadProduct(productId);									
		ev.preventDefault();
	});
	
	/**
	 * 上传照片
	 */
	uploadPhoto = function(menuId){
		alterURL(menuId);
		loadProduct(menuId);									
		ev.preventDefault();
	}
	
	/**
	 * 导航切换处理
	 */
	$('.navigate-item').click(function(ev) {
		var productId = $(this).attr("id");
		alterURL(productId);
		loadProduct(productId);									
		ev.preventDefault();									//取消超链接的事件和默认动作
	});
	
	if (window.location.hash) {									//此出是进入页面后，必须走的
		window.location.hash;
		var path = window.location.hash;
		var productId = path.substring(1, path.length);
		loadProduct(productId);									//根据path加载默认实例
	}		
	
	function alterURL(productId){					//改变URL
		window.location.hash = productId;
	}
	
	function loadProduct(productId){				//加载产品
		
		if (productId == "home") {
			$('.mykaBody').empty();
		}else if (productId == "uploadPhoto") {
			$('.mykaBody').empty().append("<iframe id='edui3_iframe' frameborder='0' scrolling='no' class='friendIframe' src='"+productId+".html'></iframe>");
		}else {
			$('.mykaBody').empty().append("<iframe id='main' frameborder='0' scrolling='no' class='friendIframe' src='"+productId+".html'></iframe>");
			$(document).scrollTop(450);
		}
		
	}
});
 