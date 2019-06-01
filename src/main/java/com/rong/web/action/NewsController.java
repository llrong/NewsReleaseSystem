package com.rong.web.action;

import com.rong.service.CommentService;
import com.rong.service.NewsInfoService;
import com.rong.service.NewsTypeService;
import com.rong.utils.DateTimeUtils;
import com.rong.web.pojo.Comment;
import com.rong.web.pojo.NewsInfo;
import com.rong.web.pojo.NewsType;
import com.rong.web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController
{
    @Autowired
    private NewsInfoService newsInfoService;

    @Autowired
    private NewsTypeService newsTypeService;

    @Autowired
    private CommentService commentService;



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
                newsInfo.setRemark(user.getId().toString());
                newsInfo.setDeleted((byte) 0);
                newsInfo.setIsCheck((byte) 0);
                newsInfoService.insertNews(newsInfo);
                result = 1;  //成功
            }else{
                result = 2; //新闻类型不存在
            }
        }
       return  result;

    }


    @RequestMapping(value = "/deleted",method = RequestMethod.POST)
    @ResponseBody
    public int  deleteNews(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("newsid"));
        System.out.println("id:  "+id);
        int result =0 ;
        result = newsInfoService.deleteNewsById(id);
        return  result;
    }


    @RequestMapping("/queryNews")
    public String queryAllNews(Model model) {
        List<NewsInfo> list = newsInfoService.selectAllNews();
        model.addAttribute("list", list);
        return "news/queryNews";
    }


    @RequestMapping("/queryMyNews")
    public String queryMyNews(HttpServletRequest request , Model model) {
        User user = (User)request.getSession().getAttribute("user");
        List<NewsInfo> list = newsInfoService.selectMyNews(user.getId().toString());
        model.addAttribute("list", list);
        return "news/queryMyNews";
    }

    @RequestMapping(value = "/check")
    public  String checkNews(HttpServletRequest request,Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        NewsInfo newsInfo = newsInfoService.selectNewsById(id);
        model.addAttribute("news",newsInfo);
        return  "news/NewsInfo";
    }


    @RequestMapping(value = "/getnews")
    public  String getNewsAnaCom(HttpServletRequest request,Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        NewsInfo newsInfo = newsInfoService.selectNewsById(id);
//        String content =newsInfo.getContent().replaceAll(" ","&nbsp;&nbsp;").replaceAll("\r","<br/>");
        List<Comment> list = commentService.selectByNewsId(id);
        model.addAttribute("newsinfo",newsInfo);
        model.addAttribute("comment",list);
        return  "news/newsComment";
    }


}