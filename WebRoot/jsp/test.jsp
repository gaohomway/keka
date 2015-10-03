<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html>
  <head>
    <title>My JSP 'test.jsp' starting page</title>
     <script src="../js/jquery-1.8.0.js" type="text/javascript" charset="utf-8"></script>
    <script>
	  $(window.parent.document).find("#main").load(function(){
		var main = $(window.parent.document).find("#main");
		var thisheight = $(document).height()+30;
		main.height(thisheight);
	});
    </script>
  </head>
  
  <body>
     <div style="width: 500px; height: 1000px;border: 1px solid #000">
		<p>这是测试数据</p>
		<p>这是测试数据</p>
		<p>这是测试数据</p>
		<p>这是测试数据</p>
		<p>这是测试数据</p>
		<p>这是测试数据</p>
		<p>这是测试数据</p>
		<p>这是测试数据</p>
		<p>这是测试数据</p>
		<p>这是测试数据</p>
		<p>这是测试数据</p>
	  </div>
  </body>
</html>
