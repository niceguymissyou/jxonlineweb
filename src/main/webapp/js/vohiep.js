var vohiep_captcha = {
    getCaptcha: function(){
        var ts = new Date().getTime();
        $("#captcha_img").attr("src", "/captcha/generate?" + ts );  
        $("#captcha_img").show();      
        return false;    
    }
}

var vohiep_gift = {
		isCheck : false,
		getTreasure: function(type){
			if(this.isCheck)
				return false;
			
			$.ajax({
				type : 'POST',
				url : '/gift/index',
				data: 'type=' + type,
				beforeSend: function(req){
					this.isCheck = true;
			    },
				success: function(data,status){
			    	$("#getTreasure").text(data);
					this.isCheck = false;
				}
			});
		}
	};


var vohiep_cashin = {
	isCheck : false,
	checkAccount: function(){
		if(this.isCheck)
			return false;
		account = $("#account").val();
		$.ajax({
			type : 'POST',
			url : '/server/checkaccount',
			data: 'account=' + encodeURI(account),
			beforeSend: function(req){
				this.isCheck = true;
		    },
			success: function(data,status){
				if(data == 1){
					$("#checkAccount_error").hide();
					$("#checkAccount_success").show();
				}else{
					$("#checkAccount_error").show();
					$("#checkAccount_success").hide();
				}
				this.isCheck = false;
			}
		});
	},

	checkValid: function (){
		//reset
		$('#checkAccount_error').hide();
		$('#check_repeat_password').hide();
		$('#check_server').hide();
		$('#check_seri').hide();
		$('#check_code').hide();
		isValid = true;
		if( document.cashin.account.value.trim() == ''){
			isValid = false;
			$('#checkAccount_error').show();
		}
		if(document.cashin.account.value != document.cashin.repeat_account.value){
			isValid = false;
			$('#check_repeat_password').show();
		}
		
		if( document.cashin.server.value == ''){
			isValid = false;
			$('#check_server').show();
		}
		
		if( document.cashin.seri.value == ''){
			isValid = false;
			$('#check_seri').show();
		}
		
		if( document.cashin.code.value == ''){
			isValid = false;
			$('#check_code').show();
		}
		
		if(!isValid)
			return false;
		document.cashin.submit();
	}
		
}
