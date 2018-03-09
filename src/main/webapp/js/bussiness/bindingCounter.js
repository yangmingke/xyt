$(function(){
    queryData();
});

function queryData(){
    $('#notice').empty();
	var startTime = $('#startTime').val();
    var endTime = $('#endTime').val();
	if(startTime.substr(0,7) != endTime.substr(0,7)){
		$('#notice').text("日期区间必须在同一月份");
		return false;
	}
	$.post("/bindingCounterController/queryBindingCounter",{"startTime":startTime,"endTime":endTime},function(rerult){
		draw(rerult);
	});
}

function draw(result){
	$('#dateTime').val(result.date);
	
	//画统计图
	var myChart = echarts.init(document.getElementById('main'));
	var rateList = result.rate[0];
	var countList = result.rate[1];
    var time1 = result.time;
    var timeLine = result.timeLine;
    var bindList = [];
    var unList = [];
    for(var time : timeLine){

	}
    var rateMax = result.rateMax;
    if(rateMax > 80){
        rateMax = 80;
    }
	var countMax = result.countMax;
	
	var colors = ['#d14a61', '#5793f3'];

	option = {
	    color: colors,
	    tooltip: {
	        trigger: 'axis'
	    },
	    grid: {
	        right: '20%'
	    },
	    toolbox: {
	        feature: {
	            dataView: {show: true, readOnly: false},
	            restore: {show: true},
	            saveAsImage: {show: true}
	        }
	    },
	    legend: {
	        data:['丢包率','丢包次数'],
		    x: 'left',
		    padding: [10, 20,0,20]
	    },
	    xAxis: [
	        {
	            type: 'category',
	            axisTick: {
	                alignWithLabel: true
	            },
	            data: time1
	        }
	    ],
	    yAxis: [
	        {
	            type: 'value',
	            name: '丢包率',
	            min: 0,
	            max: (rateMax + 20).toFixed(2),
	            position: 'left',
	            axisLine: {
	                lineStyle: {
	                    color: colors[0]
	                }
	            },
	            axisLabel: {
	                formatter: '{value} %'
	            }
	        },
	        {
	            type: 'value',
	            name: '丢包次数',
	            min: 0,
	            max: Math.round(countMax+0.5),
	            position: 'right',
	            axisLine: {
	                lineStyle: {
	                    color: colors[1]
	                }
	            },
	            axisLabel: {
	                formatter: '{value} 次'
	            }
	        }
	    ],
	    series: [
	        {
	            name:'丢包率',
	            type:'line',
//	            animation:false,
	            data:rateList
	        },
	        {
	            name:'丢包次数',
	            type:'line',
	            yAxisIndex: 1,
//	            animation:false,
	            data:countList
	        }
	    ]
	};
	
	myChart.setOption(option);    //载入图表
}
