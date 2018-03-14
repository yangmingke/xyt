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
	//画统计图
	var myChart = echarts.init(document.getElementById('main'));
    var timeLine = result.timeLine;
    var bindingList = result.bindingList;

    var bindList = [];//绑定
    var unbindList = [];//解绑
	var k = 0;
    var i = 0
    while(i < timeLine.length){//bindingList数据为按时间升序排列，所以可以采取以下算法
		var bindCount = 0;
        var unbindCount = 0;
		for(var j = 0; j < 2 && k < bindingList.length; j++){
			if(bindingList[k].createDate == timeLine[i]){
				if(bindingList[k].bindType == 0){
                    bindCount = bindingList[k].count;
				}else if(bindingList[k].bindType == 1){
                    unbindCount = bindingList[k].count;
				}
				k++;
			}
		}
        bindList.push(bindCount);
        unbindList.push(unbindCount);
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
	        data:['绑定次数','解绑次数'],
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
	                formatter: '{value} 次'
	            }
	        }
	    ],
	    series: [
	        {
	            name:'绑定次数',
	            type:'line',
//	            animation:false,
				smooth:0.3,
	            data:bindList
	        },
	        {
	            name:'解绑次数',
	            type:'line',
//	            animation:false,
                smooth:0.3,
	            data:unbindList
	        }
	    ]
	};
	
	myChart.setOption(option);    //载入图表
}
