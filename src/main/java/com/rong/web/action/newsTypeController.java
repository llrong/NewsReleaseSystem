package com.rong.web.action;


import com.rong.service.NewsInfoService;
import com.rong.service.NewsTypeService;
import com.rong.web.pojo.NewsInfo;
import com.rong.web.pojo.NewsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/newstype")
public class newsTypeController {


    @Autowired
    private NewsTypeService newsTypeService;


    @Autowired
    private NewsInfoService newsInfoService;

    @RequestMapping(value = "/addNewsType",method = RequestMethod.POST)
    @ResponseBody
    public int addNewsType(HttpServletRequest request){
        String typeName = request.getParameter("newstype");
        NewsType news = newsTypeService.selectByName(typeName);
        int result;
        if (news != null) {
            result = 2;//此新闻类型已经存在
        } else if(typeName == "" || typeName==null){
            result = 3;  //新闻类型为空
        }else{
            newsTypeService.insertNewsType(typeName);
            result = 1;
        }
        return result;

    }

    @RequestMapping("/queryNewsType")
    public String findUserAll(Model model) {
        List<NewsType> list = newsTypeService.selectAllnewsTypes();
        model.addAttribute("list", list);
        return "newstype/queryNewsType";
    }

//    @RequestMapping(value = "/deleted")
//    public String  delete(HttpServletRequest request, HttpServletResponse response)throws IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter printWriter = response.getWriter();
//        int result  = newsTypeService.deleteById(id);
//        if(result == 1){
//            printWriter.println("<script language='javascript'>alert('删除成功！');</script>");
//        }
//        return "newstype/queryNewsType";
//    }

    @RequestMapping(value = "/deleted",method = RequestMethod.POST)
    @ResponseBody
    public int  deleteNews(HttpServletRequest request) {
        int result;
        if(request.getParameter("typeid")== null){
            result = 0;
        }else{
            int id = Integer.parseInt(request.getParameter("typeid"));
            newsInfoService.deleteByTypeId(id);
            result = newsTypeService.deleteById(id);
        }
        return  result;
    }


    @RequestMapping(value = "/updated",method = RequestMethod.POST)
    @ResponseBody
    public int  update(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String uptype = request.getParameter("uptype");
        int result;
        if(uptype.equals("")){
            result = 0;
        }else{
            NewsType newsType = new NewsType();
            newsType.setId(id);
            newsType.setTypeName(uptype);
            result = newsTypeService.updateById(newsType);
        }
        return  result;
    }


    @RequestMapping("/getTypes")
    @ResponseBody
    public Map<String, Object> getTypes(){
       List<NewsType> list = newsTypeService.selectAllnewsTypes();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list);
        return  map;
    }

}