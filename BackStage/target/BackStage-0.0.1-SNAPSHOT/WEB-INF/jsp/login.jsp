<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/adminlogin" method="post">
		<input type="text" name="username" value="${User.username}">
		<input type="password" name="password" value="${User.password}"> 
		<input type="submit" value="提交">
	</form>
	<label>${message }</label>
</body>
</html>