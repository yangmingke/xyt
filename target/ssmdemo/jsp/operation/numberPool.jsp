<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>号码池</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/select-ui.min.js"></script>
    <link href="/css/select.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript">
        $(document).ready(function(){
            $(".select3").uedSelect({
                width : 100
            });

            $(".click").click(function(){
                $(".tip").fadeIn(200);
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
        <li><a href="javascript:void(0);">号码池</a></li>
    </ul>
</div>

<div class="rightinfo">
    <form action="/operationController/queryNumberPool" id="dataForm" method="post">
        <input name="currentPage" id="currentPage" value="">
        <div class="tools">
            <ul class="seachform">
                <li><label>号码</label><input name="forwardnumber" value="${paras.forwardnumber}" class="scinput"/></li>
                <li><label>地区</label><input name="city" value="${paras.city}" class="scinput"/></li>
                <li><label>运营商</label>
                    <div class="vocation">
                        <select class="select3" name="isp">
                            <option value="">全部</option>
                            <option value="1" <c:if test="${paras.isp == 1}">selected="selected"</c:if>>电信</option>
                            <option value="2" <c:if test="${paras.isp == 2}">selected="selected"</c:if>>联通</option>
                            <option value="3" <c:if test="${paras.isp == 3}">selected="selected"</c:if>>移动</option>
                        </select>
                    </div>
                </li>

                <li><label>类型</label>
                    <div class="vocation">
                        <select class="select3" name="type">
                            <option value="">全部</option>
                            <option value="0" <c:if test="${paras.type == 0}">selected="selected"</c:if>>卡号码</option>
                            <option value="1" <c:if test="${paras.type == 1}">selected="selected"</c:if>>固话号</option>
                        </select>
                    </div>
                </li>

                <li><label>状态</label>
                    <div class="vocation">
                        <select class="select3" name="status">
                            <option value="">全部</option>
                            <option value="0" <c:if test="${paras.status == 0}">selected="selected"</c:if>>可用</option>
                            <option value="1" <c:if test="${paras.status == 1}">selected="selected"</c:if>>冻结</option>
                        </select>
                    </div>
                </li>
                <li><label>&nbsp;</label><input name="submit" type="submit" class="scbtn" value="查询"/></li>
                <span class="toolbar"><li class="click"><span><img src="/images/t01.png" /></span>添加</li></span>
            </ul>
        </div>
    </form>

    <table class="tablelist">
        <thead>
        <tr>
            <th>序号</th>
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
        <%int i = 1; %>
        <c:forEach var="numberList" items="${page.resultMap}">
            <tr>
                <td><%=i++%></td>
                <td>${numberList.city}</td>
                <td>${numberList.forwardnumber}</td>
                <td>
                    <c:if test="${numberList.isp == 1}">电信</c:if>
                    <c:if test="${numberList.isp == 2}">联通</c:if>
                    <c:if test="${numberList.isp == 3}">移动</c:if>
                </td>
                <td>
                    <c:if test="${numberList.multi == 0}">否</c:if>
                    <c:if test="${numberList.multi == 1}">是</c:if>
                </td>
                <td>${numberList.counter}</td>
                <td>
                    <c:if test="${numberList.type == 0}">卡号码</c:if>
                    <c:if test="${numberList.type == 1}">固话号</c:if>
                </td>
                <td>
                    <c:if test="${numberList.status == 0}">可用</c:if>
                    <c:if test="${numberList.status == 1}">冻结</c:if>
                </td>
                <td>${numberList.remark}</td>
                <td>
                    <a href="#" class="tablelink">修改</a>
                    <a href="#" class="tablelink"> 删除</a>
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
            <span><img src="/images/ticon.png" /></span>
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

    function jumpToPage(page) {
        $("#currentPage").val(page);
        $("#dataForm").submit();
    }
</script>
</body>
</html>
