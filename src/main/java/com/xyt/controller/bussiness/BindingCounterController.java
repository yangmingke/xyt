package com.xyt.controller.bussiness;

import com.xyt.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("bindingCounterController")
public class BindingCounterController {

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
    public Map<String,Object> queryBindingCounter(String startTime, String endTime){
        return null;
    }
}
