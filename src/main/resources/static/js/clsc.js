layui.use(['form', 'upload'], function () {
    var form = layui.form, upload = layui.upload;
    //执行实例
    upload.render({
        elem: '.uploadbtn',
        url: 'uploadfile',
        exts: 'xls|xlsx|csv|zip|rar|pdf|doc|docx|png|jpeg|jpg|gif',// 设置允许上传的格式
        accept: 'file',
        data: {},
        choose: function (obj) {
            loadIndex = layer.load(1, {
                shade: [0.3, '#ccc']
            });
            obj.preview(function (index, file, result) {
            })
        },
        done: function (res) {
            layer.close(loadIndex);
            var item = this.item;
            if(res.code == 1){
                var materialUnid = $(item).parent().find("input[name='_unid']").val();
                $(item).before('<input type="hidden" name="'+materialUnid+'_upload" value="'+res.unid+'">')

                var html_file = '<div class="sp-div-img">'
                               +'  <span class="sp-filename">'+res.fileName+'</span>'
                               +'  <img src="image/apply/del.png" data-id="'+res.unid+'" class="icon-delete" onclick="delfile(this)"/>'
                               +'</div>';
                $(item).after(html_file);
            }
            form.render();
        },
        error: function () {
            layer.close(loadIndex);
            layer.msg("上传失败！", {icon: 2});
        }
    });


});

function delfile(obj){
    $.ajax({
        type: 'POST',
        url: 'delFile',
        data: {
            fileUnid:$(obj).data("id"),
        },
        dataType: 'json',
        success: function (res) {
            if(res.code===1){
                if ($(obj).parent().hasClass("sp-div-img")) {
                    $(obj).parent().remove();
                }
            }
        },
        error: function (e) {
            layer.msg("与服务器通信出错", {icon: 2});
        }
    });
}

/**
 * 发起并推送办件至一张网审批
 */
function saveAttrStartUp() {

    var loadIndex = layer.load(1, {
        shade: [0.3, '#ccc']
    });
    var data = $("#saFrom").serialize();
    $.ajax({
        type:'post',
        url:'saveAttrStartUp',
        cache: false,
        data:data,  //重点必须为一个变量如：data
        dataType:'text',
        success:function(res){
            layer.close(loadIndex);
            if("success" == res){
                location.href = 'sbgz?moduleInstanceId='+$("input[name='moduleInstanceUnid']").val();
            }else{
                layer.alert('与服务器通信出错！')
            }
            layer.close(loadIndex);
        },
        error:function(){
            layer.close(loadIndex);
            layer.alert('与服务器通信出错！')
        }
    })


}