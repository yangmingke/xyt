package com.xyt.controller.bussinessAdmin;

import com.xyt.model.TbOrderInfo;
import com.xyt.service.bussinessAdmin.OrderService;
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
@RequestMapping("/orderController")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/queryOrderList")
    public ModelAndView queryOrderList(HttpServletRequest request){
        String orderid = request.getParameter("orderid");
        String clientphone = request.getParameter("clientphone");
        String status = request.getParameter("status");
        String mobile = request.getParameter("mobile");
        String currentPage = request.getParameter("currentPage");

        Map<String, Object> paras = new HashMap<String, Object>();
        paras.put("orderid", StringUtils.isEmpty(orderid) ? null : orderid);
        paras.put("clientphone", StringUtils.isEmpty(clientphone) ? null : clientphone);
        paras.put("status", StringUtils.isEmpty(status) ? 2 : "-1".equals(status) ? null : status);
        paras.put("mobile", StringUtils.isEmpty(mobile) ? null : mobile);
        paras.put("currentPage", StringUtils.isEmpty(currentPage) ? 1 : Integer.valueOf(currentPage));

        PageContainer pageContainer = orderService.queryOrderList(paras);

        Map<String,Object> model = new HashMap<String, Object>();
        model.put("page",pageContainer);
        model.put("paras",paras);

        return new ModelAndView("bussiness/orderList",model);
    }

    @RequestMapping("/deleteOrder")
    @ResponseBody
    public String deleteOrder(int deleteId){
        return orderService.deleteOrder(deleteId);
    }

    @RequestMapping("/addOrderPage")
    public ModelAndView addOrderPage(){
        return new ModelAndView("operation/qrCodeInfo");
    }

    @RequestMapping("/addOrder")
    public ModelAndView addOrder(TbOrderInfo tbOrderInfo){
        orderService.addOrder(tbOrderInfo);
        return new ModelAndView("redirect:queryOrderList");
    }

    @RequestMapping("/updateOrderPage")
    public ModelAndView updateOrderPage(int id){
        TbOrderInfo qrCodeInfo = orderService.queryOrderInfoById(id);

        Map<String,Object> model = new HashMap<String, Object>();
        model.put("qrCodeInfo",qrCodeInfo);
        return new ModelAndView("operation/qrCodeInfo", model);
    }

    @RequestMapping("/updateOrder")
    @ResponseBody
    public String updateOrder(TbOrderInfo tbOrderInfo){
        return orderService.updateOrder(tbOrderInfo) > 0 ? "success" :"faile";
    }
}
