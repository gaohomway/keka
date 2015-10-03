$(document).ready(function() {
	$("#submit-leave").click(function() {
		var form = $('#leaveFormId');
		var options = {
			url : '../MessageBoardAction!addMessage.html',
			type : 'post',
			success : function() {
			alert("553");
			}
		};
		form.ajaxSubmit(options);
		return false;
	});
});