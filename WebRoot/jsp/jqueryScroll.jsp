<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<title>滚动条</title>
		<style>
		.demo {
			height:100px;
			width:500px;
			background:#f5f5f5;
			margin:30px;
			padding:1px;
			border:1px solid #ccc;
		}
		</style>
		<script src="../js/jquery/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/jquery.scroll.js"  type="text/javascript" charset="utf-8"></script>
		<script  type="text/javascript" charset="utf-8">
		$('.demo').jscroll({
		    loadingHtml: '<img src="loading.gif" alt="Loading" /> Loading...',
		    padding: 20,
		    nextSelector: 'a.jscroll-next:last',
		    contentSelector: 'li'
		});
		</script>
	</head>

	<body>
		<div class="demo">
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
	      <p>测试文字</p>
		 </div>
	</body>
</html>
