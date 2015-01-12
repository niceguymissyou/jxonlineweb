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
                
                    <li><a class="a_sk" href="/"> <span class="iconspan"></span>Trang chủ</a> </li>
                    
                    <li><a target="_blank" class="a_sk" href="<%=request.getContextPath()%>"> <span class="iconspan"></span>Diễn đàn</a> </li>
                    
                    <li><a  class="a_sk" href="<%=request.getContextPath()%>/admin.htm"> <span class="iconspan"></span>Đăng bài</a> </li>
                    
                    <li><a class="a_sk" href="<%=request.getContextPath()%>/admin/postmanage.htm?post_type=1"> <span class="iconspan"></span>Quản lí bài đăng</a> </li>
                
                    <li><a class="a_sk" href="/"> <span class="iconspan"></span>Quản lí User</a> </li>
                    
                    
                    
                
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
                </div>>        
            </div>
        </div>
    </div>
</div>
