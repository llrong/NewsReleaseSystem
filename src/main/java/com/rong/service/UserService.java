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


    public List<Map<String,Object>> selectAllUsers(){
        List<User>  list = userMapper.selectAllUsers();
        List<Map<String, Object>> result = new ArrayList<>(list.size());
        for (User user : list) {
            Map<String, Object> map = new HashMap<>(10);
            map.put("id", user.getId());
            map.put("email", user.getEmail());
            map.put("juris", user.getJusis()==0?"普通用户":"管理员");
            result.add(map);
            }
        return result;
    }

    public int updateUserById(User user){
        return userMapper.updateById(user);
    }

}