package com.xyt.controller;

import com.xyt.model.TForwardNumberList;
import com.xyt.model.TbUcpaasCity;
import com.xyt.service.CityService;
import com.xyt.service.OperationService;
import com.xyt.util.PageContainer;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/operationController")
public class OperationController {
    @Autowired
    private OperationService operationService;
    @Autowired
    private CityService cityService;

    @RequestMapping("/queryNumberPool")
    public ModelAndView queryNumberPool(HttpServletRequest request){
        String city = request.getParameter("city");
        String isp = request.getParameter("isp");
        String forwardnumber = request.getParameter("forwardnumber");
        String type = request.getParameter("type");
        String status = request.getParameter("status");
        String currentPage = request.getParameter("currentPage");

        Map<String, Object> paras = new HashMap<String, Object>();
        paras.put("city", StringUtils.isEmpty(city) ? null : city);
        paras.put("isp", StringUtils.isEmpty(isp) ? null : isp);
        paras.put("forwardnumber", StringUtils.isEmpty(forwardnumber) ? null : forwardnumber);
        paras.put("type", StringUtils.isEmpty(type) ? null : type);
        paras.put("status", StringUtils.isEmpty(status) ? null : status);
        paras.put("currentPage", StringUtils.isEmpty(currentPage) ? 1 : Integer.valueOf(currentPage));

        PageContainer pageContainer = operationService.queryNumberPool(paras);

        Map<String,Object> model = new HashMap<String, Object>();
        model.put("page",pageContainer);
        model.put("paras",paras);

        return new ModelAndView("operation/numberPool",model);
    }

    @RequestMapping("/deleteNumber")
    @ResponseBody
    public String deleteNumber(int deleteId){
        return operationService.deleteNumber(deleteId);
    }

    @RequestMapping("/addNumberPage")
    public ModelAndView addNumberPage(){
        List<TbUcpaasCity> provinceList = cityService.getProvinceList();
        return new ModelAndView("operation/numberInfo","provinceList",provinceList);
    }

    @RequestMapping("/addNumber")
    public ModelAndView addNumber(TForwardNumberList tForwardNumberList){
        operationService.addNumber(tForwardNumberList);
        return new ModelAndView("redirect:queryNumberPool");
    }

    @RequestMapping("/updateNumberPage")
    public ModelAndView updateNumberPage(int numberId){
        TForwardNumberList numberInfo = operationService.queryNumberInfoById(numberId);
        TbUcpaasCity cityInfo = cityService.queryCityByCityId(numberInfo.getAreaid());
        List<TbUcpaasCity> provinceList = cityService.getProvinceList();
        List<TbUcpaasCity> cityList = cityService.queryCitysByProvinceId(cityInfo.getProvinceid());

        Map<String,Object> model = new HashMap<String, Object>();
        model.put("numberInfo",numberInfo);
        model.put("cityInfo",cityInfo);
        model.put("provinceList",provinceList);
        model.put("cityList",cityList);
        return new ModelAndView("operation/numberInfo", model);
    }

    @RequestMapping("/updateNumber")
    public ModelAndView updateNumber(TForwardNumberList tForwardNumberList){
        operationService.updateNumber(tForwardNumberList);
        return new ModelAndView("redirect:queryNumberPool");
    }


}
