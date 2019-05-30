function del(Obj) {
    var $td = $(Obj).parents('tr').children('td');
    var id = $td.eq(0).text();
    console.info(id);
    $.ajax({
        url: "/newstype/deleted/"+id,
        type: 'POST',
        dataType: 'json',
        success: function (result) {
            if (result == 1) {
                alert("删除新闻类型成功！");
                window.location.href="/queryNewsType";
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
                    window.location.href="/queryNewsType";
                }else{
                    alert("请先点击修改按钮！");
                    window.location.href="/queryNewsType";
                }

                uptype.value="";
                document.getElementById("upform").style.display="none";
                document.getElementById("edit").disabled = false;
                window.location.reload();

            }
        });
    }

}


