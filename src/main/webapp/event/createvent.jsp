<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.petpet.bean.EmpBean"%>
    <%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<meta charset="UTF-8">

 <!-- Latest compiled and minified CSS -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 <!-- jQuery library -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <!-- Popper JS -->
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> 
 <!-- Latest compiled JavaScript -->
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="/EEIT/event/jquery-ui-1.12.1.custom/jquery-ui.min.css">
<script src="/EEIT/event/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
<script src="/EEIT/event/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
 
<title>新增活動資料</title>

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
height: 70px;
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
			
<div class="container anchor">
    <form method="post" name="createvent" action="/EEIT/insertevent" >  
      	<div class="row">
            <div class="col">
            活動名稱 :<br> <input type="text" class="form-control" required name="eventname"  placeholder="請輸入活動名稱"/>
            <small  class="form-text text-muted">
	        必填欄位
			</small>
            <p>  
            </div>
            <div class="col">
            活動日期: <br><input type="text" class="form-control" required  name="eventdate" id="date"  placeholder="請輸入活動日期 YYYY-MM-DD" />
            <small  class="form-text text-muted">
	        必填欄位
			</small>
            <p>
            </div>
     	</div>
      <div class="row">
          <div class="col">
          活動起始時間: <br><input type="text" size="30"  class="form-control" required name="eventstarttime"  id="date" placeholder="請輸入活動時間 YYYY-MM-DD HH:mm"/>
          <small class="form-text text-muted">
	      必填欄位
		  </small>
                   
          <p>
          </div>
          <div class="col">
          活動結束時間: <br><input type="text" size="30" class="form-control" required name="eventendtime"  placeholder="請輸入活動時間 YYYY-MM-DD HH:mm" />
          <small class="form-text text-muted">
	      必填欄位
		  </small>
          <p>
          </div>
      </div>  
      <div class="row">
          <div class="col">
          活動地點: <br><input type="text" class="form-control" required name="eventlocation"  placeholder="請輸入活動地點" />
          <small class="form-text text-muted">
	      必填欄位
		  </small><p>
          </div>
      </div>
      <div class="row">
          <div class="col">
          活動種類: <br><input type="text"  name="eventtype" class="form-control" required placeholder="請輸入活動種類" />
          <small class="form-text text-muted">
	      必填欄位
		  </small>      
          <p>
          </div>
          <div class="col">
          活動種類1: <br><input type="text"  name="eventtype1" placeholder="請輸入活動種類" /><p>
          </div>
          <div class="col">
          活動種類2: <br><input type="text"  name="eventtype2" placeholder="請輸入活動種類"  /><p>
          </div>
          <div class="col">
          活動種類自訂: <br><input type="text"  name="eventtypecustom"placeholder="請輸入活動種類"  /><p>
          </div>
      </div>
      <div class="row">
          <div class="col">
          活動人數上限: <br><input type="text" class="form-control" required  name="eventmaxlimit" placeholder="請輸入活動人數" /><p>
          </div>
          <div class="col">
          活動費用:<br><input type="text"  name="eventfee" placeholder="請輸入活動費用"  /><p>
          </div>
      </div>
      <div>
        活動說明:<br><textarea name="eventdescribe"  placeholder="請輸入活動說明"  rows="5" cols="100"></textarea>
   		</div>
        <button type="submit" class="btn btn-primary">確認修改</button>
     </form>
     </div>
<footer>
    第六組
</footer>
<script>
$( "#date" ).datepicker(
		{ dateFormat: 'yy-mm-dd' }
		);
</script>
</body>
</html>