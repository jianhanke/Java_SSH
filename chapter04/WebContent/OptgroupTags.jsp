<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
                      "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>optgroup</title>
</head>
<body>
	<s:form method="get">
	
	<s:select lable="选择所学内容" name="course" list="#{'java web':'java web','数据库':'数据库' }" listKey="value" listValue="key">
	
	<s:optgroup label="Java web2" list="#{'jsp':'jsp','servlet':'service','javaBean':'javaBean' }" listKey="value" listValue="key" />
	<s:optgroup label="数据库2" list="#{'mysql':'mysql','Oracle':'Oracle','DB2':'DB2' }" listKey="value" listValue="key" />
	</s:select>
	
	<s:submit />
	</s:form>
</body>
</html>