package com.beijing.mapper;

import com.alibaba.druid.sql.visitor.functions.If;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class MyInter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        ArrayList<Object> objects =new ArrayList<>();

        objects.add("/crowd_war/some");
        objects.add("/crowd_war/index");
        objects.add("/crowd_war/login01");
        objects.add("/crowd_war/doLogin");
        String contextPath = request.getRequestURI();
        String substring = contextPath.substring(0, contextPath.lastIndexOf("."));
        if (objects.contains(substring)){
            return true;
        }else {

            Object user = request.getSession().getAttribute("user");
            if (user!=null){
                return true;
            }else {
                return false;
            }



        }




    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
