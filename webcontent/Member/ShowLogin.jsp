<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>會員資料</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
    <style>
        .hide {
            visibility: hidden;
        }

        .show {
            visibility: visible;
        }

        .loadText {
            font-size: 30px;
            margin-top: 50px;
        }

        .div {
            margin: 60px auto;
            width: 600px;
            right: 60px;
        }

        h1 {
            margin-top: 205px;
            text-align: center;
        }

        .outSide {
            width: 500px;

        }

        .MemberNum {
            color: #7E1436;
        }

        .MemberNumInput {
            border-style: none;
            outline: none;
            background-color: transparent;
        }

        .back {
            background-size: 0 0;
        }
        .last{
                margin-bottom: 670px;
            }
    </style>
</head>

<body id="third" class="back" background="image/Back.jpg">
    <!-- <div id="first" class="container show loadText" align="center">準備載入頁面......</div>
    <div id="second" class="container outSide hide"> -->
        <jsp:useBean id="member" scope="request" class="com.petpet.Member.LoginBean" />
        <h1>會員資料</h1>
        <form>
        	<div><br>
                <h4 class="MemberNum">
                    <input class="MemberNum MemberNumInput" readonly type="Hidden" id="memberid" name="memberid" 
                    value="${member.memberid}">
                </h4>
            </div>
            <div class="input-group flex-nowrap input-group-lg div">
                <span class="input-group-text">帳號</span>
                <input id="email" type="text" name="email" disabled value="${member.email}">
            </div>
            <div class="input-group flex-nowrap input-group-lg div">
                <span class="input-group-text">密碼</span>
                <input id="password" type="password" name="password" disabled value="${member.password}">
            </div>              
       	    <div class="input-group input-group-lg div">
                <span class="input-group-text ">姓名</span>
                <input type="text" class="form-control" placeholder="姓" id="firstName" name="firstname" disabled value="${member.firstname}" autocomplete="off">
                <input type="text" class="form-control" placeholder="名" id="lastName" name="lastname" disabled value="${member.lastname}" autocomplete="off">
            </div>
            <div class="input-group flex-nowrap input-group-lg div">
                <span class="input-group-text">性別</span>
                <div class="btn-group">
                    <input type="text" id="genderInput" name="gender" disabled value="${member.gender}">
                </div>
            </div>
            <div class="input-group flex-nowrap input-group-lg div">
                <span class="input-group-text">生日</span>
                <input id="birthday" type="date" name="birthday" disabled value="${member.birthday}">
            </div>
            <div class="input-group flex-nowrap input-group-lg div">
                <span class="input-group-text">手機號碼</span>
                <input type="text" class="form-control" placeholder="手機號碼" id="mobil" name="mobile" disabled value="${member.mobile}" autocomplete="off">
            </div>
            <div class="d-grid gap-2 col-6 mx-auto container" align="center">
                <button type="submit" class="btn btn-success" id="signOutput"
                    style="width:200px;height:40px;">修改</button>
            </div>
        </form>
        <div class="last"></div>
    <!-- </div> -->
    <!-- <script>

        const choose = document.getElementById('gender');

        choose.addEventListener("input", getOption)

        function getOption() {
            var x = document.getElementById("gender")
            document.getElementById("genderInput").value = x.options[x.selectedIndex].text;
            console.log(document.getElementById("genderInput").value);
        }

        function autoShow() {
            document.getElementById( "second" ).classList.remove("hide");
            document.getElementById( "second" ).classList.add("show");
            document.getElementById( "first" ).classList.remove("show");
            document.getElementById( "first" ).classList.add("hide");
            document.getElementById( "third" ).classList.remove("back");
            alert("資料修改完成！");
        }

        var timer = autoRun();
        function autoRun() {
            setTimeout("autoShow()", 3000);
        }



    </script> -->

</body>
</html>