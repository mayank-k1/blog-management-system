<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Posts</h2>
<table border="1" align="center">
	<tr>
	<th>Email</th> <th> Title </th><th>Theme</	th><th>Content</th>
	</tr>
	
    <jstlcore:forEach items="${blogList}" var="post">
		<tr align="center">
		<td align="center"><jstlcore:out value="${post.email}"></jstlcore:out></td>
		<td align="center"><jstlcore:out value="${post.title}"></jstlcore:out></td>
		<td align="center"><jstlcore:out value="${post.themes}"></jstlcore:out></td>
		<td align="center"><jstlcore:out value="${post.content}"></jstlcore:out></td>
<%-- 		<td align="center"><jstlcore:out value="${post.blogEnteredDate}"></jstlcore:out></td> --%>
		</tr>
	</jstlcore:forEach>
</table>
	<font color="red">${MESSAGE}</font>
 <br> <a href="home.html"> Home</a> <br> 
</center>
</body>
</html>