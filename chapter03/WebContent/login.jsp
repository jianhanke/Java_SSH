<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录</title>
</head>
<body>
<center>
${requestScope.msg}<br>
	<form action="/chapter03/login.action" method="post">
		<table>
			<tr>
				<td><label style="text-align: right;">用户名:</label></td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td><label style="text-align: right;">密码:</label></td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td align="right" colspan="2"><input type="submit" value="登录"></td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>
