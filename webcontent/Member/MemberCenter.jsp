<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>會員資料修改</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
    <style>
        .div {
                margin: 60px auto;
                /* border: 3px solid red; */
                width: 600px;
                right: 60px;
            }
    
            h1 {
                margin-top: 300px;
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
            .last{
                margin-bottom: 670px;
            }
    </style>
</head>

<body background="image/Back.jpg">
    <div class="container outSide">
        <jsp:useBean id="member" scope="request" class="com.petpet.Member.LoginBean" />
        <h1>帳戶資料修改</h1>
        <form  method="post" action="UpdateData">
            <div><br>
                <h4 class="MemberNum">您的會員編號：
                    <input class="MemberNum MemberNumInput" readonly type="text" name="memberid"
                     value="${member.memberid}">
                </h4>
            </div>

            <div class="input-group input-group-lg div">
                <span class="input-group-text ">姓名</span>
                <input type="text" class="form-control" placeholder="姓" name="firstname" value="${member.firstname}" autocomplete="off">
                <input type="text" class="form-control" placeholder="名" name="lastname" value="${member.lastname}" autocomplete="off">
            </div>
            <div class="input-group flex-nowrap input-group-lg div">
                <span class="input-group-text">性別</span>
                <div class="btn-group">
                    <input type="hidden" id="genderInput" name="gender" value="${member.gender}">
                    <select id="gender">
                        <option>請選擇</option>
                        <option>男</option>
                        <option>女</option>
                    </select>
                </div>
            </div>
            <div class="input-group flex-nowrap input-group-lg div">
                <span class="input-group-text">生日</span>
                <input type="date" name="birthday" value="${member.birthday}">
            </div>
            <div class="input-group flex-nowrap input-group-lg div">
                <span class="input-group-text">手機號碼</span>
                <input type="text" class="form-control" placeholder="手機號碼" name="mobile" value="${member.mobile}" autocomplete="off">
            </div>
            <div class="d-grid gap-2 col-6 mx-auto container">
                <button type="submit" class="btn btn-success" id="signOutput"
                    style="width:200px;height:40px;">送出</button>
            </div>
        </form>
        <div class="last"></div>
    </div>
    <script>

        const choose = document.getElementById('gender');

        choose.addEventListener("input",getOption)

        function getOption() {
            var x = document.getElementById("gender")
            document.getElementById("genderInput").value=x.options[x.selectedIndex].text;
            console.log(document.getElementById("genderInput").value);
        }
    </script>

</body>
</html>