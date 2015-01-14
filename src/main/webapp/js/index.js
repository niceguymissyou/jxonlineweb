(function(){	  
	new xl.ui.SlideImgs($('#imgBox > a'), $('#imgBox span a'), 'up').start(); 
	var newsTab = new xl.ui.Tabs($('#newsTabs li'), $('#newsBox ul.news_list'),'up');
	newsTab.init('mouseover');
	newsTab.done = function(index){
		var url = '';
		switch(index){
			case 0:
				url = 'http://36ji.xunlei.com/c/1-2-3_1.html';
				break;
			case 1:
				url = 'http://36ji.xunlei.com/c/1_1.html';
				break;
			case 2:
				url = 'http://36ji.xunlei.com/c/2_1.html';
				break;
			case 3:
				url = 'http://36ji.xunlei.com/c/3_1.html';
				break;
		}
		$('#newsBox .more').attr('href',url);
	};
	
	var wjglTab  = new xl.ui.Tabs($('#ziliaoTabs li'), $('#ziliaoBox ul.news_list'),'up');//玩家攻略
	wjglTab.init('mouseover');
	
	var yxjtTab  = new xl.ui.Tabs($('#topBox .tabs li'), $('#topBox .tbl'),'up');//游戏截图
	yxjtTab.init('mouseover');
	
	var bbsTab  = new xl.ui.Tabs($('#bbsTabs div.tabs li'), $('#bbsTabs ul.list'),'up');//bss
	bbsTab.init('mouseover');
	
	function fillServerList(){
		var objServers = document.getElementById('serverRankList');
		if(!objServers)return;
		if(objServers){
			objServers.options.length = 0;
		}
		if(webgameSingleGameServers){
			for(var i=0;i<webgameSingleGameServers.length;i++){
				var od = webgameSingleGameServers[i];
				objServers.options[objServers.options.length] = new Option(od['servername'],od['serverid']);
			}
		}
		$('#topBox select').change(function(){
			$('#topBox .tbl').html('');
			fillTop($(this).val());
		});
	}
	fillServerList();
	
	function fillTop(n){
		if(n == '') return;
		var s = server_rank;
		var limit = 5;
		
		var table = $('<table border="0" width="100%"></table>');
		table.append('<tr><th class="t1">排名</th><th class="t2">人物</th><th class="t3">国家</th><th class="t4">发展分</th><th class="t5">爵位</th></tr>');
		if(s[n]){
			for(var j = 0, obj = s[n]['fazhan']; j < limit; j++){
				table.append('<tr><td>'+Number(j+1)+'</td><td>'+obj[j]["name"]+'</td><td>'+obj[j]["nation_name"]+'</td><td>'+obj[j]["resource_score"]+'</td><td>'+obj[j]["nation_class_name"]+'</td></tr>');
			}
		}
		$('#topBox .tbl').eq(0).append(table);
		
		var table_1 = $('<table border="0" width="100%"></table>');
		table_1.append('<tr><th class="t1">排名</th><th class="t2">人物</th><th class="t3">国家</th><th class="t4">军功</th><th class="t5">爵位</th></tr>');
		if(s[n]){
			for(var j = 0, obj = s[n]['jungong']; j < limit; j++){
				table_1.append('<tr><td>'+Number(j+1)+'</td><td>'+obj[j]["name"]+'</td><td>'+obj[j]["nation_name"]+'</td><td>'+obj[j]["kill_score"]+'</td><td>'+obj[j]["nation_class_name"]+'</td></tr>');
			}
		}
		$('#topBox .tbl').eq(1).append(table_1);
		
		var table_2 = $('<table border="0" width="100%"></table>');
		table_2.append('<tr><th class="t1">排名</th><th class="t2">人物</th><th class="t3">国家</th><th class="t4">威望</th><th class="t5">爵位</th></tr>');
		if(s[n]){
			for(var j = 0, obj = s[n]['weiwang']; j < limit; j++){
				table_2.append('<tr><td>'+Number(j+1)+'</td><td>'+obj[j]["name"]+'</td><td>'+obj[j]["nation_name"]+'</td><td>'+obj[j]["credit"]+'</td><td>'+obj[j]["nation_class_name"]+'</td></tr>');
			}
		}
		$('#topBox .tbl').eq(2).append(table_2);
	}
	fillTop($('#topBox select').val());	
})();
var mjnCount = 0;
function srollMengjiangnv(){
	if(!mengjangnvPic)return;
	if (mengjangnvPic.length>mjnCount){
		jQuery('#mjnpic').attr("src",mengjangnvPic[mjnCount].cutphoto)
		jQuery('#mjnnick').html(mengjangnvPic[mjnCount].rolename);
		jQuery('#mjncountry').html(mengjangnvPic[mjnCount].countryname);
		jQuery('#mjnserver').html(mengjangnvPic[mjnCount].servername);
		mjnCount++;
	}else{
		mjnCount = 0;
	}
}
var mengjiangnvTimer = null;
jQuery.getScript("js/mengjiangnvpic.js",function(){
	mengjiangnvTimer = setInterval("srollMengjiangnv()",3000);
	jQuery(".pic").bind("mouseover",function(){clearInterval(mengjiangnvTimer);});
	jQuery(".pic").bind("mouseout",function(){mengjiangnvTimer = setInterval("srollMengjiangnv()",3000);});
});	
