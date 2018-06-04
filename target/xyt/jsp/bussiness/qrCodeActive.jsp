<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>二维码激活数统计</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script src="/js/echarts.min.js"></script>
    <script src="/js/plugin/My97DatePicker/WdatePicker.js"></script>
    <script src="/js/bussiness/qrCodeActive.js"></script>
    <style type="text/css">
        .Wdate{
            width: 160px;
            height:35px;
        }
    </style>
</head>

<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="javascript:void(0);">运营管理</a></li>
        <li><a href="javascript:void(0);">二维码激活数统计</a></li>
    </ul>
</div>

<div class="rightinfo">
    <div>
        <input name="currentPage" id="currentPage" value="" hidden="hidden">
        <div class="tools">
            <ul class="seachform">
                <li><label>开始日期</label><input type="text" class="Wdate" id="startTime" value="${startTime}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endTime\')}'})"/> </li>
                <li><label>结束如期</label><input type="text" class="Wdate" id="endTime" value="${endTime}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',minDate:'#F{$dp.$D(\'startTime\')}'})"/></li>
                <li>
                    <label>&nbsp;</label><input type="button" class="scbtn" value="查询" onclick="queryData()"/>
                    <i style="color: red" id="notice"></i>
                </li>
            </ul>
        </div>
    </div>

    <div id="main" style="height:480px;"></div>
</div>

</body>
</html>
