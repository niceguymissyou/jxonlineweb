<%-- 
    Document   : post
    Created on : Jan 20, 2015, 6:44:54 PM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <jsp:include page="header.jsp"/>   
        <div class = "ct-mr"></div>
        <script>
             $(document).ready(function () {
               $.fn.PostDetail("${url}")  
             })
        </script>
  <jsp:include page="footer.jsp"/>    
