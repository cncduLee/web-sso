package com.bitium10.sso.client;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-5-31
 * Time: 下午2:11
 * To change this template use File | Settings | File Templates.
 */
public class Auth implements Filter{

    public static final String USER = "user";
    private Consumer consumer;
    private boolean cookie;   //cookies方式保存回话信息
    private HttpServletRequest SSOUser;


    @Override
    public void init(FilterConfig config) throws ServletException {
        String authUrl = config.getInitParameter("authUrl");
        String consumerUrl = config.getInitParameter("consumerUrl");
        cookie = config.getInitParameter("cookie") != null;
        consumer = new Consumer(authUrl, consumerUrl, cookie);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        setSSOUser(request);

        boolean processed = consumer.process(request, response);
        if (processed) {
            SSOContext.remove();
            return;
        } else {
            chain.doFilter(request, response);
            SSOContext.remove();
        }

    }

    @Override
    public void destroy() {

    }

    public void setSSOUser(HttpServletRequest request) {
        if(cookie){
            Cookie[] cookies = request.getCookies();
            for(Cookie c : cookies){
                if(USER.equals(c.getName())){
                    User user = new User(c.getName());
                    SSOContext.setUser(user);
                }
            }
        }else {
            String name = (String) request.getSession().getAttribute(USER);
            if(name != null && !"".equals(name)){
                User user = new User(name);
                SSOContext.setUser(user);
            }
        }

    }
}
