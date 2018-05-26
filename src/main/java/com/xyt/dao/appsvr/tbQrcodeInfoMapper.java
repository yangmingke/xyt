package com.xyt.dao.appsvr;


import com.xyt.model.tbQrcodeInfo;

public interface tbQrcodeInfoMapper {

    int deleteByPrimaryKey(Long id);


    int insert(tbQrcodeInfo record);


    int insertSelective(tbQrcodeInfo record);


    tbQrcodeInfo selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(tbQrcodeInfo record);


    int updateByPrimaryKey(tbQrcodeInfo record);
}