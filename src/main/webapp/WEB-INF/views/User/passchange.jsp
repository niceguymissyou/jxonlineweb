<%-- 
    Document   : index
    Created on : Jan 16, 2015, 11:37:36 PM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

    <!-- Mirrored from ids.vohiep.com/users/log   in by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 31 Dec 2014 07:21:48 GMT -->
    <!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
            <title>Võ lâm truyền kỳ - thập đại phái</title>
            <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css" />
            <link rel="stylesheet" type="text/css" href="../assets/css/site.css" />
            <link rel="stylesheet" type="text/css" href="../assets/css/responsive.css" />
            <link rel="icon" type="image/png" href="../assets/images/favicon-tt.png"/>
            <script type="text/javascript" src="../assets/js/jquery-1.9.1.min.js"></script>
            <script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
            <script type="text/javascript" src="../assets/js/appsScript.js"></script>
            <script src="../js/thapthanh.js" type="text/javascript"></script>
            <script src='https://www.google.com/recaptcha/api.js?hl=vi'></script>
                <script>
                    $(document).ready(function () {
                        var posMenu = 0;
                        $('.menuMore a').click(function (e) {
                            if (posMenu == 0) {
                                e.preventDefault();
                                $('.menuSide').animate({"margin-left": '50%'}, 400);
                                $('.menuSide').css({"position": 'absolute'}, 400);
                                posMenu = 1;
                            }
                            else if (posMenu == 1) {
                                e.preventDefault();
                                $('.menuSide').animate({"margin-left": '100%'}, 200);
                                $('.menuSide').css({"position": 'fixed'}, 200);
                                posMenu = 0;
                            }
                        });
                        var showProfile = 0;
                        $('.showMore').click(function (e) {
                            if (showProfile == 0) {
                                e.preventDefault();
                                $('.profileInfo').css({"display": 'block'}, 400);
                                showProfile = 1;
                            }
                            else if (showProfile == 1) {
                                e.preventDefault();
                                $('.profileInfo').css({"display": 'none'}, 200);
                                showProfile = 0;
                            }
                        });
                        
                        //submit
                          $(".btn-signin.pull-left").click(function(){
                              
                              $(".alert").remove()
                              if($("#confirmPass").val()!= $("#newPass").val()){
                                   var str = "<div class = 'alert'>"
                                                    + "Mật khẩu phải khớp"
                                                    + "</div>"
                                        $(str).insertBefore($(".form-horizontal.signin"))
                                        $(window).scrollTop($(".wrap.one-column").offset().top);
                                    return
                              }
                              
                              $.post("/tai-khoan/doi-mat-khau-1.html",
                              {'cPassWord':$("#oldPass").val(),
                                'cNewPassWord':$("#newPass").val()
                              },function(data){
                                  if(data){
                                      data = $.parseJSON(data)
                                     
                                        $(".alert").remove()
                                        var str = "<div class = 'alert'>"
                                                    + data.result
                                                    + "</div>"
                                        $(str).insertBefore($(".form-horizontal.signin"))
                                        $(window).scrollTop($(".wrap.one-column").offset().top);
                                       $("#oldPass").val('')
                                       $("#newPass").val('')
                                       $("#confirmPass").val('')
                                       
                                  }
                              })
                          })
                    });
                </script>
                </head>
                <body>
                    <!--Start: HEADER-->
                    <header>
                        <div>
                            <div class="container">
                                <div class="wrap header">
                                    <h1 id="logo" class="pull-left">
                                        <a href="http://thapdaiphai.com/" class="logo" title="logo">
                                            <img src="../assets/images/logo.png" alt="logo">
                                        </a>
                                    </h1>
                                    <ul class="user pull-right signout">
                                        <li class="userava">
                                            <a href="/tai-khoan.html" class="group">
                                                <span class="avatar">
                                                    <img style="background:url(http://a0.ttimg.vn/15526387.ava?1421603618) center center no-repeat; background-size:cover" class="img-circle">
                                                </span>
                                                <span class="username">${user}</span>
                                                <i class="caret"></i>
                                            </a>
                                            <div class="usersetting">
                                                <ul>
                                                    <!--
                                                    <li><a href="http://thapthanh.com/nhom-cua-toi.html">Nhóm của tôi</a></li>
                                                    -->
                                                    <li><a href="/tai-khoan/doi-mat-khau.html">Đổi mật khẩu</a></li>
                           
                                                    <li><a href="/tai-khoan.html">Thông tin tài khoản</a></li>
                                                    
                                                    <!--
                                                    <li><a href="/users/message">Tin nhắn</a></li>
                                                    <li><a href="/users/friend">Bạn bè</a></li>
                                                    -->
                                                    <li><a href="/tai-khoan/dang-xuat.html">Thoát</a></li>
                                                </ul>
                                            </div>
                                        </li>
                                    </ul>
                                </div>

                                <div class="clearfix menuResponsive">
                                    <div class="menuMore">
                                        <a href="#"><span class="circle"></span><span class="circle"></span><span class="circle"></span></a>
                                    </div>
                                    <div class="menuFull">
                                        <ul class="menuHeader pull-left">
                                            <li><span style="white-space: nowrap;"><a href="http://thapdaiphai.com/">Trang chủ</a></span></li>
                                            <li><span style="white-space: nowrap;"><a href="http://thapdaiphai.com/tin-tuc-lst.html">Tin tức</a></span></li>
                                            <li><span><a href="http://thapdaiphai.com/tai-khoan/nap-the.html">Nạp thẻ</a></span></li>
                                            <li><span style="white-space: nowrap;"><a href="http://thapdaiphai.com/ho-tro-vo-lam-thap-dai-phai-post.html">Hỗ trợ</a></span></li>
                                            <li><span style="white-space: nowrap;"><a href="http://thapdaiphai.com">Diễn đàn</a></span></li>
                                        </ul>
                                    </div>
                                    <div class="menuSide">
                                        <ul class="menuHeader">
                                            <li><span style="white-space: nowrap;"><a href="http://thapdaiphai.com/">Trang chủ</a></span></li>
                                            <li><span style="white-space: nowrap;"><a href="http://thapdaiphai.com/tin-tuc-lst.html">Tin tức</a></span></li>
                                            <li><span><a href="http://thapdaiphai.com/tai-khoan/nap-the.html">Nạp thẻ</a></span></li>
                                            <li><span style="white-space: nowrap;"><a href="http://thapdaiphai.com/ho-tro-vo-lam-thap-dai-phai-post.html">Hỗ trợ</a></span></li>
                                            <li><span style="white-space: nowrap;"><a href="http://thapdaiphai.com">Diễn đàn</a></span></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </header>
                    <!--ALERT-->
                    <div class="wrapAll">
                        <!--Start: CONTENT-->
                        <div class="mainContent">
                            <script type="text/javascript">
                                $(document).ready(function () {
                                    $("#username").focus();
                                });
                            </script>

                            <div class="wrap one-column"> 
                                <h2>Cập nhật thông tin</h2>
                                <!--Start: One column-->
                                <div class="wrap-signin clearfix">
                                    <div class="account-setting-menu pull-right">
                                        <ul id="" class="nav nav-tabs">
                                            <li><a href="/tai-khoan.html">Thông tin cơ bản</a></li>
                                            <li class="active"><a href="/tai-khoan/doi-mat-khau.html">Đổi mật khẩu</a></li>
                                            
                                            
                                        </ul>
                                    </div>
                                    <div class="tab-content wrap-signin-left pull-left">
                                        <div id="passchange" class="tab-pane fade active in">
                                            <div  class="form-horizontal signin">
                                                <div class="control-group">
                                                    <label for="inputPassword" class="control-label">Mật khẩu hiện tại:</label>
                                                    <div class="controls">
                                                        <input type="password" placeholder="" name="oldPass" id="oldPass">
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label for="inputPassword" class="control-label">Mật khẩu mới:</label>
                                                    <div class="controls">
                                                        <input type="password" placeholder="" name="newPass" id="newPass">
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label for="inputPassword" class="control-label">Xác nhận MK mới:</label>
                                                    <div class="controls">
                                                        <input type="password" placeholder="" name="confirmPass" id="confirmPass">
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <div class="controls submit">
                                                        <button class="btn-signin pull-left" type="submit">Cập nhật</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!--End: One column--> 
                                </div>
</div>
                        </div>
                    </div>
                    <!--Start: Footer-->
                    <div class="footer-static clearfix">
                        <ul class="footer-menu">
                            <li class="active"><a href="http://thapdaiphai.com/">Trang chủ</a></li>
                            <li><a href="http://thapdaiphai.com/tin-tuc-lst.html">Tin tức</a></li>
                            <li><a href="http://thapdaiphai.com/tai-khoan/nap-the.html">Nạp thẻ</a></li>
                            <li><a href="http://thapdaiphai.com/ho-tro-vo-lam-thap-dai-phai-post.html">Hỗ trợ</a></li>
                            <li><a href="http://thapdaiphai.com/">Diễn đàn</a></li>
                        </ul>
                    </div>
                    <p id="back-top"><a href="#top"><span></span></a></p>
                    </div>
                    <!--End: CONTENT--> 
                </body>

  
</html>
