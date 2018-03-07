package com.xyt.service;

import com.xyt.model.TbUcpaasCity;

import java.util.List;

public interface CityService {
    List<TbUcpaasCity> getProvinceList();

    List<TbUcpaasCity> queryCitysByProvinceId(int provinceId);

    TbUcpaasCity queryCityByCityId(String areaid);
}
