package com.dh.mongodbconnection.controller;

import com.dh.mongodbconnection.dao.userDao;
import com.dh.mongodbconnection.dao.userDaoImpl;
import com.dh.mongodbconnection.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {


    @Autowired
    userDao userDao;

    @ResponseBody
    @RequestMapping("insert//{id}/{name}/{sex}/{age}")
    public String insert(@PathVariable("id")int id,@PathVariable("name")String name,@PathVariable("sex")String sex,@PathVariable("age")int age){
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setSex(sex);
        user.setAge(age);
        userDao.insert(user);
        return "添加成功";

    }

    @ResponseBody
    @RequestMapping("delete/{name}")
    public String delete(@PathVariable("name")String name){
        userDao.remove(name);
        return "删除成功";

    }

    @ResponseBody
    @RequestMapping("update/{name}/{sex}/{age}")
    public String update(@PathVariable("name")String name,@PathVariable("sex")String sex,@PathVariable("age")int age){
        User user=new User();
        user.setName(name);
        user.setSex(sex);
        user.setAge(age);
        userDao.update(user);
        return "修改成功";

    }

    @ResponseBody
    @RequestMapping("find/{name}")
    public String find(@PathVariable("name")String name){
        User user=userDao.findByName(name);
        return user.toString();

    }
}
