package com.xyt.service.operation.impl;

import com.xyt.dao.appsvr.TbQrcodeInfoMapper;
import com.xyt.model.TbQrcodeInfo;
import com.xyt.service.operation.QrCodeService;
import com.xyt.util.PageContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QrCodeServiceImpl implements QrCodeService {
    @Autowired
    TbQrcodeInfoMapper tbQrcodeInfoMapper;

    public PageContainer queryQrCodeList(Map<String, Object> paras) {
        int total = tbQrcodeInfoMapper.queryQrCodeListCount(paras);//查询数据总数
        PageContainer pageContainer = new PageContainer();
        paras = pageContainer.createParameter(paras, total);

        List<Map<String, String>> resultMap = tbQrcodeInfoMapper.queryQrCodeList(paras);

        pageContainer.setResultMap(resultMap);

        return pageContainer;
    }

    public String deleteQrCode(int deleteId) {
        int count = tbQrcodeInfoMapper.deleteQrcode(deleteId);
        return count > 0 ? "success" : "fail";
    }

    public void addQrCode(TbQrcodeInfo tbQrcodeInfo) {
        tbQrcodeInfoMapper.addQrCode(tbQrcodeInfo);
    }

    public TbQrcodeInfo queryQrCodeInfoById(int id) {
        return tbQrcodeInfoMapper.queryQrCodeInfoById(id);
    }

    public void updateQrCode(TbQrcodeInfo tbQrcodeInfo) {
        tbQrcodeInfoMapper.updateQrCode(tbQrcodeInfo);
    }
}
