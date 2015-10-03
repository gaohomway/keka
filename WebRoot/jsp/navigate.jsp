<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<title>导航</title>
		<link rel="stylesheet" href="keekan/css/navigate.css" />
	</head>

	<body>
		<div class="navigate-card">
			<%--<div class="navigate-sort"></div>--%>
			<div class="navigate-box">
				<s:iterator value="navigateList">
					<div class="navigate-item" id="<s:property value="navigateId"/>">
						<div class="navigate-icon" id="<s:property value="navigateURL"/>">
							<img src="keekan/icon/<s:property value="navigateIcon"/>" title="相册"/>
						</div>
						<div class="navigate-name" id="<s:property value="navigateSorting"/>">
							<p><s:property value="navigateName"/></p>
						</div>
					</div>
				</s:iterator>
			</div>
		</div>
	</body>
</html>
