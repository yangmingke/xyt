package com.xyt.dao.statistic;


import java.util.List;
import java.util.Map;

public interface TbQrCodeMapper {

    List<Map<String,Object>> queryQcCodeCounter(Map<String, Object> paras);

    List<Map<String,Object>> queryQrcodeCall(Map<String, Object> paras);
}