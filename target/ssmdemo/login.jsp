<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/2/28
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎登录信游通管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function(){
            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            $(window).resize(function(){
                $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            })
        });
    </script>s
</head>
<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



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
            <li><input name="" type="text" class="loginuser" value="" placeholder="账号"/></li>
            <li><input name="" type="password" class="loginpwd" placeholder="密码" /></li>
            <li><input style="margin-left: 90px" type="button" class="loginbtn" value="登录"  onclick="javascript:window.location='main.html'" /></li>
        </ul>


    </div>

</div>



<div class="loginbm"></div>
</body>
</html>
