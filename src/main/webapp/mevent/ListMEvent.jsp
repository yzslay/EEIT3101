<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.petpet.bean.mevent.MarketingEventBean,com.petpet.customEL.ImgOut"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"mevent"; 
System.out.println(basePath);%> 
<base href="<%=basePath%>">
<meta charset="UTF-8">
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="EXPIRES" CONTENT="0">
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html, body, h1, h2, h3, h4 {
	font-family: "Lato", sans-serif
}

.mySlides {
	display: none
}

.w3-tag, .fa {
	cursor: pointer
}

.w3-tag {
	height: 15px;
	width: 15px;
	padding: 0;
	margin-top: 6px
}
del{
	color:red;
}
</style>
<link rel="stylesheet" href="${basePath}/EEIT3101/mevent/jqueryui/jquery-ui.min.css">
<link rel="stylesheet" href="${basePath}/EEIT3101/mevent/jqyeryui/jquery-ui.structure.min.css">
<link rel="stylesheet" href="${basePath}/EEIT3101/mevent/jqyeryui/jquery-ui.theme.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
			integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
			crossorigin="anonymous"></script>
<script src="${basePath}/EEIT3101/mevent/jqueryui/jquery-ui.min.js"></script>		
<title>行銷活動列表</title>
</head>
<body>
	<!-- Links (sit on top) -->
	<div class="w3-top">
		<div class="w3-row w3-large "
			style="background-color: #97EBBE; color: #55876D">
			<div class="w3-col s3">
				<a href="<c:url value="${basePath}"><c:param name="action" value="list" /></c:url>" class="w3-button w3-block">回到列表</a>
			</div>
			<div class="w3-col s3">
				<a href="<c:url value="${basePath}"><c:param name="action" value="new" /></c:url>" class="w3-button w3-block">新增活動</a>
		  	</div>
		<!--	<div class="w3-col s3">
				<a href="#about" class="w3-button w3-block">About</a>
			</div>
			<div class="w3-col s3">
				<a href="#contact" class="w3-button w3-block">Contact</a>
			</div>  -->
		</div>
	</div>
	<!-- Content -->
	<div class="w3-content"
		style="max-width: 1400px; margin-top: 80px; margin-bottom: 80px">

		<!-- Grid -->
		<div class="w3-row w3-container">
			<div class="w3-center w3-padding-8">
				<span class="w3-xlarge w3-padding-14" style="color: #EB9097"><b>行銷活動清單</b></span>
			
			<table class="w3-table-all">
				<thead>
					<tr class="w3-pale-green">
						<th>活動名稱</th>
						<th>類型ID</th>
						<th>活動開始時間</th>
						<th>活動結束時間</th>
						<th>活動辦法</th>
						<th>是否上線</th>
						<th>圖片</th>
						<th>負責人ID</th>
						<th>修改</th>
						<th>刪除</th>
					</tr>
				</thead>
				<c:forEach items="${mevents}" var="mevent" varStatus="s">
					<tr>
						<td><c:out value="${mevent.meventname}" /></td>
						<td><c:out value="${mevent.meventtypeid}" /></td>
						<td><c:out value="${mevent.meventstartdate}" /></td>
						<td><c:out value="${mevent.meventenddate}" /></td>
						<td><c:out value="${mevent.meventdescription}" /></td>
						<td><c:out value="${mevent.meventonline}" /></td>
						<td><c:choose>
								<c:when test="${mevent.meventpicture!=null }">
									<img
										src="data:image/jpg;base64,${ImgOut().ImgWrite(mevent.meventpicture) }"
										width="250px">
								</c:when>
								<c:otherwise>沒有圖片喔</c:otherwise>
							</c:choose></td>
						<td><c:out value="${mevent.meventownerid}" /></td>
						<td><a href="${basePath}?action=edit&eid=${mevent.meventid }" class="w3-button">修改</a></td>
						<td><a href="${basePath}?action=delete&eid=${mevent.meventid }" class="w3-button del">刪除</a></td>
						<c:set var="count" value="${s.count }" />
				</c:forEach>
			</table>
			<span class="w3-large w3-padding-14" style="color: #EB9097">共${count}筆資料</span>
			</div>
		</div>

	</div>
	<div id="deldiv" title="提醒"><p>確定刪除?</p></div>
	<!-- Footer -->

	<footer class="w3-container w3-center"
		style="background-color: #DAF88F; color: #809D66">
		<a href="#" class="w3-button w3-margin-top"
			style="background-color: #467E14; color: #C9F89F"><i
			class="fa fa-arrow-up w3-margin-right"></i>To the top</a>
		<p>
			報告組別&amp;報告人<br> 第7組 petpet寵物網 &nbsp;&nbsp;&nbsp;42 鄭雅心
		<p>
	</footer>
<script src="${basePath}/EEIT3101/mevent/js/listcheck.js"></script>
</body>
</html>