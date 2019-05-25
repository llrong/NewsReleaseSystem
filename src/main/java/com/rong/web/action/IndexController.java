package com.rong.web.action;

import com.rong.web.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public String index(HttpServletRequest request, Model model) {
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("userName","未登录状态");
        }else {
            if(user.getJusis() == 0){
                model.addAttribute("userName","欢迎您：用户"+user.getUserName());
            }
            else {
                model.addAttribute("userName","欢迎您：管理员"+user.getUserName());
            }
        }
        return "index";
    }

    @RequestMapping("/addNews")
    public String addNews(HttpServletRequest request, Model model) {
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("userName","未登录状态");
        }else {
            if(user.getJusis() == 0){
                model.addAttribute("userName","欢迎您：用户"+user.getUserName());
            }
            else {
                model.addAttribute("userName","欢迎您：管理员"+user.getUserName());
            }
        }return "addNews";
    }

    @RequestMapping("/menu")
    public String menu(HttpServletRequest request, Model model) {
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("userName","未登录状态");
        }else {
            if(user.getJusis() == 0){
                model.addAttribute("userName","欢迎您：用户"+user.getUserName());
            }
            else {
                model.addAttribute("userName","欢迎您：管理员"+user.getUserName());
            }
        }return "menu";
    }

    @RequestMapping("/user")
    public String user(HttpServletRequest request, Model model) {
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("userName","未登录状态");
        }else {
            if(user.getJusis() == 0){
                model.addAttribute("userName","欢迎您：用户"+user.getUserName());
            }
            else {
                model.addAttribute("userName","欢迎您：管理员"+user.getUserName());
            }
        }return "user";
    }

    @RequestMapping("/news")
    public String news(HttpServletRequest request, Model model) {
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("userName","未登录状态");
        }else {
            if(user.getJusis() == 0){
                model.addAttribute("userName","欢迎您：用户"+user.getUserName());
            }
            else {
                model.addAttribute("userName","欢迎您：管理员"+user.getUserName());
            }
        }return "news";
    }


    @RequestMapping("/logout")
    public String logout(HttpServletRequest request , HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null ) {
        session.removeAttribute("user");
        }
        return "redirect:/index";
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
