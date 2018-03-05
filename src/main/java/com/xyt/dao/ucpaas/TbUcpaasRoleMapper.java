package com.xyt.dao.ucpaas;

import com.xyt.model.TbUcpaasRole;

public interface TbUcpaasRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(TbUcpaasRole record);

    int insertSelective(TbUcpaasRole record);

    TbUcpaasRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(TbUcpaasRole record);

    int updateByPrimaryKey(TbUcpaasRole record);
}