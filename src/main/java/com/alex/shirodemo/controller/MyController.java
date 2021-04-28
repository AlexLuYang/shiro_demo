package com.alex.shirodemo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @GetMapping({"index","/"})
    public String test(Model model){
        model.addAttribute("msg","这是首页页面");
        return "index";
    }

    @GetMapping("user/add")
    public String toAdd(Model model){
        return "user/add";
    }

    @GetMapping("user/update")
    public String toUpdate(Model model){
        return "user/update";
    }

    @GetMapping("/toLogin")
    public String toLogin(Model model){
        return "login";
    }

    @GetMapping("login")
    public String login(String username , String password , Model model){

        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) { //用户名不存在
            model.addAttribute("msg","用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e){//密码不存在
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }

    @GetMapping("/noauth")
    @ResponseBody
    public String noauth(){
        return "未授权不能访问";
    }
}
