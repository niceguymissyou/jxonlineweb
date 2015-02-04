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
             <script type="text/javascript" src="js/jquery.blockUI.js"></script>
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
                        
                        $.getJSON("/tai-khoan/thong-tin.html",{},function(data){
                            if(data){
                                $("#firstname").val(data.cRealName);
                                if(data.CSex == '1') 
                                  $("#optionsRadios1").prop( "checked", true );
                                else $("#optionsRadios2").prop( "checked", true );

                                var d = new Date(data.dBirthDay);
                                $("#birth_day").val(d.getDate())
                                $("#birth_month").val(d.getMonth() + 1)
                                $("#birth_year").val(d.getFullYear())

                                $("#phone").val(data.cPhone)

                            }

                          })
                          
                          //submit
                          $(".btn-signin.pull-left").click(function(){
                              $(".alert").remove()
                              $.post("/tai-khoan/thong-tin.html",
                              {'cRealName':$("#firstname").val(),
                                'cPhone':$("#phone").val(),
                                'CSex': $("#optionsRadios1").is(':checked')? '1': '0',
                                'dBirthDay': $("#birth_year").val() + "/" + $("#birth_month").val() + "/" + $("#birth_day").val()    
                              },function(data){
                                  if(data){
                                      data = $.parseJSON(data)
                                     
                                        $(".alert").remove()
                                        var str = "<div class = 'alert'>"
                                                    + data.result
                                                    + "</div>"
                                        $(str).insertBefore($(".form-horizontal.signin"))
                                        $(window).scrollTop($(".wrap.one-column").offset().top);
                                      
                                  }
                              })
                          })
                          
                          $(".kickacc").click(function(){
                              $.blockUI();
                              $.getJSON('/tai-khoan/kick-acc.html',function(data){
                                  if(data){
                                      if(data == true)
                                          alert("kich acc thành công!")
                                  }
                                  $.unblockUI();
                              })
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
                                            <li><span style="white-space: nowrap;"><a href="http://thapdaiphai.com/tai-khoan/nap-the.html">Nạp thẻ</a></span></li>
                                            <li><span style="white-space: nowrap;"><a href="http://thapdaiphai.com/ho-tro-vo-lam-thap-dai-phai-post.html">Hỗ trợ</a></span></li>
                                            <li><span style="white-space: nowrap;"><a href="http://thapdaiphai.com">Diễn đàn</a></span></li>
                                        </ul>
                                    </div>
                                    <div class="menuSide">
                                        <ul class="menuHeader">
                                            <li><span style="white-space: nowrap;"><a href="http://thapdaiphai.com/">Trang chủ</a></span></li>
                                            <li><span style="white-space: nowrap;"><a href="http://thapdaiphai.com/tin-tuc-lst.html">Tin tức</a></span></li>
                                            <li><span style="white-space: nowrap;"><a href="http://thapdaiphai.com/tai-khoan/nap-the.html">Nạp thẻ</a></span></li>
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
                                            <li class="active"><a href="/tai-khoan.html">Thông tin cơ bản</a></li>
                                            <li><a href="/tai-khoan/doi-mat-khau.html">Đổi mật khẩu</a></li>
                    
                                        </ul>
                                    </div>
                                    <div class="tab-content wrap-signin-left pull-left">
                                        <div id="infobasic" class="tab-pane fade active in">
                                            <div  class="form-horizontal signin">
                                                  <div class="control-group">
                                                    <div class="controls">
                                                        <button class="kickacc" >Kich acc</button>
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label for="inputEmail" class="control-label"><span class="required">*</span>Tên :</label>
                                                    <div class="controls">
                                                        <input type="text" value="" placeholder="" name="firstname" id="firstname">
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label for="inputPassword" class="control-label"><span class="required">*</span>Giới tính:</label>
                                                    <div class="controls">
                                                        <label class="checkbox inline">
                                                            <input type="radio" value="1" id="optionsRadios1" name="sex">
                                                                Nam </label>
                                                        <label class="checkbox inline">
                                                            <input type="radio" value="2" id="optionsRadios2" name="sex">
                                                                Nữ </label>
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label for="inputPassword" class="control-label"><span class="required">*</span>Ngày sinh:</label>
                                                    <div class="controls">
                                                        <select name="birth_day" class="day" id = "birth_day">
                                                            <option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option><option value="31">31</option>                                                    </select>
                                                        <select name="birth_month" class="month" id = "birth_month">
                                                            <option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option>                                                    </select>
                                                        <select name="birth_year" class="year" id = "birth_year">
                                                            <option value="2015">2015</option><option value="2014">2014</option><option value="2013">2013</option><option value="2012">2012</option><option value="2011">2011</option><option value="2010">2010</option><option value="2009">2009</option><option value="2008">2008</option><option value="2007">2007</option><option value="2006">2006</option><option value="2005">2005</option><option value="2004">2004</option><option value="2003">2003</option><option value="2002">2002</option><option value="2001">2001</option><option value="2000">2000</option><option value="1999">1999</option><option value="1998">1998</option><option value="1997">1997</option><option value="1996">1996</option><option value="1995">1995</option><option value="1994">1994</option><option value="1993">1993</option><option value="1992">1992</option><option value="1991">1991</option><option value="1990">1990</option><option value="1989">1989</option><option value="1988">1988</option><option value="1987">1987</option><option value="1986">1986</option><option value="1985">1985</option><option value="1984">1984</option><option value="1983">1983</option><option value="1982">1982</option><option value="1981">1981</option><option value="1980">1980</option><option value="1979">1979</option><option value="1978">1978</option><option value="1977">1977</option><option value="1976">1976</option><option value="1975">1975</option><option value="1974">1974</option><option value="1973">1973</option><option value="1972">1972</option><option value="1971">1971</option><option value="1970">1970</option><option value="1969">1969</option><option value="1968">1968</option><option value="1967">1967</option><option value="1966">1966</option><option value="1965">1965</option><option value="1964">1964</option><option value="1963">1963</option><option value="1962">1962</option><option value="1961">1961</option><option value="1960">1960</option><option value="1959">1959</option><option value="1958">1958</option><option value="1957">1957</option><option value="1956">1956</option><option value="1955">1955</option><option value="1954">1954</option><option value="1953">1953</option><option value="1952">1952</option><option value="1951">1951</option><option value="1950">1950</option><option value="1949">1949</option><option value="1948">1948</option><option value="1947">1947</option><option value="1946">1946</option><option value="1945">1945</option><option value="1944">1944</option><option value="1943">1943</option><option value="1942">1942</option><option value="1941">1941</option><option value="1940">1940</option><option value="1939">1939</option><option value="1938">1938</option><option value="1937">1937</option><option value="1936">1936</option><option value="1935">1935</option><option value="1934">1934</option><option value="1933">1933</option><option value="1932">1932</option><option value="1931">1931</option><option value="1930">1930</option><option value="1929">1929</option><option value="1928">1928</option><option value="1927">1927</option><option value="1926">1926</option><option value="1925">1925</option><option value="1924">1924</option><option value="1923">1923</option><option value="1922">1922</option><option value="1921">1921</option><option value="1920">1920</option><option value="1919">1919</option><option value="1918">1918</option><option value="1917">1917</option><option value="1916">1916</option><option value="1915">1915</option><option value="1914">1914</option><option value="1913">1913</option><option value="1912">1912</option><option value="1911">1911</option><option value="1910">1910</option><option value="1909">1909</option><option value="1908">1908</option><option value="1907">1907</option><option value="1906">1906</option><option value="1905">1905</option><option value="1904">1904</option><option value="1903">1903</option><option value="1902">1902</option><option value="1901">1901</option>                                                    </select>
                                                    </div>
                                                </div>
                                                <div class="control-group">
                                                    <label for="inputEmail" class="control-label">Số điện thoại:</label>
                                                    <div class="controls">
                                                        <input type="text" value="" placeholder="" name="phone" id="phone">
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
