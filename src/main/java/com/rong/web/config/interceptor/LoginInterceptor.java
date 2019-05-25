package com.rong.web.config.interceptor;

import com.rong.web.pojo.User;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Component
public class LoginInterceptor implements HandlerInterceptor {
//
//    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //每一个项目对于登陆的实现逻辑都有所区别，我这里使用最简单的Session提取User来验证登陆。
//        //这里的User是登陆时放入session的
//        User user = (User)request.getSession().getAttribute("user");
//        //如果session中没有user，表示没登陆
//        if (user == null){
//            response.setContentType("text/html;charset=gb2312");
//            PrintWriter out = response.getWriter();
//            out.print("<script language=\"javascript\">alert('请先登录');window.location.href='/login'</script>");
//            return false;
//        }else {
//            return true;    //如果session里有user，表示该用户已经登陆，放行，用户即可继续调用自己需要的接口
//        }
//
//
//    }
//
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//    }
//
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//    }



    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
    }
    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
        //首页路径以及登录放行
        if ("/index".equals(arg0.getRequestURI()) || "/login".equals(arg0.getRequestURI())
                ||  "/register".equals(arg0.getRequestURI())  ||  "/first/login".equals(arg0.getRequestURI())
                ||  "/first/register".equals(arg0.getRequestURI())) {
            return true;}
        //重定向
        Object object = arg0.getSession().getAttribute("user");
        if (null == object) {
            arg1.setContentType("text/html;charset=gb2312");
            PrintWriter out = arg1.getWriter();
            out.print("<script language=\"javascript\">confirm('请先登录!');window.location.href='/index'</script>");
            return false;
        }
        return true;
    }

}