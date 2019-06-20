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

    List<User> selectUsers();

    List<User> selectAdmin();

    User selectById(@Param("id") Integer id);

    int updateById(@Param("id") Integer id, @Param("userName") String userName, @Param("remark") String remark);

    int updatePassById(@Param("id") Integer id, @Param("password") String password);

    int setAdmin(@Param("id") Integer id);
}