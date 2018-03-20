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
	$.post("/rechargeController/queryRechargeStatistics",{"startDate":startDate,"endDate":endDate},function(result){
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
    var rechargeList = result.rechargeList;

    var feeTotalList = [];//日充值金额
	var k = 0;
    var i = 0
    while(i < timeLine.length){// rechargeList 数据为按时间升序排列，所以可以采取以下算法
		var totalFee = 0;
		if(rechargeList.length > 0 && rechargeList[k].createDate == timeLine[i]){
			totalFee = rechargeList[k].totalFee;
			k++;
		}
        feeTotalList.push(totalFee);
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
	                formatter: '{value} 元'
	            }
	        }
	    ],
	    series: [
	        {
	            name:'充值金额',
	            type:'line',
				smooth:0.3,
	            data:feeTotalList
	        }
	    ]
	};
	
	myChart.setOption(option);    //载入图表
}
