package com.xyt.dao.statistic;

import java.util.List;
import java.util.Map;

public interface TbSrvClientFeeMapper {

    List<Map<String,Object>> queryRechargeStatistics(Map<String, Object> paras);
}