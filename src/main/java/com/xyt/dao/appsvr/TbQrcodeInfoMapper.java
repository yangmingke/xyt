package com.xyt.dao.appsvr;


import com.xyt.model.TbQrcodeInfo;

import java.util.List;
import java.util.Map;

public interface TbQrcodeInfoMapper {
    int queryQrCodeListCount(Map<String, Object> paras);

    List<Map<String,String>> queryQrCodeList(Map<String, Object> paras);

    int deleteQrcode(int deleteId);

    TbQrcodeInfo queryQrCodeInfoById(int numberId);

    int addQrCode(TbQrcodeInfo tForwardNumberList);

    int updateQrCode(TbQrcodeInfo tbQrcodeInfo);
}