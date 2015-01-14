document.open();
var $xl_TempFuncs=new (function(){
	/***基础参数配置 Begin*****/
	var xl_pvurl = "http://web.stat.xunlei.com/pv?";
	var xl_cvsid = "_xlcvsid";  /*visit id*/
	var xl_cpvdt = "_xlcpvdt";  /*last pv time*/
	var xl_cvcid = "_xlcvcid";  /*visit count*/
	var xl_clul = "_xlclul"; 
	var xl_sessionBegin = "_xlsessionBegin";  /*visit begin date*/
	var xl_sessionDepth = "_xlsessionDepth";  /*visit depth*/
	var xl_customerFlag="0";
	var xl_redirectUrl = "";  /*redirectUrl*/
	var _xlt_referrer = "";
	var _na = navigator;
	var _uAgt = _na.userAgent;
	var _uPlu = _na.plugins;
	var _ifActive = window.ActiveXObject;
	var _upfm = _na.platform;
	var _pvURL = xl_pvurl;
	var _ifDebug = false;
	var _xltj_image=new Image();
	/***基础参数配置 End*****/
	/*Alex 工具条用*/
	document.write('<script language="javascript" src="res://AlxRes.dll/SCRIPT/dsn.class.js"></script>');
	try{
		var bgTime=(Date.parse(new Date()));
		if(xlfun_getCookie('__xltjbr')==''){
			xlfun_setCookie('__xltjbr',(new Date()).getTime());
		}
		if(__xltj_getCustomerReferrer){
			_xlt_referrer=__xltj_getCustomerReferrer();
		}
	}catch(e){}
	var pst=0;
	try{
		pst=(new Date()).getTime()-__xltjLoadTime;
	}catch(e){}
	updateAddonPara();
	regiterPostEvent();

	
	
	this.init = function(gsid){
		if(!gsid ) return;
		_pvURL += '&gs='+gsid;
		_pvURL += '&'+String(Date.parse(new Date()));
		if(_ifDebug){
			//alert(_pvURL);
		}

		try{
			if(xl_redirectUrl && xl_redirectUrl!=''){				
				document.location=_pvURL;
			}else{
				document.write('<script language="javascript" src="'+_pvURL+'" type="text/javascript" onload="javascript:$xl_TempFuncs.updateAddonPara();"></script>');
			}
		}catch(e){
			if(_ifDebug){
				alert(e);
			}
		}
		xl_redirectUrl='';
		xl_customerFlag='0';
	}
	function dw(s){
		document.open();
		document.write(s);
		document.close();
	}
	this.updtpv = xlfun_updatepv;
	this.updtpv2 = xlfun_updatepv2;
	this.updateAddonPara = function(){
		if(_ifDebug){
			alert('载入耗时:'+String(Date.parse(new Date()) - bgTime));
		}
	}
	function getRndStr(){
		var str='abcdefghijklmnopqrstuvwxyz0123456789';
		var l = Math.ceil(Math.random() * 5);
		var ret = '';
		for(var i=0;i<l;i++){
			ret += str.charAt(Math.ceil(Math.random()*(str.length-1)));
		}
		return ret;
	}
	
	function parseLocation(){
		var originalUrl=window.location.href;
		try{
			if(__xltj_parseLocationCustomer!=undefined){
				return __xltj_parseLocationCustomer(originalUrl);
			}			
		}catch(ex){}		
		//去掉所有的url参数
		try{
			if(__xltj_ingoreAllParameter!=undefined&&__xltj_ingoreAllParameter==true){
				var i=originalUrl.indexOf("?");
				if(i!=-1){
					return originalUrl.substring(0,i);
				}
				return originalUrl;	
			}
		}catch(ex){}
		try{
			if(__xltj_onlyParameter!=undefined&&__xltj_onlyParameter.length!=0){
				var i=originalUrl.indexOf("?");
				if(i!=-1){
					var pre= originalUrl.substring(0,i);
					var queryPath=originalUrl.substring(i);
					var ps=__xltj_onlyParameter.split(",");
					for(k=0,m=0;k<ps.length;k++){
						var r = new RegExp("[?\&]"+ps[k]+'=([^\&]*)');
						var valP=(r.test(queryPath)?((queryPath.match(r).length>0)?RegExp.$1:''):null)
						if(valP!=null){
							if(m==0)
								pre+="?"+ps[k]+"="+valP;
							else
								pre+="&"+ps[k]+"="+valP;
							m++;
						}						
					}
					return pre;				
				}
				return originalUrl;	
			}
		}catch(ex){}
		try{	
			if(__xltj_ingoreParameter!=undefined&&__xltj_ingoreParameter.length!=0){
				var ps=__xltj_ingoreParameter.split(",");
				for(i=0;i<ps.length;i++){
					originalUrl=originalUrl.replace(new RegExp("[\\?\\&]?"+ps[i]+"=[^\\&]*","gi"),"");
				}
				var i=originalUrl.indexOf("?");
				if(i==-1){
					i=originalUrl.indexOf("&");
					if(i!=-1){
						originalUrl=originalUrl.substring(0,i)+"?"+originalUrl.substring(i+1);
					}					
				}
				return originalUrl;	
			}
		}catch(ex){}		
		return originalUrl;
	}
	
	function updateAddonPara(){
		var vc = getSiteParameter(xl_cvcid); if (!vc || isNaN(parseInt(vc))){vc="0";}
		var br = encodeURIComponent(xlfun_getBrowserVer());
		var _au = '&sd=' + getSessionParameter(xl_cvsid) + '&vb='+ getSessionParameter(xl_sessionBegin) + '&vd='+ getSessionParameter(xl_sessionDepth) + '&dm=' + encodeURIComponent(document.domain) + '&ul='+encodeURIComponent(parseLocation());
		_au += '&vc=' + vc + '&st=' + encodeURIComponent(getSiteParameter(xl_cpvdt)) + '&co=' +encodeURIComponent(window.screen.colorDepth)+ '&jv=' +encodeURIComponent(xlfun_getJavaVer()) + '&fv=' +encodeURIComponent(xlfun_getFlashVer());
		_au += '&ru=' + encodeURIComponent(screen.width*100000+screen.height)+'&os=' + encodeURIComponent(xlfun_getOSType()) + '&br=' + br + '&ln=' + encodeURIComponent(xlfun_getLanguage());
		_au += '&zn=' + String(new Date().getTimezoneOffset()/60) +'&al=' +xlfun_getAlexa() + '&tt=' + encodeURIComponent(document.title) + '&rf=' + ((_xlt_referrer && _xlt_referrer != '')?encodeURIComponent(_xlt_referrer):encodeURIComponent(document.referrer));		
		(xl_redirectUrl&&xl_redirectUrl!='') && (_au +='&cf=2&cu='+xl_redirectUrl);
		(xl_customerFlag&&xl_customerFlag=='1') && ( _au+= '&cf=1');
		try{
			_au+="&lul="+encodeURIComponent(decodeURIComponent(getSessionParameter(xl_clul)));
		}
		catch(e){
			_au+="&lul="+encodeURIComponent(parseLocation());
		}
		if(br=='NA%2F1.0'){
			_au+="&_nabr="+navigator.userAgent;
		}		
		_au+="&pi="+getPeerid();
		_au+="&usr0="+getUserNameOld();
		_au+="&usr1="+getUserNameNew();
		_au+="&usrId="+getUserNameId();
		_au+="&bfg="+xlfun_getCookie('__xltjbr');
		_au+="&pst="+pst;
		
		//个性化参数
		try{
			if(__xltj_getCustomerParameter!=undefined){
				_au+="&clp="+__xltj_getCustomerParameter();
			}			
		}catch(ex){
			_au+="&clp=";
		}
		//后缀
		_au += '&_a=';
		_pvURL += _au;
	}
	function xlfun_getCookie(ckname) {
		   var arrStr = document.cookie.split("; ");
		   for(var i = 0;i < arrStr.length;i ++){
		    	var temp = arrStr[i].split("=");
		    	if(temp[0] == ckname&&temp[1]!="") return temp[1];
		   }
		   return "";	
	}
	function xlfun_setCookie(ckname,ckvalue, tiout){
		if(xlfun_getCookieNo()>=xlfun_getMaxCookieCount()){
			if(xlfun_getCookie(ckname)==""){
				return;
			}
		}		
		var strVal=escape(ckname)+'='+escape(ckvalue);var expireDate=0;
		var expires=(!isNaN(tiout) && tiout!==null && tiout!== undefined)?("expires='"+(expireDate=new Date(new Date().getTime()+tiout*1000)).toGMTString()+";"):"";
		try{
			 strVal+=('; path=/; '+expires+'domain='+__xltj_domain);
		}
		catch(e){
			 strVal+='; path=/; '+expires;
		}		
		document.cookie=strVal;
	}
	function xlfun_getCookieNo(){
		var c =document.cookie; 
		var result=0;
		while(true){
			var i=c.indexOf("=");
			if(i==-1){
				break;
			}
			c=c.substring(i+1);
			result++;
		}
		return result;
	}
	function xlfun_getMaxCookieCount(){
		var br=xlfun_getBrowserVer();
		if(br.indexOf("MSIE/6")==0){
			return 20;
		}
		if(br.indexOf("MSIE/7")==0){
			return 50;
		}
		if(br.indexOf("Firefox")==0){
			return 50;
		}
		if(br.indexOf("Chrome")==0){
			return 50;
		}
		if(br.indexOf("Opera")==0){
			return 30;
		}
		return 20;
	}
	
	function xlfun_getFlashVer() {
		var f="";
		if (_uPlu && _uPlu.length){
			for (var ii=0;ii<_uPlu.length;ii++){
				if (_uPlu[ii].name.indexOf('Shockwave Flash')!=-1){
					f=_uPlu[ii].description.split('Shockwave Flash ')[1];
					f=f.split(" ")[0];
					break;
				}
			}
		}else if (_ifActive){
			for (var j=11; j>=2; j--) {
				try{   
					var fl=eval("new ActiveXObject('ShockwaveFlash.ShockwaveFlash."+j+"');");
					if (fl){f=j + '.0'; break; }
				}
				catch(e){}
			}
		}
		return f; 
	}
	function xlfun_getJavaVer() {
		var f=""; 
		if (_uPlu && _uPlu.length){
			for (var ii=0;ii<_uPlu.length;ii++){
				if (_uPlu[ii].name.indexOf('Java')!=-1){
					f=_uPlu[ii].description.split('Java Runtime Environment ')[1];
					if (_uPlu[ii].name.indexOf('Apple')!=-1) return "unknown";
					var offset = _uPlu[ii].description.indexOf("Plug-in ");
					return _uPlu[ii].description.substring(offset+8, _uPlu[ii].description.indexOf("_",offset));
					break;
				}
			}
			return "";
		}
		if (_ifActive) {
			try {
				var testObj = new ActiveXObject("JavaWebStart.isInstalled");
				for (var j=7;j>=4;j--) {
					try{   
						var fl=eval("new ActiveXObject('JavaWebStart.isInstalled.1."+j+".0.0');");
						if (fl) return "1."+j+".0";
					} catch(e){}
				}
			}
			catch(e){
				
			}
			if(navigator.javaEnabled()){
				return "NA";
			}
		}
		return "";		
	}
	function xlfun_getOSType () {
		var isWin = (_upfm == "Win32") || (_upfm == "Windows");
		var isLinux = _upfm.indexOf("Linux") >-1;
		var isMac = (_upfm == "Mac68K") || (_upfm == "MacPPC") || (_upfm == "Macintosh");	
		var isUnix = (_upfm == "X11") && !isWin && !isMac&&!isLinux;

		if (isWin) {
			if(_uAgt.indexOf("Win95") > -1 || _uAgt.indexOf("Windows 95") > -1){return "Win95";}
			if(_uAgt.indexOf("Win98") > -1 || _uAgt.indexOf("Windows 98") > -1){return "Win98";}
			if(_uAgt.indexOf("Win 9x 4.90") > -1|| _uAgt.indexOf("Windows ME") > -1){return "WinMe";}
			if(_uAgt.indexOf("Windows NT 5.0") > -1|| _uAgt.indexOf("Windows 2000") > -1 ){return "Win2K";}
			if(_uAgt.indexOf("Windows NT 5.1") > -1 || _uAgt.indexOf("Windows XP") > -1){return "WinXP";}
            if(_uAgt.indexOf("Windows NT 5.2") > -1) return "Win2003";
            if(_uAgt.indexOf("Windows NT 6.0") > -1) return "Vista";			
            if(_uAgt.indexOf("Windows NT 6.1") > -1) return "Win7";
			if(_uAgt.indexOf("WinNT") > -1 || _uAgt.indexOf("Windows NT") > -1
				|| _uAgt.indexOf("WinNT4.0") > -1 || _uAgt.indexOf("Windows NT 4.0") > -1
				&& (!isWinME && !isWin2K && !isWinXP)){return "WinNT4";}
		}
		if (isMac) {
			if (_uAgt.indexOf("Mac_68000") > -1 || _uAgt.indexOf("68K") > -1 ){return "Mac68K";}
			if (_uAgt.indexOf("Mac_PowerPC") > -1 || _uAgt.indexOf("PPC") > -1){return "MacPPC";}
		}	
		if (isUnix) {
			isSunOS = _uAgt.indexOf("SunOS") > -1;	
			if (isSunOS) {
				var reSunOS = new RegExp("SunOS (//d+//.//d+(?://.//d+)?)");
				reSunOS.test(_uAgt);
				if (compareVersions(RegExp["$1"], "4.0") >= 0){return "MinSunOS4";}
				if (compareVersions(RegExp["$1"], "5.0") >= 0){return "MinSunOS5";}
				if (compareVersions(RegExp["$1"], "5.5") >= 0){return "MinSunOS5.5";}
			}
		}
		if(isLinux){
			if (_uAgt.indexOf("Linux") > -1){return "Linux";}
		}
		return "NA";
	}
	function xlfun_getBrowserVer (){
		var _binfo = ['MSIE ','Firefox','Chrome','Opera','Safari'];
		var _roffChar = [';','',' ','(',' Safari'];
		var _fix = {'Safari':'Version'};
		var _appName = '';
		var _version = '';
		for(var i=0;i<_binfo.length;i++){			
			var p = _uAgt.indexOf(_binfo[i]);
			if(p>-1){
				_appName = _binfo[i];
				if(_roffChar[i]){
					if(_fix[_appName]){
						_version = _uAgt.substring(_uAgt.indexOf(_fix[_appName])+_fix[_appName].length,_uAgt.indexOf(_roffChar[i]));
					}else{
						_version = _uAgt.substring(p+_appName.length,_uAgt.indexOf(_roffChar[i],p+_appName.length));
					}
				}else{
					_version = _uAgt.substr(p+_appName.length);
				}
				break;
			}
		}
		(_version.substr(0,1)=='/') && (_version = _version.substr(1));
		return trim(_appName)+"/"+_version;
	}
	function xlfun_getLanguage() {
		return (_na.language?_na.language.toLowerCase():(_na.browserLanguage?_na.browserLanguage.toLowerCase():''));
	}
	function xlfun_getAlexa() {
		return (typeof(aborter)=='Function'?1:0);
	}
	function xlfun_parseReferrerDomain(){
		var referer;if(_xlt_referrer&& _xlt_referrer != ''){referer=_xlt_referrer;}else{referer = document.referrer;}if(!referer || referer.substring(0, 7) == "file://") return "";var pos = referer.indexOf("//");if(pos < 0) return "";referer = referer.substring(pos + 2);var reg = new RegExp('[^\\:\\?\\/]+');if(reg.test(referer)){return referer.match(reg)[0];}else{return '';}
	}
	
	function xlfun_updatepv(vcount, vsid, pvtime,sessionBegin,sessionDepth) {
		try{		
		setSiteParameter(pvtime,vcount);
		setSessionParameter(vsid,sessionBegin,sessionDepth);
		_pvURL = xl_pvurl;		
		updateAddonPara();
		_pvURL += '&gs='+xl_gsid;
		}catch(e){}		
	}		
	function xlfun_updatepv2(pvtime) {
		try{		
		setSiteParameter(pvtime,0);
		_pvURL = xl_pvurl;		
		updateAddonPara();
		_pvURL += '&gs='+xl_gsid;
		}catch(e){}		
	}		
	function getSiteParameter(name){
		var g=encode(xl_gsid);
		var p=xlfun_getCookie("_xltj");
		if(p=="")return "";
		i=p.indexOf(g+"a");
		if(i!=-1){
			li=p.indexOf("c",i);
			l=p.length;
			if(li!=-1)l=li;
			var ginfo=p.substring(i+1+(""+g).length,l);
			var v=ginfo.split("b");
			var result="";
			if(name==xl_cpvdt){
				result=v[0];
			}
			if(name==xl_cvcid){
				result=v[1];
			}
			if(result)return result;
		}	
		return "";	
	}	
	function setSiteParameter(pvdt,vcid){
		var g=encode(xl_gsid);
		var p=xlfun_getCookie("_xltj");
		if(p=="")p=g+"a"+pvdt+"b"+vcid+"c";
		else{
			i=p.indexOf(g+"a");
			if(i!=-1){
				p=p.replace(new RegExp(""+g+"a[0-9b]*c?"),g+"a"+pvdt+"b"+vcid+"c");
			}	
			else{
				p+=g+"a"+pvdt+"b"+vcid+"c";
			}
		}
		xlfun_setCookie("_xltj",p,315360000);
	}	
	
	function getSessionParameter(name){
		var p=xlfun_getCookie("_s"+encode(xl_gsid));
		if(p==undefined||p==""){
			if(name==xl_cvsid){
				result= "";
			}
			if(name==xl_sessionBegin){
				result= 0;
			}
			if(name==xl_sessionDepth){
				result= 1;
			}	
			if(name==xl_clul){
				result="";
			}	
			if(result)return result;
			return "";	
		}
		var v=p.split("b");
		var result="";
		if(name==xl_cvsid){
			result= v[0];
		}
		if(name==xl_sessionBegin){
			result= v[1];
		}
		if(name==xl_sessionDepth){
			result= v[2];
		}	
		if(name==xl_clul){
			//search the third 'b'
			var ind=0;
			for(var k=0;k<3;k++){
				ind=p.indexOf('b',ind+1);
				if(ind==-1){
						break;
				}
			}
			if(ind!=-1){
				result=p.substring(ind+1);
			}
		}	
		if(result)return result;
		return "";	
	}
	function setSessionParameter(vsid,sb,sd){
		xlfun_setCookie("_s"+encode(xl_gsid),vsid+"b"+sb+"b"+sd+"b"+parseLocation(),1800);
	}	
	
	function encode(gsid){
		var a=gsid;
		var v=a.split("_");
		var i=1;
		res="0";
		for(i=1;i<5;i++){
			if(v[i]!='001'){
				res+=v[i];
			}else if(res!='0')
				res+=v[i];
		}
		if(res=='0')res='1';
		for(i=0;i<res.length;i++){
			if(res.charAt(i)!='0'){
				res=res.substring(i);
				break;
			}
		}
		return res;
	}
	
	function trim(str){
		return str.replace(/(^\s+)|(\s+$)/g,'');
	}
	this.xl_pvManually=function(ul){
	
	}
	function getPeerid(){
		try{
		    if(_uAgt.toLowerCase().indexOf("firefox")!=-1){
			   return 100;
			}
			var peeridobj;
			try{
				peeridobj = new ActiveXObject("MediaAddin.MediaComm");
			}catch (e){}
			var peerId;
			if (peeridobj != null && typeof(peeridobj) != "undefined"){
				peerId = peeridobj.peerid;
			}else{
			   return "NVL";
			}
			return peerId;
		}catch(ee){return "NVL";}
	}
	function getUserNameOld(){
		return xlfun_getCookie('usrname');
	}
	function getUserNameNew(){
		return xlfun_getCookie('usernewno');
	}
	function getUserNameId(){
		return xlfun_getCookie('userid');
	}
	
	this.pvManually = function(gsid,ul,para){
		if(!gsid ) return;
		_pvURL += '&'+String(Date.parse(new Date()));
		if(_ifDebug){
			//alert(_pvURL);
		}

		try{
			//替换_pvURL中的地址参数
			_pvURL=_pvURL.replace(new RegExp("\\&ul=[^\\&]*"),"&ul="+encodeURIComponent(ul));
			_pvURL=_pvURL.replace(new RegExp("\\&rf=[^\\&]*"),"&rf="+encodeURIComponent(parseLocation()));
			if(para!=undefined){
				_pvURL=_pvURL.replace(new RegExp("\\&clp=[^\\&]*"),"&clp="+para);
			}
			else{
				try{
				_pvURL=_pvURL.replace(new RegExp("\\&clp=[^\\&]*"),"&clp="+__xltj_getCustomerParameter());
				}catch(e){}
			}
			_xltj_image.src=_pvURL;
		}catch(e){
			if(_ifDebug){
				alert(e);
			}
		}
		xl_redirectUrl='';
		xl_customerFlag='0';
	}
	
	this.pvManually2 = function(gsid,ul,para){
		if(!gsid ) return;
		_pvURL += '&'+String(Date.parse(new Date()));
		if(_ifDebug){
			//alert(_pvURL);
		}

		try{
			//替换_pvURL中的地址参数
			_pvURL=_pvURL.replace(new RegExp("\\&ul=[^\\&]*"),"&ul="+encodeURIComponent(ul));
			_pvURL=_pvURL.replace(new RegExp("\\&rf=[^\\&]*"),"&rf="+encodeURIComponent(parseLocation()));
			if(para!=undefined){
				_pvURL=_pvURL.replace(new RegExp("\\&clp=[^\\&]*"),"&clp="+para);
			}
			else{
				try{
				_pvURL=_pvURL.replace(new RegExp("\\&clp=[^\\&]*"),"&clp="+__xltj_getCustomerParameter());
				}catch(e){}
			}
			var _xltj_image2=new Image();
			_xltj_image2.src=_pvURL;
		}catch(e){
			if(_ifDebug){
				alert(e);
			}
		}
		xl_redirectUrl='';
		xl_customerFlag='0';
	}

	function regiterPostEvent(){
		try{
			for(var obj in __xltj_registerClickEventPoint){
				try{
					if(window.attachEvent){
					  document.getElementById(""+obj).attachEvent("on"+__xltj_registerClickEventPoint[obj].type,function() {try{xl_pvManually(__xltj_registerClickEventPoint[this.event.srcElement.id].url)}catch(e){};});
					}
					else{
					  document.getElementById(""+obj).addEventListener(__xltj_registerClickEventPoint[obj].type,function() {try{xl_pvManually(__xltj_registerClickEventPoint[this.id].url);}catch(e){}},false);
					}
				}
				catch(e) {}
		}}catch(ee){}
	}
})();

var xl_track = function(){	
	if(typeof(xl_gsid)=='undefined'||xl_gsid=="" ){return;}
	$xl_TempFuncs.init(xl_gsid);
}
var xlfun_updatepv = function(a, b, c,d,e){
	$xl_TempFuncs.updtpv(a, b, c,d,e);
}
var xlfun_updatepv2 = function(a){
	$xl_TempFuncs.updtpv2(a);
}
function xl_pvManually(ul,para){
	if(typeof(xl_gsid)=='undefined'||xl_gsid==""||typeof(ul)=='undefined'||ul=="" ){return;}
	$xl_TempFuncs.pvManually(xl_gsid,ul,para);
}
function xl_pvManually2(ul,para){
	if(typeof(xl_gsid)=='undefined'||xl_gsid==""||typeof(ul)=='undefined'||ul=="" ){return;}
	$xl_TempFuncs.pvManually2(xl_gsid,ul,para);
}
xl_track();

document.close();
