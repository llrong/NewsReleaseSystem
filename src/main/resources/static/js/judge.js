function judge(){
    var num = document.getElementById("num").innerText;
    console.info(num);
    if(num == "" || num== null){
        document.getElementById("newsmanger").style.display = 'none';
        document.getElementById("usermanger").style.display = 'none';
        document.getElementById("logout").style.display = 'none';
    }else{
        document.getElementById("login").style.display = 'none';
        if(num == 0){
            document.getElementById("newsmanger").style.display = 'none';
            document.getElementById("usermanger").style.display = 'none';
        }
    }

}


function out() {
        $.ajax({
            url: "/first/logout",
            type: 'get',
            success: function (result) {
                if (result == 1) {
                    confirm("登出成功！");
                    window.location.href = '/index';
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log('XMLHttpRequest:');
                console.log(XMLHttpRequest);
            }
        });

}


function menu() {
    var num = document.getElementById("num").innerText;
    if(num == "" || num== null){
        alert("您尚未登录！")
        return false;
    }


}


// function out() {
//     var mymessage = confirm("确认登出？");
//     if (mymessage == true) {
//         $.ajax({
//             url: "/first/logout",
//             type: 'get',
//             success: function (result) {
//                 if (result == 1) {
//                     confirm("登出成功！");
//                     window.location.href = '/index';
//                 }
//             },
//             error: function (XMLHttpRequest, textStatus, errorThrown) {
//                 console.log('XMLHttpRequest:');
//                 console.log(XMLHttpRequest);
//             }
//         });
//     }else{
//
//     }
//
// }

