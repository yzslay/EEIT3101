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
    <form method="post" name="createvent" action="/EEIT/insertevent" >  
    
        活動名稱 :<br> <input type="text" name="eventname" placeholder="請輸入活動名稱"/><p>  
        活動日期: <br><input type="text" size="30"  name="eventdate" placeholder="請輸入活動日期 YYYY-MM-DD" /><p>
        活動起始時間: <br><input type="text" size="30"   name="eventstarttime"  placeholder="請輸入活動時間 YYYY-MM-DD HH:mm"/><p>
        活動結束時間: <br><input type="text" size="30"   name="eventendtime"  placeholder="請輸入活動時間 YYYY-MM-DD HH:mm" /><p>
        活動地點: <br><input type="text"  size="30" name="eventlocation"  placeholder="請輸入活動地點" /><p>
        活動種類: <br><input type="text"  name="eventtype" placeholder="請輸入活動種類" /><p>
        活動種類1: <br><input type="text"  name="eventtype1" placeholder="請輸入活動種類" /><p>
        活動種類2: <br><input type="text"  name="eventtype2" placeholder="請輸入活動種類"  /><p>
        活動種類自訂: <br><input type="text"  name="eventtypecustom"placeholder="請輸入活動種類"  /><p>
        活動人數上限: <br><input type="text"   name="eventmaxlimit" placeholder="請輸入活動人數" /><p>
        活動費用:<br><input type="text"  name="eventfee" placeholder="請輸入活動費用"  /><p>
        活動說明:<br><textarea name="eventdescribe"  placeholder="請輸入活動g說明"  rows="5" cols="50"></textarea>
   
        <input type="submit" value="修改">
     </form>
     
     <form></form>
     
     <input type="button" value="要有INPUT" name="eventID" onclick="location.href='./Getaevent?eventid=${event.eventID}'"> 

     </form>
     <input type="button" value="查詢所有活動" name="eventID" onclick="location.href='./Getallevent'"> 
</body>
</html>