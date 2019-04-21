package com.rong.service;

import com.rong.dao.NewsInfoMapper;
import com.rong.web.pojo.NewsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsInfoService {

    @Autowired
    private NewsInfoMapper newsInfoMapper;

    public int insertNews(NewsInfo newsInfo){
        return newsInfoMapper.insert(newsInfo);
    }

    public int deleteNewsById(Integer id){
        return newsInfoMapper.deleteById(id);
    }

    public int updateByAuthor(NewsInfo newsInfo){
        return newsInfoMapper.updateByAuthor(newsInfo);
    }

    public int updateByIdByAdmin(Integer id){
        return newsInfoMapper.updateByIdByAdmin(id);
    }

    public List<Map<String,Object>> selectAllNews(){
        List<NewsInfo>  list = newsInfoMapper.selectAllNews();
        List<Map<String, Object>> result = new ArrayList<>(list.size());
        for (NewsInfo newsInfo : list) {
            Map<String, Object> map = new HashMap<>(10);
            map.put("id", newsInfo.getId());
            map.put("title", newsInfo.getTitle());
            result.add(map);
        }
        return result;
    }
    public List<Map<String,Object>> selectUnchecked(){
        List<NewsInfo>  list = newsInfoMapper.selectAllNews();
        List<Map<String, Object>> result = new ArrayList<>(list.size());
        for (NewsInfo newsInfo : list) {
            Map<String, Object> map = new HashMap<>(10);
            map.put("id", newsInfo.getId());
            map.put("title", newsInfo.getTitle());
            map.put("author",newsInfo.getAuthor());
            map.put("content",newsInfo.getContent());
            map.put("digest",newsInfo.getDigest());
            result.add(map);
        }
        return result;
    }
}