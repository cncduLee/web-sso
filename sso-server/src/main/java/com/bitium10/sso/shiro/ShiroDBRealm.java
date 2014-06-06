package com.bitium10.sso.shiro;

import com.bitium10.sso.common.BusinessLogParam;
import com.bitium10.sso.common.ParamWrapper;
import com.bitium10.sso.common.Result;
import com.bitium10.sso.domain.UserLoginResult;
import com.bitium10.sso.facade.api.ShiroManageFacade;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-4
 * Time: 下午6:05
 * To change this template use File | Settings | File Templates.
 */
public class ShiroDBRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(ShiroDBRealm.class);


    @Resource
    private ShiroManageFacade shiroManageFacade;

    /**
     * 【授权查询回调函数】为当前登录的Subject授予角色和权限,访问需要授权的资源时调用
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            if (null != session) {
                UserLoginResult user = (UserLoginResult) session.getAttribute("currentUser");
                for (String permission : user.getPermissions()) {
                    simpleAuthorInfo.addStringPermission(permission);
                }
                return simpleAuthorInfo;
            }
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

        BusinessLogParam logParam = new BusinessLogParam("", "", "", "", loginName);
        ParamWrapper<String> param = new ParamWrapper<String>(logParam, loginName);
        Result<UserLoginResult> result = shiroManageFacade.login(param);
        if (result == null || !result.isCodeSuccess() || result.getData() == null) {
            return null;
        }
        UserLoginResult user = result.getData();
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(), ByteSource.Util.bytes(user.getSalt()), user.getLoginName());
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
}
