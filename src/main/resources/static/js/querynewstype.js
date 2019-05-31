function del(id) {
    console.info(id);
    $.ajax({
        url: "/newstype/deleted/"+id,
        type: 'POST',
        dataType: 'json',
        success: function (result) {
            if (result == 1) {
                alert("删除新闻类型成功！");
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log('XMLHttpRequest:');
            console.log(XMLHttpRequest);
        }
    });
}

function sumbit(id){
    var uptype=document.getElementById("uptype");
    if(uptype == null || uptype==""){
        alert("请先点击修改按钮！")
    }else{
        $.ajax({
            type:"POST",
            dataType:'text',
            url:"/newstype/updated",
            data:{
                id:id.value,
                uptype:uptype.value
            },
            success:function(result){
                if (result == 1) {
                    alert("修改新闻类型成功！");
                }else{
                    alert("请先点击修改按钮！");
                }

                uptype.value="";
                document.getElementById("upform").style.display="none";
                document.getElementById("edit").disabled = false;
                window.location.reload();

            }
        });
    }

}


