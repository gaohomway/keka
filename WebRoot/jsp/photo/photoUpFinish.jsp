<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    <base href="<s:text name="basePath"/>">
    <title>相册 - 上传完成</title>
  	<link rel="stylesheet" href="css/photo/photoUpFinish.css" type="text/css"></link>
  	<script src="js/jquery/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
  	<script src="js/photo/photoUpFinish.js" type="text/javascript" charset="utf-8"></script>
  </head>
  
  <body>
    <div class="photoUpFinishCard">
    	<div class="photoUpFinishMenu">
			<div class="menuTitle">
				<P>照片上传成功</P>
			</div>
			<div class="menu" id="photoUpload">
				<p><a href="photoUpload.html">继续上传</a></p>
			</div>
			<div class="menu" id="photoUpload">
				<p><a href="">返回相册</a></p>
			</div>
			<div class="menu" id="viewPhoto" >
				<p>查看照片</p>
			</div>
			<div class="menu" id="editPhoto" >
				<p>编辑照片信息</p>
			</div>
		</div>
		<div class="photoUpFinishMain">
			<div class="finishPrompt">
				<div class="correctSign">
					<img src="img/correct.png"></img>
				</div>
				<div class="promptInfo">
					<p>您已成功上传<a>&nbsp;<s:property value="photoNumber"/>&nbsp;</a>张照片</p>
				</div>
			</div>
			<div class="finishOperate">
				<input id="ownAlbumId" type="hidden" value="<s:property value="ownAlbumId"/>"/>
				<input id="uploadDate" type="hidden" value="<s:property value="uploadDate"/>"/>
				<input id="uploadTime" type="hidden" value="<s:property value="uploadTime"/>"/>
				<div class="addInofTitle">
					<p>统一添加照片信息</p>
				</div>
				<div class="photoName">
					<p>照片名称:</p>
					<input type="text" value="" name="rawPhotoName"/>
				</div>
				<div class="photoDescription">
					<p>照片描述:</p>
					<textarea rows="" cols="" name="photoDescription" id="photoDescription"></textarea>
				</div>
			</div>
			<div class="finishControl">
				<div class="saveButton">
					<input type="button" value="保存" id="save"/>
				</div>
			</div>
		</div>
    </div>
  </body>
</html>
