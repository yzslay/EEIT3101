<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>會員登入</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
    <style>
        .tip {
            font-size: 1px;
        }
        .outSide {
            margin: 80px auto;
            width: 600px;
        }
        .H {
            width: 700px;
            height: 700px;
            margin-top: 100px auto;
            border: 1px transparent solid;
            background-color: white;
            margin-bottom: 500px;
        }
        .inSide {
            width: 400px;
        }
        form {
            margin: 80px;
            right: 100px;
        }
        .upButton {
            margin: 0 auto;
        }
        .sub {
            margin: 50px;
        }
        h1{
            margin-top: 260px;
            margin-bottom: 70px;
        }
    </style>

</head>

<body background="../image/Back.jpg">
<h1 align="center"><font size="10">會員專區</font></h1>
    <div class="container H" style="box-shadow:3px 3px 5px 6px #cccccc;">
        <div class="container outSide">
            <nav>
                <div class="nav nav-tabs" id="nav-tab" role="tablist">
                    <button class="nav-link active upButton" id="login" data-bs-toggle="tab" data-bs-target="#nav-home"
                        type="button" role="tab" aria-controls="nav-home" aria-selected="true">　　　　　登入會員　　　　　</button>
                    <button class="nav-link upButton" id="signIn" data-bs-toggle="tab" data-bs-target="#nav-profile"
                        type="button" role="tab" aria-controls="nav-profile"
                        aria-selected="false">　　　　　註冊會員　　　　　</button>
                </div>
            </nav>
            <div class="tab-content" id="nav-tabContent">
                <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="login">
                    <form method="post" action="../CheckMemberData">
                        <div class="mb-3 inSide">
                            <label for="logInput" class="form-label">會員帳號</label>
                            <input type="email" class="form-control" id="logInput" placeholder="請輸入Email" name="email">
                            <span id="logInputShowBox" class="tip"></span>
                        </div>
                        <div class="mb-3 inSide">
                            <label for="logInputPwd" class="form-label">密碼</label>
                            <input type="password" class="form-control" id="logInputPwd"
                                placeholder="請輸入8~20字元的英數字，不可有特殊符號" name="password">
                            <span id="logInputPwdShowBox" class="tip"></span>
                        </div>
                        <font color="red"><%
					if(request.getAttribute("message")!= null){
						out.print(request.getAttribute("message"));
					}
				%></font>
                        <div class="d-grid gap-2 col-6 mx-auto sub">
                            <button type="submit" class="btn btn-success" id="logOutput">送出</button>
                        </div>
                    </form>
                </div>

                <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="signIn">
                    <form method="post" action="../UpdateData">
                        <div class="mb-3 inSide">
                            <label for="signInput" class="form-label">會員帳號</label>
                            <input type="email" class="form-control" id="signInput" placeholder="請輸入Email" name="email" autocomplete="off">
                            <span id="signInputShowBox" class="tip"></span>
                        </div>
                        <div class="mb-3 inSide">
                            <label for="signInputPwd" class="form-label">密碼</label>
                            <input type="password" class="form-control" id="signInputPwd"
                                placeholder="請輸入8~20字元的英數字，不可有特殊符號" name="password">
                            <span id="signInputPwdShowBox" class="tip"></span>
                        </div>
                        <div class="mb-3 inSide">
                            <label for="signCheckPwd" class="form-label">確認密碼</label>
                            <input type="password" class="form-control" id="signCheckPwd" placeholder="請輸入相同密碼"
                                name="dbpassword">
                            <span id="signCheckShowBox" class="tip"></span>
                        </div>
                        <div class="d-grid gap-2 col-6 mx-auto sub">
                            <button type="submit" class="btn btn-success" id="signOutput" disabled="true">送出</button>
                        </div>
                    </form>
                </div>

                <script>
                    var signAccount = false, signPassword = false, signCheckPassword = false;
					
                    const input1 = document.getElementById('signInput');
                    const input2 = document.getElementById('signInputPwd');
                    const input3 = document.getElementById('signCheckPwd');

                    var signInputAccount = document.getElementById("signInput"),
                        signInputAccountShowBox = document.getElementById("signInputShowBox");

                    input1.addEventListener('input', CheckAccount);

                    function CheckAccount() {
                        if (signInputAccount.value == "") {
                            signInputAccountShowBox.innerHTML = "請輸入Email";
                            signAccount = false;
                        }
                        if (signInputAccount.value == "") {
                            signInputAccountShowBox.innerHTML = "不可空白";
                            signAccount = false;
                        } else {
                            var emailRule = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/;
                            if (signInputAccount.value.search(emailRule) != -1) {
                                signInputAccountShowBox.innerHTML = "";

                                signAccount = true;
                            } else {
                                signInputAccountShowBox.innerHTML = "Email格式錯誤";
                                signAccount = false;
                            }
                        }
                    }

                    var signInputPwd = document.getElementById("signInputPwd"),
                        signInputPwdShowBox = document.getElementById("signInputPwdShowBox"),
                        signInputDoubleCheck = false;

                    input2.addEventListener('input', CheckPassword);

                    function CheckPassword() {
                        if (signInputPwd.value == "") {
                            signInputPwdShowBox.innerHTML = "請輸入密碼";
                            signPassword = false;
                            signInputDoubleCheck = false;
                        }
                        if (signInputPwd.value == "") {
                            signInputPwdShowBox.innerHTML = "不可空白";
                            signPassword = false;
                            signInputDoubleCheck = false;
                        } else {
                            if (signInputPwd.value.length < 8) {
                                signInputPwdShowBox.innerHTML = "至少要8字元";
                                signPassword = false;
                                signInputDoubleCheck = false;
                            } else {
                                var a = /[0-9]/;
                                var b = a.test(signInputPwd.value);
                                if (b == true) {
                                    var c = /[a-z]/i;
                                    var b = c.test(signInputPwd.value);
                                    if (b == true) {
                                        signInputPwdShowBox.innerHTML = "";
                                        signPassword = true;
                                        signInputDoubleCheck = true;
                                    } else {
                                        signInputPwdShowBox.innerHTML = "必須含有英數字";
                                        signPassword = false;
                                        signInputDoubleCheck = false;
                                    }
                                } else {
                                    signInputPwdShowBox.innerHTML = "必須含有英數字";
                                    signPassword = false;
                                    signInputDoubleCheck = false;
                                }
                            }
                        }
                    }

                    var signCheckPwd = document.getElementById("signCheckPwd"),
                        signCheckShowBox = document.getElementById("signCheckShowBox");

                    input3.addEventListener('input', CheckDoublePassword);

                    function CheckDoublePassword() {
                        if (signCheckPwd.value == "") {
                            signCheckShowBox.innerHTML = "請再次輸入密碼";
                        }
                        if (signCheckPwd.value == "") {
                            signCheckShowBox.innerHTML = "不可空白";
                        } else {
                            if (signCheckPwd.value.length < 8) {
                                signCheckShowBox.innerHTML = "至少要8字元";
                            } else {
                                var a = /[0-9]/;
                                var b = a.test(signCheckPwd.value);
                                if (b == true) {
                                    var c = /[a-z]/i;
                                    var b = c.test(signCheckPwd.value);
                                    if (b == true) {
                                        if (signCheckPwd.value == signInputPwd.value && signInputDoubleCheck == true) {
                                            signCheckShowBox.innerHTML = "";
                                        } else {
                                            signCheckShowBox.innerHTML = "請輸入相同密碼";
                                        }
                                    } else {
                                        signCheckShowBox.innerHTML = "必須含有英數字";
                                    }
                                } else {
                                    signCheckShowBox.innerHTML = "必須含有英數字";
                                }
                            }
                        }
                    }
                    var doubleLock = false;

                    function CheckAgain() {
                        if (signInputPwd.value == signCheckPwd.value) {
                            doubleLock = true;
                        } else {
                            doubleLock = false;
                        }
                    }
                    input2.addEventListener('input', CheckAgain);
                    input3.addEventListener('input', CheckAgain);


                    function Lock() {
                        if (signAccount == true && signPassword == true && doubleLock == true) {
                            document.getElementById("signOutput").disabled = false;
                        } else {
                            document.getElementById("signOutput").disabled = true;
                        }
                        console.log("doubleLock  " + doubleLock);
                        console.log("signAccount  " + signAccount);
                        console.log("signPassword  " + signPassword);
                        console.log("signCheckPassword  " + signCheckPassword);
                    }

                    input1.addEventListener('input', Lock);
                    input2.addEventListener('input', Lock);
                    input3.addEventListener('input', Lock);

                </script>
            </div>
        </div>
    </div>
</body>
</html>