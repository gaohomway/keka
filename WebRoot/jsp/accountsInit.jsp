<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<base href="<s:text name="basePath"/>">
		<title>帐号初始化</title>
		<link id="ikeekan-main-css" rel="stylesheet" href="css/accountsInit.css" type="text/css" />
	</head>

	<body>
		<div class="keekan-logo">
	 		<p>KEEKAN</p>
	 	</div>
	 	<div class="welcome-box">
	 		<h2>欢迎您！</h2>
	 		<p>现在您可以使用KEEKAN的产品啦。</p>
	 		<p>您的帐号为：<s:property value="#session.keeno"/>。</p>
	 		<p>感谢您创建帐户！祝您使用愉快！</p>
	 		<form action="myka.html" method="post">
	 		<p><input type="submit" value="开始使用"></p>
	 		</form>
	 	</div>
	</body>
</html>
