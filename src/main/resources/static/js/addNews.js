// $("#tijiao").click(function(){
//     var title = document.getElementById("title").value;
//     var content = document.getElementById("content").value;
//     if(title == ""){
//         alert("新闻标题为空！");
//     }else if (content == ""){
//         alert("新闻内容为空！");
//     }else{
//         $.ajax({
//             url: "/news/addNews",       //login是登录接口
//             type: 'GET',
//             success: function (result) {
//                 if (result == 0) {
//                     alert("您尚未登录！")
//                 } else {
//                     if (result == 1) {
//                         alert("添加新闻成功！");
//                     } else {
//                         alert("新闻类型不存在！");
//                     }
//                 }
//             },
//             error: function (XMLHttpRequest, textStatus, errorThrown) {
//                 console.log('XMLHttpRequest:');
//                 console.log(XMLHttpRequest);
//             }
//         });
//     }
//
// })

//
// $("#baocun").click(function(){
//     var title = document.getElementById("title").value;
//     var content = document.getElementById("content").value;
//     var digest = document.getElementById("digest").value;
//     var type = document.getElementById("type").value;
//     if(title == ""){
//         alert("新闻标题为空！");
//     }else if (content == ""){
//         alert("新闻内容为空！");
//     }else {
//         $.ajax({
//             url: "/news/baocun",       //login是登录接口
//             type: 'post',
//             dataType: 'json',
//             data: {
//                 title:title,
//                 content:content,
//                 type:type,
//                 digest:digest
//             },
//             success: function (result) {
//                 if (result == 0) {
//                     alert("您尚未登录！")
//                 } else {
//                     if (result == 1) {
//                         alert("添加新闻成功！");
//                     } else {
//                         alert("新闻类型不存在！");
//                     }
//                 }
//             },
//             error: function (XMLHttpRequest, textStatus, errorThrown) {
//                 console.log('XMLHttpRequest:');
//                 console.log(XMLHttpRequest);
//             }
//         });
//     }
// })


function getTypes() {
    $.ajax({
        url:"/newstype/getTypes",       //login是登录接口
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            var arr=data.list;
            for(var i=0;i<data.list.length;i++){
                var name=arr[i].typeName;
                console.info(name);
                $('#type').append("<option th:text="+name+">"+name+"</option>");  //未识别
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:');
            console.log(XMLHttpRequest);
        }
    });

}