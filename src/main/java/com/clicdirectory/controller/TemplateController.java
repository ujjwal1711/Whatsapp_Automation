package com.clicdirectory.controller;

import com.clicdirectory.SysProperties;
import com.clicdirectory.entity.Post;
import com.clicdirectory.global.FileUtility;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by hackme on 12/9/18.
 */
@Controller
@RequestMapping("/")
public class TemplateController extends BaseController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public static String home( ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "/template/signup";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/signup")
    public String signup(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "adminsignup";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "adminlogin";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public static String welcome( ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        ArrayList<Post> posts = null;
        String str = "contentpost.jsp";
        if("fb".equals(request.getParameter("p"))){
            str="fbpost.jsp";
            posts= new Gson().fromJson(FileUtility.readFile(SysProperties.getBaseDir()+"/data/dummy/fbpost.txt"), new TypeToken<ArrayList<Post>>(){}.getType());
            for(Post post:posts){
                try {
                    post.embedCode="<iframe src=\"https://www.facebook.com/plugins/video.php?href="+ URLEncoder.encode(post.url,"UTF-8")+"&show_text=1&width=560\" width=\"560\" height=\"446\" style=\"border:none;overflow:hidden\" scrolling=\"no\" frameborder=\"0\" allowTransparency=\"true\" allow=\"encrypted-media\" allowFullScreen=\"true\"></iframe>";
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }else if("yt".equals(request.getParameter("p"))){
            str="post.jsp";
            posts= new Gson().fromJson(FileUtility.readFile(SysProperties.getBaseDir()+"/data/dummy/post.txt"), new TypeToken<ArrayList<Post>>(){}.getType());
        }
        else {
            posts= new Gson().fromJson(FileUtility.readFile(SysProperties.getBaseDir()+"/data/dummy/post.txt"), new TypeToken<ArrayList<Post>>(){}.getType());
        }
        modelMap.addAttribute("POSTS", posts);
        modelMap.addAttribute("SHOW_LAYOUT",str);

        return "/template/filter";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filter")
    public static String filter( ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        ArrayList<Post> posts = null;
        String str = "contentpost.jsp";
        if("fb".equals(request.getParameter("p"))){
            str="fbpost.jsp";
            posts= new Gson().fromJson(FileUtility.readFile(SysProperties.getBaseDir()+"/data/dummy/fbpost.txt"), new TypeToken<ArrayList<Post>>(){}.getType());
            for(Post post:posts){
                try {
                    post.embedCode="<iframe src=\"https://www.facebook.com/plugins/video.php?href="+ URLEncoder.encode(post.url,"UTF-8")+"&show_text=1&width=560\" width=\"560\" height=\"446\" style=\"border:none;overflow:hidden\" scrolling=\"no\" frameborder=\"0\" allowTransparency=\"true\" allow=\"encrypted-media\" allowFullScreen=\"true\"></iframe>";
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }else if("yt".equals(request.getParameter("p"))){
            str="post.jsp";
            posts= new Gson().fromJson(FileUtility.readFile(SysProperties.getBaseDir()+"/data/dummy/post.txt"), new TypeToken<ArrayList<Post>>(){}.getType());
        }
        else {
            posts= new Gson().fromJson(FileUtility.readFile(SysProperties.getBaseDir()+"/data/dummy/post.txt"), new TypeToken<ArrayList<Post>>(){}.getType());
        }
        modelMap.addAttribute("POSTS", posts);
        modelMap.addAttribute("SHOW_LAYOUT",str);

        return "/template/filter";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/image")
    public static String image( ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        ArrayList<Post> posts= new Gson().fromJson(FileUtility.readFile(SysProperties.getBaseDir()+"/data/dummy/post.txt"), new TypeToken<ArrayList<Post>>(){}.getType());
        modelMap.addAttribute("POSTS", posts);
        return "/template/image";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public static String search( ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        ArrayList<Post> posts= new Gson().fromJson(FileUtility.readFile(SysProperties.getBaseDir()+"/data/dummy/post.txt"), new TypeToken<ArrayList<Post>>(){}.getType());
        modelMap.addAttribute("POSTS", posts);
        return "/template/search";
    }

    public static void main(String[] args) {
        ArrayList<Post> posts= new Gson().fromJson(FileUtility.readFile(SysProperties.getBaseDir()+"/data/dummy/post.txt"), new TypeToken<ArrayList<Post>>(){}.getType());
       System.out.println(posts);
    }

}
