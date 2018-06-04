package com.xyt.service.operation;


import com.xyt.model.TbQrcodeInfo;
import com.xyt.util.PageContainer;

import java.util.Map;

public interface QrCodeService {
    PageContainer queryQrCodeList(Map<String, Object> paras);

    String deleteQrCode(int deleteId);

    void addQrCode(TbQrcodeInfo tForwardNumberList);

    TbQrcodeInfo queryQrCodeInfoById(int numberId);

    void updateQrCode(TbQrcodeInfo tForwardNumberList);
}
