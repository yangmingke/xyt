package com.xyt.dao.ucpaas;

import com.xyt.model.TbUcpaasUser;

import java.util.Map;

public interface TbUcpaasUserMapper {
    TbUcpaasUser queryAdministrator(TbUcpaasUser user);

    int changePwd(Map para);
}