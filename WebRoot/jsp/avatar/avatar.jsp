<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<base href="<s:text name="basePath"/>">
		<title>KEEKAN-头像</title>
		<link rel="stylesheet" href="css/avatar/avatar.css" type="text/css"></link>
		<script src="js/jquery/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/avatar/avatar.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<div class="avatarCard">
			<!-- 头像栏 -->
			<div class="avatarMainBar">
				<div class="nowAvatarBox">
					<img src="img/100_100.jpg" id="avatar">
				</div>
				<div class="pastAvatarBox">
					
				</div>
			</div>
			<!-- 头像互动栏 -->
			<div class="avatarInteract">
				<div class="avatarInfoBox">
					<div class="avatarInfoTitle">
						<p>头像信息</p>
					</div>
					<div class="avatarInfo">
						&nbsp;上传：[2012-12-09] &nbsp;使用：[124]天&nbsp;
					</div>
				</div>
				<div class="labelBox">
					<div class="labelTitle">
						<p>标签 (49346)</p>
					</div>
					<div class="label">
						<input type="button" value="编辑标签" id="label"/>
					</div>
					
					<div class="tagSelectBox">
						<div class="tagCustom">
							<input type="text" name=""/><input type="button" value="提交"/>
						</div>
						<div class="tagSelect">
							
						</div>
						<div class="tagPage">
							
						</div>
					</div>
				</div>
				
				<div class="reviewBox">
					<div class="reviewTitle">
						<p>评论 (49346)</p>
					</div>
				</div>
				
				<div class="heartBox">
					<div class="heartTitle">
						<p>红心 (49346)</p>
					</div>
				</div>
				
				<div class="visitorBox">
					<div class="visitorTitle">
						<p>访客 (49346)</p>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
