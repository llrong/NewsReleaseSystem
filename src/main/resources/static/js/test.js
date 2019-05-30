function tijiao() {
    var newsType = document.getElementById("newsType").value;
    if (newsType == "") {
        alert("请输入新闻类型名称！");
        return false;
    }
    $.ajax({
        type:"post",
    url:"/news/addNewsType",
    data:{newdType:newsType },
    datatype:"json",
    success:function(data){
        if(data.result == "success"){
            alert("添加新闻类型成功！")
        }
    }
})
}




    <!--function foo(form) {-->
    <!--if (myform.title.value == "") {-->
    <!--alert('请填写你的新闻标题');-->
    <!--myform.title.focus();-->
    <!--return false;-->
    <!--}-->
    <!--if (myform.content.value == "") {-->
    <!--alert('新闻内容不能为空哦');-->
    <!--myform.content.focus();-->
    <!--return false;-->
    <!--}-->
    <!--}-->

