<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    <title>My JSP 'iframe.jsp' starting page</title>
    <script src="../js/jquery-1.8.0.js" type="text/javascript" charset="utf-8"></script>
    <script>
    	$("#main").load(function(){
			var mainheight = $(this).contents().find("body").height()+30;
			$(this).height(mainheight);
		}); 
    </script>
    <style type="text/css">
    	.iframe-style{
    		width: 600px;
    		height: 500px;
    		border: 1px solid red;
    	}
    </style>
  </head>
  
  <body>
	<iframe src="test.jsp" id="main" frameborder="0" class="iframe-style"   ></iframe>
  </body>
</html>
