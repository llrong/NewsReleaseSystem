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
            }
            window.location.reload();
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:');
            console.log(XMLHttpRequest);
        }
    });
}




function timestampToTime(timestamp) {
    var date = new Date(timestamp * 1000); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
    Y = date.getFullYear() + '-';
    M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    D = change(date.getDate()) + ' ';
    h = change(date.getHours()) + ':';
    m = change(date.getMinutes()) + ':';
    s = change(date.getSeconds());
    return Y + M + D + h + m + s;
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