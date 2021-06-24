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
		<th>活動種類</th><th>活動人數上限</th> <th>活動費用</th><th>修改</th><th>刪除</th>
    </tr>
    <c:forEach items="${events}" var="event" varStatus="s">
    <tr>
    	<td>${event.eventName}</td> <td>${event.eventDate}</td><td>${event.eventStratTime}</td><td>${event.eventLocation}</td>
    	<td>${event.eventType}<br>${event.eventType1}</td><td>${event.eventMaxLimit}</td><td>${event.eventFee}</td>
    	<td><input type="button" value="確認" name="eventID" onclick="location.href='./Getaevent?eventid=${event.eventID}'"> </td>
    	<td><input type="button" value="確認" name="eventID" onclick="location.href='./deleteevent?eventid=${event.eventID}'"> </td>
    </tr>
    </c:forEach>
</table>
         <script>
            $('#btn1').click(function(){
            $('input').removeAttr("readonly");//隱藏元素 :button 與button
            });
            function modifyemp(){
                //        document.("表單的name值").action
                //        document.("表單的name值").submit
                        document.submitselection.action="./ModifyEmployee";

                    }
                       function deleteemp() {
                        document.submitselection.action = "./deleteemp";
                    }

        
 </script>

</body>
</html>