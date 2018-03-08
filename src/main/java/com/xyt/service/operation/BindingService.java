package com.xyt.service.operation;

import com.xyt.util.PageContainer;

import java.util.Map;

public interface BindingService {
    PageContainer queryNumberBinding(Map<String, Object> paras);

    String deleteNumberBinding(int deleteId, String forwardPhone);
}
