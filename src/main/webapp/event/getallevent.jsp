<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"  import="java.util.*, com.petpet.bean.*"%>
    <%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>���u����</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

</head>
<body style="backgrond-color:#fdf5e6">
<h2>���u���</h2>

<table border="1">
<tr style="background-color:#a8fefa">
<th>���ʽs��<th>�D���HID<th>���ʦW��

	<tr><td>${event.EventID}
	<td>${event.HostID}
	<td>${event.EventName}


</table>
</body>
</html>