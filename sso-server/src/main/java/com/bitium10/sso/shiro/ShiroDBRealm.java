package com.bitium10.sso.shiro;

import com.bitium10.sso.common.Encodes;
import com.bitium10.sso.domain.Resource;
import com.bitium10.sso.domain.User;
import com.bitium10.sso.service.SystemService;
import com.bitium10.sso.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.HashMap;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-4
 * Time: 下午6:05
 * To change this template use File | Settings | File Templates.
 */
public class ShiroDBRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(ShiroDBRealm.class);

    private SystemService systemService;

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Principal principal = (Principal) getAvailablePrincipal(principals);
        User user = systemService.getUserByLoginName(principal.getLoginName());
        if (null != user) {
            UserService.putCache("user", user);
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            List<Resource> list = systemService.findAllResources();
            for(Resource resource : list){
                info.addStringPermission(resource.getPermission());
            }
            // 更新登录IP和时间
            //TODO
            return info;
        }
        return null;
    }

    /**
     * 【认证回调函数】验证当前登录的Subject, 登陆时调用
     *
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取基于用户名和密码的令牌
        //这个token是从LoginController里面subject.login(token)传过来的
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        //logger.info("用户登录，Token为: {}", ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        String loginName = usernamePasswordToken.getUsername();
        if (StringUtils.isBlank(loginName)) {
            return null;
        }
        User user = systemService.getUserByLoginName(loginName);
        if (null == user) {
            return null;
        }
        byte[] salt = Encodes.decodeHex(user.getPassword().substring(0, 16));
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
                new Principal(user),
                user.getPassword(),
                ByteSource.Util.bytes(salt),
                getName());
        this.setSession("currentUser", user);
        return authcInfo;
    }

    /**
     * 设置session
     * @param key
     * @param value
     */
    private void setSession(Object key, Object value){
        Subject currentUser = SecurityUtils.getSubject();
        if(null != currentUser){
            Session session = currentUser.getSession();
            logger.debug("Session默认超时时间为[{}]毫秒。",session.getTimeout());
            if(null != session){
                session.setAttribute(key, value);
            }
        }
    }


    /**
     * 设定密码校验的Hash算法与迭代次数
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(SystemService.HASH_ALGORITHM);
        matcher.setHashIterations(SystemService.HASH_INTERATIONS);
        setCredentialsMatcher(matcher);
    }

    /**
     * 清空用户关联权限认证，待下次使用时重新加载
     */
    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        clearCachedAuthorizationInfo(principals);
        UserService.removeCache("user");
    }

    /**
     * 清空所有关联认证
     */
    public void clearAllCachedAuthorizationInfo() {
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
        if (cache != null) {
            for (Object key : cache.keys()) {
                cache.remove(key);
            }
        }
        UserService.removeCache("menuList");
        UserService.removeCache("categoryList");
    }

    public void setSystemService(SystemService systemService) {
        this.systemService = systemService;
    }

    /**
     * 授权用户信息
     */
    public static class Principal implements Serializable {

        private static final long serialVersionUID = 1L;

        private Long id;
        private String loginName;
        private String name;
        private Map<String, Object> cacheMap;

        public Principal(User user) {
            this.id = user.getId();
            this.loginName = user.getLoginName();
            this.name = user.getName();
        }

        public Long getId() {
            return id;
        }

        public String getLoginName() {
            return loginName;
        }

        public String getName() {
            return name;
        }

        public Map<String, Object> getCacheMap() {
            if (cacheMap==null){
                cacheMap = new HashMap<String, Object>();
            }
            return cacheMap;
        }

    }
}
