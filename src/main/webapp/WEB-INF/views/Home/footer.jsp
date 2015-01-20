<%-- 
    Document   : footer
    Created on : Jan 20, 2015, 6:39:20 PM
    Author     : VuNguyen
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="clear"></div>
    </div>
    <div class="clear"></div>
</div>


<script type="text/javascript">
	$(function(){
		$('#slides').slides({
			preload: true,
			preloadImage: 'images/loading.gif',
			play: 5000,
			pause: 2500,
			hoverPause: true
		});
	});

	$(function() {
		$("#content-tabs,#content-tabs-1").tabs({
			event: 'mouseover'
		});
		$("#rank-tabs").tabs().addClass('ui-tabs-vertical ui-helper-clearfix');
	});
</script>	
	<div id="bottom-page"> 
	        <!--<div class="bottom-content"></div>--> 
	    </div>
	    
	<!-- Begin naptien modal -->
	<!-- End naptien modal -->
	
	</div>
    
 <!-- fancy box -->
<script type="text/javascript" src="http://vohiep.com/popup/index"></script>
<script type="text/javascript" >
    $.fn.LoadPostList()
</script>
<!-- end fancybox --> 

</body>

<!-- Mirrored from vh.vohiep.com/home by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 30 Dec 2014 20:28:02 GMT -->
</html>
