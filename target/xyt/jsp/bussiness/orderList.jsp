<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>订单管理</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/select-ui.min.js"></script>
    <link href="/css/select.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript">
        $(document).ready(function(){
            $(".select3").uedSelect({
                width : 100
            });

            $(".select4").uedSelect({
                width : 200
            });


            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function() {
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
        <li><a href="javascript:void(0);">订单管理</a></li>
    </ul>
</div>

<div class="rightinfo">
    <form action="/orderController/queryOrderList" id="dataForm" method="post">
        <input name="currentPage" id="currentPage" value="" hidden="hidden">
        <div class="tools">
            <ul class="seachform">
                <li><label>订单ID</label><input name="orderid" value="${paras.orderid}" class="scinput"/></li>
                <li><label>用户手机号</label><input name="clientphone" value="${paras.clientphone}" class="scinput" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"/></li>
                <li><label>收货人手机号</label><input name="mobile" value="${paras.mobile}" class="scinput" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"/></li>

                <li><label>订单状态</label>
                    <div class="vocation">
                        <select class="select3" name="status">
                            <option value="-1">全部</option>
                            <option value="0" <c:if test="${paras.status == 0}">selected="selected"</c:if>>无效</option>
                            <option value="1" <c:if test="${paras.status == 1}">selected="selected"</c:if>>待付款</option>
                            <option value="2" <c:if test="${paras.status == 2}">selected="selected"</c:if>>待发货</option>
                            <option value="3" <c:if test="${paras.status == 3}">selected="selected"</c:if>>付款失败</option>
                            <option value="4" <c:if test="${paras.status == 4}">selected="selected"</c:if>>待收货</option>
                            <option value="5" <c:if test="${paras.status == 5}">selected="selected"</c:if>>完成</option>
                        </select>
                    </div>
                </li>
                <li><label>&nbsp;</label><input type="submit" class="scbtn" value="查询"/></li>
                <%--<a class="toolbar" href="/qrcodeController/addQrCodePage"><li class="click"><span><img src="/images/t01.png" /></span>添加</li></a>--%>
            </ul>
        </div>
    </form>

    <table class="tablelist">
        <thead>
        <tr>
            <th>序号</th>
            <th>订单ID</th>
            <th>订单类型</th>
            <th>用户ID</th>
            <th>用户的手机号</th>
            <th>收货人</th>
            <th>收货人手机号</th>
            <th>收货人地址</th>
            <th>订单状态</th>
            <th>购买量</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%int i = 1; %>
        <c:forEach var="OrderInfo" items="${page.resultMap}">
            <tr>
                <td><%=i++%></td>
                <td>${OrderInfo.orderid}</td>
                <td>
                    <c:if test="${OrderInfo.ordertype == 0}">未知</c:if>
                    <c:if test="${OrderInfo.ordertype == 1}">购买二维码</c:if>
                    <c:if test="${OrderInfo.ordertype == 2}">二维码续费</c:if>
                </td>
                <td>${OrderInfo.clientnum}</td>
                <td>${OrderInfo.clientphone}</td>
                <td>${OrderInfo.name}</td>
                <td>${OrderInfo.mobile}</td>
                <td>${OrderInfo.address}</td>
                <td>
                    <c:if test="${OrderInfo.status == 0}">无效</c:if>
                    <c:if test="${OrderInfo.status == 1}">待付款</c:if>
                    <c:if test="${OrderInfo.status == 2}">待发货</c:if>
                    <c:if test="${OrderInfo.status == 3}">付款失败</c:if>
                    <c:if test="${OrderInfo.status == 4}">待收货</c:if>
                    <c:if test="${OrderInfo.status == 5}">完成</c:if>
                </td>
                <td>${OrderInfo.number}</td>
                <td>${OrderInfo.createTime}</td>
                <td>
                    <%--<a href="/qrcodeController/updateQrCodePage?id=${OrderInfo.id}" class="tablelink">修改订单状态</a>--%>
                    <a href="#" class="tablelink delete" onclick="updateStatus('${OrderInfo.id}','${OrderInfo.status}')"> 修改订单状态</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="pagin">
        <div class="message">共<i class="blue">${page.totalCount}</i>条记录，当前显示第&nbsp;<i class="blue">${page.currentPage}&nbsp;</i>页</div>
        <ul class="paginList">
            <c:if test="${page.currentPage != 1}">
                <li class="paginItem"><a onclick="jumpToPage(${page.currentPage-1})" href="javascript:void(0);"><span class="pagepre"></span></a></li>
            </c:if>
            <c:forEach items="${page.pageList}" var="item">
                <c:if test="${page.currentPage != item}">
                    <li class="paginItem"><a onclick="jumpToPage(${item})" href="javascript:void(0);">${item}</a></li>
                </c:if>
                <c:if test="${page.currentPage == item}">
                    <li class="paginItem current"><a href="javascript:void(0);">${item}</a></li>
                </c:if>
            </c:forEach>
            <c:if test="${page.currentPage != page.totalPage}">
                <li class="paginItem"><a onclick="jumpToPage(${page.currentPage+1})" href="javascript:void(0);"><span class="pagenxt"></span></a></li>
            </c:if>

        </ul>
    </div>

    <div class="tip">
        <div class="tiptop"><span>修改订单状态</span><a></a></div>

        <div class="tipinfo">
            <span><img src="/images/ticon.png" /></span>
            <div class="tipright">
                .
                <cite>
                    <div class="vocation">
                        <select class="select4" id="status0" style="width: 300px;">
                            <option value = '0' seleted='seleted'>无效</option>
                            <option value = '1'>无效</option>
                        </select>
                        <input id="id0" hidden="hidden">
                    </div>
                </cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" onclick="updateComfirm()"/>&nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
        </div>

    </div>

</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');

    function jumpToPage(page) {
        $("#currentPage").val(page);
        $("#dataForm").submit();
    }

    function updateStatus(id,status){
        $(".tip").fadeIn(200);
        $(".select4").uedSelect({
            width : 200
        });
        $('#id0').val(id);
        $('#status0').empty();
        if(status == '0'){
            $('#status0').append("<option value = '0' seleted='seleted'>无效</option>");
            $('.vocation .uew-select-text')[1].innerHTML='无效';
        }else{
            $('#status0').append("<option value = '0'>无效</option>");
        }
        if(status == '1'){
            $('#status0').append("<option value = '1' seleted='seleted'>待付款</option>");
            $('.vocation .uew-select-text')[1].innerHTML='待付款';
        }else{
            $('#status0').append("<option value = '1'>待付款</option>");
        }
        if(status == '2'){
            $('#status0').append("<option value = '2' seleted='seleted'>待发货</option>");
            $('.vocation .uew-select-text')[1].innerHTML='待发货';
        }else{
            $('#status0').append("<option value = '2'>待发货</option>");
        }
        if(status == '3'){
            $('#status0').append("<option value = '3' seleted='seleted'>付款失败</option>");
            $('.vocation .uew-select-text')[1].innerHTML='付款失败';
        }else{
            $('#status0').append("<option value = '3'>付款失败</option>");
        }
        if(status == '4'){
            $('#status0').append("<option value = '4' seleted='seleted'>待收货</option>");
            $('.vocation .uew-select-text')[1].innerHTML='待收货';
        }else{
            $('#status0').append("<option value = '4'>待收货</option>");
        }
        if(status == '5'){
            $('#status0').append("<option value = '5' seleted='seleted'>完成</option>")
            $('.vocation .uew-select-text')[1].innerHTML='完成';
        }else{
            $('#status0').append("<option value = '5'>完成</option>")
        }
    }

    function updateComfirm() {
        var id = $('#id0').val();
        var status = $('#status0').val();
        $.post("/orderController/updateOrder",{id:id,status:status},function (result) {
            if(result == "success"){
                alert("状态更新成功！");
                window.location.reload();
            }else{
                alert("状态更新失败！");
            }
        });
    }
</script>
</body>
</html>
