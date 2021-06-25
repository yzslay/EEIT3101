<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.* , com.petpet.bean.EventBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title> 活動頁面</title>
<style>

</style>
<script>

</script>
</head>
<body style="background-color:#fdf5e6">

<h2>活動資料</h2>
<table>
    <tr>
        <th>活動名稱</th> <th>活動日期</th> <th>活動起始時間</th> <th>活動地點</th> 
		<th>活動種類</th><th>活動人數上限</th> <th>活動費用</th><th>修改</th><th>刪除</th>
    </tr>
    <c:forEach items="${events}" var="event" varStatus="s">
    <tr>
    	<td> <a href="./Getaevent?eventid=${event.eventID}" title="${event.eventName}"> ${event.eventName} </a> </td> <td>${event.eventDate}</td><td>${event.eventStratTime}</td><td>${event.eventLocation}</td>
    	<td>${event.eventType}<br>
    	<c:out value="${event.eventType1}" default="" /> <br> 
    	<c:out value="${event.eventType2}"  default="未設定" /> <br> 
    	<c:out value="${event.eventTypeCustom}" default="未設定" />
    	</td>
    	<td>${event.eventMaxLimit}</td>
    	<td>${event.eventFee}</td>
    	<td><input type="button" value="確認" name="eventID" onclick="location.href='/EEIT/Getaevent?eventid=${event.eventID}'"> </td>
    	<td><input type="button" value="確認" name="eventID" onclick="location.href='/EEIT/deleteevent?eventid=${event.eventID}'"> </td>
    </tr>
    </c:forEach>
  
</table>

<input type="button" value="新增活動" onclick="location.href='/EEIT/event/createvent.jsp'">

         <script>
 

        
 </script>

</body>
</html>