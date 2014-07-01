package com.bitium10.sso.controller;

import com.bitium10.sso.bind.CurrentUser;
import com.bitium10.sso.domain.Resource;
import com.bitium10.sso.domain.User;
import com.bitium10.sso.domain.UserLoginResult;
import com.bitium10.sso.service.UserService;
import com.google.gson.Gson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-6
 * Time: 下午5:51
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = BaseController.ADMIN_PATH)
public class IndexController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequiresUser
    @RequestMapping(value = {"/index.htm","/"}, method = RequestMethod.GET)
    public String index(Model model) {
        List<Resource> menus = UserService.getResourceList();
        model.addAttribute("menus", menus);
        return "index";
    }

}
