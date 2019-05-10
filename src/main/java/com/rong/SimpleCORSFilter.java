//package com.rong;
//
//        import org.springframework.stereotype.Component;
//
//        import javax.servlet.*;
//        import javax.servlet.http.HttpServletRequest;
//        import javax.servlet.http.HttpServletResponse;
//        import java.io.IOException;
//
//
////@Component
//public class SimpleCORSFilter implements Filter {
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
////        HttpServletResponse response = (HttpServletResponse) res;
////        response.setHeader("Access-Control-Allow-Origin", "*");
////        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//////        response.setHeader("Access-Control-Max-Age", "3600");
////        response.setHeader("Access-Control-Allow-Headers", "*");
////        chain.doFilter(req, res);
//
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
////        if("OPTIONS".equals(request.getMethod())){
////            chain.doFilter(request, response);
////            return;
////        }
////        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
////        response.setHeader("Access-Control-Allow-Headers", "*");
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
//        response.setHeader("Access-Control-Allow-Credentials", "true"); //是否支持cookie跨域
//
//        chain.doFilter(req, res);
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) {
//    }
//
//    @Override
//    public void destroy() {
//    }
//}