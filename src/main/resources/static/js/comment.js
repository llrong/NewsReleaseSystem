function say(nid)  {
    var id= nid.value;
    var yourcom = document.getElementById("yourcom").value;
    console.info(yourcom);
    console.info(id);
        $.ajax({
        url: "/comment/add",
        type: 'POST',
        dataType: 'json',
        data:{
            id:id,
            yourcom:yourcom
        },
        success: function (result) {
            if (result == 1) {
                alert("发表成功！")
            }else if(result == 1){
                alert("评论内容为空！")
            } else{
                alert("您尚未登录！")
            }
            window.location.reload();
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:');
            console.log(XMLHttpRequest);
        }
    });
}


function del(id) {
    var cid = id.value;
    console.info(cid);
    $.ajax({
        url: "/comment/deleted",
        type: 'POST',
        dataType: 'json',
        data:{
            cid:cid
        },
        success: function (result) {
            if (result == 1) {
                alert("删除评论成功！");
            }else{
                alert("删除评论失败！");
            }
            window.location.reload();
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:');
            console.log(XMLHttpRequest);
        }
    });
}