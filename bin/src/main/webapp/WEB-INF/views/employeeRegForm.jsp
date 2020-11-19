<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Employee Registration form </h2>
<form action="addEmployee" method="POST">
<pre>
Employee Name: <input type="text" name="ename">
Employee Salary: <input type="text" name="esal">
Employee Address: <textarea name="addr"></textarea>

<input type="submit" value="Add Employee">

${message}
</pre>
</form>

</body>
</html>