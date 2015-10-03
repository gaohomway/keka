<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<title>留言板</title>
		<link rel="stylesheet" href="../css/leaveMessage.css" />
		<script src="../js/jquery.min.js"></script>
  		<script src="../js/messageBoard/messageBoard.js"></script>
  		<script src="../js/jquery.form.js"></script>
		<script type="text/javascript">
		<!-- window.UEDITOR_HOME_URL = location.pathname.substr(0, location.pathname.lastIndexOf('/')) + '/'; //-->
		</script>
		<script type="text/javascript" src="../js/messageBoard/editor_config.js"></script>
		<script type="text/javascript" src="../js/messageBoard/editor.js"></script>
		<link rel="stylesheet" href="../css/messageBoard/ueditor.css" />
</head>

<body>
	<div class="leave-message-title-box">
		<h6>留言板</h6>
	</div>
	<div class="leave-message-main-box">
		<div class="masters-message-main-box">
			<p align="left">主人寄语</p>
			<hr />
			<p style="font-size: 12px;color: red">当这 一MI阳光 照亮了世界的每一个黑暗的角落...... 今生的到来 无怨无悔......</p>
			<img style="width: 500px;height: 350px" src="../img/psb.jpg" alt="" />
		</div>
		<div class="editor-box">
			 <form action="MessageBoardAction!addMessage.html" method="post">
				<textarea id="editor" name="editorValue" ></textarea>
				<div class="leave-submit-box">
					<input type="submit" value="   提  交  " />
				</div>
			</form>
		</div>
		<div class="leave-content-main-box">
			 <iframe class="leave-content-iframe" frameborder="0" src="MessageBoardAction!viewLeaveMessage.html"></iframe>
		</div>
	</div>
</body>
<script type="text/javascript" >
    var editor = new UE.ui.Editor();
    editor.render('editor');
</script>
</html>