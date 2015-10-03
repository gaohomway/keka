/*!
 * KEEKAN Prompt plug v1.0.0
 * http://keekan.com
 * 
 * Copyright 2012 jQuery Foundation and other contributors
 * keekan@keekan.com
 * 
 * Date: Thu Aug 09 2012 16:24:48 GMT-0400 (Eastern Daylight Time)
 */
$(document).ready(function() {
	
	function showTips( tips, height, time ){
		var windowWidth = document.documentElement.clientWidth; 
		var tipsDiv = '<div class="tipsClass">'+tips+'</div>'; 
		$('body').append(tipsDiv); 
		$('div.tipsClass').css({
			'width':'150px',
			'height':'50px',
			'position':'absolute',
			'top':height+'px', 
			'left':(windowWidth/2)-(tips.length*13/2)+'px', 
			'padding':'3px 5px',
			'background':'#FFFFFF',
			'font-size':15+'px',
			'margin':'0 auto',
			'text-align':'center',
			'color':'#606060'
		}).show(); 
		setTimeout( function(){$( 'div.tipsClass' ).fadeOut();}, ( time * 1000 ) ); 
	}
});