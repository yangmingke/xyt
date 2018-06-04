package com.xyt.service.bussinessAdmin.impl;

import com.xyt.dao.appsvr.TbOrderInfoMapper;
import com.xyt.model.TbOrderInfo;
import com.xyt.service.bussinessAdmin.OrderService;
import com.xyt.util.PageContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    TbOrderInfoMapper tbOrderInfoMapper;

    public PageContainer queryOrderList(Map<String, Object> paras) {
        int total = tbOrderInfoMapper.queryOrderListCount(paras);//查询数据总数
        PageContainer pageContainer = new PageContainer();
        paras = pageContainer.createParameter(paras, total);

        List<Map<String, String>> resultMap = tbOrderInfoMapper.queryOrderList(paras);

        pageContainer.setResultMap(resultMap);

        return pageContainer;
    }

    public String deleteOrder(int deleteId) {
        int count = tbOrderInfoMapper.deleteOrder(deleteId);
        return count > 0 ? "success" : "fail";
    }

    public void addOrder(TbOrderInfo tbOrderInfo) {

//        tbOrderInfoMapper.addOrder(tbOrderInfo);
    }

    public TbOrderInfo queryOrderInfoById(int numberId) {
        return tbOrderInfoMapper.queryOrderInfoById(numberId);
    }

    public int updateOrder(TbOrderInfo tbOrderInfo) {
        return tbOrderInfoMapper.updateOrder(tbOrderInfo);
    }
}
