package com.xyt.service.bussinessAdmin;

import java.util.List;
import java.util.Map;

public interface QrCodeCounterService {
    List<Map<String, Object>> queryQrCodeCounter(Map<String, Object> paras);

    List<Map<String,Object>> queryQrcodeCall(Map<String, Object> paras);

    List<Map<String,Object>> queryQrCodeActive(Map<String, Object> paras);
}
