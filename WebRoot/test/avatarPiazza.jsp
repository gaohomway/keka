<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>头像走廊</title>
	<script type="text/javascript" src="keekan/test/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$(".previous").click(function(){
			$(".avatarBox").animate({left:"+=110px"}, 500);
		});
		$(".next").click(function() {
			$(".avatarBox").animate({left:"-=110px"}, 500);
		});
	});
	</script>
	<style type="text/css">
		.avatarPiazza{
			width: 600px;
			height: 100px;
			border: 1px solid #000;
			overflow: hidden;
			position: absolute;
			top: 50px;
			left: 130px;
		}
		.avatarBox{
			height: 100px;
			border: 1px solid #DDD;
			background-color: #DDD;
			position: absolute;
			top: 0;
			left: 0px;
		}
		.avatarBox img{ max-height: 100px; max-width: 100px;}
		.previous{
			width: 20px;
			height: 100px;
			background-color: #0080FF;
			position: absolute;
			top: 50px;
			left: 100px;
		}
		.next{
			width: 20px;
			height: 100px;
			background-color: #0080FF;
			position: absolute;
			top: 50px;
			left: 750px;
		}
	</style>
  </head>
  
  <body>
  	<div class="previous">
  		上一页
  	</div>
    <div class="avatarPiazza">
    	<div class="avatarBox">
			<img src="keekan/img/avatar/100 (1).jpg">
			<img src="keekan/img/avatar/100 (2).jpg">
			<img src="keekan/img/avatar/100 (3).jpg">
			<img src="keekan/img/avatar/100 (4).jpg">
			<img src="keekan/img/avatar/100 (5).jpg">
			<img src="keekan/img/avatar/100 (1).jpg">
			<img src="keekan/img/avatar/100 (2).jpg">
			<img src="keekan/img/avatar/100 (3).jpg">
			<img src="keekan/img/avatar/100 (4).jpg">
			<img src="keekan/img/avatar/100 (5).jpg">
			<img src="keekan/img/avatar/100 (1).jpg">
			<img src="keekan/img/avatar/100 (2).jpg">
			<img src="keekan/img/avatar/100 (3).jpg">
			<img src="keekan/img/avatar/100 (4).jpg">
			<img src="keekan/img/avatar/100 (5).jpg">
			<img src="keekan/img/avatar/100 (1).jpg">
			<img src="keekan/img/avatar/100 (2).jpg">
			<img src="keekan/img/avatar/100 (3).jpg">
			<img src="keekan/img/avatar/100 (4).jpg">
			<img src="keekan/img/avatar/100 (5).jpg">
			<img src="keekan/img/avatar/100 (1).jpg">
			<img src="keekan/img/avatar/100 (2).jpg">
			<img src="keekan/img/avatar/100 (3).jpg">
			<img src="keekan/img/avatar/100 (4).jpg">
			<img src="keekan/img/avatar/100 (5).jpg">
			<img src="keekan/img/avatar/100 (1).jpg">
			<img src="keekan/img/avatar/100 (2).jpg">
			<img src="keekan/img/avatar/100 (3).jpg">
			<img src="keekan/img/avatar/100 (4).jpg">
			<img src="keekan/img/avatar/100 (5).jpg">
			<img src="keekan/img/avatar/100 (1).jpg">
			<img src="keekan/img/avatar/100 (2).jpg">
			<img src="keekan/img/avatar/100 (3).jpg">
			<img src="keekan/img/avatar/100 (4).jpg">
			<img src="keekan/img/avatar/100 (5).jpg">
			<img src="keekan/img/avatar/100 (1).jpg">
			<img src="keekan/img/avatar/100 (2).jpg">
			<img src="keekan/img/avatar/100 (3).jpg">
			<img src="keekan/img/avatar/100 (4).jpg">
			<img src="keekan/img/avatar/100 (5).jpg">
    	</div>
    </div>
    <div class="next">
    	下一页
    </div>
  </body>
</html>
