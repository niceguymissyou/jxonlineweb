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
        <div class="boxwarp_md"><div class="boxwarp_md_leftcon"><div class="boxwarp_md_rightcon">
            
            <div style="width:97%; padding:5px 0;" class="warpboxcon">
                <div class="box_titel">
                    <h1 class="titel_h1">${post.getPost_subject()}</h1>
                    <div class="line_titel">
                        <a href="<%=request.getContextPath()%>">Trang chủ</a>
                       
                    </div>
                    <div style="clear:both"></div>
                </div>

                <div class="boxsubcontent">
                    <div class="line_contentext">
                        <!--<h1 class="contenh1">Liên Đấu</h1>-->
                        <span> <fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss "  value="${post.getPost_time()}" /> </span>
                    </div>
                    
                    <!-- text_conten-->
                     <div class = "box_textcon">
                         ${post.getPost_text()}  
                     </div>
                    <!--end text conten-->
                    <!--tin tuc khac-->
                    <div style="border-bottom:none;" class="line_pop linenews">
                        <span class="spantext_tin">Tin đã đăng</span>
                    </div>

                                 <c:forEach items="${lstpost}" var="post">
                                    <div class="div_tin">
                                        <a href="<%=request.getContextPath()%>/${post.getPost_link()}-post.htm">
                                             <c:out value="${post.getPost_subject()}" escapeXml="false" />
                                        </a>
                                        <span>[ <fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss "  value="${post.getPost_time()}" /> ]</span>
                                        <div style="clear:both"></div>
                                    </div>
                                 </c:forEach>    
                    <!--end tin tuc khac-->
                </div>
                <span class="bgboxright_top_left"></span>
                <span style="top:-11px; right:-16px;" class="bgboxright_top_right"></span>
                <div style="clear:both"></div>
            </div>
            
        </div></div>
            <div class="boxwarpcon_bt"></div>
        </div>
    </div>
    <!--end warpbox_right-->
</div>