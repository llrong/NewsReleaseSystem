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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.*;
import java.util.*;

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
//    @ResponseBody
    public String  addNews(@RequestParam(value = "file") MultipartFile file,
                        @RequestParam(value = "title")  String title,
                        @RequestParam(value = "digest") String digest,
                        @RequestParam(value = "type") String type,
                        @RequestParam(value = "content") String content, HttpServletRequest request,
                        HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        if(title.equals("")){
            printWriter.println("<script language='javascript'>alert('请输入新闻标题！');</script>");
        }else if(content.equals("")){
            printWriter.println("<script language='javascript'>alert('请输入新闻内容！');</script>");
        }else{
            NewsInfo newsInfo = new NewsInfo();
            User user = (User)request.getSession().getAttribute("user");
            if(user == null ){
                printWriter.println("<script language='javascript'>alert('请先登录！');</script>");
            }else{
                NewsType newsType= newsTypeService.selectByName(type);
                if(newsType != null){
                    if(file != null){
                        try {
                            BufferedOutputStream out = new BufferedOutputStream(
                                    new FileOutputStream(new File("E:\\IntelliJ IDEA\\NewsReleaseSystem\\src\\main\\resources\\static\\picture\\"+file.getOriginalFilename())));//保存图片到目录下
                            out.write(file.getBytes());
                            out.flush();
                            out.close();
                            String filename="/picture/"+file.getOriginalFilename();
                            newsInfo.setPicture(filename);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
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
                    newsInfo.setIsCheck((byte) 1);
                    newsInfoService.insertNews(newsInfo);
                    printWriter.println("<script language='javascript'>alert('添加成功！');</script>");
                }
                else{
                    printWriter.println("<script language='javascript'>alert('新闻类型不存在！');</script>");
                }
            }
        }


       return  "news/addNews";

    }


    @RequestMapping(value = "/addagain", method = RequestMethod.POST)
//    @ResponseBody
    public String  addagain(@RequestParam(value = "file") MultipartFile file,
                           @RequestParam(value = "title")  String title,
                           @RequestParam(value = "digest") String digest,
                           @RequestParam(value = "type") String type,
                           @RequestParam(value = "content") String content, HttpServletRequest request,
                           HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        if(title.equals("")){
            printWriter.println("<script language='javascript'>alert('请输入新闻标题！');</script>");
        }else if(content.equals("")){
            printWriter.println("<script language='javascript'>alert('请输入新闻内容！');</script>");
        }else{
            NewsInfo newsInfo = new NewsInfo();
            User user = (User)request.getSession().getAttribute("user");
            if(user == null ){
                printWriter.println("<script language='javascript'>alert('请先登录！');</script>");
            }else{
                NewsType newsType= newsTypeService.selectByName(type);
                if(newsType != null){
                    if(file != null){
                        try {
                            BufferedOutputStream out = new BufferedOutputStream(
                                    new FileOutputStream(new File("E:\\IntelliJ IDEA\\NewsReleaseSystem\\src\\main\\resources\\static\\picture\\"+file.getOriginalFilename())));//保存图片到目录下
                            out.write(file.getBytes());
                            out.flush();
                            out.close();
                            String filename="/picture/"+file.getOriginalFilename();
                            newsInfo.setPicture(filename);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
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
                    newsInfo.setIsCheck((byte) 1);
                    newsInfoService.insertNews(newsInfo);
                    printWriter.println("<script language='javascript'>alert('添加成功！');</script>");
                }
                else{
                    printWriter.println("<script language='javascript'>alert('新闻类型不存在！');</script>");
                }
            }
        }


        return  "news/updateNews";

    }


//    @RequestMapping(value = "/baocun", method = RequestMethod.POST)
////    @ResponseBody
//    public String baocun( HttpServletRequest request, HttpServletResponse response) throws IOException{
//            String type = request.getParameter("type");
//            String digest  = request.getParameter("digest");
//            String content = request.getParameter("content");
//            String title = request.getParameter("title");
//            NewsInfo newsInfo = new NewsInfo();
//            int result;
//            User user = (User)request.getSession().getAttribute("user");
//            if(user == null ){
//               result = 0;
//            }else{
//                NewsType newsType= newsTypeService.selectByName(type);
//                if(newsType != null){
//                        newsInfo.setTypeId(newsType.getId());
//                        newsInfo.setAuthor(user.getUserName());
//                        newsInfo.setTitle(title);
//                        newsInfo.setDigest(digest);
//                        newsInfo.setContent(content);
//                        newsInfo.setCreated(DateTimeUtils.getCurrentTime());
//                        newsInfo.setHits(0);
//                        newsInfo.setRemark(user.getId().toString());
//                        newsInfo.setIsCheck((byte) 0);
//                        newsInfoService.insertNews(newsInfo);
//
//                    }
//                }
//        return  result;
//
//    }

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
        List<Map<String, Object>> result = new ArrayList<>(list.size());
        for (NewsInfo newsInfo : list) {
            if(newsTypeService.selectById(newsInfo.getTypeId()) != null){
                Map<String, Object> map = new HashMap<>(10);
                map.put("id", newsInfo.getId());
                map.put("title",newsInfo.getTitle());
                map.put("author",newsInfo.getAuthor());
                map.put("type",newsTypeService.selectById(newsInfo.getTypeId()).getTypeName());
                map.put("created",DateTimeUtils.getFormatTime(newsInfo.getCreated()));
                result.add(map);
            }
        }
        model.addAttribute("result", result);
        return "news/queryNews";
    }


    @RequestMapping("/queryMyNews")
    public String queryMyNews(HttpServletRequest request , Model model) {
        User user = (User)request.getSession().getAttribute("user");
        List<NewsInfo> list = newsInfoService.selectMyNews(user.getId().toString());
        List<Map<String, Object>> result = new ArrayList<>(list.size());
        for (NewsInfo newsInfo : list) {
            if(newsTypeService.selectById(newsInfo.getTypeId()) != null) {
                Map<String, Object> map = new HashMap<>(10);
                map.put("id", newsInfo.getId());
                map.put("title", newsInfo.getTitle());
                map.put("hits", newsInfo.getHits());
                map.put("type", newsTypeService.selectById(newsInfo.getTypeId()).getTypeName());
                map.put("created", DateTimeUtils.getFormatTime(newsInfo.getCreated()));
                result.add(map);
            }
        }
        model.addAttribute("result", result);
        return "news/queryMyNews";
    }

    @RequestMapping("/queryUncheck")
    public String queryUnckeck(HttpServletRequest request , Model model) {
        User user = (User)request.getSession().getAttribute("user");
        List<NewsInfo> list = newsInfoService.selectMyNews(user.getId().toString());
        List<Map<String, Object>> result = new ArrayList<>(list.size());
        for (NewsInfo newsInfo : list) {
            Map<String, Object> map = new HashMap<>(10);
            map.put("id", newsInfo.getId());
            map.put("title",newsInfo.getTitle());
            map.put("type",newsTypeService.selectById(newsInfo.getTypeId()).getTypeName());
            map.put("created",DateTimeUtils.getFormatTime(newsInfo.getCreated()));
            result.add(map);
        }
        model.addAttribute("result", result);
        return "news/queryUnckeck";
    }


    @RequestMapping(value = "/check")
    public  String checkNews(HttpServletRequest request,Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        NewsInfo newsInfo = newsInfoService.selectNewsById(id);
        Map<String, Object> map = new HashMap<>(10);
        map.put("id", newsInfo.getId());
        map.put("title",newsInfo.getTitle());
        map.put("author",newsInfo.getAuthor());
        map.put("created",DateTimeUtils.getFormatTime(newsInfo.getCreated()));
        map.put("content",newsInfo.getContent());
        map.put("digest",newsInfo.getDigest());
        map.put("picture",newsInfo.getPicture());
        model.addAttribute("news",map);
        return  "news/NewsInfo";
    }


    @RequestMapping(value = "/getnews")
    public  String getNewsAnaCom(HttpServletRequest request,Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        NewsInfo newsInfo = newsInfoService.selectNewsById(id);
        Map<String, Object> map = new HashMap<>(10);
        map.put("id", newsInfo.getId());
        map.put("title",newsInfo.getTitle());
        map.put("author",newsInfo.getAuthor());
        map.put("created",DateTimeUtils.getFormatTime(newsInfo.getCreated()));
        map.put("hits",newsInfo.getHits());
        map.put("content",newsInfo.getContent());
        map.put("picture",newsInfo.getPicture());
        model.addAttribute("newsinfo",map);

        List<Comment> list = commentService.selectByNewsId(id);
        List<Map<String, Object>> result = new ArrayList<>(list.size());
        for (Comment comment : list) {
            Map<String, Object> mc = new HashMap<>(10);
            mc.put("id", comment.getId());
            mc.put("content",comment.getCommentContent());
            mc.put("ower",comment.getOwer());
            mc.put("created",DateTimeUtils.getFormatTime(comment.getCreated()));
            result.add(mc);
        }
        newsInfoService.addHits(id);
        model.addAttribute("coms",result);
        return  "news/newsComment";
    }


    @RequestMapping(value = "/updated")
    public  String updated(HttpServletRequest request,Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        NewsInfo newsInfo = newsInfoService.selectNewsById(id);
        Map<String, Object> map = new HashMap<>(10);
        map.put("id", newsInfo.getId());
        map.put("title",newsInfo.getTitle());
        map.put("author",newsInfo.getAuthor());
        map.put("created",DateTimeUtils.getFormatTime(newsInfo.getCreated()));
        map.put("content",newsInfo.getContent());
        map.put("digest",newsInfo.getDigest());
        map.put("picture",newsInfo.getPicture());
        model.addAttribute("news",map);
        return  "news/updateNews";
    }




}