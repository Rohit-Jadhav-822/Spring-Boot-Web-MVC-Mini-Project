<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employee Data</h1>
<table border="1">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Salary</th>
		<th>Address</th>
		<th>HRA</th>
		<th>DA</th>		
	</tr>
	
	<c:forEach items="${empList}" var="emp">
		<tr>
			<td>${emp.eid}</td>
			<td>${emp.ename}</td>
			<td>${emp.esal}</td>
			<td>${emp.addr}</td>
			<td>${emp.hra}</td>
			<td>${emp.da}</td>
			<td><a href="/DeleteEmployee?id=${emp.eid}">Delete</a></td>
		</tr>
	
	</c:forEach>

</table>

</body>
</html> 