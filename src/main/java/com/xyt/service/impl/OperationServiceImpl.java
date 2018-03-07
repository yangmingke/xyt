package com.xyt.service.impl;

import com.xyt.dao.ucpaas.TForwardNumberListMapper;
import com.xyt.model.TForwardNumberList;
import com.xyt.service.OperationService;
import com.xyt.util.PageContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OperationServiceImpl implements OperationService {
    @Autowired
    TForwardNumberListMapper tForwardNumberListMapper;

    public PageContainer queryNumberPool(Map<String, Object> paras) {
        int total = tForwardNumberListMapper.queryNumberPoolCount(paras);//查询数据总数
        PageContainer pageContainer = new PageContainer();
        paras = pageContainer.createParameter(paras, total);

        List<Map<String, String>> resultMap = tForwardNumberListMapper.queryNumberPool(paras);

        pageContainer.setResultMap(resultMap);

        return pageContainer;
    }

    public String deleteNumber(int deleteId) {
        int count = tForwardNumberListMapper.deleteNumber(deleteId);
        return count > 0 ? "success" : "fail";
    }

    public void addNumber(TForwardNumberList tForwardNumberList) {
        tForwardNumberListMapper.addNumber(tForwardNumberList);
    }

    public TForwardNumberList queryNumberInfoById(int numberId) {
        return tForwardNumberListMapper.queryNumberInfoById(numberId);
    }

    public void updateNumber(TForwardNumberList tForwardNumberList) {
        tForwardNumberListMapper.updateNumber(tForwardNumberList);
    }
}
