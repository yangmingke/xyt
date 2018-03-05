<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>号码池</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });

        });
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="javascript:void(0);">运维管理</a></li>
        <li><a href="javascript:void(0);">号码池</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">
            <li class="click"><span><img src="/images/t01.png" /></span>添加</li>
            <li class="click"><span><img src="/images/t02.png" /></span>修改</li>
            <li><span><img src="/images/t03.png" /></span>删除</li>
            <li><span><img src="/images/t04.png" /></span>统计</li>
        </ul>

    </div>


    <table class="tablelist">
        <thead>
        <tr>
            <th>编号</th>
            <th>地区</th>
            <th>号码</th>
            <th>运营商</th>
            <th>复用</th>
            <th>引用次数</th>
            <th>类型</th>
            <th>状态</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>20130908</td>
            <td>王金平幕僚：马英九声明字字见血 人活着没意思</td>
            <td>admin</td>
            <td>江苏南京</td>
            <td>2013-09-09 15:05</td>
            <td>已审核</td>
            <td>已审核</td>
            <td>已审核</td>
            <td>已审核</td>
            <td><a href="#" class="tablelink">修改</a>     <a href="#" class="tablelink"> 删除</a></td>
        </tr>

        <tr>
            <td>20130907</td>
            <td>温州19名小学生中毒流鼻血续：周边部分企业关停</td>
            <td></td>
            <td>山东济南</td>
            <td>2013-09-08 14:02</td>
            <td>未审核</td>
            <td>已审核</td>
            <td>已审核</td>
            <td>已审核</td>
            <td><a href="#" class="tablelink">修改</a>     <a href="#" class="tablelink">删除</a></td>
        </tr>

        <tr>
            <td>20130906</td>
            <td>社科院:电子商务促进了农村经济结构和社会转型</td>
            <td>user</td>
            <td>江苏无锡</td>
            <td>2013-09-07 13:16</td>
            <td>未审核</td>
            <td>已审核</td>
            <td>已审核</td>
            <td>已审核</td>
            <td><a href="#" class="tablelink">修改</a>     <a href="#" class="tablelink">删除</a></td>
        </tr>
        </tbody>
    </table>


    <div class="pagin">
        <div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
            <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
            <li class="paginItem"><a href="javascript:;">1</a></li>
            <li class="paginItem current"><a href="javascript:;">2</a></li>
            <li class="paginItem"><a href="javascript:;">3</a></li>
            <li class="paginItem"><a href="javascript:;">4</a></li>
            <li class="paginItem"><a href="javascript:;">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="javascript:;">10</a></li>
            <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>


    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="images/ticon.png" /></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" />&nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
        </div>

    </div>




</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>
