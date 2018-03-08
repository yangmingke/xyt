package com.xyt.service.operation.impl;

import com.xyt.dao.ucpaas.TForwardNumberListMapper;
import com.xyt.dao.ucpaas.TbUcpaasRoamMapper;
import com.xyt.service.operation.BindingService;
import com.xyt.util.PageContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BindingServiceImpl implements BindingService{

    @Autowired
    TbUcpaasRoamMapper tbUcpaasRoamMapper;
    @Autowired
    TForwardNumberListMapper tForwardNumberListMapper;

    public PageContainer queryNumberBinding(Map<String, Object> paras) {
        int total = tbUcpaasRoamMapper.queryNumberBindingCount(paras);//查询数据总数
        PageContainer pageContainer = new PageContainer();
        paras = pageContainer.createParameter(paras, total);

        List<Map<String, String>> resultMap = tbUcpaasRoamMapper.queryNumberBinding(paras);

        pageContainer.setResultMap(resultMap);
        return pageContainer;
    }

    public String deleteNumberBinding(int deleteId, String forwardPhone) {
        int count = tbUcpaasRoamMapper.deleteBinding(deleteId);
        if(count > 0){
            tForwardNumberListMapper.subCounterByNumber(forwardPhone);
            return "success";
        }
        return "fail";
    }
}
