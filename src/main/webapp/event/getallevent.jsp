<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"  import="java.util.* , com.petpet.bean.EventBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>���ʭ���</title>
<style>

</style>
<script>

</script>
</head>
<body style="background-color:#fdf5e6">

<h2>���u���</h2>
<table>
    <tr>
        <th>���ʦW��</th> <th>���ʤ��</th> <th>���ʰ_�l�ɶ�</th> <th>���ʦa�I</th> 
		<th>���ʺ���</th>  <th>���ʺ���</th>  <th>���ʤH�ƤW��</th> <th>���ʶO��</th>
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