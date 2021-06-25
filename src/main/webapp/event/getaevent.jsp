<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.petpet.bean.EmpBean"%>
    <%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>
<head>
<style>



</style>
<meta charset="UTF-8">
<title>員工資料</title>
</head>


<body>
    <form method="post" name="submitselection" action="./ModifyEvent" >  
    	<br> <input type="hidden"  readonly name="eventid" value="${event.eventID}" /><p>  
        活動名稱 :<br> <input type="text" name="eventname" value="${event.eventName}" /><p>  
        活動日期: <br><input type="text"  name="eventdate" value ="${event.eventDate}" /><p>
        活動起始時間: <br><input type="text"   name="eventstarttime" value ="${event.eventStratTime}" /><p>
        活動結束時間: <br><input type="text"   name="eventendtime" value ="${event.eventEndTime}" /><p>
        活動地點: <br><input type="text"   name="eventlocation" value ="${event.eventLocation}" /><p>        
        活動種類: <br><input type="text"  name="eventtype" value ="${event.eventType}"/><p>
        活動種類1: <br><input type="text"  name="eventtype1" value ="${event.eventType1}"/><p>
        活動種類2: <br><input type="text"  name="eventtype2" value ="${event.eventType2}"/><p>
        活動種類自訂: <br><input type="text"  name="eventtypecustom" value ="${event.eventTypeCustom}"/><p>
        活動人數上限: <br><input type="text"   name="eventmaxlimit"value ="${event.eventMaxLimit}" /><p>
        活動費用:<br><input type="text"  name="eventfee"  value ="${event.eventFee}" /><p>
        活動說明:<br><textarea name="eventdescribe"  rows="5" cols="50"> ${event.eventDescribe} </textarea><p>
   
        <input type="submit" value="確認修改">
     </form>
     

     <input type="button" value="查詢所有活動" name="eventID" onclick="location.href='/EEIT/Getallevent'"> 
</body>
</html>