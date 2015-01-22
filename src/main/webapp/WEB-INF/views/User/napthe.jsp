<%-- 
    Document   : napthe
    Created on : Jan 21, 2015, 4:49:38 PM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>   

<style>
    .alert1 {
    background-color: #def0d8;
    border: 1px solid #468847;
    color: #468847;
    margin-bottom: 20px;
    padding: 8px 35px 8px 14px;
    text-shadow: none;
}
</style>
<div  id="form">
    

    <div id="alert">

      

    </div>


    <table width="100%" border="0" cellpadding="3" cellspacing="3">
         <tr>
            <td align="right" width="40%">
                Tài khoản:
            </td>
            <td >
                <b>${user}</b>
            </td>

        </tr>
         <tr>
            <td align="right" width="40%">
                Số dư:
            </td>
            <td >
                <b>${sodu} xu</b>
            </td>

        </tr>
        <tr>
            <td colspan="2" align="center">
                <h2>Nạp thẻ điện thoại</h2><br>
                 Số xu đươc nạp theo quy tắc : 1 xu = 1000 vnd
                 <br>
            </td>
            
        </tr>
        <tr>
            <td align="right" width="40%">
                Nhà Mạng :
            </td>
            <td>
                <select id="lstTelco" name="lstTelco">
                    <option value="1">Viettel</option>
                    <option value="2">MobiFone</option>
                    <option value="3">Vinaphone</option>
                    <option value="4">Gate</option>
                    <option value="5">Vcoin</option>
                </select>
            </td>
        </tr>
        <tr>

            <td align="right">
                Số Seri :
            </td>
            <td>
                <input type="text" id="txtSeri" name="txtSeri" />
            </td>
        </tr>
        <tr><td align="right">
                Mã số :
            </td>
            <td>
                <input type="text" id="txtCode" name="txtCode" />
            </td>
        </tr>
        <tr>
            <td align="right">

            </td>
            <td>
                <input id ="btnNapThe" type="submit" value="Nạp thẻ" />
            </td>
        </tr>
        
    </table>
</div>
                
<script>
    $(document).ready(function () {
        $("#btnNapThe").click(function(){
             $("#alert").empty();
            $("#alert").removeClass()
            $.post("/tai-khoan/nap-the.html",
            {'lstTelco':$("#lstTelco").val(),
             'txtSeri': $("#txtSeri").val(),
             'txtCode': $("#txtCode").val()
            },function(data){
                if(data){

                     error = {
                    '-3' : "Thẻ không sử dụng được.",
                    '-10': "Nhập sai định dạng thẻ.",
                    '-1001' : "Nhập sai qúa 3 lần.",
                    '-1002' : "Lỗi hệ thống",
                    '-1005' : "Loại thẻ không đúng",
                    '-1006' : "Hệ thống đang bảo trì"
                    }
                    data = $.parseJSON(data)
                    if(data.resultCode >= 10000){
                        
                       var str = "<center><strong>Chúc mừng!</strong> Bạn đã nạp thẻ thành công.</center>"
                       $("#alert").append(str);
                       $("#alert").addClass("alert1 alert-success");
                    }
                    else{
                       var str = "<center><strong>Thất bại!</strong> " +  error[data.resultCode] + "</center>"
                       $("#alert").append(str);
                       $("#alert").addClass("alert alert-error");
                       if(data.resultCode == -1007){
                           window.location.href = "/tai-khoan/nap-the.html";
                       }
                    }
                   
                   
                    
                }
            })
        })
    })
</script>
<jsp:include page="footer.jsp"/>  
