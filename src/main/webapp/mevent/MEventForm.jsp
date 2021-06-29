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
	   <!-- 從servlet獲得圖案的路徑 -->
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
		th{
			width:150px;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
			integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
			crossorigin="anonymous"></script>
	<title>行銷活動設定</title>
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
					<a href="<c:url value="${basePath}"><c:param name="action" value="search" /></c:url>" class="w3-button w3-block">查詢活動</a>
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
							<span class="w3-xlarge w3-padding-14" style="color: #EB9097"><b>行銷活動設定</b></span>
							<c:if test="${mevent != null }">
								<form method="post" action="<c:url value="${basePath}"><c:param name="action" value="update" /></c:url>" enctype="multipart/form-data" id="updateform">
							</c:if>

							<c:if test="${mevent == null }">
								<form method="post" action="<c:url value="${basePath}"><c:param name="action" value="insert" /></c:url>" enctype="multipart/form-data">
							</c:if>
							<div class="w3-center">
								<table class="w3-table-all w3-card-4">
									<caption>
										<c:if test="${mevent != null }">修改活動設定</c:if>
										<c:if test="${mevent == null }">新增活動</c:if>
									</caption>
									<tr>
										<c:if test="${mevent != null}">
											<input type="hidden" name="id" value="<c:out value='${mevent.meventid}' />" />
										</c:if>
									</tr>
									<tr>
										<c:if test="${mevent != null}">
											<input type="hidden" name="title" value="<c:out value='${mevent.meventtitle}' />" />
										</c:if>
									</tr>
									<tr>
										<th>活動名稱:</th>
										<td><input type="text" name="name" size="100" id="name" value="<c:out value='${mevent.meventname}' />" /><span id="spname"></span></td>
									</tr>
									<tr>
										<th>活動類型:</th>
										<td>
											<c:if test="${mevent != null }">
												<select name="typeid">
													<c:choose>
														<c:when test="${mevent.meventtypeid==1 }">
															<option value="1" selected>會員招募活動</option>
														</c:when>
														<c:otherwise>
															<option value="1">會員招募活動</option>
														</c:otherwise>
													</c:choose>
													<c:choose>
														<c:when test="${mevent.meventtypeid==2 }">
															<option value="2" selected>商品促銷活動</option>
														</c:when>
														<c:otherwise>
															<option value="2">商品促銷活動</option>
														</c:otherwise>
													</c:choose>
													<c:choose>
														<c:when test="${mevent.meventtypeid==3 }">
															<option value="3" selected>限時搶購活動</option>
														</c:when>
														<c:otherwise>
															<option value="3">限時搶購活動</option>
														</c:otherwise>
													</c:choose>
													<c:choose>
														<c:when test="${mevent.meventtypeid==4 }">
															<option value="4" selected>滿額登記抽獎</option>
														</c:when>
														<c:otherwise>
															<option value="4">滿額登記抽獎</option>
														</c:otherwise>
													</c:choose>
												</select>
											</c:if>
											<c:if test="${mevent == null }">
												<select name="typeid">
													<option value="1">會員招募活動</option>
													<option value="2">商品促銷活動</option>
													<option value="3">限時搶購活動</option>
													<option value="4">滿額登記抽獎</option>
												</select>
											</c:if>
										</td>
									</tr>
									<tr>
										<th>活動開始時間:</th>
										<c:set var="ts" value="${mevent.meventstartdate }" />
										<td><input type="date" name="startdate" value="${fn:substring(ts,0,10) }"><span id="spsd"></span><br>
											<input type="time" name="starttime" step="1" value="${fn:substring(ts,11,-1) }"><span id="spst"></span>
										</td>
									</tr>
									<tr>
										<th>活動結束時間:</th>
										<c:set var="td" value="${mevent.meventenddate }" />
										<td><input type="date" name="enddate" value="${fn:substring(td,0,10) }"><span id="sped"></span><br>
											<input type="time" name="endtime" step="1" value="${fn:substring(td,11,-1) }"><span id="spet"></span>
										</td>
									</tr>
									<tr>
										<th>活動辦法:</th>
										<td><textarea rows="5" cols="30" name="description">${mevent.meventdescription }</textarea></td>
									</tr>
									<tr>
										<th>活動是否上線:</th>
										<td>
											<c:choose>
												<c:when test="${mevent != null }">
													<c:choose>
														<c:when test="${mevent.meventonline==true }">
															<input type="radio" name="online" value="true" checked>是
															<input type="radio" name="online" value="false">否
														</c:when>
														<c:otherwise>
															<input type="radio" name="online" value="true">是
															<input type="radio" name="online" value="false" checked>否
														</c:otherwise>
													</c:choose>
												</c:when>
												<c:otherwise>
													<input type="radio" name="online" value="true" checked>是
													<input type="radio" name="online" value="false">否
												</c:otherwise>
											</c:choose>
										</td>
									</tr>
									<tr>
										<th>活動圖片:</th>
										<td>
											<c:choose>
												<c:when test="${mevent.meventpicture!=null }">
													<img id="img0" src="data:image/jpg;base64,${ImgOut().ImgWrite(mevent.meventpicture) }">
												</c:when>
												<c:otherwise></c:otherwise>
											</c:choose> 
											<input type="file" name="pic" id="file1" multiple="multiple"><hr>預覽:<br><img id="img1">
										</td>
									</tr>
									<tr>
										<c:if test="${mevent != null}">
											<input type="hidden" name="ownerid" value="<c:out value='${mevent.meventownerid}' />" />
										</c:if>
									</tr>
									<tr>
										<td colspan="2" align="center"><input type="button" value="送出" id="btn"></td>
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
				<script src="<c:url value="${basePath}/mevent/js/formcheck.js"/>"></script>
			</body>
			</html>