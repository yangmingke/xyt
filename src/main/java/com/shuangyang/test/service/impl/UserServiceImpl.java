package com.shuangyang.test.service.impl;

import com.shuangyang.test.dao.UserMapper;
import com.shuangyang.test.model.TbRsUserInfo;
import com.shuangyang.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
