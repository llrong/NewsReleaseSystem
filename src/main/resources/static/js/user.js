function add() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var email = document.getElementById("email").value;
    var admin = document.getElementById("admin").value;
    if(username == ""){
        alert("用户名为空！")
    } else if(password == ""){
        alert("密码为空！")
    } else if(email == ""){
        alert("邮箱为空！")
    }else {
        $.ajax({
            url: "/user/addUser",       //login是登录接口
            type: 'POST',
            dataType: 'json',
            data: {
                username: username,
                password:password,
                email: email,
                admin: admin
            },
            success: function (result) {
                if (result == 0) {
                    alert("该邮箱已经被注册！")
                } else {
                    alert("添加用户成功！");

                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log('XMLHttpRequest:');
                console.log(XMLHttpRequest);
            }
        });
    }
}


function setadmin(id) {
    var userid = id.value;
    if(userid == 1){
        alert("该用户已经是管理员！")
    }else{
        $.ajax({
            url: "/user/setAdmin",       //login是登录接口
            type: 'POST',
            dataType: 'json',
            data: {
                userid:userid
            },
            success: function (result) {
                if (result == 1) {
                    alert("设置成功！")
                } else {
                    alert("设置失败！");

                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log('XMLHttpRequest:');
                console.log(XMLHttpRequest);
            }
        });
    }

}


function del(id) {
    var userid = id.value;
    console.info(userid);
    $.ajax({
        url: "/user/deleted",
        type: 'POST',
        dataType: 'json',
        data:{
            userid:userid
        },
        success: function (result) {
            if (result == 1) {
                alert("删除此用户成功！");
                window.location.href="/queryUser";
            }
            else {
                alert("删除失败！");
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:');
            console.log(XMLHttpRequest);
        }
    });
}

function sure(id) {
    var userid = id.value;
    var oldpass = document.getElementById("oldpass").value;
    var newpass = document.getElementById("newpass").value;
    var confirm  = document.getElementById("confirm").value;
    console.info(userid);
    if(oldpass == "" || oldpass==null){
        alert("当前密码为空！");
    }else if(newpass == "" || newpass==null){
        alert("当前密码为空！");
    }else if(confirm == "" || confirm==null){
        alert("当前密码为空！");
    }else if(newpass != confirm){
        alert("两次新密码不一致！")
    }
    else{
        $.ajax({
            url: "/user/submitPass",
            type: 'POST',
            dataType: 'json',
            data:{
                userid:userid,
                oldpass:oldpass,
                newpass:newpass,
                confirm:confirm
            },
            success: function (result) {
                if (result == 1) {
                    alert("修改密码成功！");
                }
                else {
                    alert("修改密码失败！");
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log('XMLHttpRequest:');
                console.log(XMLHttpRequest);
            }
        });
    }
}



function info(id) {
    var userid = id.value;
    var username = document.getElementById("username").value;
    var remark = document.getElementById("remark").value;
    console.info(userid);
    if(username == "" || username==null){
        alert("当前用户名为空！");
    }else if(remark == "" || remark==null){
        alert("当前用户名为空！");
    } else{
        $.ajax({
            url: "/user/submitInfo",
            type: 'POST',
            dataType: 'json',
            data:{
                userid:userid,
                username:username,
                remark:remark
            },
            success: function (result) {
                if (result == 1) {
                    alert("修改个人信息成功！");
                }
                else {
                    alert("修改个人信息失败！");
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log('XMLHttpRequest:');
                console.log(XMLHttpRequest);
            }
        });
    }


}
