package com.xyt.controller.bussinessAdmin;

import com.xyt.service.bussinessAdmin.QrCodeCounterService;
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
@RequestMapping("qrCodeCounterController")
public class QrCodeCounterController {

    @Autowired
    QrCodeCounterService qrCodeCounterService;

    @RequestMapping("queryQrCodeCounterPage")
    public ModelAndView queryQrCodeCounterPage(){
        String endTime = DateUtil.getTdDate();
        String startTime = DateUtil.getDate(-6);
        String monthFirstDay = DateUtil.getMonthFirstDay();
        if(monthFirstDay.compareTo(startTime) > 0){
            startTime = monthFirstDay;
        }

        Map<String,String> model = new HashMap<String, String>();
        model.put("endTime", endTime);
        model.put("startTime", startTime);

        return new ModelAndView("bussiness/qrCodeCounter",model);
    }

    @RequestMapping("queryQrCodeCounter")
    @ResponseBody
    public Map<String,Object> queryQrCodeCounter(String startDate, String endDate){
        Map<String,Object> paras = new HashMap<String, Object>();
        //设置日期横坐标
        List<String> timeLine = DateUtil.getStrBetweenDate(startDate, endDate);

        List<String> dateList = new ArrayList<String>();
        for (String date : timeLine){
            dateList.add(date.replaceAll("-",""));
        }
        paras.put("dateList",dateList);

        Map<String, Object> result = new HashMap<String, Object>();
        List<Map<String, Object>> qrCodeList = null;
        try {
            qrCodeList = qrCodeCounterService.queryQrCodeCounter(paras);
        }catch (Exception e){
            result.put("result","fail");
            result.put("describe","查询数据库出错！");
            return result;
        }
        result.put("qrCodeList",qrCodeList);
        result.put("timeLine",timeLine);
        result.put("result","success");

        return result;
    }

    @RequestMapping("queryQrCodeCallPage")
    public ModelAndView queryQrCodeCallPage(){
        String endTime = DateUtil.getTdDate();
        String startTime = DateUtil.getDate(-6);
        String monthFirstDay = DateUtil.getMonthFirstDay();
        if(monthFirstDay.compareTo(startTime) > 0){
            startTime = monthFirstDay;
        }

        Map<String,String> model = new HashMap<String, String>();
        model.put("endTime", endTime);
        model.put("startTime", startTime);

        return new ModelAndView("bussiness/qrCodeCall",model);
    }

    @RequestMapping("queryQrCodeCall")
    @ResponseBody
    public Map<String,Object> queryQrCodeCall(String startDate, String endDate){
        Map<String,Object> paras = new HashMap<String, Object>();
        //设置日期横坐标
        List<String> timeLine = DateUtil.getStrBetweenDate(startDate, endDate);

        List<String> dateList = new ArrayList<String>();
        for (String date : timeLine){
            dateList.add(date.replaceAll("-",""));
        }
        paras.put("dateList",dateList);

        Map<String, Object> result = new HashMap<String, Object>();
        List<Map<String, Object>> callList = null;
        try {
            callList = qrCodeCounterService.queryQrcodeCall(paras);
        }catch (Exception e){
            result.put("result","fail");
            result.put("describe","查询数据库出错！");
            return result;
        }
        result.put("callList",callList);
        result.put("timeLine",timeLine);
        result.put("result","success");

        return result;
    }

    @RequestMapping("queryQrCodeActivePage")
    public ModelAndView queryQrCodeActivePage(){
        String endTime = DateUtil.getTdDate();
        String startTime = DateUtil.getDate(-6);
        String monthFirstDay = DateUtil.getMonthFirstDay();
        if(monthFirstDay.compareTo(startTime) > 0){
            startTime = monthFirstDay;
        }

        Map<String,String> model = new HashMap<String, String>();
        model.put("endTime", endTime);
        model.put("startTime", startTime);

        return new ModelAndView("bussiness/qrCodeActive",model);
    }

    @RequestMapping("queryQrCodeActive")
    @ResponseBody
    public Map<String,Object> queryQrCodeActive(String startDate, String endDate){
        Map<String,Object> paras = new HashMap<String, Object>();
        //设置日期横坐标
        List<String> timeLine = DateUtil.getStrBetweenDate(startDate, endDate);

        List<String> dateList = new ArrayList<String>();
        for (String date : timeLine){
            dateList.add(date.replaceAll("-",""));
        }
        paras.put("dateList",dateList);

        paras.put("startDate",startDate);
        paras.put("endDate",endDate);
        Map<String, Object> result = new HashMap<String, Object>();
        List<Map<String, Object>> activeList = null;
        try {
            activeList = qrCodeCounterService.queryQrCodeActive(paras);
        }catch (Exception e){
            result.put("result","fail");
            result.put("describe","查询数据库出错！");
            return result;
        }
        result.put("activeList",activeList);
        result.put("timeLine",timeLine);
        result.put("result","success");

        return result;
    }
}
