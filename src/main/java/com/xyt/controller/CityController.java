package com.xyt.controller;

import com.xyt.model.TbUcpaasCity;
import com.xyt.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("cityController")
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping("queryCitiesByProvinceId")
    @ResponseBody
    public List<TbUcpaasCity> queryCitiesByProvinceId(int provinceId){
        return  cityService.queryCitiesByProvinceId(provinceId);
    }
}
