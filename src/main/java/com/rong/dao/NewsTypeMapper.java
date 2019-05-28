package com.rong.dao;

import com.rong.web.pojo.NewsType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsTypeMapper {
    int deleteById(@Param("id") Integer id);

    int insert(@Param("typeName") String typeName);

    NewsType selectByName(@Param("typeName") String typeName);

    List<NewsType> selectAllNewsType();

    int updateById(NewsType newsType);


}