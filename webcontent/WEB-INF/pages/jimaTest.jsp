<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
<h3>Form</h3>
<form action="jima.controller" method="get">
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="userName"/></td>
			<td>${errors.username}</td>
		</tr>
		<tr>
			<td><input type="submit" value="gogo"/></td>
		</tr>
	</table>
</form>
</body>
</html>