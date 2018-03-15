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
        String endDate = DateUtil.getTdDate();
        String startDate = DateUtil.getDate(-6);
        String monthFirstDay = DateUtil.getMonthFirstDay();
        if(monthFirstDay.compareTo(startDate) > 0){
            startDate = monthFirstDay;
        }

        Map<String,String> model = new HashMap<String, String>();
        model.put("startDate", startDate);
        model.put("endDate", endDate);

        return new ModelAndView("finance/rechargeStatistics",model);
    }

    @RequestMapping("queryRechargeStatistics")
    @ResponseBody
    public Map<String,Object> queryRechargeStatistics(String startDate, String endDate){
        String yearMonth =  startDate.substring(0,8);
        Map<String,Object> paras = new HashMap<String, Object>();
        paras.put("yyyyMM",yearMonth.replaceAll("-",""));
        paras.put("startDate", startDate);
        paras.put("endDate", endDate);

        //设置日期横坐标
        List<String> timeLine = DateUtil.getStrBetweenDate(startDate, endDate);

        Map<String, Object> result = new HashMap<String, Object>();
        List<Map<String,Object>> rechargeList = null;
        try {
            rechargeList = rechargeService.queryRechargeStatistics(paras);
        }catch (Exception e){
            result.put("result","fail");
            result.put("describe","查询数据库出错！");
            return result;
        }
        result.put("rechargeList",rechargeList);
        result.put("timeLine",timeLine);
        result.put("result","success");

        return result;
    }
}
