<%-- 
    Document   : index
    Created on : Jun 2, 2014, 12:09:25 PM
    Author     : VuNguyen
--%>

<%@page pageEncoding="UTF-8" contentType="text/html;" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
   <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8 "/>
  
    <title>Võ Lâm Kỳ Hiệp</title>
    <link rel="icon" type="image/ico" href="<%=request.getContextPath()%>/images/favicon.ico"/>
    <link href="<%=request.getContextPath()%>/css/A.style_main.css,qr=3.pagespeed.cf.aGKgvFOnCO.css" rel="stylesheet" type="text/css"/>
    <style>.flex-container a:active,.flexslider a:active{outline:none}.slides,.flex-control-nav,.flex-direction-nav{margin:0;padding:0;list-style:none}.flexslider{width:243px;margin:0px 0 0 4px;padding:0px 0 0 0;height:187px;overflow:hidden}.flexslider .slides>li{display:none}.flexslider .slides img{width:243px;height:187px;display:block}.flex-pauseplay span{text-transform:capitalize}.slides:after{content:".";display:block;clear:both;visibility:hidden;line-height:0;height:0}html[xmlns] .slides{display:block}* html .slides{height:1%}.no-js .slides>li:first-child{display:block}.flexslider{position:relative;padding:1px 0px 0px 1px}.flexslider .slides{}.flexslider .slides>li{position:relative}.flex-container{zoom:1;position:relative}.flex-control-nav{width:100%;position:absolute;bottom:5px;text-align:right;right:10px}.flex-control-nav li{margin:0 0 0 5px;display:inline-block;zoom:1;*display: inline}.flex-control-nav li:first-child{margin:0}.flex-control-nav li a{width:16px;height:16px;display:block;background:url(http://static1.hoiucmotthoi.com/static/images/images/iconweb.png.pagespeed.ce.WMxVbwLIVZ.png) no-repeat -2px -58px;cursor:pointer;text-indent:0px;position:relative;text-align:center;color:#fff;font-size:11px;font-weight:bold;line-height:16px}.flex-control-nav li a:hover,.flex-control-nav li a.active{background:url(http://static1.hoiucmotthoi.com/static/images/images/iconweb.png.pagespeed.ce.WMxVbwLIVZ.png) no-repeat -2px -36px}.warp_laucher .flexslider{margin:0px 0 0 0px}</style>
    <link href="<%=request.getContextPath()%>/css/A.style_subsite.css,qr=3.pagespeed.cf.Fq9vGczDgX.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/css/A.style_content.css,qr=3.pagespeed.cf.1XYrkvK--b.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/A.style_menu.css.pagespeed.cf.tTV-E9F-w9.css"/>
    <link href="<%=request.getContextPath()%>/css/A.style_menuleft_conten.css.pagespeed.cf.DnqEIPcbIZ.css" rel="stylesheet" type="text/css"/>
    
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/mainsite.js.pagespeed.jm.6Z3MVPThTk.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/dtq-subpage.js"></script>
    <script type="text/javascript" charset="utf-8">$(document).ready(function(){$("#nav li").hover(function(){$(this).find('ul:first').css({visibility:"visible",display:"none"}).show(400);},function(){$(this).find('ul:first').css({visibility:"hidden"});});});</script>
    <script src="<%=request.getContextPath()%>/js/jquery.flexslider-min.js.pagespeed.jm.J0Amlx6KVj.js"></script>
    <script type="text/javascript">$(window).load(function(){$('.flexslider').flexslider();});</script>
</head>

    <body >
        <div id = "bodysub">
        <jsp:include page="header.jsp"/>  
        <jsp:include page="content.jsp"/>  
        <jsp:include page="footer.jsp"/> 
       </div>
        
    </body>
</html>
