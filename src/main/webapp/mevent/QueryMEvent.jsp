<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="com.petpet.bean.mevent.MarketingEventBean,com.petpet.customEL.ImgOut" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
	<html>
	<head>
	<% String path=request.getContextPath();
	   String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"mevent";
	   System.out.println(basePath);%>
	<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
	<META HTTP-EQUIV="EXPIRES" CONTENT="0">
	<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style>
		html,body,h1,h2,h3,h4 {
			font-family: "Lato", sans-serif
		}

		.mySlides {
			display: none
		}

		.w3-tag,.fa {
			cursor: pointer
		}

		.w3-tag {
			height: 15px;
			width: 15px;
			padding: 0;
			margin-top: 6px
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
			integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
			crossorigin="anonymous"></script>
	<title>查詢行銷活動</title>
	</head>
	<body>
		<!-- Links (sit on top) -->
		<div class="w3-top">
			<div class="w3-row w3-large " style="background-color: #97EBBE; color: #55876D">
				<div class="w3-col s3">
					<a href="<c:url value="${basePath }"><c:param name="action" value="list" /></c:url>" class="w3-button w3-block">回到總表</a>
				</div>
				<div class="w3-col s3">
					<a href="<c:url value="${basePath}"><c:param name="action" value="new" /></c:url>" class="w3-button w3-block">新增活動</a>
				</div>
			  	<div class="w3-col s3">
					<a href="<c:url value="${basePath}"><c:param name="action" value="query" /></c:url>" class="w3-button w3-block">查詢活動</a>
				</div>
			<!--	<div class="w3-col s3">
					<a href="#contact" class="w3-button w3-block">Contact</a>
				</div>  -->
			</div>
			</div>
				<!-- Content -->
				<div class="w3-content" style="max-width: 1400px; margin-top: 80px; margin-bottom: 80px">
					<!-- Grid -->
					<div class="w3-row w3-container">
						<div class="w3-center w3-padding-8">
							<span class="w3-xlarge w3-padding-14" style="color: #EB9097"><b>查詢行銷活動</b></span>							
								<form method="post" action="<c:url value="${basePath}?action=query"></c:url>">
							<div class="w3-center">
								<table class="w3-table-all w3-card-4">
									<caption>
										查詢條件設定
									</caption>
									<tr>
										<th>活動名稱:</th>
										<td><input type="text" name="name" size="100" id="name" value="" /><span id="spname"></span></td>
									</tr>
<!--  									<tr>
										<th>活動類型:</th>
										<td>											
												<select name="typeid">
													<option value="1">會員招募活動</option>
													<option value="2">商品促銷活動</option>
													<option value="3">限時搶購活動</option>
													<option value="4">滿額登記抽獎</option>
												</select>		
										</td>
									</tr>
									<tr>
										<th>活動開始時間:</th>
										<td><input type="date" name="startdate" value=""><span id="spsd"></span><br>
											<input type="time" name="starttime" step="1" value=""><span id="spst"></span>
										</td>
									</tr>
									<tr>
										<th>活動結束時間:</th>
										<td><input type="date" name="enddate" value=""><span id="sped"></span><br>
											<input type="time" name="endtime" step="1" value=""><span id="spet"></span>
										</td>
									</tr>
									<tr>
										<th>活動辦法:</th>
										<td><textarea rows="5" cols="30" name="description"></textarea></td>
									</tr>
									<tr>
										<th>活動是否上線:</th>
										<td>									
													<input type="radio" name="online" value="true">是
													<input type="radio" name="online" value="false">否
										</td>
									</tr> -->
									<tr>
										<td colspan="2" align="center"><input type="submit" value="送出" id="btn"></td>
									</tr>
								</table>
							</div>
							</form>
						</div>
					</div>
				</div>
				<!-- Footer -->
				<footer class="w3-container w3-center" style="background-color: #DAF88F; color: #809D66">
					<p>
						報告組別&amp;報告人<br> 第7組 petpet寵物網 &nbsp;&nbsp;&nbsp;42 鄭雅心
					<p>
				</footer>
			<!--  	<script src="<c:url value="${basePath}/mevent/js/formcheck.js"/>"></script> -->
			</body>
			</html>