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
		<th>���ʺ���</th><th>���ʤH�ƤW��</th> <th>���ʶO��</th><th>�ק�</th><th>�R��</th>
    </tr>
    <c:forEach items="${events}" var="event" varStatus="s">
    <tr>
    	<td>${event.eventName}</td> <td>${event.eventDate}</td><td>${event.eventStratTime}</td><td>${event.eventLocation}</td>
    	<td>${event.eventType}<br>${event.eventType1}</td><td>${event.eventMaxLimit}</td><td>${event.eventFee}</td>
    	<td><input type="button" value="�T�{" name="eventID" onclick="location.href='./Getaevent?eventid=${event.eventID}'"> </td>
    	<td><input type="button" value="�T�{" name="eventID" onclick="location.href='./deleteevent?eventid=${event.eventID}'"> </td>
    </tr>
    </c:forEach>
</table>
         <script>
            $('#btn1').click(function(){
            $('input').removeAttr("readonly");//���ä��� :button �Pbutton
            });
            function modifyemp(){
                //        document.("��檺name��").action
                //        document.("��檺name��").submit
                        document.submitselection.action="./ModifyEmployee";

                    }
                       function deleteemp() {
                        document.submitselection.action = "./deleteemp";
                    }

        
 </script>

</body>
</html>