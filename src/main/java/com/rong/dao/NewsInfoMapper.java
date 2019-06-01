package com.rong.dao;

import com.rong.web.pojo.NewsInfo;
import com.rong.web.pojo.NewsInfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(NewsInfo record);

    NewsInfo selectByExampleWithBLOBs(@Param("id") Integer id);

    List<NewsInfo> selectByExample(NewsInfoExample example);

    NewsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsInfo record);

    int updateByPrimaryKeyWithBLOBs(NewsInfo record);

    int updateByPrimaryKey(NewsInfo record);

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