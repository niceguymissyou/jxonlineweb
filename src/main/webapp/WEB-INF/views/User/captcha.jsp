<%-- 
    Document   : captcha
    Created on : Jan 17, 2015, 4:36:45 PM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src='https://www.google.com/recaptcha/api.js?hl=vi'></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="/tai-khoan/validate.html" method="get">
            <div class="g-recaptcha" data-sitekey="6Ld5mwATAAAAANej65k2E_al8DuhsOkEZxaptzmx"></div>
            <input type="submit" value="submit" />
        </form>

    

    </body>
</html>
