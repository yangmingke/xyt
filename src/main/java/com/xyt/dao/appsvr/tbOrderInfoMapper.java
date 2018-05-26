package com.xyt.dao.appsvr;


import com.xyt.model.tbOrderInfo;

public interface tbOrderInfoMapper {

    int deleteByPrimaryKey(Long id);


    int insert(tbOrderInfo record);


    int insertSelective(tbOrderInfo record);


    tbOrderInfo selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(tbOrderInfo record);


    int updateByPrimaryKey(tbOrderInfo record);
}