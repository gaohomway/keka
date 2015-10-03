$(function() {
	$('#avatar-editor-pop').click(function(ev) {
		var pagePath = $(this).attr("href")
		var pageTitle = $(this).attr("title")
		$(window.parent.avatarEditorPop(pagePath, pageTitle));
		ev.preventDefault();									
	});
});
