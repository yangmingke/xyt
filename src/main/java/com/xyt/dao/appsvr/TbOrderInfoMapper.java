package com.xyt.dao.appsvr;


import com.xyt.model.TbOrderInfo;

import java.util.List;
import java.util.Map;

public interface TbOrderInfoMapper {
    int queryOrderListCount(Map<String, Object> paras);

    List<Map<String,String>> queryOrderList(Map<String, Object> paras);

    int deleteOrder(int deleteId);

    TbOrderInfo queryOrderInfoById(int numberId);

    int updateOrder(TbOrderInfo tbQrcodeInfo);
}