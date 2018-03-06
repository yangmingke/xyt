package com.xyt.dao.ucpaas;

import java.util.List;
import java.util.Map;

public interface TForwardNumberListMapper {
    int queryNumberPoolCount(Map<String, Object> paras);

    List<Map<String,String>> queryNumberPool(Map<String, Object> paras);
}