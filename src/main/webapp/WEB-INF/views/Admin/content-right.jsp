<%-- 
    Document   : content-right
    Created on : Jun 25, 2014, 3:00:38 AM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="warpright warprightcon">
    <div class="boxwarpright">
        <div class="boxwarpcon_top"></div>
        <div class="boxwarp_md">
            <div class="boxwarp_md_leftcon">
                <div class="boxwarp_md_rightcon">
            
                    <div style="width:97%; padding:5px 0;" class="warpboxcon">
                        <div class="box_titel">
                            <h1 class="titel_h1">Đăng bài</h1>
                            <div class="line_titel">
                                <a href="/">Trang chủ</a><span>/</span>
                                <a href="/admin.htm">Admin</a>
                            </div>
                            <div style="clear:both"></div>
                        </div>

                        <div class="boxsubcontent">


                            <!-- text_conten-->
                            <div class = "box_textcon">
                                 <jsp:include page="post.jsp"/>   
                            </div>
                            <!--end text conten-->
                            <!--tin tuc khac-->
                            <div style="border-bottom:none;" class="line_pop linenews">
                                <span class="spantext_tin">Tin đã đăng</span>
                            </div>

                            <div class="news_ul">
                                 <c:forEach items="${lstpost}" var="post">
                                    <div class="div_tin">
                                        <a href="/${post.getPost_link()}-post.htm">
                                             <c:out value="${post.getPost_subject()}" escapeXml="false" />
                                        </a>
                                        <span>[ <fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss "  value="${post.getPost_time()}" /> ]</span>
                                        <div style="clear:both"></div>
                                    </div>
                                 </c:forEach>           
                              
                                <div style="clear:both"></div>
                            </div>
                            <!--end tin tuc khac-->
                        </div>
                        <span class="bgboxright_top_left"></span>
                        <span style="top:-11px; right:-16px;" class="bgboxright_top_right"></span>
                        <div style="clear:both"></div>
                    </div>
            
                </div>
            
            </div>
            <div class="boxwarpcon_bt"></div>
        </div>
    </div>
    <!--end warpbox_right-->
</div>