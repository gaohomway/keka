<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<link type="text/css" href="css/smoothness/jquery-ui-1.8.21.custom.css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
<script type="text/javascript">
	$(function() {
		 
		// Dialog
		$('#dialog').dialog( {
			autoOpen : false,
			width : 500,
			buttons : {
				"Ok" : function() {
					$(this).dialog("close");
				},
				"Cancel" : function() {
					$(this).dialog("close");
				}
			}
		});

		// Dialog Link
		$('#dialog_link').click(function() {
			$('#dialog').dialog('open');
			return false;
		});
	});
</script>
<style type="text/css">
body {
	font-size: 12px;
}
</style>
</head>
	<body>
		<a href="#" id="dialog_link" >
			弹出
		</a>
		<div id="dialog" title="Dialog Title">
			<p>
				Lorem ipsum dolor sit amet,
			</p>
		</div>

	</body>
</html>


