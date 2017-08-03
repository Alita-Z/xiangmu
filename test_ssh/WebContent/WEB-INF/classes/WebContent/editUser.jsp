<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h1>编辑用户</h1>
	<form action="/test_ssh/user/updateUser" name="userForm" method="post">
		<input type="hidden" name="id" value="${user.id }"> 
		用户名：<input type="text" name="username"
			value="${user.username }"> 
		密码：<input type="text" name="password" 
			value="${user.password }">
		<input type="submit" value="编辑">
	</form>
</body>
</html>