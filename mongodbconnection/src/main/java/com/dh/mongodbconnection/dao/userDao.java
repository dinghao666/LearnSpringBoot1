package com.dh.mongodbconnection.dao;

import com.dh.mongodbconnection.entity.User;

public interface userDao {

    void insert(User user);

    void remove(String name);

    void update(User user);

    User findByName(String name);
}
