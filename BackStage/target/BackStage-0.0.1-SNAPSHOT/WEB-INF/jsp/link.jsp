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
<form action="${pageContext.request.contextPath }/addNewLink" method="post">
link_name:<input type="text" name="link_name"><br />
link:<input type="text" name="link"><br />
provider_name:<input type="text" name="proviser_name"><br />
isPass:<input type="radio" name="isPass" value="1" /> yes<br />
        <input type="radio" name="isPass" value="0" /> no<br />
remarks:<input type="text" name="remarks"><br />
<input type="submit" value="添加新链接">
</form>

<c:forEach items="${linklist }" var="item">
	<form action="${pageContext.request.contentType }/deleteALink" method="post">
		<label>${item.link_name }</label>
		<label>${item.link }</label>
		<label>${item.provider_name }</label>
		<label>${item.isPass }</label>
		<label>${item.remarks }</label>
		<input type="submit" value="删除链接">			
	</form>
</c:forEach>


</body>
</html>