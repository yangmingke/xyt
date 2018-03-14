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
	$.post("/rechargeController/queryRechargeStatistics",{"startDate":startDate,"endDate":endDate},function(rerult){
		draw(rerult);
	});
}

function draw(result){
	//画统计图
	var myChart = echarts.init(document.getElementById('main'));
    var timeLine = result.timeLine;
    var roamingList = result.roamingList;

    var inList = [];//呼入
    var outList = [];//呼出
	var k = 0;
    var i = 0
    while(i < timeLine.length){//roamingList数据为按时间升序排列，所以可以采取以下算法
		var inCount = 0;
        var outCount = 0;
		for(var j = 0; j < 2 && k < roamingList.length; j++){
			if(roamingList[k].createDate == timeLine[i].replace("-","").replace("-","")){
				if(roamingList[k].callType == 7){
                    inCount = roamingList[k].totalTime;
				}else if(roamingList[k].callType == 1){
                    outCount = roamingList[k].totalTime;
				}
				k++;
			}
		}
        inList.push(inCount);
        outList.push(outCount);
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
	        data:['呼入时长','呼出时长'],
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
	            name:'呼入时长',
	            type:'line',
//	            animation:false,
				smooth:0.3,
	            data:inList
	        },
	        {
	            name:'呼出时长',
	            type:'line',
//	            animation:false,
                smooth:0.3,
	            data:outList
	        }
	    ]
	};
	
	myChart.setOption(option);    //载入图表
}
