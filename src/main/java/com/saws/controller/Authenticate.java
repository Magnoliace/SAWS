package com.saws.controller;

import com.saws.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Authenticate {

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    UserDao userDao;

    @PostMapping("/authenticate")
    @ResponseBody
    public String authenticate(@RequestParam("name") String name, @RequestParam("pw") String pw,
                               HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        if(userDao.authenticate(name, pw)){
            Cookie cookie = new Cookie("id", name);
            cookie.setMaxAge(3600);
            httpServletResponse.addCookie(cookie);
            return "success";
        }
        return "failed";
    }

    @GetMapping("/authenticate")
    public String page(){
        return "user_login";
    }
}
