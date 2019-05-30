package com.rong.web.action;


import com.rong.service.NewsTypeService;
import com.rong.web.pojo.NewsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/newstype")
public class newsTypeController {


    @Autowired
    private NewsTypeService newsTypeService;


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

    @RequestMapping(value = "/deleted/{id}",method = RequestMethod.POST)
    @ResponseBody
    public int  delete(@PathVariable Integer id, HttpServletRequest request) {
      int result ;
      result = newsTypeService.deleteById(id);
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