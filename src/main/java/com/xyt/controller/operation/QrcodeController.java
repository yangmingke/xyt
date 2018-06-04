package com.xyt.controller.operation;

import com.xyt.model.TbQrcodeInfo;
import com.xyt.service.operation.QrCodeService;
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
@RequestMapping("/qrcodeController")
public class QrcodeController {
    @Autowired
    private QrCodeService qrCodeService;

    @RequestMapping("/queryQrCodeList")
    public ModelAndView queryQrCodeList(HttpServletRequest request){
        String clientnum = request.getParameter("clientnum");
        String qrcode = request.getParameter("qrcode");
        String bindnum = request.getParameter("bindnum");
        String status = request.getParameter("status");
        String currentPage = request.getParameter("currentPage");

        Map<String, Object> paras = new HashMap<String, Object>();
        paras.put("clientnum", StringUtils.isEmpty(clientnum) ? null : clientnum);
        paras.put("qrcode", StringUtils.isEmpty(qrcode) ? null : qrcode);
        paras.put("bindnum", StringUtils.isEmpty(bindnum) ? null : bindnum);
        paras.put("status", StringUtils.isEmpty(status) ? null : status);
        paras.put("currentPage", StringUtils.isEmpty(currentPage) ? 1 : Integer.valueOf(currentPage));

        PageContainer pageContainer = qrCodeService.queryQrCodeList(paras);

        Map<String,Object> model = new HashMap<String, Object>();
        model.put("page",pageContainer);
        model.put("paras",paras);

        return new ModelAndView("operation/qrCodeList",model);
    }

    @RequestMapping("/deleteQrCode")
    @ResponseBody
    public String deleteQrCode(int deleteId){
        return qrCodeService.deleteQrCode(deleteId);
    }

    @RequestMapping("/addQrCodePage")
    public ModelAndView addQrCodePage(){
        return new ModelAndView("operation/qrCodeInfo");
    }

    @RequestMapping("/addQrCode")
    public ModelAndView addQrCode(TbQrcodeInfo tbQrcodeInfo){
        qrCodeService.addQrCode(tbQrcodeInfo);
        return new ModelAndView("redirect:queryOrderList");
    }

    @RequestMapping("/updateQrCodePage")
    public ModelAndView updateQrCodePage(int id){
        TbQrcodeInfo qrCodeInfo = qrCodeService.queryQrCodeInfoById(id);

        Map<String,Object> model = new HashMap<String, Object>();
        model.put("qrCodeInfo",qrCodeInfo);
        return new ModelAndView("operation/qrCodeInfo", model);
    }

    @RequestMapping("/updateQrCode")
    public ModelAndView updateQrCode(TbQrcodeInfo tbQrcodeInfo){
        qrCodeService.updateQrCode(tbQrcodeInfo);
        return new ModelAndView("redirect:queryOrderList");
    }


}
