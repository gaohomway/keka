<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<title>上传新照片</title>
		<link rel="stylesheet" href="keekan/css/uploadPhoto.css" type="text/css"></link>
		<script type="text/javascript" src="keekan/js/album/editor.js"></script>
		<script type="text/javascript">
			var editor = new UE.ui.Editor();
		</script>
	</head>
<body>
	<div class="album-photo-title-box">
	</div>
	<div class="upload-photo-main-box">
		<form action="LoginAction!checkLogin.html" method="post">
			<div class="upload-photo-operate-box">
			<input type="button" id="upload" value="开始上传" />
			</div>
		</form>
		<div id="flashContainer" class="flash-container"></div>
		<script type="text/javascript" src="keekan/js/album/tangram.js"></script>
		<script type="text/javascript" src="keekan/js/album/image.js"></script>
	</div>
</body>
</html>
