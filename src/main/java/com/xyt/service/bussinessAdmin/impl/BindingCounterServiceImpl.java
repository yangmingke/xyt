package com.xyt.service.bussinessAdmin.impl;



import com.xyt.dao.statistic.TbBindNumLogMapper;
import com.xyt.service.bussinessAdmin.BindingCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BindingCounterServiceImpl implements BindingCounterService {
    @Autowired
    TbBindNumLogMapper tbBindNumLogMapper;

    public List<Map<String, Object>> queryBindingCounter(Map<String, Object> paras) {
        List<Map<String,Object>> bindingList = tbBindNumLogMapper.queryBindingCounter(paras);
        return bindingList;
    }
}
