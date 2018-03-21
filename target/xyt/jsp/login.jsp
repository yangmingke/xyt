<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎登录信游通管理系统</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="../js/jquery.js"></script>
    <script src="../js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });
    </script>
    s
</head>
<body style="background-color:#1c77ac; background-image:url(../images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;"
      onkeyup="if (event.keyCode==13) {login()}">
<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>
<div class="logintop">
    <span>欢迎登录信游通管理系统</span>
    <ul>

    </ul>
</div>
<div class="loginbody">
    <span class="systemlogo"></span>
    <div class="loginbox">
        <ul>
            <li><input type="text" class="loginuser" id="user" placeholder="账号"/></li>
            <li><input type="password" class="loginpwd" id="pwd" placeholder="密码"/></li>
            <li>
                <input style="margin-left: 90px" type="button" class="loginbtn" value="登录" onclick="login()"/>
                <span class="login_form_warn" style="color: red;"></span>
            </li>
        </ul>
    </div>
</div>
<div class="loginbm"></div>
</body>
<script>
    function login() {
        var username = $("#user").val();
        var password = $("#pwd").val();
        if (username != null && username != "" && password != null && password != "") {
            $.ajax({
                url: "/userController/login",
                data: {
                    "username": username,
                    "password": password
                },
                type: "post",
                success: function (data) {
                    if (data == "success") {
                        window.location = '/jsp/main.jsp';
                    }
                    if (data == "false") {
                        $(".login_form_warn").text("用户名或密码错误");
                    }
                }
            });
        } else {
            $(".login_form_warn").text("用户名/密码/验证码均不能为空");
        }
    }
</script>
</html>
