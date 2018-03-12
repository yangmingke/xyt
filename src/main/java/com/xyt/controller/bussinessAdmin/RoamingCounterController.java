package com.xyt.controller.bussinessAdmin;

import com.xyt.service.bussinessAdmin.RoamingCounterService;
import com.xyt.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("roamingCounterController")
public class RoamingCounterController {

    @Autowired
    RoamingCounterService roamingCounterService;

    @RequestMapping("queryRoamingCounterPage")
    public ModelAndView queryRoamingCounterPage(){
        String endTime = DateUtil.getTdDate();
        String startTime = DateUtil.getDate(-6);
        String monthFirstDay = DateUtil.getMonthFirstDay();
        if(monthFirstDay.compareTo(startTime) > 0){
            startTime = monthFirstDay;
        }

        Map<String,String> model = new HashMap<String, String>();
        model.put("endTime", endTime);
        model.put("startTime", startTime);

        return new ModelAndView("bussiness/roamingCounter",model);
    }

    @RequestMapping("queryRoamingCounter")
    @ResponseBody
    public Map<String,Object> queryRoamingCounter(String startDate, String endDate){
        Map<String,Object> paras = new HashMap<String, Object>();
        //设置日期横坐标
        List<String> timeLine = DateUtil.getStrBetweenDate(startDate, endDate);

        List<String> dateList = new ArrayList<String>();
        for (String date : timeLine){
            dateList.add(date.replaceAll("-",""));
        }
        paras.put("dateList",dateList);

        List<Map<String,Object>> roamingList = roamingCounterService.queryRoamingCounter(paras);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("roamingList",roamingList);
        result.put("timeLine",timeLine);

        return result;
    }
}
