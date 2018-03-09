package com.xyt.service.bussinessAdmin.impl;



import com.xyt.model.TbBindNumLog;
import com.xyt.service.bussinessAdmin.BindingCounterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BindingCounterServiceImpl implements BindingCounterService {
    public List<TbBindNumLog> queryBindingCounter(Map<String, Object> paras) {
        List<TbBindNumLog> bindingList = new ArrayList<TbBindNumLog>();
        TbBindNumLog t1 = new TbBindNumLog();
        t1.setBindType(0);
        t1.setCreateDate("2018-03-04");
        t1.setCount(5);
        TbBindNumLog t2 = new TbBindNumLog();
        t2.setBindType(1);
        t2.setCreateDate("2018-03-04");
        t2.setCount(2);
        TbBindNumLog t3 = new TbBindNumLog();
        t3.setBindType(0);
        t3.setCreateDate("2018-03-06");
        t3.setCount(2);
        TbBindNumLog t4 = new TbBindNumLog();
        t4.setBindType(1);
        t4.setCreateDate("2018-03-07");
        t4.setCount(11);
        TbBindNumLog t5 = new TbBindNumLog();
        t5.setBindType(0);
        t5.setCreateDate("2018-03-08");
        t5.setCount(12);
        TbBindNumLog t6 = new TbBindNumLog();
        t6.setBindType(1);
        t6.setCreateDate("2018-03-08");
        t6.setCount(5);
        TbBindNumLog t7 = new TbBindNumLog();
        t7.setBindType(0);
        t7.setCreateDate("2018-03-09");
        t7.setCount(12);
        TbBindNumLog t8 = new TbBindNumLog();
        t8.setBindType(1);
        t8.setCreateDate("2018-03-09");
        t8.setCount(1);

        bindingList.add(t1);
        bindingList.add(t2);
        bindingList.add(t3);
        bindingList.add(t4);
        bindingList.add(t5);
        bindingList.add(t6);
        bindingList.add(t7);
        bindingList.add(t8);
        return bindingList;
    }
}
