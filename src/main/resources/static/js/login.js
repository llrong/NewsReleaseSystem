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
            else if(result == 2){
                alert("有资料填写为空！");
            } else if(result == 3){
                alert("密码长度小于6");
            }else{
                alert("两次密码长度不一致");
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:');
            console.log(XMLHttpRequest);
        }
    });
}


