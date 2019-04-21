package com.rong.dao;

import com.rong.web.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteById(@Param("id") Integer id);

    int insert(User user);

    User selectByEmail(@Param("email") String email);

    List<User> selectAllUsers();

    User selectById(@Param("id") Integer id);


    int updateById(User user);
}