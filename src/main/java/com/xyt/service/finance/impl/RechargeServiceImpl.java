package com.xyt.service.finance.impl;

import com.xyt.dao.statistic.TbSrvClientFeeMapper;
import com.xyt.model.TbSrvClientFee;
import com.xyt.service.finance.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RechargeServiceImpl implements RechargeService {
    @Autowired
    TbSrvClientFeeMapper tbSrvClientFeeMapper;

    public List<Map<String, Object>> queryRechargeStatistics(Map<String, Object> paras) {
        List<Map<String,Object>> bindingList = tbSrvClientFeeMapper.queryRechargeStatistics(paras);
        return bindingList;
    }
}
