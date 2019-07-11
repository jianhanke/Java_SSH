<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
		静态属性值为:
	<s:property value="@cn.itcast.chapter05.ognl.TestOgnl02@staticvalue" />
	</br>调用静态方法请查看控制台
	<s:property value="@cn.itcast.chapter05.ognl.TestOgnl02@testMethod()" />	
</body>
</html>