package com.xyt.service.operation;


import com.xyt.model.TForwardNumberList;
import com.xyt.util.PageContainer;

import java.util.Map;

public interface NumberPoolService {
    PageContainer queryNumberPool(Map<String, Object> paras);

    String deleteNumber(int deleteId);

    void addNumber(TForwardNumberList tForwardNumberList);

    TForwardNumberList queryNumberInfoById(int numberId);

    void updateNumber(TForwardNumberList tForwardNumberList);
}
