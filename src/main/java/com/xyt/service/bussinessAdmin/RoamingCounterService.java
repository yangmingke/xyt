package com.xyt.service.bussinessAdmin;

import java.util.List;
import java.util.Map;

public interface RoamingCounterService {
    List<Map<String, Object>> queryRoamingCounter(Map<String, Object> paras);
}
