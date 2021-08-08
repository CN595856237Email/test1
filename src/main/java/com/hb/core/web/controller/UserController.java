package com.hb.core.web.controller;

import com.hb.core.po.User;
import com.hb.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login.action",method = RequestMethod.POST)
    public String login(String usercode, String password, Model model, HttpSession session){
        User user = userService.findUser(usercode,password);

        /**
         * 如果查询到用户跳转 customer;
         */
        if(user != null){
            session.setAttribute("USER_SESSION",user);
            return "redirect:customer/list.action";
        }

        model.addAttribute("msg", "账号或密码错误,请重新输入");
        return "login";
    }

    @RequestMapping(value = "/toCustomer.action")
    public String toCustomer(){
        return "customer";
    }

    /**
     * 退出
     *
     */

    @RequestMapping(value = "/logout.action")
    public String logout(HttpSession session){
        //清除seesion
        session.invalidate();
        return "redirect:login.action";
    }

    /**
     * 向用户登录页面跳转
     */
    @RequestMapping(value = "/login.action",method = RequestMethod.GET)
    public String toLogin(){
        return "login";

    }
}
