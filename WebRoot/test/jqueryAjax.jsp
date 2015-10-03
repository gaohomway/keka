<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<title>局部刷新</title>
		<script src="jquery-1.7.2.min.js"></script>
		<script src="recaptcha.js"></script>
	</head>
	<body>
		<form action="" id="myForm">
			用户名：<input type="text" name="userName"/>
			年龄：<input type="text" name="age"/>
		</form>
	
		<div id="mysubmit" style="width: 50px; height: 50px; background-color: #DDD">
		
		</div>
		<div id="result" style="width: 300px; height: 200px; border: 1px solid red">
		<%--<s:iterator value="albumGroupList">
			<s:property value="albumGroupId"/>
			<s:property value="albumGroupName"/>
		</s:iterator>
		--%></div>	
	</body>
</html>
