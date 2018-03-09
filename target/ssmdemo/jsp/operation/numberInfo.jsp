<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>号码信息</title>
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
        <li><a href="javascript:void(0);">号码信息</a></li>
    </ul>
</div>

<form class="formbody" id="formbody" method="post"
      <c:if test="${numberInfo.id == null}">action="/numberPoolController/addNumber"</c:if>
      <c:if test="${numberInfo.id != null}">action="/numberPoolController/updateNumber"</c:if>
>

    <div id="usual1" class="usual">

        <div id="tab1" class="tabson">

            <ul class="forminfo">
                <input value="${numberInfo.id}" name="id" hidden="hidden"/>
                <li>
                    <label>号码<b>*</b></label><input maxlength="11" value="${numberInfo.forwardnumber}" name="forwardnumber" id="forwardnumber" type="text" class="dfinput" style="width:518px;" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"/>
                    <i style="color: red" class="notice" id="forwardnumberText"></i>
                </li>

                <li><label>运营商<b>*</b></label>

                    <div class="vocation" >
                        <select class="select1" name="isp" id="isp">
                            <option value="1" <c:if test="${numberInfo.isp == 1}">selected="selected"</c:if>>电信</option>
                            <option value="2" <c:if test="${numberInfo.isp == 2}">selected="selected"</c:if>>联通</option>
                            <option value="3" <c:if test="${numberInfo.isp == 3}">selected="selected"</c:if>>移动</option>
                        </select>
                    </div>

                </li>

                <li><label>复用<b>*</b></label>

                    <div class="vocation">
                        <select class="select1" name="multi" id="multi">
                            <option value="0" <c:if test="${numberInfo.multi == 0}">selected="selected"</c:if>>否</option>
                            <option value="1" <c:if test="${numberInfo.multi == 1}">selected="selected"</c:if>>是</option>
                        </select>
                    </div>

                </li>

                <li><label>类型<b>*</b></label>

                    <div class="vocation">
                        <select class="select1" name="type" id="type">
                            <option value="0" <c:if test="${numberInfo.type == 0}">selected="selected"</c:if>>卡号码</option>
                            <option value="1" <c:if test="${numberInfo.type == 1}">selected="selected"</c:if>>固话号</option>
                        </select>
                    </div>

                </li>

                <li><label>状态<b>*</b></label>

                    <div class="vocation">
                        <select class="select1" name="status" id="status">
                            <option value="0" <c:if test="${numberInfo.status == 0}">selected="selected"</c:if>>可用</option>
                            <option value="1" <c:if test="${numberInfo.status == 1}">selected="selected"</c:if>>冻结</option>
                        </select>
                    </div>

                </li>

                <li>
                    <label>引用次数<b>*</b></label>
                    <input <c:if test="${numberInfo.id != null}">readonly="readonly"</c:if> value="${numberInfo.counter}" name="counter" id="counter" placeholder="如果不可以复用，引用次数最多为1" class="dfinput" style="width:518px;" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"/>
                    <i style="color: red" class="notice" id="counterText"></i>
                </li>

                <li><label>地区<b>*</b></label>

                    <div class="usercity">

                        <div class="cityleft">
                            <select class="select2" name="province" id="province" onchange="provinceChange()">
                                <option value="">选择省份</option>
                                <c:forEach var="provinceInfo" items="${provinceList}">
                                    <option value="${provinceInfo.provinceid}"
                                            <c:if test="${provinceInfo.provinceid == cityInfo.provinceid}">
                                                selected="selected"
                                            </c:if>
                                    >${provinceInfo.province}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="cityright">
                            <select class="select2" id="areaid" name="areaid">
                                <c:forEach var="city" items="${cityList}">
                                    <option value="${city.cityid}"
                                            <c:if test="${city.cityid == cityInfo.cityid}">
                                                selected="selected"
                                            </c:if>
                                    >${city.city}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <i style="color: red" class="notice" id="areaText"></i>
                    </div>

                </li>
                <li><label>备注</label>
                    <textarea  name="remark" cols="" rows="" class="textinput">${numberInfo.remark}</textarea>
                </li>
                <li>
                    <c:if test="${numberInfo.id == null}">
                    <label>&nbsp;</label><input name="" type="button" class="btn" onclick="addConfirm()" value="添加"/>
                    </c:if>
                    <c:if test="${numberInfo.id != null}">
                        <label>&nbsp;</label><input name="" type="button" class="btn" onclick="addConfirm()" value="修改"/>
                    </c:if>
                    <label>&nbsp;</label><input  type="button" class="btn" onclick="history.back(-1);" value="取消"/>
                </li>

            </ul>

        </div>
    </div>
</form>

<script>
    function provinceChange() {
        $('#areaid').empty();
        var provinceId = $('#province option:selected').val();
        $.post("/cityController/queryCitysByProvinceId",{provinceId:provinceId},function(data){
            $.each(data, function (index, item) {
                if(index == 0){
                    $('#areaid').append("<option selected='selected' value = '"+item.cityid+"'>"+item.city+"</option>");
                    $('#areaid').change();
                }else {
                    $('#areaid').append("<option value = '"+item.cityid+"'>"+item.city+"</option>");
                }
            });
        })
    }
    
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
