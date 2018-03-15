package com.xyt.service.impl;


import com.xyt.dao.ucpaas.TbUcpaasCityMapper;
import com.xyt.model.TbUcpaasCity;
import com.xyt.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    TbUcpaasCityMapper tbUcpaasCityMapper;

    public List<TbUcpaasCity> getProvinceList() {
        return tbUcpaasCityMapper.getProvinceList();
    }

    public List<TbUcpaasCity> queryCitiesByProvinceId(int provinceId) {
        return tbUcpaasCityMapper.queryCitiesByProvinceId(provinceId);
    }

    public TbUcpaasCity queryCityByCityId(String areaid) {
        return tbUcpaasCityMapper.queryCityByCityId(areaid);
    }
}
