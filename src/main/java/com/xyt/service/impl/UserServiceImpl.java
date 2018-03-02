package com.xyt.service.impl;

import com.xyt.dao.ucpaas.UserMapper;
import com.xyt.model.TbRsUserInfo;
import com.xyt.service.UserService;
import com.xyt.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 罗高杨 on 2017-7-11.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
  @Autowired
  private UserMapper userMapper;

  public TbRsUserInfo queryAdministrator(TbRsUserInfo user) {
    return userMapper.queryAdministrator(user);
  }

  public int changePwd(String oldPwd, String newPwd, String sid) {
    Map para = new HashMap();
    para.put("oldPwd", MD5Util.getMD5(oldPwd));
    para.put("newPwd",MD5Util.getMD5(newPwd));
    para.put("sid",sid);
    return userMapper.changePwd(para);
  }
}
