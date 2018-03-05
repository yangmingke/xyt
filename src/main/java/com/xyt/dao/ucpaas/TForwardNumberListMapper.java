package com.xyt.dao.ucpaas;


import com.xyt.model.TForwardNumberList;

public interface TForwardNumberListMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TForwardNumberList record);

    int insertSelective(TForwardNumberList record);

    TForwardNumberList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TForwardNumberList record);

    int updateByPrimaryKey(TForwardNumberList record);
}