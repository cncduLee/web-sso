package com.bitium10.sso.client;

import javax.servlet.ServletConfig;

/**
 * Created with IntelliJ IDEA.
 * User:  lpm【百墨】 shouli1990@gmail.com
 * Date: 14-5-31
 * Time: 下午1:16
 * To change this template use File | Settings | File Templates.
 */
public class Utils {

    /**
     * 读取web.xml配置信息
     * @param servletConfig
     * @param configuration
     * @return
     */
    public static String getConfiguration(ServletConfig servletConfig, String configuration){
        return servletConfig.getInitParameter(configuration);
    }

}
