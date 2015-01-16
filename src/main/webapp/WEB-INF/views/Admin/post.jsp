<%-- 
    Document   : post
    Created on : Jun 25, 2014, 4:03:05 AM
    Author     : VuNguyen
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
    .text_id {
        display: block;
        margin: 0;
        width: 90%;
        font-family: sans-serif;
        font-size: 18px;
        appearance: none;
        box-shadow: none;
        border-radius: none;
        margin-bottom: 20px;
    }
    .submitbutton {
        border:2px groove #7c93ba;
        cursor:pointer; /*forces the cursor to change to a hand when the button is hovered*/
        padding: 5px 25px;
        /*give the background a gradient - see cssdemos.tupence.co.uk/gradients.htm for more info*/
        background-color:#6b6dbb; /*required for browsers that don't support gradients*/
        background: -webkit-gradient(linear, left top, left bottom, from(#88add7), to(#6b6dbb));
        background: -webkit-linear-gradient(top, #88add7, #6b6dbb);
        background: -moz-linear-gradient(top, #88add7, #6b6dbb);
        background: -o-linear-gradient(top, #88add7, #6b6dbb);
        background: linear-gradient(top, #88add7, #6b6dbb);
        /*style to the text inside the button*/
        font-family:Andika, Arial, sans-serif; /*Andkia is available at http://www.google.com/webfonts/specimen/Andika*/
        color:#fff;
        font-size:1.1em;
        letter-spacing:.1em;
        font-variant:small-caps;
        /*give the corners a small curve*/
        -webkit-border-radius: 0 15px 15px 0;
        -moz-border-radius: 0 15px 15px 0;
        border-radius: 0 15px 15px 0;
        /*add a drop shadow to the button*/
        -webkit-box-shadow: rgba(0, 0, 0, .75) 0 2px 6px;
        -moz-box-shadow: rgba(0, 0, 0, .75) 0 2px 6px;
        box-shadow: rgba(0, 0, 0, .75) 0 2px 6px;
        margin-bottom: 10px;
        margin-top: 10px;
    }
    /***NOW STYLE THE BUTTON'S HOVER AND FOCUS STATES***/
    .submitbutton:hover, .submitbutton:focus {
        color:#edebda;
        /*reduce the spread of the shadow to give a pushed effect*/
        -webkit-box-shadow: rgba(0, 0, 0, .25) 0 1px 0px;
        -moz-box-shadow: rgba(0, 0, 0, .25) 0 1px 0px;
        box-shadow: rgba(0, 0, 0, .25) 0 1px 0px;
    }
</style>
<script type="text/javascript">
    function preview()
    {
        var url = "/admin/preview.html?";
        url += "Post_text=" + document.getElementById('Post_text').value;
        url += "&Post_subject" + document.getElementById('Post_subject').value;
        window.open(url, '_blank');

    }
</script>
<form:form method="POST" action="/admin/post.html" accept-charset="UTF-8" commandName = "post">
    <span>Post link: </span>
    <br>
    <form:errors STYLE="color: #ff0000; " path="Post_link"/>
    <form:input path="Post_link" id="post_link" class = "text_id"  type="text" value = ""/>

    <span >Post subject: </span>
    <br>
    <form:errors STYLE="color: #ff0000;" path="Post_subject"/>
    <form:input path="Post_subject" id="Post_subject"  class = "text_id" type="text" value = ""/>

    <span>Post Type: </span>
    <br>
    <form:errors STYLE="color: #ff0000;" path="Post_type"/>
    <br>
    <form:radiobutton path="Post_type" id = "post_type"  value = "1" />
    <span style=" margin-right: 20px ">  Tin tức</span>
    <form:radiobutton path="Post_type" id = "post_type"  value = "2" />
    <span style=" margin-right: 20px "> Sự kiện</span>
    <form:radiobutton path="Post_type" id = "post_type"  value = "3" />
    <span style=" margin-right: 20px ">Tính năng</span>
    <form:radiobutton path="Post_type" id = "post_type"  value = "4" />
    <span style=" margin-right: 20px ">Cẩm nang</span>
    <br>
    <br>
    <span >Nội dung:</span>
    <br>   
    <form:errors STYLE="color: #ff0000;" path="Post_text"/>
    <form:textarea path ="Post_text" id = "Post_text" class = "ckeditor" value = ""></form:textarea>
        <div style="margin-top: 10px ">
        <form:checkbox path="preview" checked = "true"  value="preview"/> Preview 

        <br>
    </div>
    <input style ="margin-top: 10px" type = "submit" value="Post" class="submitbutton">

</form:form>