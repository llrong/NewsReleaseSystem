package com.rong.web.action;

import com.rong.service.NewsInfoService;
import com.rong.service.NewsTypeService;
import com.rong.web.pojo.NewsInfo;
import com.rong.web.pojo.NewsType;
import com.rong.web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@Controller
public class IndexController {

    @Autowired
    private NewsTypeService newsTypeService;

    @Autowired
    private NewsInfoService newsInfoService;

    @RequestMapping("/login")
    public String login() {
        return "user/login";
    }

    @RequestMapping("/register")
    public String register() {
        return "user/register";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        List<NewsType> type = newsTypeService.selectAllnewsTypes();
        model.addAttribute("type",type);
        List<NewsInfo>  hot = newsInfoService.selectHotNews();
        List<NewsInfo>  curr = newsInfoService.selectCurrNews();
        NewsInfo  cir = newsInfoService.selectCirNews();
        NewsInfo  circle = newsInfoService.selectCircleNews();
        model.addAttribute("hot",hot);
        model.addAttribute("curr",curr);
        model.addAttribute("cir",cir);
        model.addAttribute("circle",circle);
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("userName","未登录状态");
            return "index";
        }else {
            model.addAttribute("num",user.getJusis());
            if(user.getJusis() == 0){
                model.addAttribute("userName","欢迎您：用户"+user.getUserName());
                return "index";
            }
            else {
                model.addAttribute("userName","欢迎您：管理员"+user.getUserName());
                return "adminIndex";
            }
        }
    }


    @RequestMapping("/guide")
    public String guide(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        List<NewsType> type = newsTypeService.selectAllnewsTypes();
        model.addAttribute("type",type);
        List<NewsInfo>  news = newsInfoService.selectByTypeId(Integer.parseInt(id));
        model.addAttribute("news",news);
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("userName","未登录状态");
        }else {
            model.addAttribute("num",user.getJusis());
            if(user.getJusis() == 0){
                model.addAttribute("userName","欢迎您：用户"+user.getUserName());
            }
            else {
                model.addAttribute("userName","欢迎您：管理员"+user.getUserName());
            }
        }
        return "guide";

    }

    @RequestMapping("/addNews")
    public String addNews(HttpServletRequest request, Model model) {
       return "news/addNews";
    }

    @RequestMapping("/menu")
    public String menu(HttpServletRequest request, Model model) {
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("userName","未登录状态");
        }else {
            model.addAttribute("num",user.getJusis());
            model.addAttribute("id",user.getId());
            if(user.getJusis() == 0){
                model.addAttribute("userName","欢迎您：用户"+user.getUserName());
            }
            else {
                model.addAttribute("userName","欢迎您：管理员"+user.getUserName());
            }
        }return "user/menu";
    }

    @RequestMapping("/userManger")
    public String user(HttpServletRequest request, Model model) {
        User user = (User)request.getSession().getAttribute("user");
        model.addAttribute("userName","欢迎您：管理员"+user.getUserName());
        return "user/userManger";
    }

    @RequestMapping("/newsManger")
    public String news(HttpServletRequest request, Model model) {
        User user = (User)request.getSession().getAttribute("user");
        model.addAttribute("userName","欢迎您：管理员"+user.getUserName());
        return "news/newsManger";
    }


//    @RequestMapping("/logout")
//    public void logout(HttpServletRequest request , HttpServletResponse response) throws IOException{
////        HttpSession session = request.getSession();
////        if(session.getAttribute("user")!=null ) {
////        session.removeAttribute("user");
////        }
////        return "redirect:/index";
//    }



    @RequestMapping("/hi")
    public String index(Model model){
//            String students ="刘洋";
        User user = new User();
        user.setPassword("jjjj");
            model.addAttribute("s",user);
            return "forget";
    }

    @RequestMapping("newsTypeManger")
    public String newsTypeManger(HttpServletRequest request,Model model){
        User user = (User)request.getSession().getAttribute("user");
        model.addAttribute("userName","欢迎您：管理员"+user.getUserName());
        return "newsType/newsTypeManger";
    }

    @RequestMapping("/addNewsType")
    public String addNewsType(HttpServletRequest request, Model model) {
        return "newsType/addNewsType";
    }



    @RequestMapping("/addUser")
    public String addUser() {
        //向后端发送数据的页面需要写一个请求解决前端的get问题，否则会出现405错误
        return "user/addUser";
    }

    @RequestMapping("/search")
    public String searchNews(HttpServletRequest request,Model model){
        String key = request.getParameter("key");
        List<NewsInfo> list = newsInfoService.selectAllNews();
        List<NewsInfo> res = new ArrayList<>(list.size());
        for( NewsInfo newsInfo : list){
            if(newsInfo.getTitle().contains(key)){
                res.add(newsInfo);
            }
        }
        model.addAttribute("result",res);
        return "news/searchNews";
    }


}
