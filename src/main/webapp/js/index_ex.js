/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function ($) {
    $.fn.template = function (str, params) {
        if (str && params) {
            return str.replace(/\{([^\}]+)\}/g, function (substr, found) {
                return params[found];
            });
        }

        return str;
    };
    $.fn.LoadPostList = function(){
        //Tin tuc
        $.getJSON("./danh-sach-tin.html", {'post_type': '1'}, function (data) {
            if (data) {
                $.each(data, function(index, value){
                    if(index > 5)   return; 
                    var str = "<li>"
                        + "<a href='/tin-tuc-lst.html' class='type'>[Tin Tức]</a>"
                        + "<a href='{Post_link}'>{Post_subject}</a>"
                        + "<span class='time'>{Post_time}</span>"
                        + "</li>";
                    var news = $.fn.template(str, {
                        "Post_link": value.Post_link + "-post.html",
                        "Post_subject": value.Post_subject,
                        "Post_time": ""
                    })
                    $("#tabs-2 ul").append(news);
                   
                });
               
                
            }
        });
       
       // Su Kien
        $.getJSON("./danh-sach-tin.html", {'post_type': '2'}, function (data) {
            if (data) {
                $.each(data, function(index, value){
                    if(index > 5)   return; 
                    var str = "<li>"
                        + "<a href='/su-kien-lst.html' class='type'>[Sự Kiện]</a>"
                        + "<a  href='{Post_link}'>{Post_subject}</a>"
                        + "<span class='time'>{Post_time}</span>"
                        + "</li>";
                    var news = $.fn.template(str, {
                        "Post_link": value.Post_link + "-post.html",
                        "Post_subject": value.Post_subject,
                        "Post_time": ""
                    })
                    $("#tabs-4 ul").append(news);
                   
                });
               
                
            }
        });
        
        //Tinh nang
        $.getJSON("./danh-sach-tin.html", {'post_type': '3'}, function (data) {
            if (data) {
                $.each(data, function(index, value){
                    if(index > 5)   return; 
                    var str = "<li>"
                        + "<a href='/tinh-nang-lst.html' class='type'>[Tính Năng]</a>"
                        + "<a  href='{Post_link}'>{Post_subject}</a>"
                        + "<span class='time'>{Post_time}</span>"
                        + "</li>";
                    var news = $.fn.template(str, {
                        "Post_link": value.Post_link + "-post.html",
                        "Post_subject": value.Post_subject,
                        "Post_time": ""
                    })
                    $("#tabs-3 ul").append(news);
                   
                });
               
                
            }
        });
        
        //Cam Nang
        $.getJSON("./danh-sach-tin.html", {'post_type': '4'}, function (data) {
            if (data) {
                $.each(data, function(index, value){
                    if(index > 5)   return; 
                    var str = "<li>"
                        + "<a href='/cam-nang-lst.html' class='type'>[Cẩm Nang]</a>"
                        + "<a href='{Post_link}'>{Post_subject}</a>"
                        + "<span class='time'>{Post_time}</span>"
                        + "</li>";
                    var news = $.fn.template(str, {
                       // "Post_link": value.Post_link + "-post.html",
                        "Post_subject": value.Post_subject,
                        "Post_link": value.Post_link + "-post.html",
                        "Post_time": ""
                    })
                    $("#tabs-13 ul").append(news);
                   
                });
               
                
            }
        });
    };
    $.fn.PostDetail = function(url){
        $.getJSON(url , function(data){
            if(data){
                $(".ct-mr").empty()
                $(".ct-mr").addClass("dt-page")
                var title = "<div class='dt-top'>"
                        + "<div class='inside-tit'>"
                        + "<span class='breadcum'><a href='/'><strong>Trang chủ</strong></a> &gt;</span> "
                        + "<span style='width: 450px' class='box-name'>{title}</span> </div>"
                        + "</div>"
                title = $.fn.template(title,{'title':data.Post_subject});
                $(".ct-mr").append(title)
                var content = "<div class = 'dt-mid'>"
                        + "<div class = 'content'>"
                        + "<div class = 'new-content'>"
                        + "{Post_text}"
                        + "<div class='fb-comments' data-href='http://thapdaiphai.com?{Post_subject}' data-numposts='5' data-colorscheme='light'></div>"
                        + "</div>"
                        + "</div>"
                        + "</div>"
                content = $.fn.template(content,{'Post_text':data.Post_text, 'Post_subject':data.Post_subject});
                $(".ct-mr").append(content)
                var footer = "<div class='dt-bot'> </div>"
                $(".ct-mr .dt-mid").append(footer)
                 $(window).scrollTop($(".ct-mr").offset().top);
                 
            }
        });
        

    };
    
}(jQuery));
