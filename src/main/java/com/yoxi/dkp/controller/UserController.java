package com.yoxi.dkp.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.yoxi.dkp.entity.Dkp;
import com.yoxi.dkp.entity.User;
import com.yoxi.dkp.result.CommonResult;
import com.yoxi.dkp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser")
    public List<User> getAllUser() {
        List<User> userList = userService.getAllUser();
        return userList;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody User user) {
        log.info(user.getName());
        log.info(user.getPassword());
        CommonResult result = userService.login(user);
        return result;
    }

    @RequestMapping(value = "/getAllDkp")
    public CommonResult getAllDkp(int pageNo,int pageSize) {
        CommonResult allDkp = userService.getAllDkp(pageNo, pageSize);
        log.info(allDkp.toString());
        return allDkp;
    }
}
