<%-- 
    Document   : header
    Created on : Jun 23, 2014, 1:42:08 AM
    Author     : VuNguyen
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="warpbodytop">
    <div class="topmenu">
        <ul id="nav">
                <li class="limenu">
                    <a class="a_home" href="/"></a>
                </li>
                <li class="limenu">
                    <a class="a_news" href="<%=request.getContextPath()%>/tin-tuc-list.htm"></a>
                </li>
                <li class="limenu"><a class="a_sk" href="<%=request.getContextPath()%>/su-kien-list.htm"></a>
                </li>            
                <li class="limenu"><a class="a_camnang" href="<%=request.getContextPath()%>/cam-nang-list.htm"></a>
                </li>                
                <li class="limenu"><a class="a_help" href="<%=request.getContextPath()%>/home/post.htm?post_link=hotrotructuyen"></a>
                </li>
                <li class="limenu">
                    <a class="a_panpage" target="_blank" href="/"></a>
                </li>
        </ul>
    </div>
</div>
