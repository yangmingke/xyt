<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>左侧导航</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="/js/jquery.js"></script>

    <script type="text/javascript">
        $(function () {
            //导航切换
            $(".menuson li").click(function () {
                $(".menuson li.active").removeClass("active")
                $(this).addClass("active");
            });

            $('.title').click(function () {
                var $ul = $(this).next('ul');
                $('dd').find('ul').slideUp();
                if ($ul.is(':visible')) {
                    $(this).next('ul').slideUp();
                } else {
                    $(this).next('ul').slideDown();
                }
            });
        })
    </script>


</head>

<body style="background:#f0f9fd;">


<dl class="leftmenu">

    <dd>
        <div class="title">
            <span><img src="/images/leftico01.png"/></span>管理员中心
        </div>
        <ul class="menuson">
            <li class="active"><cite></cite><a href="/jsp/adminCenter/index.jsp" target="rightFrame">管理员资料</a><i></i></li>
            <li><cite></cite><a href="/jsp/adminCenter/changePwd.jsp" target="rightFrame">修改密码</a><i></i></li>
            <%--<li><cite></cite><a href="/jsp/bussiness/bindingCounter.jsp" target="rightFrame">首页模版</a><i></i></li>
            <li><cite></cite><a href="/right.html" target="rightFrame">数据列表</a><i></i></li>
            <li><cite></cite><a href="/imgtable.html" target="rightFrame">图片数据表</a><i></i></li>
            <li><cite></cite><a href="/form.html" target="rightFrame">添加编辑</a><i></i></li>
            <li><cite></cite><a href="/imglist.html" target="rightFrame">图片列表</a><i></i></li>
            <li><cite></cite><a href="/imglist1.html" target="rightFrame">自定义</a><i></i></li>
            <li><cite></cite><a href="/tools.html" target="rightFrame">常用工具</a><i></i></li>
            <li><cite></cite><a href="/filelist.html" target="rightFrame">信息管理</a><i></i></li>
            <li><cite></cite><a href="/tab.html" target="rightFrame">Tab页</a><i></i></li>--%>
        </ul>
    </dd>


    <dd>
        <div class="title">
            <span><img src="/images/leftico02.png"/></span>运维管理
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="/numberPoolController/queryNumberPool" target="rightFrame">号码池</a><i></i></li>
            <li><cite></cite><a href="/qrcodeController/queryQrCodeList" target="rightFrame">二维码管理</a><i></i></li>
            <%--<li><cite></cite><a href="/bindingController/queryNumberBinding" target="rightFrame">号码绑定关系</a><i></i></li>--%>
        </ul>
    </dd>


    <dd>
        <div class="title"><span><img src="/images/leftico03.png"/></span>运营管理</div>
        <ul class="menuson">
            <li><cite></cite><a href="/qrCodeCounterController/queryQrCodeCounterPage" target="rightFrame">扫码次数统计</a><i></i></li>
            <li><cite></cite><a href="/qrCodeCounterController/queryQrCodeCallPage" target="rightFrame">扫码通话量统计</a><i></i></li>
            <li><cite></cite><a href="/qrCodeCounterController/queryQrCodeActivePage" target="rightFrame">二维码激活数统计</a><i></i></li>
            <li><cite></cite><a href="/orderController/queryOrderList" target="rightFrame">订单管理</a><i></i></li>
            <%--<li><cite></cite><a href="/bindingCounterController/queryBindingCounterPage" target="rightFrame">号码绑定次数统计</a><i></i></li>
            <li><cite></cite><a href="/roamingCounterController/queryRoamingCounterPage" target="rightFrame">漫游通话量统计</a><i></i></li>--%>
        </ul>
    </dd>


    <dd>
        <div class="title"><span><img src="/images/leftico04.png"/></span>财务管理</div>
        <%--<ul class="menuson">
            <li><cite></cite><a href="/rechargeController/queryRechargeStatisticsPage" target="rightFrame">充值统计</a><i></i></li>
        </ul>--%>

    </dd>

</dl>
</body>
</html>
