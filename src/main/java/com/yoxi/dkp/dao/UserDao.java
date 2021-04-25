package com.yoxi.dkp.dao;

import com.github.pagehelper.Page;
import com.yoxi.dkp.entity.Dkp;
import com.yoxi.dkp.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<User> getAllUser();

    String login(String name);

    Page<Dkp> getAllDkp();
}
