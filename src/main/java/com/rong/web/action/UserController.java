package com.rong.web.action;


import com.rong.service.UserService;
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

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/myinfo")
    public String myinfo(HttpServletRequest request,Model model){
        User user = (User)request.getSession().getAttribute("user");
        String admin = user.getJusis()==0 ? "普通用户":"管理员";
        String bei="";
        if(user.getRemark()==null || user.getRemark().equals("")){
            bei = "当前无备注";
        }else{
           bei = user.getRemark();
        }
        model.addAttribute("user",user);
        model.addAttribute("admin",admin);
        model.addAttribute("bei",bei);
        return "user/myinfo";
    }

    @RequestMapping("updatePass")
    public String updatePass(HttpServletRequest request,Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        model.addAttribute("id",id);
        return "user/updatePass";
    }

    @RequestMapping("/submitPass")
    @ResponseBody
    public  int submitPass(HttpServletRequest request){
        int userid = Integer.parseInt(request.getParameter("userid"));
        String oldpass = request.getParameter("oldpass");
        String newpass = request.getParameter("newpass");
        String confirm = request.getParameter("confirm");
        int result;
        if(!userService.selectById(userid).getPassword().equals(oldpass)){
            result = 0; // 当前密码错误
        }else{
            result = userService.updatePassById(userid,newpass);
        }
        return result;
    }

    @RequestMapping("updateInfo")
    public String updateInfo(HttpServletRequest request,Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        model.addAttribute("id",id);
        return "user/updateInfo";
    }

    @RequestMapping("/submitInfo")
    @ResponseBody
    public  int submitInfo(HttpServletRequest request){
        int userid = Integer.parseInt(request.getParameter("userid"));
        String userName = request.getParameter("username");
        String remark = request.getParameter("remark");
        int result = 0;
        result = userService.updateUserById(userid,userName,remark);
        return result;
    }


    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
    public int addUser(HttpServletRequest request){
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String admin = request.getParameter("admin");

        int result;

        User u = userService.selectByEmail("email");

        if(u != null){
            result = 0;  //邮箱已经注册
        }else{
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            user.setEmail(email);

            int jusis = admin.equals("是") ? 1 :0;
            user.setJusis(jusis);

            result = userService.insertUser(user);
        }
        return  result;

    }


    @RequestMapping("/queryUsers")
    public String queryAllUsers(Model model) {
        List<User> list = userService.selectAllUsers();
        model.addAttribute("list", list);
        return "user/queryUser";
    }


    @RequestMapping(value = "/setAdmin",method = RequestMethod.POST)
    @ResponseBody
    public int setAdmin(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("userid"));
        int result = 0;
        result= userService.setAdmin(id);
        return  result;
    }


    @RequestMapping(value = "/deleted",method = RequestMethod.POST)
    @ResponseBody
    public int  delete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("userid"));
        int result = 0;
        result = userService.deleteById(id);
        return  result;
    }
}