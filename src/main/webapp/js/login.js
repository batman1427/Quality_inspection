function check(form) {
             if($("#username").val()=="") {
                 document.getElementById('tip').innerHTML = "用户名不能为空！";
                 form.username.focus();
                 return false;
             } else if($("#password").val()=="") {
                 document.getElementById('tip').innerHTML = "密码不能为空！";
                 form.password.focus();
                 return false;
             } else {
            	 var username = $("#username").val();  
            	 var password = $("#password").val(); 
                 $.ajax({  
                     type:"POST",   //http请求方式  
                     url:"Authentication", //发送给服务器的url  
                     data:{"username":username,"password":password}, //发送给服务器的参数 
                     dataType:"json",  //告诉JQUERY返回的数据格式(注意此处数据格式一定要与提交的controller返回的数据格式一致,不然不会调用回调函数complete)  
                     success:function(data) {  
                    	if(data.code==0){
                    		 document.getElementById('tip').innerHTML = "用户名或密码错误！";
                    	}else{
                    		 window.location.href = "dashboard";
                    	}
                     }//定义交互完成,并且服务器正确返回数据时调用回调函数   
                 });  
                 return false;
             }
}
