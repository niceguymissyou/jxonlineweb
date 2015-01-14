
function Set_Cookie(name, value, expires, path, domain, secure) {
	// set time, it's in milliseconds
	var today = new Date();
	today.setTime(today.getTime());

	/*
	if the expires variable is set, make the correct
	expires time, the current script below will set
	it for x number of days, to make it for hours,
	delete * 24, for minutes, delete * 60 * 24
	*/
	if (expires) {
		//expires = expires * 1000 * 60 * 60 * 24;
		expires = expires * 1000 * 60 ;
	}
	var expires_date = new Date(today.getTime() + (expires));

	document.cookie = name + "=" + escape(value) +
((expires) ? ";expires=" + expires_date.toGMTString() : "") +
((path) ? ";path=" + path : "") +
((domain) ? ";domain=" + domain : "") +
((secure) ? ";secure" : "");
}

function Get_CookieValue(check_name) {
	// first we'll split this cookie up into name/value pairs
	// note: document.cookie only returns name=value, not the other components
	var a_all_cookies = document.cookie.split(';');
	var a_temp_cookie = '';
	var cookie_name = '';
	var cookie_value = '';
	var b_cookie_found = false; // set boolean t/f default f

	for (i = 0; i < a_all_cookies.length; i++) {
		// now we'll split apart each name=value pair
		a_temp_cookie = a_all_cookies[i].split('=');


		// and trim left/right whitespace while we're at it
		cookie_name = a_temp_cookie[0].replace(/^\s+|\s+$/g, '');

		// if the extracted name matches passed check_name
		if (cookie_name == check_name) {
			b_cookie_found = true;
			// we need to handle case where cookie has no value but exists (no = sign, that is):
			if (a_temp_cookie.length > 1) {
				cookie_value = unescape(a_temp_cookie[1].replace(/^\s+|\s+$/g, ''));
			}
			// note that in cases where cookie is initialized but no value, null is returned
			return cookie_value;
			break;
		}
		a_temp_cookie = null;
		cookie_name = '';
	}
	if (!b_cookie_found) {
		return null;
	}
}

function Delete_Cookie(name, path, domain) {
	if (Get_Cookie(name)) document.cookie = name + "=" +
((path) ? ";path=" + path : "") +
((domain) ? ";domain=" + domain : "") +
";expires=Thu, 01-Jan-1970 00:00:01 GMT";
}

function Get_Cookie(name) {

	var start = document.cookie.indexOf(name + "=");
	var len = start + name.length + 1;
	if ((!start) && (name != document.cookie.substring(0, name.length))) {
		return null;
	}
	if (start == -1) return null;
	var end = document.cookie.indexOf(";", len);
	if (end == -1) end = document.cookie.length;
	return unescape(document.cookie.substring(len, end));
}

function IntroCookie(IntroURL)
{
	//Detected Cookie Browser
	var cookieEnabled=(navigator.cookieEnabled)? true : false;
	//if not IE4+ nor NS6+
	if (typeof navigator.cookieEnabled=="undefined" && !cookieEnabled){ 
		document.cookie="checkcookie"
		cookieEnabled=(document.cookie.indexOf("checkcookie")!=-1)? true : false 
	}

	if (cookieEnabled){
		if(!Get_Cookie('IntroMU')){
			//Write Cookie
			Set_Cookie('IntroMU','Intro Actived',5,'/','','');
			window.location.href = IntroURL;
		}
	}
}
function CheckCookie(IntroURL,Value)
{
//Detected Cookie Browser
	var cookieEnabled=(navigator.cookieEnabled)? true : false;
	//if not IE4+ nor NS6+
	if (typeof navigator.cookieEnabled=="undefined" && !cookieEnabled){ 
		document.cookie="checkcookie"
		cookieEnabled=(document.cookie.indexOf("checkcookie")!=-1)? true : false 
	}

	if(!Get_Cookie(Value)){
		//Write Cookie
		Set_Cookie(Value,'Register',5,'/','','');
		window.location.href = IntroURL;
	}
}
var popupStatus = 0;

function IntroPopup(URL, URLImg) {
	var _tran = document.getElementById("backgroundPopup");
	var _popup = document.getElementById("popupIntro");
	//Detected Cookie Browser
	var cookieEnabled = (navigator.cookieEnabled) ? true : false;
	//if not IE4+ nor NS6+
	if (typeof navigator.cookieEnabled == "undefined" && !cookieEnabled) {
		document.cookie = "checkcookie"
		cookieEnabled = (document.cookie.indexOf("checkcookie") != -1) ? true : false
	}

	if (cookieEnabled) {
		if (!Get_Cookie('PopupIntroMU')) {
			//Write Cookie
			var sHTML = '';
			sHTML += '<a href="' + URL + '" target="_blank" onclick="HidePopup();"><img alt="" src="' + URLImg + '" width="450" height="300" border="0" /></a>';
			sHTML += '<div class="popupClose"><a href="javascript:void(-1);" onclick="HidePopup();">Close</a></div>';
			Set_Cookie('PopupIntroMU', 'Popup Intro Actived', 10, '/', '', '');
			_popup.innerHTML= sHTML;
			loadPopup();
			centerPopup();
		}
	}
}

function HidePopup() {
	disablePopup();
}

//loading popup with jQuery magic!
function loadPopup() {
	//loads popup only if it is disabled
	var _tran = document.getElementById("backgroundPopup");
	var _popup = document.getElementById("popupIntro");
	if (popupStatus == 0) {
		_tran.style.display = 'block';
		_popup.style.display = 'block';
		popupStatus = 1;
	}
}

//disabling popup with jQuery magic!
function disablePopup() {
	//disables popup only if it is enabled
	var _tran = document.getElementById("backgroundPopup");
	var _popup = document.getElementById("popupIntro");
	if (popupStatus == 1) {
		_tran.style.display = 'none';
		_popup.style.display = 'none';
		popupStatus = 0;
	}
}

//centering popup
function centerPopup() {
	var _tran = document.getElementById("backgroundPopup");
	var _popup = document.getElementById("popupIntro");
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	//centering
	_popup.style.top = (windowHeight/2- 300/2) + "px";
	_popup.style.left = (windowWidth/2- 450/2) + "px";
	//only need force for IE6
	_tran.style.heigth = windowHeight  + "px";
}

function getScrollTop() {
	var scrOfY = 0;
	if (typeof (window.pageYOffset) == 'number') {
		//Netscape
		scrOfY = window.pageYOffset;
	}
	else if (document.body && (document.body.scrollTop)) {
		//DOM
		scrOfY = document.body.scrollTop;
	}
	else if (document.documentElement && (document.documentElement.scrollTop)) {
		//DOM
		scrOfY = document.documentElement.scrollTop;
	}
	return scrOfY;
}

function getSizeBrowser(size) {
	var mySize = 0;
	if (typeof (window.innerWidth) == 'number') {
		//Non-IE
		if (size == 'width') {
			mySize = window.innerWidth;
		}
		else {
			mySize = window.innerHeight;
		}
	}
	else if (document.documentElement && (document.documentElement.clientWidth || document.documentElement.clientHeight)) {
		//IE 6+
		if (size == 'width') {
			mySize = document.documentElement.clientWidth;
		}
		else {
			mySize = document.documentElement.clientHeight;
		}
	}
	else if (document.body && (document.body.clientWidth || document.body.clientHeight)) {
		//IE 4
		if (size == 'width') {
			mySize = document.body.clientWidth;
		}
		else {
			mySize = document.body.clientHeight;
		}
	}
	return mySize;
}