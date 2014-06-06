package com.bitium10.sso.controller;

import com.bitium10.sso.domain.UserLoginResult;
import com.google.gson.Gson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-6
 * Time: 下午5:51
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public String index(Model model) {
        logger.debug("go to index page....");
        System.out.println("go to index page...");
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            if (null != session) {
                UserLoginResult user = (UserLoginResult) session.getAttribute("currentUser");
                String jr = new Gson().toJson(user.getResources());
                model.addAttribute("menus", jr);
                return "index";
            }
        }
        return SystemErrorController.SYSTEM_ERROR;
    }

}
