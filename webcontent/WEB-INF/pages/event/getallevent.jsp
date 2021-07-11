<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.* , com.petpet.bean.EventBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html lang="en">
<head>
	<% String path=request.getContextPath();
	   String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"event";
	   System.out.println(basePath);%>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
 <!-- Latest compiled and minified CSS -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 <!-- jQuery library -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <!-- Popper JS -->
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> 
 <!-- Latest compiled JavaScript -->
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
 
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
 
<link rel="stylesheet" href="/EEIT/event/jquery-ui-1.12.1.custom/jquery-ui.min.css">
<script src="/EEIT/event/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
<script src="/EEIT/event/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>

<title> 活動頁面</title>
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

}
td {
  text-align: center;
}
footer{
  background-color:#58876D;
  padding:13px;
  margin:0px;
  font-size:20px;
  text-align: center;
  font-weight:bolder;
}
.anchor::before {
content: "";
display: block;
height: 70px;
}

</style>
<script>

</script>
</head>
<body>
    <nav>
		<ul>
			<li><a href="queryallevent.controller" class="href">查詢所有活動</a> 	</li>
			<li><a href="createeevent.url" class="href">新增活動</a> 	</li>
			<li><a href="about" class="href">about</a> 	</li>
		</ul>
	</nav>	


<div class="container anchor " >
<table class="table table-hover">
	<thead class="thead-dark">
		<tr>
			<th scope="col">活動名稱</th> <th scope="col">活動日期</th> <th scope="col">活動起始時間</th> <th scope="col">活動地點</th> 
			<th scope="col">活動種類</th><th scope="col">活動人數上限</th> <th scope="col">活動費用</th><th scope="col" >修改</th><th scope="col">刪除</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${events}" var="event" varStatus="s">
		<tr>
			<th scope="row"> <a href="${basePath}Getaevent?eventid=${event.eventID}" title="${event.eventName}"> ${event.eventName} </a> </th> <td>${event.eventDate}</td><td>${event.eventStratTime}</td><td>${event.eventLocation}</td>
			<td>${event.eventType}<br>
			<c:out value="${event.eventType1}" default="--" /> <br> 
			<c:out value="${event.eventType2}"  default="--" /> <br> 
			<c:out value="${event.eventTypeCustom}" default="--" />
			</td>
			<td>${event.eventMaxLimit}</td>
			<td>${event.eventFee}</td>
			<td><input type="button" value="修改" name="eventID" onclick="location.href='/EEIT3101/queryevent.controller?eventid=${event.eventID}'"> <i class="fa fa-pencil fa-1x" aria-hidden="true"></i>
			</td>
			<td><input type="button" class="delete" value="刪除" name="eventID" onclick="deleteItem(${event.eventID})"><i class="fa fa-trash fa-1x" aria-hidden="true"></i>
			</td>
		</tr>
  		</c:forEach>
	</tbody>
  
</table>
</div>


<footer>
	第八組組員-蕭詠謙
</footer>


</body>
<script>
 
function deleteItem(ID) {
    if (confirm("你確定要刪除這個活動嗎")) {
    	let  web="/EEIT3101/deleteevent.controller?eventid="+ID;
    	window.location.href=web;
    	
    }
    return false;
}
 </script>


</html>