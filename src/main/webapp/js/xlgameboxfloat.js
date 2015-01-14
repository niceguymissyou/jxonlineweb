var ___box_ua = window.navigator.userAgent;
var ___box_ua_isMsie = ___box_ua.toLowerCase().indexOf("msie") != -1 && ___box_ua.indexOf("opera") == -1;
var ___box_imgurl = 'http://opi.yahoo.com/online?u=viettri_forum&amp;m=g&amp;t=14';
if(___box_ua_isMsie&&___box_ua_version()=='6.0') ___box_imgurl = 'http://opi.yahoo.com/online?u=viettri_forum&amp;m=g&amp;t=14';
document.write('<div id="_float_div" style="position:absolute;z-index:99"><a href="#" id="__box_click_count" target="_blank" title="下载迅雷游戏盒子"> <img src="'+___box_imgurl+'" alt="下载迅雷游戏盒子" /></a></div>');
window.onload = function(){
	if(window.attachEvent){
		window.attachEvent("onresize",___box_set_pos);
		window.attachEvent("onscroll",___box_set_pos);
	}else{
		window.onscroll = window.onresize = ___box_set_pos;
	}
	___box_set_pos();
}
document.getElementById("__box_click_count").onclick = function(){
	___box_clickCount();
};
function ___box_set_pos(){
	var scrollTop = document.body.scrollTop + document.documentElement.scrollTop;
	var top = document.documentElement.clientHeight/2 + scrollTop;
	var download_div = document.getElementById('_float_div');
	download_div.style.right = '20px';
	download_div.style.top = top+'px';
}
function ___box_ua_version(){
	var s,v,ua=___box_ua.toLowerCase();
	(s = ua.match(/msie ([\d.]+)/)) ? v = s[1] :
	(s = ua.match(/firefox\/([\d.]+)/)) ? v = s[1] :
	(s = ua.match(/chrome\/([\d.]+)/)) ? v = s[1] :
	(s = ua.match(/opera.([\d.]+)/)) ? v = s[1] :
	(s = ua.match(/version\/([\d.]+).*safari/)) ? v = s[1] : 0; 
	return v;
}
function ___box_clickCount() {
	var PV_URL = 'http://act3.game.xunlei.com:81/xlcdjx/statatics?action=doClick&id=XL_GAME_BOX_CLICK&cacheTime=' + new Date().getTime();
	if(document.getElementById("__box__click_img") == null) {
		var d = document, img = d.createElement("img");	
		img.id = "__box__click_img";
		img.style.display = 'none';
		d.body.appendChild(img);	
	} 
	document.getElementById("__box__click_img").style.display = 'none';
	document.getElementById("__box__click_img").src = PV_URL;	
}
