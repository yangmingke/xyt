package com.xyt.dao.ucpaas;

import com.xyt.model.TbUcpaasRoam;

import java.util.List;
import java.util.Map;

public interface TbUcpaasRoamMapper {
    int queryNumberBindingCount(Map<String, Object> paras);

    List<Map<String,String>> queryNumberBinding(Map<String, Object> paras);

    int deleteBinding(int numberId);
}