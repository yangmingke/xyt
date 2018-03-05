<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>修改密码</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="/js/jquery.js"></script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="javascript:void(0);">管理员中心</a></li>
        <li><a href="javascript:void(0);">修改密码</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <ul class="forminfo">
        <li><label>管理员账号 </label><input value="${adminSession.email}" class="dfinput" readonly="readonly"/></li>
        <li><label>原始密码</label><input id="oldPwd" type="password" class="dfinput"/></li>
        <li><label>新密码</label><input id="newPwd" type="password" class="dfinput"/></li>
        <li><label>确认新密码</label><input id="comfirmPwd" type="password" class="dfinput"/></li>
        <li><label>&nbsp;</label><input ONCLICK="changePwd()" type="button" class="btn" value="确认保存"/><i id="note"
                                                                                                         style="color: red"></i>
        </li>
    </ul>
</div>
</body>
<script>
    function changePwd() {
        var oldPwd = $('#oldPwd').val();
        var newPwd = $('#newPwd').val();
        var comfirmPwd = $('#comfirmPwd').val();
        if (oldPwd == "") {
            $("#note").text("原始密码不能为空");
            return;
        }
        if (newPwd.length < 5 || newPwd.length > 20) {
            $("#note").text("新密码不能小于5位或者大于20位");
            return;
        }
        if (newPwd != comfirmPwd) {
            $("#note").text("两次输入的密码不一致");
            return;
        }
        $.ajax({
            url: "/userController/changePwd",
            data: {
                "newPwd": newPwd,
                "oldPwd": oldPwd
            },
            type: "post",
            success: function (data) {
                if (data == "success") {
                    alert("修改成功！");
                    window.location = "/jsp/adminCenter/changePwd.jsp";
                }
                $("#note").text("当前密码错误，修改失败!");
            }
        });
    }
</script>
</html>
