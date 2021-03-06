package com.rong.web.action;


import com.rong.service.CommentService;
import com.rong.utils.DateTimeUtils;
import com.rong.web.pojo.Comment;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/comment")
public class commentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/add")
    @ResponseBody
    public int addComment(HttpServletRequest request){
        int result;
        int nid = Integer.parseInt(request.getParameter("id"));
        String com = request.getParameter("yourcom");
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
             result = 0;
             return result;
        }else{
            if(com == null){
                result=2;
            }else{
                Comment comment = new Comment();
                comment.setCommentContent(com);
                comment.setOwerId(user.getId());
                comment.setOwer(user.getUserName());
                comment.setNewsId(nid);
                int time = DateTimeUtils.getCurrentTime();
                comment.setCreated(time);
                comment.setIsCheck((byte) 0);
                comment.setDeleted((byte) 0);
                commentService.insertNews(comment);
                result = 1;
            }

        }
        return result;
    }

    @RequestMapping("/queryMyComment")
    public String queryComment(HttpServletRequest request, Model model) {
        User user = (User)request.getSession().getAttribute("user");
        List<Comment> list = commentService.selectByOwerId(user.getId());
        List<Map<String, Object>> result = new ArrayList<>(list.size());
        for (Comment comment : list) {
            Map<String, Object> map = new HashMap<>(10);
            map.put("id", comment.getId());
            map.put("content",comment.getCommentContent());
            map.put("created",DateTimeUtils.getFormatTime(comment.getCreated()));
            result.add(map);
        }
        model.addAttribute("result", result);
        return "comment/queryMyComment";
    }

    @RequestMapping(value = "/deleted",method = RequestMethod.POST)
    @ResponseBody
    public int  deleteComment(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("cid"));
        System.out.println("id:  "+id);
        int result =0 ;
        result = commentService.deleteById(id);
        return  result;
    }
}