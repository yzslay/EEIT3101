<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"  import="java.util.* , com.petpet.bean.EventBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>活動頁面</title>
<style>

</style>
<script>

</script>
</head>
<body style="background-color:#fdf5e6">

<h2>員工資料</h2>
<table>
    <tr>
        <th>活動名稱</th> <th>活動日期</th> <th>活動起始時間</th> <th>活動地點</th> 
		<th>活動種類</th>  <th>活動種類</th>  <th>活動人數上限</th> <th>活動費用</th>
    </tr>
    <c:forEach items="${events}" var="event" varStatus="s">
    <tr>
    	<td>${event.eventName}</td> <td>${event.eventDate}</td><td>${event.eventStratTime}</td><td>${event.eventLocation}</td>
    	<td>${event.eventType1}</td><td>${event.eventType2}</td><td>${event.eventMaxLimit}</td><td>${event.eventFee}</td>
    </tr>
    </c:forEach>
</table>


</body>
</html>