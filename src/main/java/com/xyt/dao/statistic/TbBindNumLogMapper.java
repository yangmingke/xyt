package com.xyt.dao.statistic;


import java.util.List;
import java.util.Map;

public interface TbBindNumLogMapper {

    List<Map<String,Object>> queryBindingCounter(Map<String, Object> paras);
}