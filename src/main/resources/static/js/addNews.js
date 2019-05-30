function tijiao() {
    var title = document.getElementById("title").value;
    var digest = document.getElementById("digest").value;
    var type = document.getElementById("type").value;
    var content = document.getElementById("content").value;
    if(title == ""){
        alert("新闻标题为空！")
    } else if(type == ""){
        alert("请选择新闻类型！")
    } else if(content == ""){
        alert("新闻内容不能为空！")
    }else {
        $.ajax({
            url: "/news/addNews",       //login是登录接口
            type: 'POST',
            dataType: 'json',
            data: {
                title: title,
                digest: digest,
                type: type,
                content: content
            },
            success: function (result) {
                if (result == 0) {
                    alert("您尚未登录！")

                } else {
                    if (result == 1) {
                        alert("添加新闻成功！");
                    } else {
                        alert("新闻类型不存在！");
                    }
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log('XMLHttpRequest:');
                console.log(XMLHttpRequest);
            }
        });
    }
}



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