package com.bitium10.sso.controller;

import com.bitium10.sso.utils.DateUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-7-1
 * Time: 下午5:50
 * To change this template use File | Settings | File Templates.
 */


public class BaseController {

    /**
     * 设置管理端访问路径
     */
    public static final String ADMIN_PATH = "/a";
    /**
     * 设置访问URL后缀
     */
    public static final String URL_SUFFIX = ".html";

    /**
     * 请求对象
     */
    protected HttpServletRequest request;

    /**
     * 响应对象
     */
    protected HttpServletResponse response;
    /**
     * 初始化数据绑定
     * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
     * 2. 将字段中Date类型转换为String类型
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder, HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        //将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
            }
            @Override
            public String getAsText() {
                Object value = getValue();
                return value != null ? value.toString() : "";
            }
        });
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /////////////////////////////////////////////////////////

    public static String getAdminPath() {
        return ADMIN_PATH;
    }
}
