<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<script type="text/javascript" src="keekan/jsp/ajax-pushlet-client.js"></script> 
	<script type="text/javascript">  
		PL.keeNumber='20000';
		PL._init();
		PL.joinListen('loginTopics'); 

        function onData(event) {   
              alert(event.get("friendNumber"));    
        }  
	</script> 
  </head>
  <body>
  </body>
</html>