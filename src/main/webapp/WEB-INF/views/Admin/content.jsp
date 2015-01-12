<%-- 
    Document   : content
    Created on : Jun 23, 2014, 1:42:30 AM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>    
<div style="margin: 58px auto 0  auto; position:relative" id="warpbody_md">
      <div class="box_play">
        <a class="a_play" href="/Huong-dan-tai-game-post.htm">
            <img onmouseout="this.src='<%=request.getContextPath()%>/images/a_play.jpg'" onmouseover="this.src='<%=request.getContextPath()%>/images/a_playhover.png'" src="<%=request.getContextPath()%>/images/a_play.jpg">
        </a>
        <div class="boxnt_help">
            <a class="bt_napthe " href="<%=request.getContextPath()%>/tai-khoan.htm"></a>
            <!-- napthe_active-->
            <a class="bt_help " href="<%=request.getContextPath()%>/tai-khoan/nap-the.htm"></a>
            <!--help_active-->
        </div>
        <div style="clear:both"></div>
    </div>
    <div class="boxwarp_content" style="margin:-15px 0 0 0; ">
        <jsp:include page="content-left.jsp"/>              
        <jsp:include page="${page}"/>
     </div>         
   
    <div style="clear:both"></div>
</div>


