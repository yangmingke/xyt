$(function(){
    queryData();
});

function queryData(){
    $('#notice').empty();
    var startDate = $('#startTime').val();
    var endDate = $('#endTime').val();
    if(startDate.substr(0,7) != endDate.substr(0,7)){
        $('#notice').text("日期区间必须在同一月份");
        return false;
    }
    $.post("/qrCodeCounterController/queryQrCodeCounter",{"startDate":startDate,"endDate":endDate},function(result){
        if(result.result == "fail"){
            $('#notice').text(result.describe);
            return false;
        }else if(result.result == "success") {
            draw(result);
        }
    });
}

function draw(result){
    //画统计图
    var myChart = echarts.init(document.getElementById('main'));
    var timeLine = result.timeLine;
    var qrCodeList = result.qrCodeList;

    var countList = [];//呼入
    var k = 0;
    var i = 0
    while(i < timeLine.length){//qrCodeList 数据为按时间升序排列，所以可以采取以下算法
        var dayCount = 0;
        for(var j = 0; j < 2 && k < qrCodeList.length; j++){
            if(qrCodeList.length > 0 && qrCodeList[k].createDate == timeLine[i].replace("-","").replace("-","")){
                dayCount = qrCodeList[k].count;
                k++;
            }
        }
        countList.push(dayCount);
        i++;
    }

    var option = {
        tooltip: {
            trigger: 'axis'
        },
        grid: {
            right: '20%'
        },
        dataZoom: [
            {
                show: true,
                start: 0,
                end: 100
            }
        ],
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data:['扫码次数'],
            x: 'left',
            padding: [10, 20,0,20]
        },
        xAxis: [
            {
                type: 'category',
                axisTick: {
                    alignWithLabel: true
                },
                data: timeLine
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '',
                position: 'left',
                axisLabel: {
                    formatter: '{value} 秒'
                }
            }
        ],
        series: [
            {
                name:'扫码次数',
                type:'line',
//	            animation:false,
                smooth:0.3,
                data:countList
            }
        ]
    };

    myChart.setOption(option);    //载入图表
}
