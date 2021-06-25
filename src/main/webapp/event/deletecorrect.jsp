<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8" import="java.util.*, com.petpet.bean.EmpBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<style>
table {
  border-collapse: collapse;
}
th, td {
  padding: 15px;
  text-align: left;
}
tr:nth-child(even) {background-color: #f2f2f2;}
</style>
</head>
<body>
<h3>刪除成功，刪除資料如下</h3>

<table>
    <thead>
        <tr>
            <th colspan="2">活動刪除內容</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>活動名稱:</td>
            <td>${event.eventName}</td>
        </tr>
        <tr>
            <td>活動日期:</td>
            <td>${event.eventDate}</td>
        </tr>
        <tr>
            <td>活動開始時間:</td>
            <td>${event.eventStratTime}</td>
        </tr>
        <tr>
            <td>活動結束時間:</td>
            <td>${event.eventEndTime}</td>
        </tr>
        <tr>
            <td>活動地點:</td>
            <td>${event.eventLocation}</td>
        </tr>
        <tr>
            <td>活動種類:</td>
            <td>${event.eventType}</td>
        </tr>
        <tr>
            <td>活動種類1:</td>
            <td>${event.eventType1}</td>
        </tr>
        <tr>
            <td>活動種類2:</td>
            <td>${event.eventType2}</td>
        </tr>
        <tr>
            <td>活動人數上限:</td>
            <td>${event.eventMaxLimit}</td>
        </tr>
        <tr>
            <td>活動費用:</td>
            <td>${event.eventFee}</td>
        </tr>
        <tr>
            <td>活動說明:</td>
            <td>${event.eventDescribe}</td>
        </tr>
        
    </tbody>
</table>

 <input type="button" value="�d�ߩҦ�����" name="eventID" onclick="location.href='/EEIT/Getallevent'"> 

</body>
</html>