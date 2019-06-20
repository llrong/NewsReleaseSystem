package com.rong.dao;

import com.rong.web.pojo.Access;
import com.rong.web.pojo.AccessExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AccessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Access record);

    int insertSelective(Access record);

    List<Access> selectByExample(AccessExample example);

    Access selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Access record);

    int updateByPrimaryKey(Access record);
}