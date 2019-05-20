package com.rong.web.action;

import com.rong.web.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
public class IndexController {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/addNews")
    public String addNews() {
        return "addNews";
    }

    @RequestMapping("/menu")
    public String menu() {
        return "menu";
    }

    @RequestMapping("/user")
    public String user() {
        return "user";
    }

    @RequestMapping("/news")
    public String news() {
        return "news";
    }


    @RequestMapping("/logout")
    public String logout(HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        out.print("<script language=\"javascript\">confirm('确认退出登录？');window.location.href='/register'</script>");
        return "login";
    }

    @RequestMapping("/hi")
    public String index(Model model){
//            String students ="刘洋";
        User user = new User();
        user.setPassword("jjjj");
            model.addAttribute("s",user);
            return "forget";
    }



}
