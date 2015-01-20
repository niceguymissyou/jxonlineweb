<%-- 
    Document   : postlst
    Created on : Jan 20, 2015, 7:37:36 PM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <jsp:include page="header.jsp"/>   
 <div class="ct-mr dt-page">
            <div class="dt-top">
                <div class="inside-tit"> 
                	<span class="breadcum">
                		<span class="breadcum"><a href="/"><strong>Trang chủ</strong></a> &gt;</span>
                	</span>	
                	
                	<span class="box-name">${type}</span> </div>
            </div>
            <div class="dt-mid">
                <div class="content">
                    <div class="jscq"></div>
                    <div class="cont-ins">
                        <ul>
                           
                        </ul>
                    </div>
                    <!--Start: PageView-->
                     <!--Start: PageView-->
                     <div class = 'paginationdemo' style="margin-left: 200px; margin-top: 20px;"></div>
<!--End: PageView-->    

                     <!--End: PageView--> 
                    
                </div>
            </div>
            <div class="dt-bot"> </div>
        </div>
               <script>
             $(document).ready(function () {
                 
               $(".paginationdemo").pagination({
                    items: 100,
                    itemsOnPage: 10,
                    cssStyle: 'light-theme',
                    onPageClick(pageNumber, event){
                        $(".cont-ins ul").empty();
                        $.getJSON('/getpostlist.html',
                        {'post_type':"${post_type}",'index': (pageNumber - 1) *10 },
                        function(data){
                            if(data){
                                $.each(data,function(index,val){
                                  var str = "<li><span class='time'>[{Post_time}]</span>"
                                   +      "<a href='' class='title-arti'><b>{Post_subject}</b></a>"
                                   +"</li>"
                                    d = new Date(val.Post_time)
                                    d = d.getDate() + "-" + (d.getMonth() + 1) + "-" + d.getFullYear(); 
                                    str =        $.fn.template(str,{'Post_subject':val.Post_subject,
                                                                    'Post_time':d })    
                                    $(".cont-ins ul").append(str);
                                })

                            }
                        })
                    }
                });
                
                 $(".paginationdemo").pagination('selectPage', 1);
             })
        </script>
  <jsp:include page="footer.jsp"/>    

