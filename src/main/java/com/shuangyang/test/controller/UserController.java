package com.shuangyang.test.controller;

import com.shuangyang.test.bean.User;
import com.shuangyang.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 罗高杨 on 2017-7-11.
 */
@Controller
public class UserController {
  @Autowired
  private UserService userService;

  @RequestMapping("/user")
  @ResponseBody
  public List<User> findUsers(){
    List<User> list = null;
    try {
      list = userService.findUsers();
    }catch (Exception e){

    }
    return list;
  }
}
