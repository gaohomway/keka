<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<title></title>
		<link id="ikeekan-main-css" rel="stylesheet" href="../css/avatarEditor.css" type="text/css" />
		<link id="ikeekan-main-css" rel="stylesheet" href="../css/avatar/jquery-ui-1.8.21.custom.css" type="text/css" />
		<script src="../js/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/jquery-ui-1.8.21.custom.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				$('#tabs').tabs();
				$('.avatarTabs').click(function(){
					$('#tabs-2').empty().append("<iframe src='http://www.163.com' name='test' width='1000' height='3000' ></iframe>");
				});
			});
		</script>
		<style type="text/css"> 
		<!-- 
		.line { position:relative; float:left; padding:8px 0} 
		.line span { float:left} 
		input { border:1px solid #888; vertical-align:middle} 
		.file { position:absolute; left:90px; top:8px; display:none;filter:alpha(opacity=0);opacity:0} 
		.select-button {
			width: 50px;
			height: 14px;
			border: 1px solid #aaaaaa;
			padding: 1px 5px 5px 20px;
			background-color: #E6E6E6;
			display:block;
			float:left; 
			color:#000000; 
			z-index:1; 
			vertical-align:middle;
			cursor: pointer
		}
		.inputstyle { width:150px; border:1px solid #888; z-index:99} 
		--> 
		</style>
	</head>

	<body>
		<div id="tabs">
			<ul>
				<li>
					<a href="#tabs-1">本地上传</a>
				</li>
				<li>
					<a href="#tabs-2" class="avatarTabs">相册照片</a>
				</li>
			</ul>
			<div id="tabs-1">
				 
			</div>
			<div id="tabs-2">
				
			</div>
		</div>
	</body>
</html>
