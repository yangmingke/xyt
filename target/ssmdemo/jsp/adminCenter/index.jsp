<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>首页</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/jquery.js"></script>

</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="javascript:void(0);">首页</a></li>
    </ul>
</div>

<div class="mainindex">
    <div class="welinfo">
        <span><img src="/images/sun.png" alt="天气"/></span>
        <b>Admin早上好，欢迎使用信息管理系统</b>
    </div>

    <div class="xline"></div>
    <div style="padding:10% 0 0 36%;white-space:nowrap;  ">
        <div class="welinfo" style="width:40%;">
            <label style="font-size: 12px;">管理员Sid：${adminSession.sid}</label>
        </div>

        <div class="welinfo" style="width:40%;">
            <label style="font-size: 12px;">管理员Token：${adminSession.token}</label>
        </div>

        <div class="welinfo" style="width:40%;">
            <label style="font-size: 12px">管理员账号：${adminSession.email}</label>
        </div>

        <div class="welinfo" style="width:40%;">
            <label style="font-size: 12px">管理员名称：信游通系统管理员</label>
        </div>
    </div>
</div>
</body>
</html>
