<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>二维码信息</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <link href="/css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="/js/select-ui.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function(e) {
            $(".select1").uedSelect({
                width : 345
            });
            $(".select2").uedSelect({
                width : 167
            });
            $(".select3").uedSelect({
                width : 100
            });
        });
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="javascript:void(0);">运维管理</a></li>
        <li><a href="javascript:void(0);">二维码信息</a></li>
    </ul>
</div>

<form class="formbody" id="formbody" method="post"
      <c:if test="${qrCodeInfo.id == null}">action="/qrcodeController/addQrCode"</c:if>
      <c:if test="${qrCodeInfo.id != null}">action="/qrcodeController/updateQrCode"</c:if>
>

    <div id="usual1" class="usual">

        <div id="tab1" class="tabson">

            <ul class="forminfo">
                <input value="${qrCodeInfo.id}" name="id" hidden="hidden"/>
                <li>
                    <label>二维码ID</label><input  value="${qrCodeInfo.qrcode}"  readonly="readonly" class="dfinput" style="width:518px;"/>
                </li>
                <li>
                    <label>用户ID</label><input  value="${qrCodeInfo.clientnum}"  readonly="readonly" class="dfinput" style="width:518px;"/>
                </li>
                <li>
                    <label>类型</label><input
                        <c:if test="${qrCodeInfo.qrtype == 0}"> value="通用类型"</c:if>
                        <c:if test="${qrCodeInfo.qrtype == 1}"> value="挪车类型"</c:if>
                        readonly="readonly" class="dfinput" style="width:518px;"/>
                </li>
                <li>
                    <label>绑定号码<b>*</b></label><input maxlength="11" value="${qrCodeInfo.bindnum}" name="bindnum" id="bindnum" type="text" class="dfinput" style="width:518px;" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"/>
                    <i style="color: red" class="notice" id="bindnumText"></i>
                </li>
                <li>
                    <label>生存时间<b>*</b></label><input  value="${qrCodeInfo.lifetime}" name="lifetime" id="lifetime" type="text" class="dfinput" style="width:518px;" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"/>
                    <i style="color: red" class="notice" id="lifetimeText"></i>
                </li>
                <li><label>状态<b>*</b></label>
                <div class="vocation">
                        <select class="select1" name="status" id="status">
                            <option value="0" <c:if test="${qrCodeInfo.status == 0}">selected="selected"</c:if>>无效</option>
                            <option value="1" <c:if test="${qrCodeInfo.status == 1}">selected="selected"</c:if>>就绪</option>
                            <option value="2" <c:if test="${qrCodeInfo.status == 2}">selected="selected"</c:if>>激活</option>
                        </select>
                    </div>
                </li>
                <li>
                    <label>生效时间</label><input value='<fmt:formatDate value="${qrCodeInfo.beginTime}" type="both" />'  readonly="readonly" class="dfinput" style="width:518px;"/>
                </li>
                <li>
                    <label>失效时间</label><input value='<fmt:formatDate value="${qrCodeInfo.expTime}" type="both" />'  readonly="readonly" class="dfinput" style="width:518px;"/>
                </li>
                <li>
                    <label>创建时间</label><input value='<fmt:formatDate value="${qrCodeInfo.createTime}" type="both" />' readonly="readonly" class="dfinput" style="width:518px;"/>
                </li>

                <li>
                    <c:if test="${qrCodeInfo.id == null}">
                        <label>&nbsp;</label><input name="" type="button" class="btn" onclick="addConfirm()" value="添加"/>
                    </c:if>
                    <c:if test="${qrCodeInfo.id != null}">
                        <label>&nbsp;</label><input name="" type="button" class="btn" onclick="addConfirm()" value="修改"/>
                    </c:if>
                    <label>&nbsp;</label><input  type="button" class="btn" onclick="history.back(-1);" value="取消"/>
                </li>

            </ul>

        </div>
    </div>
</form>

<script>
    function addConfirm() {
        $('.notice').text("");
        var correct = true;
        var forwardnumber = $('#forwardnumber').val();
        var counter = $('#counter').val();
        var province = $('#province').val();
        var areaid = $('#areaid').val();
        var multi = $('#multi').val();
        if(forwardnumber == ""){
            $('#forwardnumberText').text("号码不能为空");
            correct = false;
        }

        if(counter != "0" && counter != "1" && multi == 0){
            $('#counterText').text("如果不可以复用，引用次数最多为1");
            correct = false;
        }

        if(counter == ""){
            $('#counterText').text("引用次数不能为空");
            correct = false;
        }

        if(province == ""){
            $('#areaText').text("省份不能为空");
            correct = false;
        }
        if(areaid == ""){
            $('#areaText').text("省份不能为空");
            correct = false;
        }
        if(correct && confirm("确认提交?")){
            $('#formbody').submit();
        }
    }
</script>

</body>
</html>
