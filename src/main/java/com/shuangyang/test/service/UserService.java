package com.shuangyang.test.service;

import com.shuangyang.test.bean.User;

import java.util.List;

/**
 * Created by 罗高杨 on 2017-7-11.
 */
public interface UserService {
  List<User> findUsers() throws Exception;
}
