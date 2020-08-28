package com.saws.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.saws.dao.UserDao;
import com.saws.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class Register {
    //注入
    UserDao userDao;
    @Autowired
    void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }

    //注册
    @RequestMapping(method = RequestMethod.POST,value = "/register")
    @ResponseBody
    public String register(HttpServletRequest httpServletRequest) throws JsonProcessingException {
        User user = new User();
        user.setUser_id(httpServletRequest.getParameter("user_id"));
        user.setUser_password(httpServletRequest.getParameter("user_pw"));
        user.setUsr_name(httpServletRequest.getParameter("user_name"));
        user.setUser_phone(Integer.parseInt(httpServletRequest.getParameter("user_phone")));
        user.setUser_address(httpServletRequest.getParameter("user_address"));
        user.setUser_age(Integer.parseInt(httpServletRequest.getParameter("user_age")));
        user.setUser_gender(httpServletRequest.getParameter("user_sex"));
        Boolean res = userDao.register(user);

        return "{" +
                "\"res\":" + res +
                '}';
    }
}

