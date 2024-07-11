function check() {
    if (form.id.value == "") {
        alert("用户编号不能为空！");
        form.id.focus();
        return false;
    }
    var regm = /^s[0-9][0-9]$/;
    if (form.id.value != "" && !form.id.value.match(regm)) {
        alert("用户编号格式不对，检查后请以s00的形式重新输入！");
        form.id.focus();
        return false;
    }
    if (form.name.value == "") {
        alert("用户名不能为空 ！");
        form.name.focus();
        return false;
    }
    if (form.password.value == "") {
        alert("请输入密码 ！");
        form.password.focus();
        return false;
    }
    if (form.password2.value == "") {
        alert("请再次输入密码 ！");
        form.password2.focus();
        return false;
    }
    if (form.password.value != form.password2.value) {
        alert("两次输入的密码不一致 ！");
        form.password2.focus();
        return false;
    }
}