package com.rong.web.action;

import com.rong.service.NewsInfoService;
import com.rong.service.NewsTypeService;
import com.rong.utils.DateTimeUtils;
import com.rong.web.pojo.NewsInfo;
import com.rong.web.pojo.NewsType;
import com.rong.web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController
{
    @Autowired
    private NewsInfoService newsInfoService;

    @Autowired
    private NewsTypeService newsTypeService;



    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    @ResponseBody
    public int  addNews(HttpServletRequest request) {
        String title = request.getParameter("title");
        String digest = request.getParameter("digest");
        String type = request.getParameter("type");
        String content = request.getParameter("content");
        int result;
        NewsInfo newsInfo = new NewsInfo();
        User user = (User)request.getSession().getAttribute("user");
        if(user == null ){
            result = 0;    //尚未登录
        }else{
            NewsType newsType= newsTypeService.selectByName(type);
            if(newsType != null){
                newsInfo.setTypeId(newsType.getId());
                newsInfo.setAuthor(user.getUserName());
                newsInfo.setTitle(title);
                newsInfo.setDigest(digest);
                newsInfo.setContent(content);
                newsInfo.setCreated(DateTimeUtils.getCurrentTime());
                newsInfo.setHits(0);
                newsInfoService.insertNews(newsInfo);
                result = 1;  //成功
            }else{
                result = 2; //新闻类型不存在
            }
        }
       return  result;

    }


}