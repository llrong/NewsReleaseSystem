//package com.rong.web.config;
////
////import com.rong.web.config.interceptor.LoginInterceptor;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
////import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
////import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
////
////@Configuration
////public class WebConfig implements WebMvcConfigurer {
////
////    @Autowired
////    private LoginInterceptor loginInterceptor;
////
////    // 这个方法是用来配置静态资源的，比如html，js，css，等等
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////    }
////
////    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
////    @Override
////    public void addInterceptors(InterceptorRegistry registry) {
//////         addPathPatterns("/**") 表示拦截所有的请求，
//////         excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
//////        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/index","/login","/register")
//////               .excludePathPatterns("/css/**")
//////                .excludePathPatterns("/js/**").excludePathPatterns("/picture/**");
//////        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/");
////        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/index")
////                .excludePathPatterns("/login").excludePathPatterns("/register").excludePathPatterns("/static/**");//不拦截静态资源;
////        //网站配置生成器：添加一个拦截器，拦截路径为整个项目
////    }
////}
////
////
////
//
//import com.rong.web.pojo.User;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new MyInterceptor());
//
//        interceptorRegistration.excludePathPatterns("/index");
//        interceptorRegistration.excludePathPatterns("/login");
//        interceptorRegistration.excludePathPatterns("/register");
//        interceptorRegistration.excludePathPatterns("/static/**");
//        interceptorRegistration.addPathPatterns("/**");
//
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        //需要配置1：需要告知系统，这是要被当成静态文件的！
//        //第一个方法设置访问路径前缀，第二个方法设置资源路径
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
//        .addResourceLocations("classpath:/css").addResourceLocations("classpath:/js").addResourceLocations("classpath:/picture");
//}
//
//    private class MyInterceptor implements HandlerInterceptor {
//
//        @Override
//        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
//            User user = (User) request.getSession().getAttribute("user");
//            if (user == null) {
//                response.setContentType("text/html;charset=gb2312");
//                PrintWriter out = response.getWriter();
////                out.print("<script language=\"javascript\">alert('请先登录！'); window.location.href='/index'</script>");
//                response.sendRedirect( "/login");
//                return false;
//            }
//            return true;
//        }
//
//        @Override
//        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//            //controller方法处理完毕后，调用此方法
////            System.out.println("在后端控制器执行后调用 ");
//        }
//
//        @Override
//        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//            //页面渲染完毕后调用此方法
////            System.out.println("整个请求执行完成后调用 ");
//        }
//    }
//}