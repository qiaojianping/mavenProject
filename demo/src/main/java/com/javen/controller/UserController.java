package com.javen.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javen.model.User;
import com.javen.service.IUserService;


@Controller  
@RequestMapping("/user")  
// /user/**
public class UserController {
	private static Logger log=LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private IUserService userService;
	
	
	// /user/test?id=1
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(HttpServletRequest request,Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));  
        System.out.println("userId:"+userId);
        User user=null;
        if (userId==1) {
             user = new User();  
             user.setAge(11);
             user.setId(1);
             user.setPassword("123");
             user.setUserName("javen");
        }
       
        log.debug(user.toString());
        model.addAttribute("user", user);  
        return "index";
	}
	
	// /user/showUser?id=1
	@RequestMapping(value="/showUser",method=RequestMethod.GET)
	public String toIndex(HttpServletRequest request,Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));  
        System.out.println("userId:"+userId);
        User user = this.userService.getUserById(userId);  
        log.debug(user.toString());
        model.addAttribute("user", user);  
        return "showUser";  
	}
}
