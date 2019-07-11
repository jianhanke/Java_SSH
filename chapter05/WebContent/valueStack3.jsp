<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>	
	<s:debug />
	商品名称:<s:property value="model.name" /> <br />
	商品价格:<s:property value="model.price" />  <br />
	
	以下是使用EL表达式访问值栈的数据 <br />
	商品名称:${model.name }       <br />
	商品价格:${model.price }
	<hr />
	<%=request.getAttribute("model.name") %> <br />
	${requestScope.model.price } <br /> 
	
</body>
</html>