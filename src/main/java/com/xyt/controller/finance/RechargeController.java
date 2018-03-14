package com.xyt.controller.finance;

import com.xyt.service.finance.RechargeService;
import com.xyt.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("rechargeController")
public class RechargeController {

    @Autowired
    RechargeService rechargeService;

    @RequestMapping("queryRechargeStatisticsPage")
    public ModelAndView queryRechargeStatisticsPage(){
        String endTime = DateUtil.getTdDate();
        String startTime = DateUtil.getDate(-6);
        String monthFirstDay = DateUtil.getMonthFirstDay();
        if(monthFirstDay.compareTo(startTime) > 0){
            startTime = monthFirstDay;
        }

        Map<String,String> model = new HashMap<String, String>();
        model.put("endTime", endTime);
        model.put("startTime", startTime);

        return new ModelAndView("finance/rechargeStatistics",model);
    }

    @RequestMapping("queryRechargeStatistics")
    @ResponseBody
    public Map<String,Object> queryRechargeStatistics(String startTime, String endTime){
        String yearMonth =  startTime.substring(0,8);
        Map<String,Object> paras = new HashMap<String, Object>();
        paras.put("yyyyMM",yearMonth.replaceAll("-",""));
        paras.put("startTime",startTime);
        paras.put("endTime",endTime);

        //设置日期横坐标
        List<String> timeLine = DateUtil.getStrBetweenDate(startTime,endTime);

        List<Map<String,Object>> rechargeList = rechargeService.queryRechargeStatistics(paras);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("rechargeList",rechargeList);
        result.put("timeLine",timeLine);

        return result;
    }
}
