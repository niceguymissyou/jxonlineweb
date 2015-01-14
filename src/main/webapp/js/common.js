document.domain='volamkyhiep.com';
var svrInstance=new xl.gameServerList({
	gameid:'000031',
	gameDomain:'http://volamkyhiep.com/game',
	title:'迅雷三十六计官方网站 - 网页游戏 无需下载 感受十二国争霸带给你的强烈震撼',
	gmLogFail:function(){
		initLoginStatus();
	}
});
svrInstance.initSvrList = function(){
	var _this=this;	
	$.each(_this.list,function(i){
		if(_this.list[i].isrecommand) _this.svrItemRender(_this.list[i],$('#tjSvr'));
	});
	$.each(_this.list,function(i){
		_this.svrItemRender(_this.list[i],$('#allSvr'));
	});
};
svrInstance.svrItemRender = function(svrInfo,container){
	if(svrInfo==null) return false;
	var html=[];
	var className=['s_new','s_dl','s_wh'];
	var className2=['item_red','item_blue','item_green'];
	var index=0;	
	if(svrInfo.online<=2000&&svrInfo.online>1000) index=1;
	if(svrInfo.online<=1000&&svrInfo.online>=0) index=2;
	var _inuse=svrInfo.inuse;
	html.push('<li><div class="'+className2[index]+'"><div class="'+className[this.getSvrState(svrInfo)-1]+'"><a href="javascript:;" svrid="'+svrInfo.serverid+'" isuse="'+_inuse+'">'+svrInfo.servername+'<span>在线'+(svrInfo.online<0?0:svrInfo.online)+'</span></a></div></div></li>');
	$(html.join('')).appendTo(container);
};
/*获取服务器繁忙状态值*/
svrInstance.getSvrState = function(svrInfo){
	if(!svrInfo) return 3;
	var user = xl.getCookie('xl_validUname');
	var loginSvrCoo = this.getLogedSvrs();
	var state=3;
	//if(svrInfo.status!=-1){
	if(svrInfo.inuse==1){
		state = 1;
		if(loginSvrCoo){
			var svrArr = loginSvrCoo.split('|');
			for(var i=0,l=svrArr.length;i<l;i++){
				if(svrArr[i]==svrInfo.seqid) {
					state = 2;
					break;
				}
			}
		}
	}else{
		state = 3;//维护
	}
	return state;
};

//无缝滚动
function Marquee(obj,config){
	this.obj = obj;
	this.config = {speed:35,direction:'up',e:true};
	
	if(typeof config == 'object'){
		var J = $;
		J.extend(this.config, config);
	}
	
	this.obj2 = null;
	this.timer = null;
	this.init();
}

Marquee.prototype = {
	init: function(){
		var _this = this;
		if(this.config.direction == 'up' || this.config.direction == 'down'){
			if(this.obj.offsetHeight < this.obj.parentNode.offsetHeight) return;
			this.obj2 = this.obj.cloneNode(true);
			$(this.obj).after(this.obj2);
		}
		
		function temp(){
			_this.marquee();
		}
		
		var myMar = setInterval(temp,_this.config.speed);
		if(this.config.e){
			this.obj.parentNode.onmouseover = function(){clearInterval(myMar)};
			this.obj.parentNode.onmouseout = function(){myMar = setInterval(temp,_this.config.speed)};
		}
	},
	marquee: function(){
		var _this = this;
		var con = this.obj.parentNode;
		//margin 或 padding引起的偏移量		
		if(this.obj2){
			var offset = (this.obj2.offsetTop - this.obj.offsetHeight)/2;
		}
		
		if(this.config.direction == 'up'){
			if(this.obj2.offsetHeight <= con.scrollTop){
				con.scrollTop = 0;
			}else{
				con.scrollTop +=2;
			}
		}
	}
};
(function(){
	xl.logPopwin.init({
		regAfter:function(data){
			initLoginStatus();
			if(data.regRtn==0){
				$('#popwin').popupClose();
				svrInstance.loadServerList();
			}
		},
		logAfter:function(data){
			if(data.loginStatus==0) $('#popwin').popupClose();
			loginAfter(data);
		},
		extend:function(){
			var container=$('#popwin');
			if(container!=undefined){
				container.find('#reg').trigger('click'); 
			}
		}
	});
	xl.login.init($('#leftLoginBox'),function(data){
		loginAfter(data);
	});		
	//新增左侧登录
	leftLoginEvent();
	initLoginStatus();
	if(document.getElementById('go_top_gg')){
		var toTop = document.getElementById('go_top_gg'),
		pH = $('.ny_main').height(),
		sH = $(toTop).height(),
		top = toTop.offsetTop;
		window.onscroll = function(){
			var sTop = document.documentElement.scrollTop;
			var styleTop = +top + sTop - sH < 0 ? 0 : +top + sTop - sH;
			if(styleTop >= 0 && styleTop < pH){
				toTop.style.top = styleTop+'px';
			}
		}
	}
	setLinkNav();
	
	new Marquee($('#renwu')[0]);
	
	$('#timeBt').click(function(){
		var speed = $('#armType').val();
		if (speed == ""){
			alert("请选择兵种");
			return false;
		}
		var armTypeName = $('#armType option:selected').text();
		var startCity = $('#startCity').val();
		var endCity = $('#endCity').val();
		document.location.href = 'http://36ji.xunlei.com/countTime.html?speed='+encodeURI(speed)+'&armType='+encodeURI(armTypeName)+'&sCity='+encodeURI(startCity)+'&eCity='+encodeURI(endCity)+'&eHour='+encodeURI($('#eHour').val())+'&eMin='+encodeURI($('#eMin').val())+'&eSec='+encodeURI($('#eSec').val())+'&cHour='+encodeURI($('#cHour').val())+'&cMin='+encodeURI($('#cMin').val())+'&cSec='+encodeURI($('#cSec').val());
		return false;
	});
	
	$('#armType').next().attr("href","http://36ji.xunlei.com/c/1257313058402.html");

	if(xl("vote")) {
		var vote = new xl.ui.Vote("000031","1260843726703",xl("vote"));
		vote.initSubmit(xl("vote"),"http://36ji.xunlei.com/vote_result.html");
	}
})();

//登录回调
function loginAfter(data){
	if(0==data.loginStatus){
		initLoginStatus();
		svrInstance.loadServerList();
	}else{
		alert(data.rtnMsg);
	}
}

function leftLoginEvent(){
	$('#leftLogoutBtn').click(function(){
		var url = xl.gameServiceUrl+'logout.webGameLogin?r='+(+new Date);
		xl.getScript(url, null, function(data){
			xl.delCookie('xlwg_loginstate');
			xl.delCookie('xl_validUname');
			initLoginStatus();
		});
		return false;
	});
	$('#lookSvrList').click(function(){
		svrInstance.loadServerList();
	});	
}
function initLoginStatus(){
	var username = xl.getCookie('xl_validUname');	
	if(username){
		svrInstance.fillLatestLoginSvr();
		$('#welcomeUser').html(username);
		$('#leftLoginBox').hide();
		$('#leftLogonBox').show();	
	}else{		
		$('#leftLogonBox').hide();
		$('#leftLoginBox').show();
	}
}
$('#regBt').bind('click',function(){
	var user = xl.getCookie('xl_validUname');
	if(!user) xl.jumpTo('http://36ji.xunlei.com/welcome2/');
	else $('#lookSvrList').trigger('click');	
});

function  setLinkNav(){
	//设为首页
	if(xl('setHome')){
		$('#setHome').click(function(){
			 try{
				this.style.behavior='url(#default#homepage)';
				this.setHomePage('http://36ji.xunlei.com/');
			}catch(e){
				if(window.netscape) {
					try {
						netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");  
					} catch (e) { 
						alert("抱歉！您的浏览器不支持直接设为首页。请在浏览器地址栏输入“about:config”并回车然后将[signed.applets.codebase_principal_support]设置为“true”，点击“设为首页”后忽略安全提示，即可设置成功。");  
					}
					var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
					prefs.setCharPref('browser.startup.homepage','http://36ji.xunlei.com/');
				 }
			}			
		});
	}

	//收藏本站
	if(xl('scbz')){
		$('#scbz').click(function(){
			xl.addBookmark('迅雷三十六计官方网站 - 网页游戏 无需下载 感受十二国争霸带给你的强烈震撼','http://36ji.xunlei.com/');
		});	
	}
}
function showDate2(){
var url = 'http://act.game.xunlei.com:82/xl36ji_verifytime/verifytimeservlet';
	xl.getScript(url,{},function(data){
		if(typeof(data)=='undefined')return;
		var week;
		setInterval(function(){
			date = new Date(data);
			var date = new Date(data);
			var day = date.getDay();
			if(day == 1) week = '星期一';
			if(day == 2) week = '星期二';
			if(day == 3) week = '星期三';
			if(day == 4) week = '星期四';
			if(day == 5) week = '星期五';
			if(day == 6) week = '星期六';
			if(day == 7) week = '星期天';
			$('#header .ymd').text(date.toLocaleDateString());
			$('#header .hms').text(date.toLocaleTimeString());
			$('#header .week').text(week);
			data += 1000;
		},1000);
	},'verifytimeRtn');
	//$('#header .week').next().click(function(){alert('敬请期待'); return false;});
}
function showDate(){
	setTimeout("showDate2()",100);
}
showDate();