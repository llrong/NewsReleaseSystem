function check(form) {
        var username = document.getElementsByName("username").value;
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;
        var confirm = document.getElementsByName("confirm").value;
        apos=email.indexOf("@")
        dotpos=email.lastIndexOf(".")
        if(email == "" && password=="" && username=="" && confirm==""){
            alert("请输入注册内容！");
            return false;
        } else if(username=="") {
            alert("请输入用户名！");
            return false;
        }else if(email=="") {
            alert("请输入邮箱！");
            return false;
        } else if(password=="") {
            alert("请输入密码！");
            return false;
        }else if(confirm=="") {
            alert("请输入确认密码！");
            return false;
        }else if(apos<1||dotpos-apos<2){
            alert("邮箱格式不正确！")
            return false;
        } else if(password.length < 6){
            alert("密码长度小于6！")
            return false;
        } else if(password == confirm){
            alert("两次密码不一致，请重新输入！")
            return false;
        }else {
            return true;
        }
    }