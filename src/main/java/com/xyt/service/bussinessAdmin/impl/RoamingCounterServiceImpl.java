package com.xyt.service.bussinessAdmin.impl;


import com.xyt.dao.statistic.TbBillCallLogMapper;
import com.xyt.service.bussinessAdmin.RoamingCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RoamingCounterServiceImpl implements RoamingCounterService {
    @Autowired
    TbBillCallLogMapper billCallLogMapper;

    public List<Map<String, Object>> queryRoamingCounter(Map<String, Object> paras) {
        List<Map<String,Object>> bindingList = billCallLogMapper.queryRoamingCounter(paras);
        return bindingList;
    }
}
