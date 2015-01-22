<%-- 
    Document   : header
    Created on : Jan 21, 2015, 4:49:59 PM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <script type="text/javascript" src="../assets/js/jquery.blockUI.js"></script>
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