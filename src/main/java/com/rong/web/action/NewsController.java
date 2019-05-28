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



    @RequestMapping("/addNews")
    public String addNews(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String title = request.getParameter("title");
        String digest = request.getParameter("digest");
        String type = request.getParameter("type");
        String content = request.getParameter("content");

        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();

        NewsInfo newsInfo = new NewsInfo();
        User user = (User)request.getSession().getAttribute("user");
        NewsType newsType= newsTypeService.selectByName(type);
        if(newsType != null){
            newsInfo.setTypeId(newsType.getId());
            newsInfo.setAuthor(user.getUserName());
            newsInfo.setTitle(title);
            newsInfo.setDigest(digest);
            newsInfo.setContent(content);
            newsInfo.setCreated(DateTimeUtils.getCurrentTime());
        }else {
            out.print("<script language=\"javascript\">alert('新闻类型错误！');</script>");
            return "addNews";
        }

        int num = newsInfoService.insertNews(newsInfo);

        if(num !=0){
            out.print("<script language=\"javascript\">alert('新闻添加成功，请等待审核！');</script>");
            return "index";
        }else{
            out.print("<script language=\"javascript\">alert('新闻添加失败，请重新添加！');</script>");
            return "addNews";
        }
    }

    @RequestMapping("/addNewsType")
    public String addNewsType(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String typeName = request.getParameter("newsType");
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        if (typeName != null) {
            NewsType newsType= newsTypeService.selectByName(typeName);
            if(newsType != null){
                out.print("<script language=\"javascript\">alert('此新闻类型已经存在，请重新添加！');</script>");
                return "addNewsType";
            }else {
                newsTypeService.insertNewsType(typeName);
                out.print("<script language=\"javascript\">alert('添加成功！');</script>");
                return "newsManger";
            }
        }else {
            out.print("<script language=\"javascript\">alert('新闻类型为空，请重新添加！');</script>");
            return "addNewsType";
        }

    }

    @RequestMapping("/queryNewsType")
    public String findUserAll(Model model) {
        List<NewsType> list = newsTypeService.selectAllnewsTypes();
        model.addAttribute("list", list);
        return "queryNewsType";
    }
}