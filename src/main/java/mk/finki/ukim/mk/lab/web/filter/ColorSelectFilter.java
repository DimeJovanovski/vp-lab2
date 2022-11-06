//package mk.finki.ukim.mk.lab.web.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter
//public class ColorSelectFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        String userSelectedPath = request.getServletPath();
//        Object userSelectedColor = request.getSession().getAttribute("color");
//
//        if ( !userSelectedPath.equals("/balloons") && userSelectedColor==null )
//        {
//            response.sendRedirect("/balloons");
//        }
//        filterChain.doFilter(request, response);
//
//
//    }
//}
