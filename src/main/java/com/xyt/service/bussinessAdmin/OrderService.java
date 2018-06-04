package com.xyt.service.bussinessAdmin;


import com.xyt.model.TbOrderInfo;
import com.xyt.util.PageContainer;

import java.util.Map;

public interface OrderService {
    PageContainer queryOrderList(Map<String, Object> paras);

    String deleteOrder(int deleteId);

    void addOrder(TbOrderInfo tbOrderInfo);

    TbOrderInfo queryOrderInfoById(int numberId);

    int updateOrder(TbOrderInfo tbOrderInfo);
}
