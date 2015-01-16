<%-- 
    Document   : content-left
    Created on : Jun 25, 2014, 3:00:21 AM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="warpleft warpleftcon">
    <div class="boxmenuleft">

        <div class="warpmenuleft">
            <ul id="sidenav">
                <li style="border-top:none;"></li>
                
                    <li><a  href="/"> <span class="iconspan"></span>Trang chủ</a> </li>
                
                    <li>
                        <a class="a_sk" href="<%=request.getContextPath()%>/tin-tuc-list.htm"> 
                            <span class="iconspan"></span>
                            Tin tức
                        </a> 
                    </li>
                
                    <li><a class="a_sk" href="<%=request.getContextPath()%>/su-kien-list.htm"> <span class="iconspan"></span>Sự kiện</a> </li>
                
                    <li><a class="a_sk" href="<%=request.getContextPath()%>/cam-nang-list.htm"> <span class="iconspan"></span>Cẩm nang</a> </li>
                
                    <li><a class="a_sk" href="<%=request.getContextPath()%>/tinh-nang-list.htm"> <span class="iconspan"></span>Tính năng</a> </li>
                
                    <li><a target="_blank" class="a_sk" href="/"> <span class="iconspan"></span>Diễn đàn</a> </li>
                
        </ul></div>
    </div>
    <div class="boxmenuleft_bt">
        <div class="boxslide_sub">
            <div class="boxslide_subcon">
                <div class="flexslider">
                    <ul class="slides">
                          <c:forEach items="${lstSlide}" var="slide">
                                                <li style="width: 100%; float: left; margin-right: -100%; display: none;">
                                                    <a href="<c:out value="${slide.getSlide_link()}"/>" target="_blank">
                                                        <img width="243" height="187" src="/images/slide/<c:out value="${slide.getSlide_img()}"/>">
                                                    </a> 
                                                </li>
                            </c:forEach>
                    </ul>
                   <ol class="flex-control-nav">
                                           
                    </ol>
                   
                </div>
            </div>
        </div>
    </div>
</div>
