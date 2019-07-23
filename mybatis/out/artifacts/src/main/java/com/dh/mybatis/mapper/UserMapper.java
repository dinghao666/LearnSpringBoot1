package com.dh.mybatis.mapper;


import com.dh.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    @Select("insert into user1 values (#{id},#{name},#{sex},#{age})")
    User insert(@Param("id")String id,@Param("name") String name,@Param("sex") String sex,@Param("age")int age);

    @Select("delete from user1 where id=#{id}")
    void delete(@Param("id")String id);

    @Select("update user1 set name=#{name},sex=#{sex},age=#{age} where id=#{id}")
    User update(@Param("name") String name,@Param("sex") String sex,@Param("age")int age,@Param("id")String id);

    @Select("select * from user1")
    List<User> query();





}
