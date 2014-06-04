package com.bitium10.sso.common;

import com.bitium10.sso.domain.UserLoginResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-4
 * Time: 下午7:18
 * To change this template use File | Settings | File Templates.
 */
public class AccountUtils {
    private AccountUtils(){}

    private static class SingletonHolder{
        private static final AccountUtils INSTANCE = new AccountUtils();
    }

    public static final AccountUtils getInstance(){
        return SingletonHolder.INSTANCE;
    }

    /**
     * 获取登录用户
     * @return
     */
    public String getLoginName() {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            if (null != session) {
                Object object = session.getAttribute("currentUser");
                if (object != null) {
                    UserLoginResult user = (UserLoginResult) object;
                    return user.getLoginName();
                }
            }
        }
        return "";
    }

    /**
     * 获取操作用户
     * @return
     */
    public String getOperator() {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            if (null != session) {
                Object object = session.getAttribute("currentUser");
                if (object != null) {
                    UserLoginResult user = (UserLoginResult) object;
                    return user.getName();
                }
            }
        }
        return "";
    }

    /**
     * 获取IP
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public BusinessLogParam getBusinessLogParam(String businessNo,HttpServletRequest request, HttpServletResponse response){
        String ip = getIpAddr(request);
        String host = request.getRemoteHost();
        String loginName = getLoginName();
        String operator = getOperator();
        BusinessLogParam logParam = new BusinessLogParam(ip,host, loginName, operator, businessNo);
        return logParam;
    }

}
