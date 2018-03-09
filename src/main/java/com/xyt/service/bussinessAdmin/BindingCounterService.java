package com.xyt.service.bussinessAdmin;

import com.xyt.model.TbBindNumLog;

import java.util.List;
import java.util.Map;

public interface BindingCounterService {
    List<TbBindNumLog> queryBindingCounter(Map<String, Object> paras);
}
