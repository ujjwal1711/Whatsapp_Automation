package com.clicdirectory.controller;

import com.clicdirectory.Tables;
import com.clicdirectory.database.GenericDB;
import com.clicdirectory.entity.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by hackme on 17/8/17.
 */
public class ControllerUtils {

    public static final String TOKEN_COOKIE = "t";
    public static String getEmailId(HttpServletRequest httpServletRequest) {
        return (String) httpServletRequest.getSession().getAttribute("I");
    }

    public static Boolean isUserIAMMMAdmin(HttpServletRequest httpServletRequest) {
        Boolean temp = (Boolean) httpServletRequest.getSession().getAttribute("A");

        if(temp!=null&&temp)return true;

        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(TOKEN_COOKIE)) {
                    Member member = new GenericDB<Member>().getRow(Tables.MEMBER,Member.class, com.clicdirectory.tables.Member.MEMBER.TOKEN.eq(cookie.getValue()).and(com.clicdirectory.tables.Member.MEMBER.ROLE.eq("admin")));
                    if (member != null/* && member.fb_token != null */ ){ //.&& author.token_expire_time != null && author.token_expire_time > new Date().getTime()) {
                        setUserSession(httpServletRequest, member);
                        return true;
                    }
                }
            }
        }
        return null;
    }

    public static void setUserSession(HttpServletRequest httpServletRequest, Member team) {
        if(team!=null){
            httpServletRequest.getSession().setAttribute("I", team.email);
            if ("admin".equals(team.role)) {
                httpServletRequest.getSession().setAttribute("A", true);
            }
        }
    }
}
