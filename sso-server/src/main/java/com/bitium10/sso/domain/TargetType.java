package com.bitium10.sso.domain;

/**
 * Created with IntelliJ IDEA.
 * User: wylipengming
 * Date: 14-6-13
 * Time: 下午12:55
 * 连接类型【用于资源访问时】
 */
public enum TargetType {
    mainFrame(0,"mainFrame"),
    blank(1,"_blank"),
    self(2,"_self"),
    parent(3,"_parent"),
    top(4,"_top");
    private Integer code;
    private String name;
    private TargetType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
