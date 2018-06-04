package com.xyt.service.bussinessAdmin.impl;


import com.xyt.dao.appsvr.TbQrcodeStatisticsMapper;
import com.xyt.dao.statistic.TbQrCodeMapper;
import com.xyt.service.bussinessAdmin.QrCodeCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QrCodeCounterServiceImpl implements QrCodeCounterService {
    @Autowired
    TbQrCodeMapper tbQrCodeMapper;
    @Autowired
    TbQrcodeStatisticsMapper tbQrcodeStatisticsMapper;

    public List<Map<String, Object>> queryQrCodeCounter(Map<String, Object> paras) {
        List<Map<String,Object>> qrCodeList = tbQrCodeMapper.queryQcCodeCounter(paras);
        return qrCodeList;
    }

    public List<Map<String, Object>> queryQrcodeCall(Map<String, Object> paras) {
        List<Map<String,Object>> callList = tbQrCodeMapper.queryQrcodeCall(paras);
        return callList;
    }

    public List<Map<String, Object>> queryQrCodeActive(Map<String, Object> paras) {
        List<Map<String,Object>> activeList = tbQrcodeStatisticsMapper.queryQrCodeActive(paras);
        return activeList;
    }
}
