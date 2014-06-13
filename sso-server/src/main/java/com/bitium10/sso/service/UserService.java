package com.bitium10.sso.service;

import com.bitium10.sso.dao.api.ResourceDao;
import com.bitium10.sso.dao.api.RoleDao;
import com.bitium10.sso.dao.api.UserDao;
import com.bitium10.sso.domain.Resource;
import com.bitium10.sso.domain.User;
import com.bitium10.sso.shiro.ShiroDBRealm;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 下午1:35
 * To change this template use File | Settings | File Templates.
 */

@Component
public class UserService implements ApplicationContextAware {

    private static UserDao userDao;
    private static ResourceDao resourceDao;
    private static RoleDao roleDao;

    public static User getUser(){
        User user = (User)getCache("user");
        if (user == null){
            ShiroDBRealm.Principal principal = (ShiroDBRealm.Principal)SecurityUtils.getSubject().getPrincipal();
            if (principal != null){
                user = userDao.findByLoginName(principal.getLoginName());
                putCache("user", user);
            }
        }
        return user;
    }

    public static List<Resource> getResourceList(){
        @SuppressWarnings("unchecked")
        List<Resource> menuList = (List<Resource>)getCache("menuList");
        if (menuList == null){
            User user = getUser();
            if (user.isAdmin()){
                menuList = resourceDao.findAllList();
            }else{
                menuList = resourceDao.findByUserId(user.getId());
            }
            putCache("menuList", menuList);
        }
        return menuList;
    }

    public static Object getCache(String key) {
        Object obj = getCacheMap().get(key);
        return obj == null ? null : obj;
    }

    public static void putCache(String key, Object value) {
        getCacheMap().put(key, value);
    }

    public static void removeCache(String key) {
        getCacheMap().remove(key);
    }

    private static Map<String, Object> getCacheMap(){
        ShiroDBRealm.Principal principal = (ShiroDBRealm.Principal) SecurityUtils.getSubject().getPrincipal();
        return principal != null ? principal.getCacheMap() : new HashMap<String, Object>();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        userDao = (UserDao) applicationContext.getBean("userDao");
        resourceDao = (ResourceDao) applicationContext.getBean("resourceDao");
        roleDao = (RoleDao) applicationContext.getBean("roleDao");
    }
}
