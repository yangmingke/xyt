package com.xyt.service;

import com.xyt.model.TbUcpaasUser;

public interface UserService {
    public TbUcpaasUser queryAdministrator(TbUcpaasUser user);

    public int changePwd(String oldPwd, String newPwd, String sid);
}
