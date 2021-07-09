<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<body>
<form action="test.controller">
<input type="text" name="name"/><br/>
${errors.name}<br/>
<input type="submit" value="send"/><br/>
success,${name}<br/>
</form>
</body>
</html>