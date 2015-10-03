<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'MyJsp.jsp' starting page</title>
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
		<script type="text/javascript">
			$("#usual1 ul").idTabs();
		</script>
	</head>

	<body>
		<div id="usual1" class="usual">
			<ul>
				<li>
					<a href="#tab1" class="selected">Tab 1</a>
				</li>
				<li>
					<a href="#tab2">Tab 2</a>
				</li>
				<li>
					<a href="#tab3">Tab 3</a>
				</li>
			</ul>
			<div id="tab1" style="display: block;">
				This is tab 1.
			</div>
			<div id="tab2" style="display: none;">
				More content in tab 2.
			</div>
			<div id="tab3" style="display: none;">
				Tab 3 is always last!
			</div>
		</div>

	</body>
</html>
