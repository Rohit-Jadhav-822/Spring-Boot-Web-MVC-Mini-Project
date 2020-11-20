<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<th>Link</th>
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

	<!-- Go to First page -->
	<c:if test="${!page.isFirst()}">
		<a href="?page=0"> First </a>
	</c:if>
	&nbsp;
	
	<!-- Go to Previous Page -->
	<c:if test="${page.hasPrevious()}">
		<a href="?page=${page.getNumber() - 1 }"> Previous </a>
	</c:if>
	&nbsp;
	
	<!-- Pagination by page number -->
	<c:forEach var="index" begin="0" end="${page.getTotalPages() -1 }">
		<a href="?page=${index}">${index+1}</a> &nbsp; &nbsp;
	</c:forEach>

	<!-- Go to Next Page -->
	<c:if test="${page.hasNext()}">
		<a href="?page=${page.getNumber() + 1 }"> Next </a>
	</c:if>
	&nbsp;
	
	<!-- Go to Last Page -->
	<c:if test="${!page.isLast()}">
		<a href="?page=${page.getTotalPages() - 1}"> Last </a>
	</c:if>

</body>
</html>
