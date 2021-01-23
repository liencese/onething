//验证联系人证件号码
Validation.add('idcard', function (v) {
    var reg = /^[1-9][0-9]{14}$|^[1-9][0-9]{16}([0-9]|[xX])$/;
    if (!reg.test(v)) {
        return false;
    }
    return true;
});

//验证组织机构代码
Validation.add('orgcode', function (v) {
    var reg = /^[0-9a-zA-Z]{9}$/g;
    if (!reg.test(v)) {
        return false;
    }
    return true;
});

//验证联系电话
Validation.add('phone', function (v) {
    var reg = /(^1[3|5|7|8]\d{9}$)/;
    if (reg.test(v)) {
        return true;
    }
    reg = /^((\+?[0-9]{2,4}\-[0-9]{3,4}\-)|([0-9]{3,4}\-))?([0-9]{7,8})(\-[0-9]+)?$/;
    if (reg.test(v)) {
        return true;
    }
    return false;
});

//验证邮编
Validation.add('postcode', function (v) {
    var reg = /^[0-9][0-9]{5}$/;
    if (!reg.test(v)) {
        return false;
    }
    return true;
});

//验证数字
Validation.add('number', function (v) {
    if (isNaN(v)) {
        return false;
    }
    return true;
});

//验证正整数
Validation.add('digits', function (v) {
    var reg = /^\+?[1-9][0-9]*$/;
    if (!reg.test(v) && 0 != v) {
        return false;
    }
    return true;
});

//验证特殊字符
Validation.add('special', function (v) {
    // 去除了_字符的限制
    var regEn = /[`~!@#$%^&*+<>?:"{}\/;'[\]]/im,
        regCn = /[！#￥——：；“”‘|《。》？【】[\]]/im;
    if (regEn.test(v) || regCn.test(v)) {
        return false;
    }
    return true;
});

//验证url特殊字符
Validation.add('specialUrl', function (v) {
    // 去除了_字符的限制
    var regEn = /[`~!@#$%^&*+<>?:"{};'[\]]/im,
        regCn = /[！#￥——：；“”‘|《。》？【】[\]]/im;
    if (regEn.test(v) || regCn.test(v)) {
        return false;
    }
    return true;
});

//验证金额
Validation.add('money', function (v) {
    var reg = /^([+]?)((\d{1,3}(,\d{3})*)|(\d+))(\.\d{2})?$/;
    if (!reg.test(v)) {
        return false;
    }
    return true;
});

//验证下拉选选中的值大于0
Validation.add('select', function (v) {
    if (v<=0) {
        return false;
    }
    return true;
});
//验证下拉选选中的值大于0
Validation.add('select-', function (v) {
    if (v<0) {
        return false;
    }
    return true;
});

//验证>=0且可以有两位小数
Validation.add('specNumber', function (v) {
    var reg = /^(0|[1-9]\d*)(\s|$|\.\d{1,2}\b)/;
    if (!reg.test(v)) {
        return false;
    }
    return true;
});
