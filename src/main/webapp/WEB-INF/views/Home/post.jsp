<%-- 
    Document   : post
    Created on : Jan 20, 2015, 6:44:54 PM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <jsp:include page="header.jsp"/>   
  <div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&appId=766982643351181&version=v2.0";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
</script>
        <div class = "ct-mr"></div>
        <script>
             $(document).ready(function () {
               $.fn.PostDetail("${url}")  
             })
        </script>
  <jsp:include page="footer.jsp"/>    
