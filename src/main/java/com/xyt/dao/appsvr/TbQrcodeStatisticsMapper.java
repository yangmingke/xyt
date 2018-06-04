package com.xyt.dao.appsvr;


import java.util.List;
import java.util.Map;

public interface TbQrcodeStatisticsMapper {
    List<Map<String,Object>> queryQrCodeActive(Map<String, Object> paras);
}