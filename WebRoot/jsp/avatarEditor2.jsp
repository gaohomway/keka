<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<base href="<s:text name="basePath"/>">
		<title>头像切割</title>
		<script src="keekan/js/jquery/jquery-1.4.2.min.js"></script>
		<script src="keekan/js/avatar/jquery.Jcrop.js"></script>
		<script src="keekan/js/avatar/avatarEditor.js"></script>
 		<link href="keekan/css/avatar/jquery.Jcrop.css" type="text/css" rel="stylesheet"/>
		<link href="keekan/css/avatar/avatarEditor.css" type="text/css" rel="stylesheet"/>
</head>

<body>
	<div class="avatar-cutout-box">
		<form name=form1 method=post action="AvatarEditor.html">
			<div class="avatar-cutout-title">
				<h6>头像裁剪</h6>
			</div>
			<div class="avatar-cutout">
				<img class="avatar-img" src="<s:text name="kanPath"/>12235/avatar/avatar_30_30.jpg" id="imgCrop" name="imgCrop" />
				<input type="hidden" id="x1" name="x" />
				<input type="hidden" id="y1" name="y" />
				<input type="hidden" id="x2" name="x2" />
				<input type="hidden" id="y2" name="y2" />
				<input type="hidden" id="w" name="w" />
				<input type="hidden" id="h" name="h" />
				<input type="hidden" id="width" name="width" value="<s:property value="imgWidth"/>"/>  
				<input type="hidden" id="height" name="height" value="<s:property value="imgHeight"/>"/>
				<input type="hidden" id="oldImgPath" name="oldImgPath" value="upload/<s:property value="uploadFileName"/>"/>  
				<input type="hidden" id="imgRoot" name="imgRoot" value="upload/"/>	
				<input type="hidden" id="imgFileExt" name="imgFileExt" value="jpg"/>	
			</div>
			<div class="avatar-cutout-operate">
				<input type="submit" value="保存" />
				<input type="button" value="重新选择照片"/>
			</div>
		</form>
	</div>
	<div class="avatar-preview-box">
		<div class="avatar-preview-title">
			<h6>头像预览</h6>
		</div>
		<div class="avatar-preview">
			<img src="<s:text name="kanPath"/>12235/avatar/avatar_30_30.jpg" id="preview" />
		</div>
	</div>
</body>
</html>
