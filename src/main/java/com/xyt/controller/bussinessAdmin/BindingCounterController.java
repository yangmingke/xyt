package com.xyt.controller.bussinessAdmin;

import com.xyt.service.bussinessAdmin.BindingCounterService;
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
        List<String> timeLine = DateUtil.getStrBetweenDate(startTime,endTime);

        Map<String, Object> result = new HashMap<String, Object>();
        List<Map<String,Object>> bindingList = null;
        try {
            bindingList = bindingCounterService.queryBindingCounter(paras);
        }catch (Exception e){
            result.put("result","fail");
            result.put("describe","查询数据库出错！");
            return result;
        }

        result.put("bindingList",bindingList);
        result.put("timeLine",timeLine);
        result.put("result","success");

        return result;
    }
}
