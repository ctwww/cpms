<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
11111111111
<form action="${pageContext.request.contextPath }/showUserList">
<input type="submit" value="获取用户列表">
</form>

    <c:forEach items="${userlist }" var="item">
        <form action="${pageContext.request.contextPath }/deleteUserByUsername">
		<label>${item.username }</label> <label>${item.usernickname }</label> <label>${item.isAdmin }</label>
	     	<input type="submit" value="delete" >
		</form>
		<br/>
	</c:forEach>
	
	<form action="${pageContext.request.contextPath }/addAUser" method="post">
		<input type="text" name="username" value=""> <br/>
		<input type="password" name="password" value=""> <br/>
		<input type="text" name="nickname" value=""> <br/>
		<input type="radio" name="isAdmin" value="1" /> 管理员<br />
        <input type="radio" name="isAdmin" value="0" /> 非管理员<br />
		<input type="submit" value="添加用户">
	</form>
</body>
</html>