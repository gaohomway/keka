<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
	<head>
		<base href="<s:text name="basePath"/>">
		<title>头像选择</title>
		<link href="css/avatar/avatarEditor.css" type="text/css" rel="stylesheet" />
		<link href="css/avatar/jquery.jcrop.css" type="text/css" rel="stylesheet"/>
		<script src="js/jquery/jquery-1.4.2.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/avatar/jquery.jcrop.js" type="text/javascript" charset="utf-8"></script>
    	<script src="js/jquery/jquery.form-3.27.js" type="text/javascript" charset="utf-8"></script>
    	<script src="js/avatar/avatarEditor.js"></script>
	</head>

	<body>
		<div class="avatar-card">
			<div class="photoSelectMenu">
				<div class="menuTitle">
					<P>选择头像照片</P>
				</div>
				<div class="menu" id="uploadPhoto">
					<P>上传照片</P>
				</div>
				<div class="menu" id="albumPhoto" >
					<P>我的相册</P>
				</div>
				<div class="album-list-box">
					
				</div>
			</div>
			<!-- 照片上传 -->
			<div class="photoUploadBox">
				<div class="avatarSelectPrompt">
				
				</div>
				<div class="photoUploadMain">
					<div class="selectButton">
						<form id="form" method="post" enctype="multipart/form-data">
							<div class="fileInputType" style="cursor: pointer;">
								选择文件
								<input class="fileInput" id="fileInput" name="photo" type="file" />
							</div>
						</form>
					</div>
				</div>
				<div class="avatarOperate">
					<input disabled="disabled" id="avatarCut1" type="button" value="保存"/><input disabled="disabled"  id="cancel1" type="button" value="取消"/>
				</div>	
			</div>
			<!-- 照片编辑 -->
			<div class="photoEditorBox">
				<div class="avatarSelectPrompt">
				
				</div>
				<div class="photoEditorMain">
					<div class="avatarEditorBox">
						<div class="avatarImg">
						
						</div>
					</div>
					<div class="avatarPreviewBox">
						<div class="preview100">
							
						</div>	
						<div class="preview50">
							
						</div>
						<div class="preview30">
							
						</div>
						<div class="previewSize">
							<p class="size100">100*100</p><p class="size50">50*50</p><p class="size30">30*30</p>
						</div>
					</div>
				</div>
				<div class="avatarOperate">
					<input id="avatarCut" type="button" value="保存"/><input id="cancel" type="button" value="取消"/>
				</div>		
			</div>
			<!-- 照片选择 -->
			<div class="photoSelectBox">
				<div class="avatarSelectPrompt">
				
				</div>
				<div class="photoSelectMain">
					请从左侧相册列表中选择相册！
				</div>
				<div class="avatarOperate">
					<input id="editor" type="button" value="开始编辑"/><input type="button" value="取消"/>
				</div>	
			</div>
		</div>
		<input type="hidden" value="<s:property value="#session.keeNumber"/>" id="keeno"/>
	</body>
</html>
