package com.yoxi.dkp.service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yoxi.dkp.dao.UserDao;
import com.yoxi.dkp.entity.Dkp;
import com.yoxi.dkp.entity.User;
import com.yoxi.dkp.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public CommonResult login(User user) {
        String password = userDao.login(user.getName());
        if(StringUtils.equals(password, user.getPassword())) {
            return CommonResult.success(user.getName());
        } else {
            return CommonResult.validateFailed();
        }
    }

    public CommonResult getAllDkp(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Page<Dkp> allDkp = userDao.getAllDkp();
        PageInfo<Dkp> pageInfo = new PageInfo<>(allDkp);
        return CommonResult.success(pageInfo);
    }
}
