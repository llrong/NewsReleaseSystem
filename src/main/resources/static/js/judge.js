// function judge(){
//     var num = document.getElementById("num").innerText;
//     console.info(num);
//     if(num == "" || num== null){
//
//         document.getElementById("typemanger").style.display = 'none';
//         document.getElementById("newsmanger").style.display = 'none';
//         document.getElementById("usermanger").style.display = 'none';
//         document.getElementById("logout").style.display = 'none';
//     }else{
//         document.getElementById("login").style.display = 'none';
//         if(num == 0){
//             document.getElementById("typemanger").style.display = 'none';
//             document.getElementById("newsmanger").style.display = 'none';
//             document.getElementById("usermanger").style.display = 'none';
//         }
//     }
//
// }

function menujudge(){
    var num = document.getElementById("num").innerText;
    console.info(num);
       if(num == 1){
            document.getElementById("mynews").style.display = 'none';
            document.getElementById("typemanger").style.display = 'none';
            document.getElementById("newsmanger").style.display = 'none';
            document.getElementById("usermanger").style.display = 'none';
           document.getElementById("uncheck").style.display = 'none';
        }
}


function userjudge(){
    var num = document.getElementById("num").innerText;
    console.info(num);
    if(num != 3  ){
        document.getElementById("admin").style.display = 'none';

    }
}

function adminjudge(){
    var num = document.getElementById("num").innerText;
    console.info(num);
    if(num != 3  ){
        document.getElementById("setadmin").style.display = 'none';

    }
}
function out() {
        $.ajax({
            url: "/first/logout",
            type: 'get',
            success: function (result) {
                if (result == 1) {
                   alert("登出成功！");
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



function guide(name)  {
    var key = document.getElementById("key").value;
    console.info(key);
    $.ajax({
        url: "/search",
        type: 'POST',
        dataType: 'json',
        data:{
            key:key
        },
        success: function (result) {
            if (result == 1) {
                window.location.href="/guide";
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:');
            console.log(XMLHttpRequest);
        }
    });
}


// function search()  {
//     var key = document.getElementById("key").value;
//     console.info(key);
//     $.ajax({
//         url: "/search",
//         type: 'POST',
//         // dataType: 'json',
//         data:{
//             key:key
//         },
//         success: function (data) {
//             console.info("ccc");
//             // if (result == 1) {
//             // }
//         },
//         error: function (XMLHttpRequest, textStatus, errorThrown,data) {
//             console.log('XMLHttpRequest:');
//             console.log(XMLHttpRequestUpload);
//             console.log(textStatus);
//             console.info(data);
//         }
//     });
// }
