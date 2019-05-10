<script>
$(document).ready(function(){
    $("#button_1").click(function(){
        $.ajax({
            type:"POST",
            url:"http://localhost:8080/index/test",
            dataType:"json", //预期服务器返回数据的类型
            success:function(data){
//                        window.location.href='test.html'
                alert(data)
            },
            error:function(jqXHR){
//                    aler("发生错误："+ jqXHR.status);
            }
        });
    });
});
</script>