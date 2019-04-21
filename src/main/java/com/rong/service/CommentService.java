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

    public List<Map<String,Object>> selectByOwerId(Integer owerId){
        List<Comment>  list = commentMapper.selectByOwerId(owerId);
        List<Map<String, Object>> result = new ArrayList<>(list.size());
        for (Comment comment : list) {
            Map<String, Object> map = new HashMap<>(10);
            map.put("id", comment.getId());
            map.put("newsId",comment.getNewsId());
            map.put("ower",comment.getOwer());
            map.put("commentContext",comment.getCommentContent());
            map.put("created",comment.getCreated());

            result.add(map);
        }
        return result;
    }

    public List<Map<String,Object>> selectByNewsId(Integer newsId){
        List<Comment>  list = commentMapper.selectByNewsId(newsId);
        List<Map<String, Object>> result = new ArrayList<>(list.size());
        for (Comment comment : list) {
            Map<String, Object> map = new HashMap<>(10);
            map.put("id", comment.getId());
            map.put("owerId",comment.getOwer());
            map.put("ower",comment.getOwer());
            map.put("commentContext",comment.getCommentContent());
            map.put("created",comment.getCreated());
            result.add(map);
        }
        return result;
    }
}