<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>注册成功</title>
		<link rel="stylesheet" href="keekan/css/registerSuccess.css" type="text/css"></link>
	</head>

<body>
	<div class="keekan-logo">
		<p>KEEKAN</p>
	</div>
	<div class="register-success-bar">
		<p>注册成功，您的帐号是：<s:property value="keeno"/></p>
		<p>此帐号是登录KEEKAN的唯一号码，请牢记！</p>
		<p>您可以通过：文件保存</p>
		<p><a href="PersonalCenterAction.action">进入个人中心</a></p>
	</div>
</body>
</html>
