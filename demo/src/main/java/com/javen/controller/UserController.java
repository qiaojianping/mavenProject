package com.javen.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javen.model.KeyBean;
import com.javen.model.User;
import com.javen.service.IUserService;


@Controller  
@RequestMapping("/user")  
// /user/**
public class UserController {
	private static Logger log=LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private IUserService userService;
	
	//https://www.cnblogs.com/zyw-205520/p/4771253.html
	
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
	
	 // /user/showUser2?id=1
    @RequestMapping(value="/showUser2",method=RequestMethod.GET)  
    public String toIndex2(@RequestParam("id") String id,Model model){  
        int userId = Integer.parseInt(id);  
        System.out.println("userId:"+userId);
        User user = this.userService.getUserById(userId);  
        log.debug(user.toString());
        model.addAttribute("user", user);  
        return "showUser";  
    } 
    
    // /user/showUser3/{id}
    @RequestMapping(value="/showUser3/{id}",method=RequestMethod.GET)  
    public String toIndex3(@PathVariable("id")String id,Map<String, Object> model){  
        int userId = Integer.parseInt(id);  
        System.out.println("userId:"+userId);
        User user = this.userService.getUserById(userId);  
        log.debug(user.toString());
        model.put("user", user);  
        return "showUser";  
    }
    
    // /user/{id}
    @RequestMapping(value="/{id}",method=RequestMethod.GET)  
    public @ResponseBody User getUserInJson(@PathVariable String id,Map<String, Object> model){  
        int userId = Integer.parseInt(id);  
        System.out.println("userId:"+userId);
        User user = this.userService.getUserById(userId);  
        log.info(user.toString());
        return user;  
    }
    
    // /user/jsontype/{id}
    @RequestMapping(value="jsontype/{id}",method=RequestMethod.GET)
    public ResponseEntity<User> getUserInJson2(@PathVariable String id,Map<String, Object> model){
        int userId = Integer.parseInt(id);  
        System.out.println("userId:"+userId);
        User user = this.userService.getUserById(userId);
        log.info(user.toString());
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
   
    // /user/othersTest/{id}
    @RequestMapping(value="/othersTest/{id}",method=RequestMethod.GET)  
    public ResponseEntity<KeyBean>  getUserInJson3(@PathVariable String id,Map<String, Object> model){  
        int userId = Integer.parseInt(id);  
        System.out.println("userId:"+userId);
        KeyBean user = new KeyBean();
        user.data_attestation_file = "http://192.168.1.111/getAttestationFile/WV1376391152";
        user.data_hdcp_v14_file = "";
        user.data_hdcp_v22_file = "";
        user.data_customer_id = "11111";
        user.data_imei = "QG23K3C5GXBE";
        user.data_mac = "80:0B:52:06:FF:F9";
        user.data_model_code = "S111";
        user.data_playready_private_file = "";
        user.data_playready_public_file = "";
        user.data_widevine_file = "";
        user.remark = "获取成功！";
        user.result = 1;
        log.info(user.toString());
        return new ResponseEntity<KeyBean>(user,HttpStatus.OK);  
    }
}
