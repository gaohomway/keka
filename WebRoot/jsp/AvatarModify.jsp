<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>更改头像</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" href="../css/avatar/default.css" type="text/css"></link>
		<link rel="stylesheet" href="../css/avatar/uploadify.css" type="text/css"></link>
		<link rel="stylesheet" href="../css/avatar/jquery.Jcrop.css" type="text/css"></link>

		<script type="text/javascript" src="../js/avatar/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="../js/avatar/jquery.uploadify.v2.1.0.min.js"></script>
		<script type="text/javascript" src="../js/avatar/swfobject.js"></script>
		<script type="text/javascript" src="../js/avatar/fileupload.js"></script>
		<script type="text/javascript" src="../js/avatar/jquery.Jcrop.js"></script>
		<script type="text/javascript" src="../js/avatar/jQuery.UtrialAvatarCutter.js"></script>

	</head>
	<body>
		<div>
		</div>
		<div style="font-size: 15px;">
			图片文件:<input type="file" name="file" id="file" />
		</div>
			<input type="button" id="uploadFile" value="上传文件">
			<input type="button" id="cancelUpload" value="取消上传">
		<hr style="width: 370px;" " align="left">
			<div id="fileList" style="height: 51px;"></div>
			<hr style="width: 370px;" " align="left">
		<div>
			<h2>图片预览:</h2>
		</div>
		<table border="1px">
			<tr>
				<td>
					 <img id="userimg" />
				</td>
				<td>
					<div style="width: 120px; height: 120px; border: 1px solid #000; overflow: hidden; margin-left: 5px;">
						<img id="preview" />
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" id="x" />
					<input type="hidden" id="y" />
					<input type="hidden" id="w" />
					<input type="hidden" id="h" />
					<input type="button" id="submit" value="保存图片" />
				</td>
			</tr>
		</table>
	</body>
</html>
