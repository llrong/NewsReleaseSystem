package com.rong.service;

import com.rong.dao.NewsTypeMapper;
import com.rong.web.pojo.NewsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsTypeService {

    @Autowired
    private NewsTypeMapper newsTypeMapper;

    public int deleteById(Integer id){
        return  newsTypeMapper.deleteById(id);
    }

    public int insertNewsType(String typeName){
        return newsTypeMapper.insert(typeName);
    }

    public NewsType selectByName(String typeName){
        return newsTypeMapper.selectByName(typeName);
    }
    public NewsType selectById(Integer id){
        return newsTypeMapper.selectById(id);
    }

    public List<NewsType> selectAllnewsTypes(){
        List<NewsType>  list = newsTypeMapper.selectAllNewsType();
//        List<Map<String, Object>> result = new ArrayList<>(list.size());
//        for (NewsType newsType : list) {
//            Map<String, Object> map = new HashMap<>(10);
//            map.put("id", newsType.getId());
//            map.put("typeName", newsType.getTypeName());
//            result.add(map);
//        }
         return list;
    }

    public int updateById(NewsType newsType){
        return newsTypeMapper.updateById(newsType);
    }
}