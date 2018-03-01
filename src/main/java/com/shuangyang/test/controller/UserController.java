package com.shuangyang.test.controller;

import com.shuangyang.test.model.TbRsUserInfo;
import com.shuangyang.test.service.UserService;
import com.shuangyang.test.util.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/userController")
public class UserController {
    Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password, HttpSession session) {
        TbRsUserInfo user = new TbRsUserInfo();
        user.setUsername(username);
        user.setPassword(MD5Util.getMD5(password));
        user = userService.queryAdministrator(user);
        if (user == null) {
            logger.info("用户名或密码错误");
            return "false";
        }
        logger.info("登录成功");
        session.setAttribute("adminSession", user);
        return "success";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        logger.info("退出登录");
        session.removeAttribute("adminSession");
        return "logout";
    }
}
