package com.dh.mybatis.service;

import com.dh.mybatis.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserService {

    //查出所有用户
    List<User> query();

    //添加用户
    User add(User user);

    //根据id删除用户
    void deleteById(String id);

    //根据id修改用户
    void update(User user);
}
