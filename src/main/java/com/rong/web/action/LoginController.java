package com.rong.web.action;

import com.rong.service.UserService;
import com.rong.web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/first")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public int login(HttpServletRequest request){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //查询数据库中已经存在的用户名密码
        User user = userService.selectByEmail(email);
        int result;
        if(email==""||password==""){
            result = 0;   //返回值为0前端提示用户名或者密码空
        }else if (user == null){
            result = 2;    //用户名不存在
        } else if(password.equals(user.getPassword()) && email.equals(user.getEmail())){   //数据库中查询到的密码跟前端获取到的对比
            request.getSession().setAttribute("user",user);
            if(user.getJusis() == 1){
                request.getSession().setAttribute("access","欢迎您，用户："+user.getUserName());
            }else if(user.getJusis() == 2){
                request.getSession().setAttribute("access","欢迎您，管理员："+user.getUserName());
            }else{
                request.getSession().setAttribute("access","欢迎您，超级管理员："+user.getUserName());
            }
            result = 1;     //相等的话返回值1  登录成功
        }else{
            result = 3;  //用户名或者密码错误
        }
        return result;

    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public int register(HttpServletRequest request){
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        //查询数据库中已经存在的用户名密码
        User user = userService.selectByEmail(email);
        int result;
        if(user != null ) {
            result = 0;//前端返回说明此邮箱已被注册
        }else{
            User newuser = new User();
            newuser.setUserName(userName);
            newuser.setEmail(email);
            newuser.setPassword(password);
            newuser.setJusis(1);
            userService.insertUser(newuser);
            result = 1;  //成功注册
        }
        return result;
    }



    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ResponseBody
    public int logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null ) {
            session.removeAttribute("user");
        }
        int result = 1;
        return result;

    }

}
