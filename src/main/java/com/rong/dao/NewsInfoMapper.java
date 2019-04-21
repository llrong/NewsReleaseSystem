package com.rong.dao;

import com.rong.web.pojo.NewsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsInfoMapper {
    int deleteById(@Param("id") Integer id);

    int insert(NewsInfo newsInfo);

    List<NewsInfo> selectAllNews();

    List<NewsInfo> selectUnchecked();

    int updateByAuthor(NewsInfo newsInfo);

    int updateByIdByAdmin(@Param("id")Integer id);


}