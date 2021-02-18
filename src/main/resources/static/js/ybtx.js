layui.use(['layer', 'form'], function () {
    var layer = layui.layer;
    var form_base = layui.form;
    form_base.render();
    //基本信息申报类型切换
    form_base.on('radio(apply_type)', function(data){
        if(data.value == '0'){
            $("#applynameLabel").text("申报人");
            $("#idcardtypelabel").text("身份证");
            $("input[name='apply_idcard']").attr('placeholder','请输入身份证号码');
            $("#li_legalman").hide();
        }else if(data.value == '1'){
            $("#applynameLabel").text("申报单位");
            $("#idcardtypelabel").text("统一社会信用代码");
            $("input[name='apply_idcard']").attr('placeholder','请输入统一社会信用代码');
            $("#li_legalman").show();
        }
    });

    var identReg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    var phoneReg = /^1[345678]\d{9}$/;
    form_base.on('submit(baseInfo)',function(data) {
        console.log(data);
        if ($("input[name='apply_type']:checked").val()==="0") {
            if ($("input[name='apply_name']").val()==undefined||$.trim($("input[name='apply_name']").val())=='') {
                layer.msg("请输入申报人姓名", {icon: 2});
                return false;
            }
            if ($("input[name='apply_idcard']").val()==undefined||$.trim($("input[name='apply_idcard']").val())==''||!identReg.test($("input[name='apply_idcard']").val())) {
                layer.msg("请输入正确的身份证号码", {icon: 2});
                return false;
            }
            if ($("input[name='contact_name']").val()==undefined||$.trim($("input[name='contact_name']").val())=='') {
                layer.msg("请输入联系人姓名", {icon: 2});
                return false;
            }if ($("input[name='contact_phone']").val()==undefined||$.trim($("input[name='contact_phone']").val())==''||!phoneReg.test($("input[name='contact_phone']").val())) {
                layer.msg("请输入正确的联系人手机", {icon: 2});
                return false;
            }if ($("input[name='contact_idcard']").val()==undefined||$.trim($("input[name='contact_idcard']").val())==''||!identReg.test($("input[name='contact_idcard']").val())) {
                layer.msg("请输入正确的联系人身份证号码", {icon: 2});
                return false;
            }
        }
        if ($("input[name='apply_type']:checked").val()==="1") {
            if ($("input[name='apply_name']").val()==undefined||$.trim($("input[name='apply_name']").val())=='') {
                layer.msg("请输入申报单位", {icon: 2});
                return false;
            }
            if ($("input[name='apply_idcard']").val()==undefined||$.trim($("input[name='apply_idcard']").val())==''||!identReg.test($("input[name='apply_idcard']").val())) {
                layer.msg("请输入正确的统一社会信用代码", {icon: 2});
                return false;
            }
            if ($("input[name='legalman']").val()==undefined||$.trim($("input[name='legalman']").val())=='') {
                layer.msg("请输入法定代表人", {icon: 2});
                return false;
            }
            if ($("input[name='contact_name']").val()==undefined||$.trim($("input[name='contact_name']").val())=='') {
                layer.msg("请输入联系人姓名", {icon: 2});
                return false;
            }
            if ($("input[name='contact_phone']").val()==undefined||$.trim($("input[name='contact_phone']").val())==''||!phoneReg.test($("input[name='contact_phone']").val())) {
                layer.msg("请输入正确的联系人手机", {icon: 2});
                return false;
            }
            if ($("input[name='contact_idcard']").val()==undefined||$.trim($("input[name='contact_idcard']").val())==''||!identReg.test($("input[name='contact_idcard']").val())) {
                layer.msg("请输入正确的联系人身份证号码", {icon: 2});
                return false;
            }
        }
        var loadIndex = layer.load(1, {
            shade: [0.3, '#ccc']
        });
        $.ajax({
            type: 'POST',
            url: "add_moduleInstance",
            data: data.field,
            dataType:'text',
            success: function (res) {
                layer.close(loadIndex);
                if(res != 'error'){
                    location.href = 'clsc?moduleInstanceId='+res;
                }
            },
            error: function (e) {
                layer.close(loadIndex);
                layer.alert('与服务器通信出错！');
            }
        });

    });


});


window.wordLeg = function (obj) {
    var currleg = $(obj).val().length;
    var length = $(obj).attr('maxlength');
    if (currleg > length) {
        layer.msg('字数请在' + length + '字以内',{icon: 2});
    } else {
        $('.text_count').text(currleg);
    }
}