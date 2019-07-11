<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
    
<!DOCTYPE html>
<head>
<title>Insert title here</title>
</head>
<body>
	<s:form action="">
		<s:checkbox label="普通用户" value="true" name="role_user" fieldValue="role_user" />
		<s:checkbox label="管理员" value="false" name="role_admin" fieldValue="role_admin" />
	</s:form>
	
	<s:form>
		<s:checkboxlist lable="爱好" name="interesters" list="{'足球','篮球','游泳' }" labelposition="left" />
		
		<s:checkboxlist lable="课程" name="education" list="#{'a':'语文','b':'数学','c':'外语' }" labelposition="left" listKey="key" listValue="value" />
	
	</s:form>
	
	
</body>
</html>