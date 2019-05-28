function check(form) {
    console.info("hhhh");
    var newsType = document.getElementById("newsType").value;
    if (newsType == "") {
        alert("请输入新闻类型名称！");
        return false;
    }
}