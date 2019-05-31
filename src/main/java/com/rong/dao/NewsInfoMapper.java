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

    List<NewsInfo> selectByTypeId(@Param("typeId")Integer typeId);

    List<NewsInfo> selectHotNews();

    NewsInfo selectCirNews();

    NewsInfo selectCircleNews();

    List<NewsInfo> selectCurrNews();

    List<NewsInfo> selectMyNews(@Param("remark") String remark);

    int updateByAuthor(NewsInfo newsInfo);

    int updateByIdByAdmin(@Param("id")Integer id);

    NewsInfo selectNewsById(@Param("id")Integer id);


}