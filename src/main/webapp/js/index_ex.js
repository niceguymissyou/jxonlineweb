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
                        + "<a href='news/list/12/He-thong.html' class='type'>[Tin Tức]</a>"
                        + "<a href='{Post_link}'>{Post_subject}</a>"
                        + "<span class='time'>{Post_time}</span>"
                        + "</li>";
                    var news = $.fn.template(str, {
                        "Post_link": value.Post_link + ".html",
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
                        + "<a href='news/list/12/He-thong.html' class='type'>[Sự Kiện]</a>"
                        + "<a href='{Post_link}'>{Post_subject}</a>"
                        + "<span class='time'>{Post_time}</span>"
                        + "</li>";
                    var news = $.fn.template(str, {
                        "Post_link": value.Post_link + ".html",
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
                        + "<a href='news/list/12/He-thong.html' class='type'>[Tính Năng]</a>"
                        + "<a href='{Post_link}'>{Post_subject}</a>"
                        + "<span class='time'>{Post_time}</span>"
                        + "</li>";
                    var news = $.fn.template(str, {
                        "Post_link": value.Post_link + ".html",
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
                        + "<a href='news/list/12/He-thong.html' class='type'>[Cẩm Nang]</a>"
                        + "<a href='{Post_link}'>{Post_subject}</a>"
                        + "<span class='time'>{Post_time}</span>"
                        + "</li>";
                    var news = $.fn.template(str, {
                        "Post_link": value.Post_link + ".html",
                        "Post_subject": value.Post_subject,
                        "Post_time": ""
                    })
                    $("#tabs-13 ul").append(news);
                   
                });
               
                
            }
        });
    };
}(jQuery));