package com.bitium10.sso.filter;

import com.bitium10.sso.common.Constant;
import com.bitium10.sso.domain.User;
import com.bitium10.sso.service.UserService;
import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-6-14
 * Time: 下午1:18
 * To change this template use File | Settings | File Templates.
 */
public class SysUserFilter extends PathMatchingFilter {

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        User user = UserService.getUser();
        request.setAttribute(Constant.CURRENT_USER,user);
        return true;
    }
}
