package com.bitium10.sso.domain;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 下午12:51
 * To change this template use File | Settings | File Templates.
 */
public enum ResourceType {
    MENU(0,"菜单"),BUTTOM(1,"按钮");
    private Integer code;
    private String name;
    private ResourceType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
