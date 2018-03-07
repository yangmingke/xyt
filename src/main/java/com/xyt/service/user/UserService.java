package com.xyt.service.user;

import com.xyt.model.TbUcpaasUser;

public interface UserService {
    public TbUcpaasUser queryAdministrator(TbUcpaasUser user);

    public int changePwd(String oldPwd, String newPwd, String sid);
}
