package com.xyt.dao.statistic;

import com.xyt.model.TbBillCallLog;

import java.util.List;
import java.util.Map;

public interface TbBillCallLogMapper {

    List<Map<String,Object>> queryRoamingCounter(Map<String, Object> paras);
}