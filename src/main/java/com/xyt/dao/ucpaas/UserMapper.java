package com.xyt.dao.ucpaas;

import com.xyt.model.TbRsUserInfo;

import javax.annotation.Resource;
import java.util.Map;

public interface UserMapper {
    TbRsUserInfo queryAdministrator(TbRsUserInfo user);

    int changePwd(Map para);
}
