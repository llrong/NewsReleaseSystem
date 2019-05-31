function jump() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    $.ajax({

        url: "/first/login",        //login是登录接口
        type: 'POST',
        dataType: 'json',
        data: {
            email:email,
            password:password,
        },
        success: function (result) {
            if (result == 1) {
                alert("登录成功！");
                window.location.href='/index';
            } else if(result == 2){
                alert("此邮箱尚未注册！");
                window.location.href='/register';
            }
            else if(result == 0){
                alert("邮箱或者密码为空！");
            } else{
                alert("账号或密码不正确");
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:');
            console.log(XMLHttpRequest);
        }
    });
}


function reg() {
    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var confirm  = document.getElementById("confirm").value;
    if(email==""){
        alert("请填写邮箱！")
    }
    else if(username==""){
        alert("请填写用户名！")
    }
    else if(password==""){
        alert("请填写密码！")
    }
    else if(confirm==""){
        alert("请填写确认密码！")
    }else if (password.length() < 6){
        result = 3;    //密码长度小于6
    } else if(!password.equals(confirm)){   //数据库中查询到的密码跟前端获取到的对比
        result = 4;     //两次密码长度不一致
    }else{
        $.ajax({

            url: "/first/register",
            type: 'POST',
            dataType: 'json',
            data: {
                username:username,
                email:email,
                password:password,
                confirm:confirm
            },
            success: function (result) {
                if (result == 1) {
                    alert("注册成功，请登录！");
                    window.location.href='/login';
                } else if(result == 0){
                    alert("此邮箱已被注册！");
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log('XMLHttpRequest:');
                console.log(XMLHttpRequest);
            }
        });
    }

}


