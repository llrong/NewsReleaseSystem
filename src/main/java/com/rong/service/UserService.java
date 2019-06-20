package com.rong.service;

import com.rong.dao.UserMapper;
import com.rong.web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int deleteById(Integer id){
        return userMapper.deleteById(id);
    }

    public int insertUser(User user){
        return  userMapper.insert(user);
    }

    public User selectByEmail(String email){
        return userMapper.selectByEmail(email);
    }

    public User selectById(Integer id){
        return userMapper.selectById(id);
    }


    public List<User> selectUsers(){
        List<User>  list = userMapper.selectUsers();
        return list;
    }

    public List<User> selectAdmin(){
        List<User>  list = userMapper.selectAdmin();
        return list;
    }

    public int updateUserById(Integer id,String userName,String remark){
        return userMapper.updateById(id,userName,remark);
    }


    public int updatePassById(Integer id,String password){
        return userMapper.updatePassById(id,password);
    }

    public  int setAdmin(Integer id){
        return  userMapper.setAdmin(id);
    }

}