<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<s:text name="basePath"/>">
		<title>头像选择</title>
		<meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
		<script src="keekan/js/jquery/jquery-1.9.0.min.js"></script>
		<script src="keekan/js/avatar/jquery.Jcrop.js"></script>
		<script type="text/javascript">
			jQuery(function($) {
				$('#target').Jcrop();
			});
		</script>
		<link href="keekan/css/avatar/jquery.Jcrop.css" type="text/css" rel="stylesheet" />
		<link href="keekan/css/avatar.css" type="text/css" rel="stylesheet" />
	</head>
	
	
	<body>
		<div class="avatarSelect-card">
			<div class="avatarSelect-menu">
				<div class="avatarSelect-title">
					<P>选择头像照片</P>
				</div>
				<div class="menu" id="uploadPhoto">
					<P>上传照片</P>
				</div>
				<div class="menu" id="myAlbum">
					<P>我的相册</P>
				</div>
				<div class="album-list-box">
					
				</div>
			</div>
			<div class="avatarSelect-main">
				<table border="1px" width="600px" height="500px"> 
					<tr>
						<td>
						<img class="avatar-img1" src="<s:text name="kanPath"/>12235/avatar/avatar_30_30.jpg" id="target" />
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>

