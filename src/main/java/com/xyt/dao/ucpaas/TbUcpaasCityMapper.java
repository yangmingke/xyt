package com.xyt.dao.ucpaas;


import com.xyt.model.TbUcpaasCity;

import java.util.List;

public interface TbUcpaasCityMapper {

    List<TbUcpaasCity> getProvinceList();

    List<TbUcpaasCity> queryCitiesByProvinceId(int provinceId);

    TbUcpaasCity queryCityByCityId(String areaid);
}