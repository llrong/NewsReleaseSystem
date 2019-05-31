function del(id) {
    var newsid = id.value;
    console.info("news"+newsid);
    $.ajax({
        url: "/news/deleted",
        type: 'POST',
        dataType: 'json',
        data:{
            newsid:newsid
        },
        success: function (result) {
            if (result == 1) {
                alert("删除新闻成功！");
                window.location.href="/querynews";
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:');
            console.log(XMLHttpRequest);
        }
    });
}


// function check(id) {
//     var newsid = id.value;
//     console.info("news"+newsid);
//     $.ajax({
//         url: "/news/check",
//         type: 'POST',
//         data:{
//             newsid:newsid
//         },
//         error: function (XMLHttpResponse, textStatus, errorThrown) {
//             console.log("1 异步调用返回失败,XMLHttpResponse.readyState:"+XMLHttpResponse.readyState);
//             console.log("2 异步调用返回失败,XMLHttpResponse.status:"+XMLHttpResponse.status);
//             console.log("3 异步调用返回失败,textStatus:"+textStatus);
//             console.log("4 异步调用返回失败,errorThrown:"+errorThrown);
//         }
//     });
// }