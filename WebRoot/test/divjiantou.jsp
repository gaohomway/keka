<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

	<head>
		<title>div箭头</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<style>
/*zishu.cn*/
* {
	margin: 0;
	padding: 0;
	font-size: 12px;
	font-family: Verdana, "宋体", Arial;
	line-height: 1.8;
	list-style: none;
}

#info,#nav {
	margin: 50px;
	border: 1px dashed #FF3300;
	background: #FFFFCC;
	padding: 50px;
}

#info div {
	background: #FF0000;
	width: 0px;
	height: 0px;
	overflow: hidden;
	margin-bottom: 10px;
}

/*一些三角的写法*/
#com_a {
	border-top: 10px solid #FFFFCC;
	border-left: 10px solid #FF3300;
	border-bottom: 10px solid #FFFFCC;
}

#com_b {
	border-top: 10px solid #FFFFCC;
	border-right: 10px solid #FF3300;
	border-bottom: 10px solid #FFFFCC;
}

#com_c {
	border-top: 10px solid #FFFFCC;
	border-right: 10px solid #FF3300;
	border-bottom: 10px solid #FFFFCC;
	border-left: 10px solid #FF3300;
}

#com_d {
	border-top: 10px solid #FF3300;
	border-right: 10px solid #FFFFCC;
	border-bottom: 10px solid #FF3300;
	border-left: 10px solid #FFFFCC;
}

#com_e {
	border-top: 10px solid #FFFFCC;
	border-left: 10px solid #FF3300;
}

#com_f {
	border-top: 10px solid #FF3300;
	border-right: 10px solid #FFFFCC;
	border-left: 10px solid #FFFFCC;
}

#com_g {
	border-right: 10px solid #FFFFCC;
	border-bottom: 10px solid #FF3300;
	border-left: 10px solid #FFFFCC;
}

#com_h {
	border-top: 10px solid #FF3300;
	border-bottom: 10px solid #FF3300;
	border-left: 10px solid #FFFFCC;
}

#com_i {
	border-top: 10px solid #FF3300;
	border-right: 10px solid #FF3300;
	border-bottom: 10px solid #FF3300;
	border-left: 10px solid #FFFFCC;
}
</style>
	</head>
	<body>
		<div id="info">
			<h1>
				一些三角形的写法
			</h1>
			<div id="com_a"></div>
			<div id="com_b"></div>
			<div id="com_f"></div>
			<div id="com_g"></div>
			<div id="com_c"></div>
			<div id="com_d"></div>
			<div id="com_e"></div>
			<div id="com_h"></div>
			<div id="com_i"></div>
		</div>
	</body>
</html>
