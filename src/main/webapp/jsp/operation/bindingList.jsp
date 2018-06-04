<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>绑定关系</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $(".select3").uedSelect({
                width : 100
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
        <li><a href="javascript:void(0);">绑定关系</a></li>
    </ul>
</div>

<div class="rightinfo">
    <form action="/bindingController/queryNumberBinding" id="dataForm" method="post">
        <input name="currentPage" id="currentPage" value="" hidden="hidden">
        <div class="tools">
            <ul class="seachform">
                <li><label>用户ID</label><input maxlength="14" name="clientNumber" value="${paras.clientNumber}" class="scinput" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"/></li>
                <li><label>手机号</label><input maxlength="11" name="phone" value="${paras.phone}" class="scinput" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"/></li>
                <li><label>中转号</label><input maxlength="11" name="forwardPhone" value="${paras.forwardPhone}" class="scinput" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"/></li>
                <li><label>&nbsp;</label><input type="submit" class="scbtn" value="查询"/></li>
            </ul>
        </div>
    </form>

    <table class="tablelist">
        <thead>
        <tr>
            <th>序号</th>
            <th>ID号</th>
            <th>手机号</th>
            <th>中转号</th>
            <th>租用天数</th>
            <th>转呼模式</th>
            <th>状态</th>
            <th>下次扣费时间</th>
            <th>过期时间</th>
            <th>更新时间</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%int i = 1; %>
        <c:forEach var="OrderInfo" items="${page.resultMap}">
            <tr>
                <td><%=i++%></td>
                <td>${OrderInfo.client_number}</td>
                <td>${OrderInfo.phone}</td>
                <td>${OrderInfo.forward_phone}</td>
                <td>${OrderInfo.exp_days}</td>
                <td>
                    <c:if test="${OrderInfo.call_mode == 1}">直接挂断</c:if>
                    <c:if test="${OrderInfo.call_mode == 2}">转直拨呼叫</c:if>
                    <c:if test="${OrderInfo.call_mode == 3}">续活APP呼叫</c:if>
                </td>
                <td>
                    <c:if test="${OrderInfo.status == 'false'}">失效</c:if>
                    <c:if test="${OrderInfo.status == 'true'}">生效</c:if>
                </td>
                <td><fmt:formatDate value="${OrderInfo.next_date}" pattern="yyyy-MM-dd" /></td>
                <td><fmt:formatDate value="${OrderInfo.exp_date}" pattern="yyyy-MM-dd" /></td>
                <td><fmt:formatDate value="${OrderInfo.update_date}" pattern="yyyy-MM-dd" /></td>
                <td><fmt:formatDate value="${OrderInfo.create_date}" pattern="yyyy-MM-dd" /></td>
                <td>
                    <a href="#" class="tablelink delete" onclick="deleteNumber('${OrderInfo.roam_id}','${OrderInfo.forward_phone}')"> 删除</a>
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
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="/images/delete.png" /></span>
            <div class="tipright">
                <p>是否确认对信息的删除 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="deleteId" id="deleteId" value="" hidden="hidden">
            <input name="forwardPhone" id="forwardPhone" value="" hidden="hidden">
            <input name="" type="button"  class="sure" value="确定" onclick="deleteComfirm()"/>&nbsp;
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

    function deleteNumber(numberId,forwardPhone){
        $(".tip").fadeIn(200);
        $('#deleteId').val(numberId);
        $('#forwardPhone').val(forwardPhone);
    }

    function deleteComfirm() {
        var deleteId = $('#deleteId').val();
        var forwardPhone = $('#forwardPhone').val();
        $.post("/bindingController/deleteNumberBinding",{deleteId:deleteId,forwardPhone:forwardPhone},function (result) {
            if(result == "success"){
                alert("删除成功！");
                window.location.reload();
            }else{
                alert("删除失败！");
            }
        });
    }
</script>
</body>
</html>
