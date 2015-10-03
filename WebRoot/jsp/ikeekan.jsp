<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<title>IKEEKAN</title>
		<link id="ikeekan-main-css" rel="stylesheet" href="keekan/css/ikeekan.css" type="text/css"/>
		<link id="ikeekan-main-css" rel="stylesheet" href="keekan/css/jquery-ui-1.8.21.custom.css" type="text/css"/>
		<script src="keekan/js/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="keekan/js/jquery-ui-1.8.21.custom.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="keekan/js/jquery-dialog-main.js" type="text/javascript" charset="utf-8"></script>
		<script src="keekan/js/ikeekan.js" type="text/javascript" charset="utf-8"></script>
	</head>
	
	<body>
		<div class="logo-bar"></div>
		<div class="top-navigation-bar">
			<a class="keekan-font">KEEKAN</a>
		</div>
		<div class="internal-navigation-bar">
			<ol class=navigation-ol>
				<li class=navigation-li>
					<a href="keekan/jsp/home.jsp" id="home">主页</a>
				</li>
				<li class=navigation-li>
					<a href="keekan/jsp/logs.jsp" id="logs">日志</a>
				</li>
				<li class=navigation-li>
					<a href="keekan/jsp/album.jsp" id="album">相册</a>
				</li>
				<li class=navigation-li>
					<a href="keekan/jsp/messageBoard.jsp" id="leaveMessage">留言板</a>
				</li>
				<li class=navigation-li>
					<a href="keekan/jsp/personalInfo.jsp" id="personalInfo">个人资料</a>
				</li>
				<li class=navigation-li>
					<a href="keekan/jsp/personalInfo.jsp" id="friend">好友</a>
				</li>
			</ol>
		</div>
		<div class="product-main-box">
		
		</div>
		<div class="copyright-main-box">
			<p>Copyright © 2012 Keekan.All Rights Reserved.</p>
		</div>
	</body>
</html>
