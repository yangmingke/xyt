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
    $.post("/qrCodeCounterController/queryQrCodeActive",{"startDate":startDate,"endDate":endDate},function(result){
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
    var activeList = result.activeList;

    var activeCountList = [];
    var inActiveCountList = [];
    var i = 0
    var j = 0;
    while(i < timeLine.length){//activeList 数据为按时间升序排列，所以可以采取以下算法
        var activeCount = 0;
        var inActiveCount = 0;
        while(j < activeList.length){
            if(activeList[j].date == timeLine[i]){
                activeCount = activeList[j].active_num;
                inActiveCount = activeList[j].inactive_num;
                j++;
            }else{
                break;
            }
        }
        activeCountList.push(activeCount);
        inActiveCountList.push(inActiveCount);
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
            data:['激活量','无效量'],
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
                name: '激活量',
                position: 'left',
                axisLabel: {
                    formatter: '{value} '
                }
            },
            {
                type: 'value',
                name: '无效量',
                position: 'right',
                axisLabel: {
                    formatter: '{value} '
                }
            }
        ],
        series: [
            {
                name:'激活量',
                type:'line',
//	            animation:false,
                smooth:0.3,
                data:activeCountList
            },
            {
                name:'无效量',
                type:'line',
//	            animation:false,
                smooth:0.3,
                data:inActiveCountList
            }
        ]
    };

    myChart.setOption(option);    //载入图表
}
