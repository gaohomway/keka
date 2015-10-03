$(document).ready(function() {
	$(".group-board-box").click(function() {
		var groupId = $(this).attr("id");
		$("#friendBoxId" + groupId).slideToggle(0);
		$(this).addClass("selected");
	});
});
