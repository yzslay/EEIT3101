<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.petpet.Member.LoginBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!@SuppressWarnings("unchecked")%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>員工資料</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>

<style>
.block {
	margin-top: 100px;
}

.set {
	margin: auto 0;
}

.title {
	font-size: 20px;
}

td {
	font-size: 20px;
}

h1 {
	margin-bottom: 50px;
	margin-top: 270px;
}

h3 {
	margin-top: 50px;
}
.MemberNumInput {
            border-style: none;
            outline: none;
            BACKGROUND-COLOR: transparent;
        }
</style>
</head>

<body background="image/Back.jpg" class="block">
    <div align="center">
        <h1>會員資料管理</h1>
        <table style="width: 1700px;" class="set table table-success table-striped block table-hover">
            <thead>
                <tr class="title">
                    <th style="width: 80px;" scope="col">會員編號</th>
                    <th style="width: 200px;" scope="col">帳號</th>
                    <th style="width: 200px;" scope="col">密碼</th>
                    <th style="width: 50px;" scope="col">姓</th>
                    <th style="width: 100px;" scope="col">名</th>
                    <th style="width: 50px;" scope="col">性別</th>
                    <th style="width: 130px;" scope="col">生日</th>
                    <th style="width: 150px;" scope="col">手機號碼</th>
                    <th style="width: 50px;" scope="col">更新</th>
                    <th style="width: 50px;" scope="col">刪除</th>
            </thead>
            <tbody>
				<c:forEach var="member" items="${memberData}" varStatus="i" >
				<form id="myForm${i.count}" action="">
                <tr>
                    <th style="width: 80px;" scope="row"><input size=9 class="MemberNumInput" readonly type="text" name="memberid" value="${member.memberid}"></th>
                    <td style="width: 200px;"><input size=35 class="MemberNumInput" readonly type="text" name="email" value="${member.email}"></td>
                    <td style="width: 200px;"><input size=20 class="MemberNumInput" readonly type="text" name="password" value="${member.password}"></td>
                    <td style="width: 50px;"><input size=3 class="MemberNumInput" readonly type="text" name="firstname" value="${member.firstname}"></td>
                    <td style="width: 100px;"><input size=5 class="MemberNumInput" readonly type="text" name="lastname" value="${member.lastname}"></td>
                    <td style="width: 50px;"><input size=3 class="MemberNumInput" readonly type="text" name="gender" value="${member.gender}"></td>
                    <td style="width: 130px;"><input size=10 class="MemberNumInput" readonly type="text" name="birthday" value="${member.birthday}"></td>
                    <td style="width: 150px;"><input size=13 class="MemberNumInput" readonly type="text" name="mobile" value="${member.mobile}"></td>
                    <td style="width: 50px;"><button type="submit" class="btn btn-success" id="change"
                            style="width:100px;height:40px;" onclick="toChange()">修改</button></td>
                    <td style="width: 50px;"><button type="submit" class="btn btn-success" id="delete"
                            style="width:100px;height:40px;" onclick="CheckForm(${i.count})">刪除</button></td>
                    </form>
                    <c:set var="count" value="${i.count}"/>
				</c:forEach>
            </tbody>
        </table>
        <h3>目前共${count}筆會員資料</h3>
    </div>

    <script>
    
    	function CheckForm(i) {
        	if (confirm("請確認是否進行變更？")) {
        		toDelete(i);
        	} else {
        	}
    	}
        
        function toChange(count) {
            alert("CHANGE!!");
            // document.pay.action = "跳轉的鏈接";
            document.myForm.submit();
        }
        function toDelete(i) {
        	var x = document.getElementById("myForm"+i)
            x.action = "ToDeleteMember";
            x.submit();
        }


    </script>
</body>
</html>