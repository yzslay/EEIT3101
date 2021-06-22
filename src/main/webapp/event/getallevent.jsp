<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"  import="java.util.*, com.petpet.bean.*"%>
    <%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>員工頁面</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

</head>
<body style="backgrond-color:#fdf5e6">
<h2>員工資料</h2>

<table border="1">
<tr style="background-color:#a8fefa">
<th>活動編號<th>主持人ID<th>活動名稱

	<tr><td>${event.EventID}
	<td>${event.HostID}
	<td>${event.EventName}


</table>
</body>
</html>