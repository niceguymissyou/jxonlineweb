var thapthanh_captcha = {
    getCaptcha: function(){
        var ts = new Date().getTime();
        $("#captcha_img").attr("src", "/captcha/generate?" + ts);  
        $("#captcha_img").show();      
        return false;    
    },
}