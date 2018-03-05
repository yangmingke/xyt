package com.xyt.controller;

import com.xyt.model.TbUcpaasUser;
import com.xyt.service.UserService;
import com.xyt.util.MD5Util;
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
        TbUcpaasUser user = new TbUcpaasUser();
        user.setEmail(username);
        user.setPassword(MD5Util.GetMD5Code(password));
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

    @RequestMapping("changePwd")
    @ResponseBody
    public String changePwd(String oldPwd, String newPwd, HttpSession session){
        TbUcpaasUser userInfo = (TbUcpaasUser) session.getAttribute("adminSession");
        int count = userService.changePwd(oldPwd, newPwd, userInfo.getSid());
        if(count < 1){
            return "false";
        }
        return "success";
    }
}
