<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
System.out.println(basePath);%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Website</title>
    <!--stylesheet-->
    <link rel="stylesheet" type="text/css" href="${basePath}/EEIT3101/css/Member/style.css">
    <!--light-slider-css-->
    <link rel="stylesheet" type="text/css" href="${basePath}/EEIT3101/css/Member/lightslider.css">
    <!--jQuery-------->
    <!-- <script src="${basePath}/EEIT3101/js/Member/jQuery.js"></script> -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
			integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
			crossorigin="anonymous"></script>
    <!--light-slider-js-->
    <script src="${basePath}/EEIT3101/js/Member/lightslider.js"></script>

    <!--fav-icon------------------->
    <link rel="shortcut icon" href="${basePath}/EEIT3101/images/Member/fav-icon.ico" />
    <!--using-FontAwesome-for-Icons-->
    <script src="https://kit.fontawesome.com/c8e4d183c2.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>

    <style>
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
        .last{
                margin-bottom: 100px;
            }
        .center{
                margin: auto;
            }
    </style>
</head>

<body id="third" class="back" background="image/Back.jpg">

<!--navigation-------------------------------->
    <nav>
        <!--social-link-and-phont-number-->
        <div class="social-call">
            <!--social-links-->
            <div class="social">
                <a href="#"><i class="fab fa-facebook-f"></i></a>
                <a href="#"><i class="fab fa-twitter"></i></a>
                <a href="#"><i class="fab fa-youtube"></i></a>
                <a href="#"><i class="fab fa-instagram"></i></a>
            </div>
            <!--phone-number-->
            <div class="phone">
                <span>Call +123456789</span>
            </div>
        </div>

        <!--menu-bar-------------------------------------->
        <div class="navigation">
            <!--logo---------->
            <a href="#" class="logo">
                <img src="${basePath}/EEIT3101/images/PetPetLogo.png" />
            </a>
            <!--menu-icon---------------------->
            <div class="toggle"></div>

            <!--menu----------->
            <ul class="menu">
                <li><a href="#">最新消息</a></li>

                <li><a href="#">商品總覽</a>
                    <!--sale-label-->
                    <span class="sale-lable">Sale</span>
                </li>

                <li><a href="#">寵愛認養</a></li>
                <li><a href="#">毛寵大小事</a></li>
                <li><a href="#">會員中心</a></li>
            </ul>
            <!--right-menu------->
            <div class="right-menu">
                <!--search-->
                <a href="javascript:void(0);" class="search">
                    <i class="fas fa-search"></i>
                </a>
                <!--user-->
                <a href="javascript:void(0);" class="user">
                    <i class="fas fa-user"></i>
                </a>
                <!--cart-icon-->
                <a href="#">
                    <i class="fas fa-shopping-cart">
                        <!--number-of-product-in-cart-->
                        <span class="num-cart-product">0</span>
                    </i>
                </a>
            </div>
        </div>
    </nav>
    <!--search-bar------------------------------->
    <div class="search-bar">
        <!--search-input-------->
        <div class="search-input">
            <!--input----->
            <input type="text" placeholder="Search For Product" />
            <!--cancel-btn-->
            <a href="javascript:void(0);" class="search-cancel">
                <i class="fas fa-times"></i>
            </a>
        </div>
    </div>

    <!--login-and-sign-up-form--------------------->
    <div class="form">
        <!--login-------------------->
        <div class="login-form">
            <!--cancel-btn--------->
            <a href="javascript:void(0);" class="form-cancel">
                <i class="fas fa-times"></i>
            </a>

            <!--heading---->
            <strong>會員登入</strong>
            <!--inputs-->
            <form>
                <input type="email" placeholder="Example@gmail.com" name="email" required>
                <input type="password" placeholder="Password" name="password" required>
                <!--submit-btn-->
                <input type="submit" value="Log In">
            </form>
            <!--forget-and-sign-up-btn-->
            <div class="form-btns">
                <a href="#" class="forget">忘記密碼？</a>
                <a href="javascript:void(0);" class="sign-up-btn">建立帳戶</a>
            </div>

        </div>


        <!--Sign-up-------------------->
        <div class="sign-up-form">
            <!--cancel-btn--------->
            <a href="javascript:void(0);" class="form-cancel">
                <i class="fas fa-times"></i>
            </a>

            <!--heading---->
            <strong>建立帳戶</strong>
            <!--inputs-->
            <form>
                <input type="email" placeholder="Example@gmail.com" name="email" required>
                <input type="password" placeholder="Password" name="password" required>
                <input type="password" placeholder="Confirm Password" name="password" required>
                <!--submit-btn-->
                <input type="submit" value="Sign Up">
            </form>
            <!--forget-and-sign-up-btn-->
            <div class="form-btns">
                <a href="javascript:void(0);" class="already-acount">已經是會員？</a>
            </div>

        </div>

    </div>


    <div id="second" class="container outSide">
        <jsp:useBean id="member" scope="request" class="com.petpet.bean.LoginBean" />
        <h1>帳戶資料修改</h1>
        <form method="post" action="newUpdateData.controller">
            <div><br>
                <h4 class="MemberNum">您的會員編號：
                    <input class="MemberNum MemberNumInput" readonly type="text" id="memberid" name="memberid" 
                    value="${member.memberid}">
                </h4>
            </div>

            <div class="input-group input-group-lg div">
                <span class="input-group-text ">姓名</span>
                <input type="text" class="form-control" placeholder="姓" id="firstName" name="firstname" value="${member.firstname}" autocomplete="off">
                <input type="text" class="form-control" placeholder="名" id="lastName" name="lastname" value="${member.lastname}" autocomplete="off">
            </div>
            <div class="input-group flex-nowrap input-group-lg div">
                <span class="input-group-text">性別</span>
                <div class="btn-group">
                	<c:if test="${member!=null}">
                	<c:set var="gd" value="${member.gender}" />
                		<select id="gender">
                	<c:choose>
                		<c:when test="${member.gender==null}">
                			<option selected>請選擇</option>
                		</c:when>
                		<c:otherwise>
                			<option>請選擇</option>
                		</c:otherwise>
                	</c:choose>          		
                	<c:choose>
                		<c:when test="${member.gender=='男'}">
                			<option selected>男</option>
                		</c:when>
                		<c:otherwise>
                			<option>男</option>
                		</c:otherwise>
                	</c:choose>
                    <c:choose>
                    	<c:when test="${member.gender=='女'}">
                    		<option selected>女</option>
                    	</c:when>
                    	<c:otherwise>
                    		<option>女</option>
                    	</c:otherwise>
                    </c:choose>  
                    	</select>                      
                	</c:if>
                    <input type="hidden" id="genderInput" name="gender" value="${member.gender}">
                    <c:if test="${member==null}">
                    <select id="gender">
                        <option>請選擇</option>
                        <option>男</option>
                        <option>女</option>
                    </select>
                    </c:if>
                </div>
            </div>
            <div class="input-group flex-nowrap input-group-lg div">
                <span class="input-group-text">生日</span>
                <input id="birthday" type="date" name="birthday" value="${member.birthday}">
            </div>
            <div class="input-group flex-nowrap input-group-lg div">
                <span class="input-group-text">手機號碼</span>
                <input type="text" class="form-control" placeholder="手機號碼" id="mobil" name="mobile" value="${member.mobile}" autocomplete="off">
            </div>
            <div class="d-grid gap-2 col-6 mx-auto container">
                <button type="submit" class="btn btn-success" id="signOutput"
                    style="width:200px;height:40px;">送出</button>
            </div>
        </form>
        <div class="last"></div>
    </div>
    <!--services--------------------------------------------->
    <section class="services">
        <!--service-box-1-------------------->
        <div class="services-box">
            <i class="fas fa-shipping-fast"></i>
            <span>免運費</span>
            <p>額滿即享免運費</p>
        </div>

        <!--service-box-2-------------------->
        <div class="services-box">
            <i class="fas fa-headphones-alt"></i>
            <span>24小時客服</span>
            <p>提供即時在線服務</p>
        </div>

        <!--service-box-3-------------------->
        <div class="services-box">
            <i class="fas fa-sync"></i>
            <span>鑑賞期內 100%退款</span>
            <p>購回一周內若不滿意，享全額退款</p>
        </div>
    </section>

<!--footer--------------------------------------->
    <footer>
        <!--copyright----------------->
        <span class="copyright">
            Copyright 2021 - EEIT31全端工程師課程第7組
        </span>
        <!--subscribe--->
        <div class="subscribe">
            <form>
                <input type="email" placeholder="Example@gmail.com" required/>
                <input type="submit" value="Subscribe">
            </form>
        </div>
    </footer>

    <!--script-------->
    <script type="text/javascript">

    const choose = document.getElementById('gender');

    choose.addEventListener("input", getOption)

    function getOption() {
        var x = document.getElementById("gender")
        document.getElementById("genderInput").value = x.options[x.selectedIndex].text;
        console.log(document.getElementById("genderInput").value);
    }

        /*----For Search bar---------------------*/
        $(document).on('click', '.search', function () {
            $('.search-bar').addClass('search-bar-active')
        });

        $(document).on('click', '.search-cancel', function () {
            $('.search-bar').removeClass('search-bar-active')
        });

        /*--login-sign-up-form-----------------*/
        $(document).on('click', '.user,.already-acount', function () {
            $('.form').addClass('login-active').removeClass('sign-up-active')
        });

        $(document).on('click', '.sign-up-btn', function () {
            $('.form').addClass('sign-up-active').removeClass('login-active')
        });

        $(document).on('click', '.form-cancel', function () {
            $('.form').removeClass('login-active').removeClass('sign-up-active')
        });

        /*---full-slider-script--------------*/
        $(document).ready(function () {
            $('#adaptive').lightSlider({
                adaptiveHeight: true,
                auto: true,
                item: 1,
                slideMargin: 0,
                loop: true
            });
        });
        /*--Feature-slider--------------------*/
        $(document).ready(function() {
        $('#autoWidth').lightSlider({
        autoWidth:true,
        loop:true,
        onSliderLoad: function() {
            $('#autoWidth').removeClass('cS-hidden');
        } 
    });  
  });

  /*----for-fix-menu-when-scroll----------------------*/
  $(window).scroll(function(){
      if($(document).scrollTop() > 50){
          $('.navigation').addClass('fix-nav');
      }
      else{
        $('.navigation').removeClass('fix-nav');
      }
  })
  /*--for-responsive-menu-----------------*/
  $(document).ready(function(){
      $('.toggle').click(function(){
          $('.toggle').toggleClass('active')
          $('.navigation').toggleClass('active')
      })
  })

    </script>
</body>
</html>