package com.xyt.dao.ucpaas;

import com.xyt.model.TbUcpaasRoam;

public interface TbUcpaasRoamMapper {
    int deleteByPrimaryKey(Integer roamId);

    int insert(TbUcpaasRoam record);

    int insertSelective(TbUcpaasRoam record);

    TbUcpaasRoam selectByPrimaryKey(Integer roamId);

    int updateByPrimaryKeySelective(TbUcpaasRoam record);

    int updateByPrimaryKey(TbUcpaasRoam record);
}