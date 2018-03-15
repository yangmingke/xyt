package com.xyt.service;

import com.xyt.model.TbUcpaasCity;

import java.util.List;

public interface CityService {
    List<TbUcpaasCity> getProvinceList();

    List<TbUcpaasCity> queryCitiesByProvinceId(int provinceId);

    TbUcpaasCity queryCityByCityId(String areaid);
}
