<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    <title>创建相册</title>
  	<link rel="stylesheet" href="../css/createAlbum.css" type="text/css"></link>
  	<script src="../js/jquery.min.js"></script>
  	<script src="../js/album/createAlbum.js"></script>
  	<script src="../js/jquery.form.js"></script>
  </head>
  
  <body> 
	<div class="album-create-main-box">
		<form id="createAlbumFormId" method="post">
		<ul>
			<li>
				<label for="album-name">相册名称：</label>
				<input class="album-name" id="albumName" type="text" name="albumName" maxlength="30"/>
			</li>
			<li>
				<label for="album-describe">相册描述：</label>
				<textarea id="album-describe" class="album-describe" name="albumDescribe"></textarea>
			</li>
			
			<li>
				<label for="album-classified">相册分类：</label>
				<select id="album-classified" class="album-classified" name="belongAlbumGroupId">
					<option value="1">最爱</option>
					<option value="2">人物</option>
					<option value="3">游记</option>
					<option value="4">生活</option>
					<option value="5">其他</option>
				</select>
				<a href="">创建相册分类</a>
			</li>
			<li>
				<label for="album-purview">相册可见：</label>
				<select id="album-purview" class="album-purview" name="">
					<option value="">所有人可见</option>
					<option>好友可见</option>
					<option>回答问题可见</option>
					<option>仅主人可见</option>
				</select>
			</li>
		</ul>
		</form>
	</div>
  </body>
</html>
