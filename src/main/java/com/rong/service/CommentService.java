package com.rong.service;

import com.rong.dao.CommentMapper;
import com.rong.web.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public  int insertNews(Comment comment){
        return  commentMapper.insert(comment);
    }

    public int updateById(Integer id){
        return commentMapper.updateById(id);
    }

    public int deleteById(Integer id){
        return commentMapper.deleteById(id);
    }

    public List<Comment> selectByOwerId(Integer owerId){
        List<Comment>  list = commentMapper.selectByOwerId(owerId);
        return list;
    }

    public List<Comment> selectByNewsId(Integer newsId){
        List<Comment>  list = commentMapper.selectByNewsId(newsId);
        return list;
    }
}