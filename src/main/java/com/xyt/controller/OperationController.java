package com.xyt.controller;

import com.xyt.service.OperationService;
import com.xyt.util.PageContainer;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/operationController")
public class OperationController {
    @Autowired
    private OperationService operationService;

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


}
