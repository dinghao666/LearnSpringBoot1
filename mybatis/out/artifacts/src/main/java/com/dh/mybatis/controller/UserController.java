package com.dh.mybatis.controller;

import com.dh.mybatis.entity.User;
import com.dh.mybatis.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@MapperScan(basePackages = "com.dh.mybatis.mapper")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("add/{id}/{name}/{sex}/{age}")
    public String add(@PathVariable("id")String id,@PathVariable("name")String name, @PathVariable("sex")String sex, @PathVariable("age")int age){
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setSex(sex);
        user.setAge(age);
        userService.add(user);
        return user.toString()+"添加成功";
    }

    @ResponseBody
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") String id){
        userService.deleteById(id);
        return "删除成功";
    }

    @ResponseBody
    @RequestMapping("update/{id}/{name}/{sex}/{age}")
    public String update(@PathVariable("id")String id,@PathVariable("name")String name, @PathVariable("sex")String sex, @PathVariable("age")int age){
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setSex(sex);
        user.setAge(age);
        userService.update(user);
        return user.toString()+"修改成功";
    }


    @ResponseBody
    @RequestMapping("query")
    public String query(){
        List<User> users=userService.query();
        return Arrays.toString(users.toArray());
    }
}
