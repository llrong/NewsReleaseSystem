function check(form) {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    console.info(email);
    apos = email.indexOf("@")
    dotpos = email.lastIndexOf(".")
    if (email == "" && password == "") {
        alert("请输入邮箱和密码！");
        return false;
    } else if (email == "") {
        alert("请输入邮箱！");
        return false;
    } else if (password == "") {
        alert("请输入密码！");
        return false;
    } else if (apos < 1 || dotpos - apos < 2) {
        alert("邮箱格式不正确！")
        return false;
    } else if (password.length < 6) {
        alert("密码长度小于6！")
        return false;
    } else {
        return true;
    }
}