<%-- 
    Document   : content-right
    Created on : Jun 25, 2014, 3:00:38 AM
    Author     : VuNguyen
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/js/jquery.twbsPagination.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var sum = 10;
        $('#pagination-demo').twbsPagination({
            totalPages: sum,
            visiblePages: 7,
            // href: '?page={{number}}'
            onPageClick: function (event, page) {
                pageselect = page;
                var index = (page - 1) * 10;

                getListPost(index,${post_type});
            }
        });
    });
    function postupdown(index, updown1, type) {

        $.ajax({
            type: "get",
            url: "/admin/postupdown.html",
            cache: true,
            data: {index: index, updown: updown1, post_type: type},
            success: function (response) {
                if (response == "true") {
                    alert("done");
                }
                else
                    alert(response);



            },
            error: function () {
                alert('Error while request..');
            }
        });
    }
    function getListPost(index, type) {

        $.ajax({
            type: "get",
            url: "/getpostlist.html",
            cache: true,
            contentType: "application/json; charset=utf-8",
            data: {index: index, post_type: type},
            success: function (response) {

                var obj = JSON.parse(response);

                var s = "";
                for (i = 0; i < obj.length; i++) {
                    s += "<div class='divlist' id='" + i + "'>"
                            + "<div class='listL'>"
                            + "<a href='/" + obj[i].Post_link + "-post.html" + "'><img  src='<%=request.getContextPath()%>/images/ximg_news.jpg.pagespeed.ic.S5fbBR57vI.jpg'></a>"
                            + " </div>"
                            + " <div class='listR'>"
                            + "<div class= 'listh1'>"
                            + "<a href='/" + obj[i].Post_link + "-post.html" + "'>"
                            + "<h1 class='conten_h3'>"
                            + "<strong>"
                            + "<div style='color:#A52A2A'>"
                            + obj[i].Post_subject
                            + "</div>"
                            + "</strong>"
                            + "</h1>"
                            + "</a>"
                            + "<span>" + obj[i].Post_time + "</span>"

                            + " </div>"
                            + "<h3 class='h3head'>"
                            + obj[i].Post_subject

                            + "</h3>"
                            + "<h3 class='h3head'>"
                            + "<a style = 'margin-left: 10px' href='javascript:postupdown(" + "\"" + obj[i].Post_link + "\"" + ",\"up\"," + "\"" + obj[i].Post_type + "\"" + ")'><u>Up</u></a>"
                            + "<a style = 'margin-left: 10px' href='javascript:postupdown(" + "\"" + obj[i].Post_link + "\"" + ",\"Down\"," + "\"" + obj[i].Post_type + "\"" + ")'><u>Down</u></a>"
                            + "<a style = 'margin-left: 10px' href='javascript:postdelete(" + "\"" + obj[i].Post_link + "\"" + ")'><u>Delete</u></a>"
                            + "<a href='/admin/postedit.html?Post_link=" + obj[i].Post_link + "' style = 'margin-left: 10px'><u>Edit</u></a>"
                            + "</h3>"


                            + " </div>"
                            + "<div style='clear:both'></div>"
                            + "</div>";
                }

                $('#list_conten').html(s);
            },
            error: function () {
                alert('Error while request..');
            }
        });
    }


    function postdelete(post_link) {

        $.ajax({
            type: "get",
            url: "<%=request.getContextPath()%>/admin/postdelete.html",
            cache: true,
            data: {Post_link: post_link},
            success: function (response) {
                location.reload();

            },
            error: function () {
                alert('Error while request..');
            }
        });

    }
</script>  

<div class="warpright warprightcon">
    <div class="boxwarpright">
        <div class="boxwarpcon_top"></div>
        <div class="boxwarp_md">
            <div class="boxwarp_md_leftcon">
                <div class="boxwarp_md_rightcon">
                    <div style="width:97%; padding:5px 0;" class="warpboxcon">
                        <div class="box_titel">
                            <h1 class="titel_h1">Quản lí bài đăng</h1>
                            <div class="line_titel">
                                <a href="/admin/postmanage.html?post_type=1" ><span>Tin tức</span></a>
                                <a href="/admin/postmanage.html?post_type=2"><span>Sự kiện</span></a>
                                <a href="/admin/postmanage.html?post_type=3"><span>Tính năng</span></a>
                                <a href="/admin/postmanage.html?post_type=4"><span>Cẩm nang</span></a>
                            </div>
                            <div style="clear:both"></div>
                        </div>

                        <div class="boxsubcontent">
                            <div class="page_conten">
                                <div class="p1">
                                    <div class="p2">
                                        <div class="p3">
                                            <div class="box_text_page">

                                                <div id="pagination-demo" class="pagination">
                                                </div>
                                                <div style="clear:both"></div>
                                            </div>
                                        </div>

                                    </div>

                                </div>
                                <div style="clear:both"></div>
                            </div>

                            <div id ="list_conten" class="list_conten">

                            </div>
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