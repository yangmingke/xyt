package com.xyt.service.impl;

import com.xyt.dao.statistic.TbSrvClientFeeMapper;
import com.xyt.dao.ucpaas.TbUcpaasUserMapper;
import com.xyt.model.TbSrvClientFee;
import com.xyt.model.TbUcpaasUser;
import com.xyt.service.UserService;
import com.xyt.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService{
  @Autowired
  private TbUcpaasUserMapper tbUcpaasUserMapper;

  public TbUcpaasUser queryAdministrator(TbUcpaasUser user) {
    return tbUcpaasUserMapper.queryAdministrator(user);
  }

  public int changePwd(String oldPwd, String newPwd, String sid) {
    Map para = new HashMap();
    para.put("oldPwd", MD5Util.GetMD5Code(oldPwd));
    para.put("newPwd",MD5Util.GetMD5Code(newPwd));
    para.put("sid",sid);
    return tbUcpaasUserMapper.changePwd(para);
  }
}
