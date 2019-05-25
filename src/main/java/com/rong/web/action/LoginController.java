package com.rong.web.action;

import com.rong.service.UserService;
import com.rong.web.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/first")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String Login(HttpServletRequest request, HttpServletResponse response,Model model) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userService.selectByEmail(email);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        Object object = request.getSession().getAttribute("user");
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            request.getSession().setAttribute("user", user);//用户名存入该用户的session 中
            out.print("<script language=\"javascript\">alert('登录成功！');window.location.href='/index'</script>");
            model.addAttribute("userName",user.getUserName());
            return "/index";
        } else if(user == null){
            out.print("<script language=\"javascript\">alert('您尚未注册，登录失败！');window.location.href='/login'</script>");
            return "/login";
        } else {
            out.print("<script language=\"javascript\">alert('账号密码错误！');window.location.href='/login'</script>");
            return "/login";
        }
    }

    @RequestMapping("/register")
    public String registerInfo(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();

        User judge = userService.selectByEmail(email);
        if(judge!=null){
            out.print("<script language=\"javascript\">alert('该邮箱已注册！');window.location.href='/register'</script>");
            return "/register";
        }
        User user = new User();
        user.setEmail(email);
        user.setUserName(username);
        user.setPassword(password);
        int res = userService.insertUser(user);
        if(res!=0){
            out.print("<script language=\"javascript\">alert('注册成功,请登录！');</script>");
            return "index";
        }
        return "register";
    }

}
/*
string baseURL  = request.
 */