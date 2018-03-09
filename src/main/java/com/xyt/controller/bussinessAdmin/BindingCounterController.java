package com.xyt.controller.bussinessAdmin;

import com.xyt.model.TbBindNumLog;
import com.xyt.service.bussinessAdmin.BindingCounterService;
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
@RequestMapping("bindingCounterController")
public class BindingCounterController {

    @Autowired
    BindingCounterService bindingCounterService;

    @RequestMapping("queryBindingCounterPage")
    public ModelAndView queryBindingCounterPage(){
        String endTime = DateUtil.getTdDate();
        String startTime = DateUtil.getDate(-6);
        String monthFirstDay = DateUtil.getMonthFirstDay();
        if(monthFirstDay.compareTo(startTime) > 0){
            startTime = monthFirstDay;
        }

        Map<String,String> model = new HashMap<String, String>();
        model.put("endTime", endTime);
        model.put("startTime", startTime);

        return new ModelAndView("bussiness/bindingCounter",model);
    }

    @RequestMapping("queryBindingCounter")
    @ResponseBody
    public Map<String,Object> queryBindingCounter(String startTime, String endTime){
        String yearMonth =  startTime.substring(0,8);
        Map<String,Object> paras = new HashMap<String, Object>();
        paras.put("yyyyMM",yearMonth.replaceAll("-",""));
        paras.put("startTime",startTime);
        paras.put("endTime",endTime);

        //设置日期横坐标
        List<String> timeLine = new ArrayList<String>();
        int startDay = Integer.parseInt(startTime.substring(8,10));
        int endDay = Integer.parseInt(endTime.substring(8,10));
        for (int day = startDay;day <=  endDay;day ++){
            if(day < 10){
                timeLine.add(yearMonth+"0"+day);
            }else {
                timeLine.add(yearMonth+day);
            }
        }

        List<TbBindNumLog> bindingList = bindingCounterService.queryBindingCounter(paras);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("bindingList",bindingList);
        result.put("timeLine",timeLine);

        return result;
    }
}
