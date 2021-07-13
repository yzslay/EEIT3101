<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
System.out.println(basePath);%> 
    
    
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Website</title>
    <!--stylesheet-->
    <link rel="stylesheet" type="text/css" href="${basePath}css/Member/style.css">
    <!--light-slider-css-->
    <link rel="stylesheet" type="text/css" href="${basePath}css/Member/lightslider.css">
    <!--jQuery-------->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
			integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
			crossorigin="anonymous"></script>
    <!--light-slider-js-->
    <script src="${basePath}js/Member/lightslider.js"></script>

    <!--fav-icon------------------->
    <link rel="shortcut icon" href="${basePath}images/Member/fav-icon.ico" />
    <!--using-FontAwesome-for-Icons-->
    <script src="https://kit.fontawesome.com/c8e4d183c2.js" crossorigin="anonymous"></script>
</head>
<body>
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
                <img src="${basePath}images/Member/PetPetLogo.png" />
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
            <form method="post" action="newCheckMemberData.controller">
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

    <!--Feature-Categories-------------------------------->
    <div class="feature-heading">
        <h2>精選推薦</h2>
    </div>

    <ul id="autoWidth" class="cs-hidden">
        <!----1------------------------------------>
        <li class="item">
            <!--feature-box-->
        <div class="feature-box">
        <a href="#">
            <img src="${basePath}images/Member/feature_1.jpg">
        </a>
        </div>
        <!--text---------------------------->
        <span>T-shirt</span>
        </li>

        <!----2------------------------------------>
        <li class="item">
            <!--feature-box-->
        <div class="feature-box">
        <a href="#">
            <img src="${basePath}images/Member/feature_2.jpg">
        </a>
        </div>
        <!--text---------------------------->
        <span>T-shirt</span>
        </li>

        <!----3------------------------------------>
        <li class="item">
            <!--feature-box-->
        <div class="feature-box">
        <a href="#">
            <img src="${basePath}images/Member/feature_3.jpg">
        </a>
        </div>
        <!--text---------------------------->
        <span>T-shirt</span>
        </li>

        <!----4------------------------------------>
        <li class="item">
            <!--feature-box-->
        <div class="feature-box">
        <a href="#">
            <img src="${basePath}images/Member/feature_4.jpg">
        </a>
        </div>
        <!--text---------------------------->
        <span>T-shirt</span>
        </li>

        <!----5------------------------------------>
        <li class="item">
            <!--feature-box-->
        <div class="feature-box">
        <a href="#">
            <img src="${basePath}images/Member/feature_5.jpg">
        </a>
        </div>
        <!--text---------------------------->
        <span>T-shirt</span>
        </li>

        <!----6------------------------------------>
        <li class="item">
            <!--feature-box-->
        <div class="feature-box">
        <a href="#">
            <img src="${basePath}images/Member/feature_6.jpg">
        </a>
        </div>
        <!--text---------------------------->
        <span>T-shirt</span>
        </li>

    </ul>

    <!--new-arrival------------------->
    <section class="new-arrival">
        <!--heading------->
        <div class="arrival-heading">
            <strong>新品上架</strong>
            <p>我們總能提供給您 最安心 最實惠的 毛小孩用品</p>
        </div>
        <!--product-container----------------->
        <div class="product-container">
            <!--product-box-1-->
            <div class="product-box">
                <!--img---->
                <div class="product-img">
                    <!--add-cart----------->
                <a href="#" class="add-cart">
                    <i class="fas fa-shopping-cart"></i>
                </a>
                    <img src="${basePath}images/Member/p-1.jpg"/>
                </div>

                <!--details-->
                <div class="product-details">
                    <a href="#" class="p-name">Drawstring T-shirt</a>
                    <span class="p-price">$22.00</span>
                </div>

            </div>

            <!--product-box-2-->
            <div class="product-box">
                <!--img---->
                <div class="product-img">
                    <!--add-cart----------->
                <a href="#" class="add-cart">
                    <i class="fas fa-shopping-cart"></i>
                </a>
                    <img src="${basePath}images/Member/p-2.jpg"/>
                </div>

                <!--details-->
                <div class="product-details">
                    <a href="#" class="p-name">Drawstring T-shirt</a>
                    <span class="p-price">$22.00</span>
                </div>
                
            </div>

            <!--product-box-3-->
            <div class="product-box">
                <!--img---->
                <div class="product-img">
                    <!--add-cart----------->
                <a href="#" class="add-cart">
                    <i class="fas fa-shopping-cart"></i>
                </a>
                    <img src="${basePath}images/Member/p-3.jpg"/>
                </div>

                <!--details-->
                <div class="product-details">
                    <a href="#" class="p-name">Drawstring T-shirt</a>
                    <span class="p-price">$22.00</span>
                </div>
                
            </div>

            <!--product-box-4-->
            <div class="product-box">
                <!--img---->
                <div class="product-img">
                    <!--add-cart----------->
                <a href="#" class="add-cart">
                    <i class="fas fa-shopping-cart"></i>
                </a>
                    <img src="${basePath}images/Member/p-4.jpg"/>
                </div>

                <!--details-->
                <div class="product-details">
                    <a href="#" class="p-name">Drawstring T-shirt</a>
                    <span class="p-price">$22.00</span>
                </div>
                
            </div>

            <!--product-box-5-->
            <div class="product-box">
                <!--img---->
                <div class="product-img">
                    <!--add-cart----------->
                <a href="#" class="add-cart">
                    <i class="fas fa-shopping-cart"></i>
                </a>
                    <img src="${basePath}images/Member/p-5.jpg"/>
                </div>

                <!--details-->
                <div class="product-details">
                    <a href="#" class="p-name">Drawstring T-shirt</a>
                    <span class="p-price">$22.00</span>
                </div>
                
            </div>

            <!--product-box-6-->
            <div class="product-box">
                <!--img---->
                <div class="product-img">
                    <!--add-cart----------->
                <a href="#" class="add-cart">
                    <i class="fas fa-shopping-cart"></i>
                </a>
                    <img src="${basePath}images/Member/p-6.jpg"/>
                </div>

                <!--details-->
                <div class="product-details">
                    <a href="#" class="p-name">Drawstring T-shirt</a>
                    <span class="p-price">$22.00</span>
                </div>
                
            </div>

            <!--product-box-7-->
            <div class="product-box">
                <!--img---->
                <div class="product-img">
                    <!--add-cart----------->
                <a href="#" class="add-cart">
                    <i class="fas fa-shopping-cart"></i>
                </a>
                    <img src="${basePath}images/Member/p-7.jpg"/>
                </div>

                <!--details-->
                <div class="product-details">
                    <a href="#" class="p-name">Drawstring T-shirt</a>
                    <span class="p-price">$22.00</span>
                </div>
                
            </div>

            <!--product-box-8-->
            <div class="product-box">
                <!--img---->
                <div class="product-img">
                    <!--add-cart----------->
                <a href="#" class="add-cart">
                    <i class="fas fa-shopping-cart"></i>
                </a>
                    <img src="${basePath}images/Member/p-8.jpg"/>
                </div>

                <!--details-->
                <div class="product-details">
                    <a href="#" class="p-name">Drawstring T-shirt</a>
                    <span class="p-price">$22.00</span>
                </div>
                
            </div>

            <!--product-box-9-->
            <div class="product-box">
                <!--img---->
                <div class="product-img">
                    <!--add-cart----------->
                <a href="#" class="add-cart">
                    <i class="fas fa-shopping-cart"></i>
                </a>
                    <img src="${basePath}images/Member/p-8.jpg"/>
                </div>

                <!--details-->
                <div class="product-details">
                    <a href="#" class="p-name">Drawstring T-shirt</a>
                    <span class="p-price">$22.00</span>
                </div>
                
            </div>

            <!--product-box-10-->
            <div class="product-box">
                <!--img---->
                <div class="product-img">
                    <!--add-cart----------->
                <a href="#" class="add-cart">
                    <i class="fas fa-shopping-cart"></i>
                </a>
                    <img src="${basePath}images/Member/p-8.jpg"/>
                </div>

                <!--details-->
                <div class="product-details">
                    <a href="#" class="p-name">Drawstring T-shirt</a>
                    <span class="p-price">$22.00</span>
                </div>
                
            </div>

        </div>

    </section>

    <!---sale------------------------------------>
    <section class="sale">
        <!--sale-box-1-------------------->
        <div class="sale-box sale-1">
            <img src="${basePath}images/Member/sale-1.jpg">
            
            <a href="#">
            <div class="sale-text">
              <strong>Bag with rose pattern</strong>
              <span>Sale off 25%</span>
            </div></a>
        
          </div>
           <!--sale-box-2-------------------->
        <div class="sale-box sale-1">
          <img src="${basePath}images/Member/sale-2.jpg">
          
          <a href="#"><div class="sale-text">
            <strong>Hello Summer</strong>
            <span>Sale off 20%</span>
          </div></a>
      
        </div>
         <!--sale-box-3-------------------->
         <div class="sale-box sale-1">
          <img src="${basePath}images/Member/sale-3.jpg">
          
          <a href="#">
          <div class="sale-text">
            <strong>Let's Party Hard Pillow</strong>
            <span>Sale off 25%</span>
          </div></a>
      
        </div>
     
    </section>

    <!--new-arrival------------------->
    <section class="new-arrival">
        <!--heading------->
        <div class="arrival-heading">
            <strong>必購好物</strong>
            <p>還在等什麼？ 趕快帶回家給自己的毛主子吧！</p>
        </div>
        <!--product-container----------------->
        <div class="product-container">
            <!--product-box-1-->
            <div class="product-box">
                <!--img---->
                <div class="product-img">
                    <!--add-cart----------->
                <a href="#" class="add-cart">
                    <i class="fas fa-shopping-cart"></i>
                </a>
                    <img src="${basePath}images/Member/p-1.jpg"/>
                </div>

                <!--details-->
                <div class="product-details">
                    <a href="#" class="p-name">Drawstring T-shirt</a>
                    <span class="p-price">$22.00</span>
                </div>

            </div>

            <!--product-box-2-->
            <div class="product-box">
                <!--img---->
                <div class="product-img">
                    <!--add-cart----------->
                <a href="#" class="add-cart">
                    <i class="fas fa-shopping-cart"></i>
                </a>
                    <img src="${basePath}images/Member/p-2.jpg"/>
                </div>

                <!--details-->
                <div class="product-details">
                    <a href="#" class="p-name">Drawstring T-shirt</a>
                    <span class="p-price">$22.00</span>
                </div>
                
            </div>

            <!--product-box-3-->
            <div class="product-box">
                <!--img---->
                <div class="product-img">
                    <!--add-cart----------->
                <a href="#" class="add-cart">
                    <i class="fas fa-shopping-cart"></i>
                </a>
                    <img src="${basePath}images/Member/p-3.jpg"/>
                </div>

                <!--details-->
                <div class="product-details">
                    <a href="#" class="p-name">Drawstring T-shirt</a>
                    <span class="p-price">$22.00</span>
                </div>
                
            </div>

            <!--product-box-4-->
            <div class="product-box">
                <!--img---->
                <div class="product-img">
                    <!--add-cart----------->
                <a href="#" class="add-cart">
                    <i class="fas fa-shopping-cart"></i>
                </a>
                    <img src="${basePath}images/Member/p-4.jpg"/>
                </div>

                <!--details-->
                <div class="product-details">
                    <a href="#" class="p-name">Drawstring T-shirt</a>
                    <span class="p-price">$22.00</span>
                </div>
                
            </div>
</div>
</section>

    <!--banner-------------------------------------->

    <!--box---------------->
    <div class="banner-box f-slide-1">
        <!--slider-text-container----------->
        <div class="banner-text-container">

            <div class="banner-text">
                <span>Limited offer</span>
                <strong>30% off<br /> with <Font>promo code</Font></strong>
                <a href="#" class="banner-btn">Shop Now</a>
            </div>

        </div>
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