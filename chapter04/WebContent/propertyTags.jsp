<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	输出字符串:
	<s:property value="'www.itcast.cn'"/> <br> <br>
	忽略HTML代码:
	<s:property value=" '<h3>www.baidu.com</h3> ' "  /> <br>
	不忽略HTML代码:
	<s:property value=" '<h3>www.jianhan.cn</h3>' "  /> <br>
	输出默认值
	<s:property  default="default_ture" />
</body>
</html>