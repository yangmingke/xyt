package com.xyt.dao.ucpaas;


import com.xyt.model.TbUcpaasCity;

import java.util.List;

public interface TbUcpaasCityMapper {

    List<TbUcpaasCity> getProvinceList();

    List<TbUcpaasCity> queryCitysByProvinceId(int provinceId);

    TbUcpaasCity queryCityByCityId(String areaid);
}