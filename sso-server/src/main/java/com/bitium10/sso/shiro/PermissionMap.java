package com.bitium10.sso.shiro;

import com.bitium10.sso.facade.api.ShiroManageFacade;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-4
 * Time: 下午7:26
 * To change this template use File | Settings | File Templates.
 */
public class PermissionMap extends HashMap{

    public PermissionMap(ShiroManageFacade shiroManageFacade) {
        Map<String, String> filers = new HashMap<String, String>();

        filers.put("/static/**", "anon");
        filers.put("/nopermission**", "anon");
        filers.put("/version**", "anon");
        filers.put("/login**", "anon");
        filers.put("/**", "authc");

        super.putAll(filers);
    }

}