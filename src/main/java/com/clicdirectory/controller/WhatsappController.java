package com.clicdirectory.controller;


import com.clicdirectory.database.GenericDB;
import com.clicdirectory.entity.Groupdata;
import com.clicdirectory.entity.Member;
import com.clicdirectory.entity.MemberBase;
import com.clicdirectory.entity.ResponseMessage;
import com.clicdirectory.tables.Messagestack;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/whatsapp")
public class WhatsappController {

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public static String home(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "template/whatsapp_pages/whatsapp_login";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/group")
    public static String home1(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
       // System.out.println("heheh");
        return "template/whatsapp_pages/group";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public static String home2(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {

        return "template/whatsapp_pages/main";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/data")
    public @ResponseBody
    ResponseMessage<Groupdata> apply1(@RequestBody Groupdata member, ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        Groupdata memberT = new GenericDB<Groupdata>().getRow(com.clicdirectory.tables.Groupdata.GROUPDATA,Groupdata.class, (com.clicdirectory.tables.Groupdata.GROUPDATA.GROUPNAME.eq(member.groupname)));
        System.out.println("executed till here"+" "+member.groupname+" "+member.tag);


        if(memberT==null){
            Groupdata member1 = new GenericDB<Groupdata>().addRow(com.clicdirectory.tables.Groupdata.GROUPDATA,member);
            System.out.println("yesssss");
            return new ResponseMessage<Groupdata>("User Created","success",member1);
        }else {
            System.out.println("noooooo");
            return new ResponseMessage<Groupdata>("User Already exists !","failure",null);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/messagedata")
    public @ResponseBody
    ResponseMessage<com.clicdirectory.entity.Messagestack> apply1(@RequestBody com.clicdirectory.entity.Messagestack member, ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) throws AWTException, InterruptedException {
        //Messagestack memberT = new GenericDB<Messagestack>().getRow(Messagestack.MESSAGESTACK,Messagestack.class, (Messagestack.MESSAGESTACK.MESSAGE.eq(member.message)));
       // System.out.println("executed till here"+" "+member.message+" "+member.tag);

        member.status=0;
        Date date= new Date();

        member.tstamp = date.getTime();
        String email=ControllerUtils.getEmailId(request);
        System.out.println(email);
        System.out.println("executed till now");
        Member m=new GenericDB<Member>().getRow(com.clicdirectory.tables.Member.MEMBER,Member.class, (com.clicdirectory.tables.Member.MEMBER.EMAIL.eq(email)));

        member.contactno=m.phone;

        List<Groupdata> list = (List<Groupdata>)GenericDB.getRows(com.clicdirectory.tables.Groupdata.GROUPDATA,Groupdata.class, com.clicdirectory.tables.Groupdata.GROUPDATA.TAG.eq(member.tag),null);



        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).groupname);
        }
        String str=member.message;
        SeleniumClass sele = new SeleniumClass();
        sele.sel(list,member);
        com.clicdirectory.entity.Messagestack memberT = new GenericDB<com.clicdirectory.entity.Messagestack>().addRow(Messagestack.MESSAGESTACK,member);
        if(memberT==null){
            System.out.println("yesssss");
            return new ResponseMessage<com.clicdirectory.entity.Messagestack>("User Created","success",memberT);
        }else {
            System.out.println("noooooo");
            return new ResponseMessage<com.clicdirectory.entity.Messagestack>("User Already exists !","failure",null);
        }
    }
}
