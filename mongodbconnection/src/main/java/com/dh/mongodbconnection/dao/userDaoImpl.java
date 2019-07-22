package com.dh.mongodbconnection.dao;

import com.dh.mongodbconnection.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;


@Component
public class userDaoImpl implements userDao {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(User user) {
        mongoTemplate.insert(user);
    }

    @Override
    public void remove(String name) {
        Query query=new Query(Criteria.where("name").is(name));
        mongoTemplate.remove(query,User.class);
    }

    @Override
    public void update(User user) {

        Query query = new Query(Criteria.where("name").is(user.getName()));

        Update update = new Update();
        update.set("name",user.getName());
        update.set("sex", user.getSex());
        update.set("age", user.getAge());
        mongoTemplate.updateFirst(query, update, User.class);

    }

    @Override
    public User findByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }
}
