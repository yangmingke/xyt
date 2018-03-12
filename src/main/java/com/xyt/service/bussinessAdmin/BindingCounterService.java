package com.xyt.service.bussinessAdmin;

import java.util.List;
import java.util.Map;

public interface BindingCounterService {
    List<Map<String, Object>> queryBindingCounter(Map<String, Object> paras);
}
