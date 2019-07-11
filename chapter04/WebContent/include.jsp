<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>debug标签</title>
</head>
<body>
<h3>这是包含页面include.jsp</h3><br>
	<s:include value="includefile.jsp">
	  	<s:param name="user" value="fdsf"/>	
	</s:include>
</body>
</html>