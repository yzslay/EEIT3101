<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8" import="java.util.*, com.petpet.bean.EmpBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>刪除成功</title>
 <!-- Latest compiled and minified CSS -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 <!-- jQuery library -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <!-- Popper JS -->
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> 
 <!-- Latest compiled JavaScript -->
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<title>刪除成功</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<style>
nav {
  background-color: #60CA91;
  padding:13px;
  position:fixed;
  top:0;
  left:0;
  width:100%;
  z-index:100;
}
nav ul{
  display:flex;
  margin:0 auto;
  padding:0;
  justify-content:center;
  list-style-type: none;
}
nav ul li a{
  color:deepblue;
  padding:15px;
  font-size:28px;
  margin:40px;
}


footer{
  background-color:#58876D;
  padding:13px;
  margin:5px;
  font-size:20px;
  text-align: center;
  font-weight:bolder;
}
.anchor::before {
content: "";
display: block;
height: 15px;
}


table {
  border-collapse: collapse;
}
th, td {
  padding: 15px;
  text-align: left;
}
.mid{

	margin:15px auto;
	text-align:center;
	}
table{
	margin: auto;
	
}

</style>
</head>
<body>

    <nav>
		<ul>
			<li><a href="/EEIT/Getallevent" class="href">查詢所有活動</a> 	</li>
			<li><a href="/EEIT/event/createvent.jsp" class="href">新增活動</a> 	</li>
			<li><a href="about" class="href">about</a> 	</li>
		</ul>
	</nav>
	
<div class="container">
<div class="row">
	<div class="col">
<h3 class="anchor">刪除成功，刪除資料如下</h3>
</div>

</div>
<div class="mid">
<table class="anchor table-striped">
    <thead>
        <tr>
            <th colspan="2">活動刪除內容</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>活動名稱 :</td>
            <td>${event.eventName}</td>
        </tr>
        <tr>
            <td>活動日期:</td>
            <td>${event.eventDate}</td>
        </tr>
        <tr>
            <td>活動起始時間:</td>
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
</div>
</div>

<footer>
	第八組組員-蕭詠謙
</footer>

</body>
</html>