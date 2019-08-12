package com.clicdirectory.controller;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

public class ApplicationInterceptor implements HandlerInterceptor {

    private static Set<String> redirectorLoggedIns = new HashSet<String>();

    static {
        String ar[] = {"/login", "/signup", ""};
        for (String a : ar) {
            redirectorLoggedIns.add(a);
            redirectorLoggedIns.add(a + "/");
        }
    }
    private static final Logger logger = Logger.getLogger(ApplicationInterceptor.class);

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        if(httpServletRequest.getRequestURI().startsWith("/static"))
            return true;

        Boolean isAdmin = ControllerUtils.isUserIAMMMAdmin(httpServletRequest);
        if(isAdmin==null){
            if(httpServletRequest.getRequestURI().equals("/")||httpServletRequest.getRequestURI().startsWith("/admin/login")||httpServletRequest.getRequestURI().startsWith("/admin/signup")){
                return true;
            }else {
                httpServletResponse.sendRedirect("/");
                return false;
            }
        }else {
            if(httpServletRequest.getRequestURI().equals("/")) {
                httpServletResponse.sendRedirect("/welcome");
                return false;
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView)
            throws Exception {
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception exception)
            throws Exception {
    }
}