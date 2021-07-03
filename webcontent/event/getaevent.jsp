<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.petpet.bean.EmpBean"%>
    <%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="/EEIT/event/jquery-ui-1.12.1.custom/jquery-ui.min.css">
<script src="/EEIT/event/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
<script src="/EEIT/event/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<html>
<head>
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

.anchor::before {
content: "";
display: block;
height: 80px;
}
footer{
  background-color:#58876D;
  padding:13px;
  margin:0px;
  font-size:20px;
  text-align: center;
  font-weight:bolder;
}
</style>
<meta charset="UTF-8">
<title>修改活動資料</title>
</head>


<body>
    <nav>
		<ul>
			<li><a href="/EEIT/Getallevent" class="href">查詢所有活動</a> 	</li>
			<li><a href="/EEIT/event/createvent.jsp" class="href">新增活動</a> 	</li>
			<li><a href="about" class="href">about</a> 	</li>
		</ul>
	</nav>
	
<div class="container anchor">
    <form method="post" name="submitselection" action="./ModifyEvent" >  
    	 <input type="hidden"  readonly name="eventid" value="${event.eventID}" />
   

    	<div class="row"> 
    		<div class="col">
        		活動名稱 :<br> <input type="text" class="form-control" required name="eventname" value="${event.eventName}" />
	        	<small  class="form-text text-muted">
	        	必填欄位
				</small>
        	<p>  
        	</div>
        	<div class="col">
      		  活動日期: <br><input type="text" class="form-control" required name="eventdate" id="date" value ="${event.eventDate}" /><p>
      		     <small class="form-text text-muted">
	        	必填欄位
				</small>      		
      		</div>

      	</div>
      	<div class="row">
            <div class="col">
        		活動起始時間: <br><input type="text"  class="form-control" required  name="eventstarttime" value ="${event.eventStratTime}" />
        		<small id="passwordHelpBlock" class="form-text text-muted">
	        	必填欄位
				</small>
        		<p>
        	</div>
        	<div class="col">
      			活動結束時間: <br><input type="text"  class="form-control" required name="eventendtime" value ="${event.eventEndTime}" />  
      			<small id="passwordHelpBlock" class="form-text text-muted">
	        	必填欄位
				</small><p>
        	</div>
        </div>
        <div class="row">
     	     <div class="col">
       			 活動地點: <br><input type="text" class="form-control" required  name="eventlocation" value ="${event.eventLocation}" />
       			 <small id="passwordHelpBlock" class="form-text text-muted">
	        	必填欄位
				</small>
				<p>        
       		 </div>
       	</div>
       	 <div class="row">
       		 <div class="col">
        		活動種類: <br><input type="text" class="form-control" required name="eventtype" value ="${event.eventType}"/>
        		<small id="passwordHelpBlock" class="form-text text-muted">
	        	必填欄位
				</small>
				<p>
             </div>
             <div class="col">
		        活動種類1: <br><input type="text"  name="eventtype1" value ="${event.eventType1}"/><p>
		     </div>
		     <div class="col">
      	  		活動種類2: <br><input type="text"  name="eventtype2" value ="${event.eventType2}"/><p>
      	  	 </div>
      	  	 <div class="col">
        		活動種類自訂: <br><input type="text"  name="eventtypecustom" value ="${event.eventTypeCustom}"/><p>
        	 </div>
        </div>
        <div class="row">
        	<div class="col">
		        活動人數上限: <br><input type="text"  class="form-control" required name="eventmaxlimit"value ="${event.eventMaxLimit}" /><p>
		    </div>
		    <div class="col">
        	活動費用:<br><input type="text"  name="eventfee"  value ="${event.eventFee}" />
        	 <small class="form-text text-muted">
		     必填欄位
			 </small>  <p>
        	</div>
        </div>
        <div>
        活動說明:<br><textarea name="eventdescribe"  rows="5" cols="50"> ${event.eventDescribe} </textarea><p>
   		</div>
        <button type="submit" class="btn btn-primary">確認</button>
     </form>
</div>

    
<footer>
	第八組組員-蕭詠謙
</footer>
    
    <script>
    $( "#date" ).datepicker(
    		{ dateFormat: 'yy-mm-dd' }
	);

    </script>
</body>
</html>