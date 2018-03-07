package com.xyt.dao.ucpaas;

import com.xyt.model.TForwardNumberList;

import java.util.List;
import java.util.Map;

public interface TForwardNumberListMapper {
    int queryNumberPoolCount(Map<String, Object> paras);

    List<Map<String,String>> queryNumberPool(Map<String, Object> paras);

    int deleteNumber(int numberId);

    void addNumber(TForwardNumberList tForwardNumberList);

    TForwardNumberList queryNumberInfoById(int numberId);

    void updateNumber(TForwardNumberList tForwardNumberList);
}