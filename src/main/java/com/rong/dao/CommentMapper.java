package com.rong.dao;

import com.rong.web.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    int insert(Comment record);

    List<Comment> selectByOwerId(@Param("owerId") Integer owerId);

    List<Comment> selectByNewsId(@Param("newsId") Integer newsId);

    int updateById(@Param("id") Integer id);

    int deleteById(@Param("id") Integer id);
}