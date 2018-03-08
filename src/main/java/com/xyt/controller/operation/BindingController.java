package com.xyt.controller.operation;

import com.xyt.service.operation.BindingService;
import com.xyt.util.PageContainer;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("bindingController")
public class BindingController {

    @Autowired
    BindingService bindingService;

    @RequestMapping("/queryNumberBinding")
    public ModelAndView queryNumberBinding(HttpServletRequest request){
        String clientNumber = request.getParameter("clientNumber");
        String forwardPhone = request.getParameter("forwardPhone");
        String phone = request.getParameter("phone");
        String currentPage = request.getParameter("currentPage");

        Map<String, Object> paras = new HashMap<String, Object>();
        paras.put("clientNumber", StringUtils.isEmpty(clientNumber) ? null : clientNumber);
        paras.put("forwardPhone", StringUtils.isEmpty(forwardPhone) ? null : forwardPhone);
        paras.put("phone", StringUtils.isEmpty(phone) ? null : phone);
        paras.put("currentPage", StringUtils.isEmpty(currentPage) ? 1 : Integer.valueOf(currentPage));

        PageContainer pageContainer = bindingService.queryNumberBinding(paras);

        Map<String,Object> model = new HashMap<String, Object>();
        model.put("page",pageContainer);
        model.put("paras",paras);

        return new ModelAndView("operation/bindingList",model);
    }

    @RequestMapping("/deleteNumberBinding")
    @ResponseBody
    public String deleteNumberBinding(int deleteId, String forwardPhone){
        return bindingService.deleteNumberBinding(deleteId, forwardPhone);
    }
}
