<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
color: #ff0000;
font-style: italic;
}
</style>
</head>
<body>
<center>
<h2>Create New Post</h2>
<form:form action="addBlog.html" modelAttribute="blog" >
	
<!-- 
To-Do Item 1.8: Complete the NewBlog.jsp page using Spring MVC Form Tag library:
TODO: --Create text box for entering email.
      --Create text box for entering title.
      --Create a dropdown menu for selecting a theme within the table.
      --Ensure that the theme dropdown is dynamically populated and mapped to the controller for data retrieval. 
      --Create text box for entering content.
      --Validations: email,title and content are mandatory fields.
      --Display appropriate error messages if validation fails.
      --Create a submit button within the table for submitting the form. 
-->

	<table>

		<tr>
			<td>Email</td>
			<td><form:input path="email"/></td>
			<td><form:errors path="email" cssClass="error" /></td>
		</tr>
		
		<tr>
			<td>Title</td>
			<td><form:input path="title"/></td>
			<td><form:errors path="title" cssClass="error"/></td>
		</tr>
		
		<tr>
			<td>Theme</td>
			<td><form:select path="themes">
			<form:options items="${ThemesList}"/>
			</form:select></td>
		</tr>
		
		<tr>
			<td>Content</td>
			<td><form:textarea path="content"/>
			<td><form:errors path="content" cssClass="error"/><td>
		</tr>	
				 
		 <tr>
			<td colspan="2" align="center">
		    <!-- Add submit button here -->
		    <input type="submit" value="Create Post"/>
		
		 </tr>	
		 <tr>
			<td colspan="2" align="center"><B>${MESSAGE}</B></td>
		 </tr>
		 
	</table>
		
		 <br> <a href="home.html"> Home</a> <br> 

</form:form>
</center>
</body>
</html>