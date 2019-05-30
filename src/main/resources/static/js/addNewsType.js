function tijiao() {
    var newstype = document.getElementById("newstype").value;
    $.ajax({
        url:"/newstype/addNewsType",       //login是登录接口
        type: 'POST',
        dataType: 'json',
        data:{
            newstype:newstype
        },
        success: function (result) {
            if (result == 1) {
                alert("添加新闻类型成功！");
            }else if(result == 2){
                alert("此新闻类型已经存在！")
            }else if(result == 3){
                alert("新闻类型名称为空！")
            }
            else{
                alert("添加失败");
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:');
            console.log(XMLHttpRequest);
        }
    });
}