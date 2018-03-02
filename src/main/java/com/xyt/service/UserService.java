package com.xyt.service;

import com.xyt.model.TbRsUserInfo;

public interface UserService {
    public TbRsUserInfo queryAdministrator(TbRsUserInfo user);

    public int changePwd(String oldPwd, String newPwd, String sid);
}
