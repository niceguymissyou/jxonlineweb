var _sPeerid = "null";
function _pgv(){
	r = document.URL;
	var username = getCookie("newusername");
	setCookie("newusername","",24)
	if(username == "")
	{
	}
	else
	{
		if(r.indexOf("?") != -1)
			r += "&username=" + username;
		else
			r += "?username=" + username;
	}
	return escape(r);
}

function _src()
{	
	r = "";	
	try {		
		r = top.document.referrer;	
	}	
	catch (e) {		
		try {			
			r = parent.document.referrer;		
		}		
		catch (e) {			
			try {				
				r = document.referrer;			
			}			
			catch (e) {				
				r = "";					
			}		
		}	
	}	
	return escape(r);
}
function setCookie(name,value,hours)
{
var expireDate=new Date(new Date().getTime()+hours*3600000);
document.cookie = name + "=" + escape(value) + "; path=/; domain=xunlei.com ; expires=" + expireDate.toGMTString() ;
}
function getCookie(name)
	{
		var search;
		search = name + "=";
		offset = document.cookie.indexOf(search);
		if (offset != -1) 
		{
			offset += search.length;
			end = document.cookie.indexOf(";", offset);
			if (end == -1)
				end = document.cookie.length;
			return unescape(document.cookie.substring(offset, end));
		}
		else
		{
			return "";
		}
	}

try{
	var t =unescape(_pgv());
	var gs ='';
	var tt='';
	var idx =t.indexOf('&gs');
	if(idx>0){
		tt=t.substr(0,idx);
		tt= escape(tt);
		gs =t.substr(idx+1);
	}else{
		tt=_pgv();
		gs='gs=xunlei36';
	}
	vhref = "http://advstat.xunlei.com/TPV?"+gs+"&peerid="+_sPeerid+"&tt=" + tt+ "&src=" + _src() + "&screensize=" +window.screen.width +"*" +window.screen.height;
	image1 = new Image(1,1);
	image1.src=vhref;
} catch(e)
{
}

