package com.dh.mybatis.service;

import com.dh.mybatis.entity.User;
import com.dh.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> query() {
        return userMapper.query();
    }

    @Override
    public User add(User user) {
        return userMapper.insert(user.getId(),user.getName(),user.getSex(),user.getAge());
    }

    @Override
    public void deleteById(String id) {
        userMapper.delete(id);

    }

    @Override
    public void update(User user) {
        userMapper.update(user.getName(),user.getSex(),user.getAge(),user.getId());

    }
}
