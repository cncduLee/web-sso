package com.bitium10.sso.controller;


import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-4
 * Time: 下午5:51
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    @RequestMapping(value="/login.htm",method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        return "login";
    }

    @RequestMapping(value="/login.htm",method = RequestMethod.POST)
    public String login(String loginName, String password,
                        Model model, HttpServletRequest request,
                        HttpServletResponse response){
        if (StringUtils.isBlank(loginName)) {
            model.addAttribute("error", "请输入用户名");
            model.addAttribute("loginName", loginName);
            model.addAttribute("password", password);
            return "login";
        }
        if (StringUtils.isBlank(password)) {
            model.addAttribute("error", "请输入登录密码");
            model.addAttribute("loginName", loginName);
            model.addAttribute("password", password);
            return "login";
        }

        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName,password);
        token.setRememberMe(false);

        try {
            user.login(token);
            return "redirect:/index.htm";
        } catch (CredentialsException e) {
            logger.error("用户登录密码错误, msg:{}", e.getMessage(), e);
            //TODO 增加密码错误次数发生异常
        }catch (AuthenticationException e) {
            logger.error("用户登录发生异常, msg:{}", e.getMessage(), e);
        }
        token.clear();
        model.addAttribute("loginName", loginName);
        model.addAttribute("password", password);
        model.addAttribute("error", "用户名或密码错误");
        return "login";
    }

    @RequestMapping("/logout.htm")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Subject user = SecurityUtils.getSubject();
        user.logout();
    }
}
