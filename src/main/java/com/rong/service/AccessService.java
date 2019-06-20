package com.rong.service;

import com.rong.dao.AccessMapper;
import com.rong.web.pojo.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessService {

    @Autowired
    private AccessMapper accessMapper;

    public Access selectByid(Integer id){
        return  accessMapper.selectByPrimaryKey(id);
    }
}