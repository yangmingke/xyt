package com.xyt.service;


import com.xyt.util.PageContainer;

import java.util.Map;

public interface OperationService {
    PageContainer queryNumberPool(Map<String, Object> paras);
}
