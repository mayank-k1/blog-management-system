<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
	<center>
		<h2>List Posts</h2>
		
		<form:form action="listBlog.html" method="GET">

			<table border="1">
				<tr>
					<td>Email</td>
					<td><input type="text" id="email" name="email" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit" value="Show Post" ></td>
				</tr>


			</table>
		</form:form>
	</center>
</body>
</html>