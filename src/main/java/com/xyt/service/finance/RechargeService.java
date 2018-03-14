package com.xyt.service.finance;


import java.util.List;
import java.util.Map;

public interface RechargeService {

    List<Map<String,Object>> queryRechargeStatistics(Map<String, Object> paras);
}
