package com.rong.service;

import com.rong.dao.NewsInfoMapper;
import com.rong.web.pojo.NewsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


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

    public List<NewsInfo> selectAllNews(){
        List<NewsInfo>  list = newsInfoMapper.selectAllNews();
        return list;
    }
    public List<NewsInfo> selectMyNews(String remark){
        List<NewsInfo>  list = newsInfoMapper.selectMyNews(remark);
        return list;
    }

    public List<NewsInfo> selectByTypeId(Integer typeId){
        List<NewsInfo>  list = newsInfoMapper.selectByTypeId(typeId);
        return list;
    }

    public NewsInfo selectCirNews(){
        return newsInfoMapper.selectCirNews();

    }
    public NewsInfo selectCircleNews(){
        return newsInfoMapper.selectCircleNews();

    }

    public List<NewsInfo> selectCurrNews(){
        List<NewsInfo>  list = newsInfoMapper.selectCurrNews();
        return list;
    }

    public List<NewsInfo> selectHotNews(){
        List<NewsInfo>  list = newsInfoMapper.selectHotNews();
        return list;
    }

    public NewsInfo selectNewsById(Integer id){
        return newsInfoMapper.selectByExampleWithBLOBs(id);
    }




}